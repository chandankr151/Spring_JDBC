package com.spring.javaConfig;

//import java.sql.ResultSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDao;
import com.spring.dao.StudentDaoImpl;
import com.spring.model.Student;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		JdbcTemplate template = context.getBean("jdbc", JdbcTemplate.class);

		System.out.println(template.getDataSource().getConnection());

		StudentDao dao = context.getBean("stDao", StudentDaoImpl.class);

//		/// Insert
//		Student st = new Student();
//		st.setId(1);
//		st.setName("Mohan");
//		st.setAddress("Hajipur");
//
//		int i = dao.insert(st);
//		System.out.println("inserted successfully " + i);
//
//		/// Fetch all record...
//		List<Student> list = dao.getAllStudent();
//		System.out.println("List of all students: ");
//		for (Student student : list) {
//			System.out.println(student);
//		}

		int i = dao.delete(4);
		System.out.println(i + " record deleted successfully");

		/// Fetch all record...
		List<Student> list2 = dao.getAllStudent();
		System.out.println("List of all students: ");
		for (Student student : list2) {
			System.out.println(student);
		}
	}

}
