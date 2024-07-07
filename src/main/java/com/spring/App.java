package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDaoImpl;
import com.spring.model.Student;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/config.xml");
		JdbcTemplate jdtemp = context.getBean("jdbcTemplate", JdbcTemplate.class);

		System.out.println(jdtemp.getDataSource().getConnection());
//		String query = "insert into student(id, name, address) values(?,?,?)";
//
//		int i = jdtemp.update(query, 1, "chandan Kumar", "Muzaffarpur");
//		System.out.println(i + ": Record Successfully inserted");
//
		/// insert operation
//		String sql1 = "insert into student(id, name, address) values (?,?,?)";
//		int ins = jdtemp.update(sql1,4, "Aasawari Saharasbuddhe", "Gurugram");
//		System.out.println("Total no of record inserted: "+ins);

		/// UPDATE OPERATION
//		String sql2 = "update student set name=?, address=? where id=?";
//		int update = jdtemp.update(sql2, "Raveena Kumari","Hajipur", 1);
//
//		System.out.println("Total number of record updated: "+update);

//		///DELETE OPERATION
//		String sql3 = "delete from student where id=?";
//		int delete = jdtemp.update(sql3,4);
//		System.out.println(delete+": Record deleted successfully");
//

		/// FETCH DATA BY ID FROM TABLE...
//		String sql = "select *from student where id=?";
//
//		RowMapper rowMapper = new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
//				String name = rs.getString(2);
//				return name;
//			}
//		};
//
//		String name = (String)jdtemp.queryForObject(sql, rowMapper, 2);
//		System.out.println(name);

		/// fetching multiple data from database...
//		String sql = "select * from student";
//
//		RowMapper rowMapper = new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
//				String name = rs.getString(2);
//				return name;
//			}
//		};
//
//		List<String> list = jdtemp.query(sql, rowMapper);
//
//		for (String obj : list) {
//			System.out.println(obj);
//		}

		StudentDaoImpl dao = context.getBean("stDao", StudentDaoImpl.class);

		/// INSERT...
//		Student st = new Student();
//		
//		st.setId(3);
//		st.setName("Rohan Kumar");
//		st.setAddress("Bangalore");
//		
//		int insert = student.insert(st);
//		System.out.println(insert+ ": Student inserted Successfully into database");
//	

		/// UPDATE STUDENT...
//		Student st = new Student();
//		
//		st.setId(3);
//		st.setName("Rohan DAS");
//		st.setAddress("Bangalore");
//		
//		int insert = student.insert(st);
//		System.out.println(insert+ ": Student UPDATED Successfully into database");

		/// Record deletion by id
//		int del = dao.delete(2);
//		System.out.println(del+": record deleted successfully.");

		////Fetch record by id...
//		Student st = dao.getStudentById(3);
//		System.out.println(st);
		
		///Fetch all record...
		List<Student> list = dao.getAllStudent();
		System.out.println("List of all students: ");
		for (Student student : list) {
			System.out.println(student);
		}
	}
}