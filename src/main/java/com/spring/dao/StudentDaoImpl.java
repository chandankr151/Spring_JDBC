package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub

		String sql1 = "insert into student(id, name, address) values (?,?,?)";
		int ins = jdbcTemplate.update(sql1, 4, student.getName(), student.getAddress());
		System.out.println("Total no of record inserted: " + ins);

		return ins;
	}

	@Override
	public int updateDetails(Student student) {
		// TODO Auto-generated method stub

		String sql2 = "update student set name=?, address=? where id=?";
		int update = jdbcTemplate.update(sql2, student.getId(), student.getName(), student.getAddress());
		return update;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql3 = "delete from student where id=?";
		int delete = jdbcTemplate.update(sql3, id);
		System.out.println(delete + ": Record deleted successfully");

		return delete;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub

		String sql = "select *from student where id=?";

		RowMapper rowMapper = new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAddress(rs.getString(3));
				return student;
			}

		};
		Student studentNew = (Student) jdbcTemplate.queryForObject(sql, rowMapper, id);
		return studentNew;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub

		String sql = "select * from student";

		RowMapper rowMapper = new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAddress(rs.getString(3));

				return student;
			}
		};

		List<Student> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}