package com.spring.javaConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
///import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.StudentDao;
import com.spring.dao.StudentDaoImpl;

@Configuration
public class config {

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("govt");

		return ds;
	}

	@Bean("jdbc")
	public JdbcTemplate getJdbctemplate() {

		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(getDataSource());
		return temp;
	}

	@Bean("stDao")
	public StudentDao studentDao() {
		StudentDaoImpl dao = new StudentDaoImpl();
		dao.setJdbcTemplate(getJdbctemplate());

		return dao;
	}
}
