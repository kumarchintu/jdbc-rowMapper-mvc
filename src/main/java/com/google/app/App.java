package com.google.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.google.entity.Employee;

public class App {
	public static void main(String[] args) {
		ApplicationContext container=new AnnotationConfigApplicationContext("com.google");
		JdbcTemplate jdbcTemplate = container.getBean(JdbcTemplate.class);
		String qry="select * from emp_tbl";

		//List<Employee>empList=jdbcTemplate.query(qry, new EmployeeMapper());
		final List<Employee> empList=new ArrayList<Employee>();
		
		jdbcTemplate.query(qry, new ResultSetExtractor<List<Employee>>() 
		{
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
				Employee employee = new Employee();
				employee.setEno(rs.getInt("eno"));
				employee.setEname(rs.getString("ename"));
				employee.setSalary(rs.getDouble("salary"));
				empList.add(employee);
				}
				return empList;
			}
		});
		
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	
		((AbstractApplicationContext)container).close();
	}
}