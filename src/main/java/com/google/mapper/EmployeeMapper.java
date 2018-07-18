package com.google.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.google.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEno(rs.getInt("eno"));
			employee.setEname(rs.getString("ename"));
			employee.setSalary(rs.getDouble("salary"));
			return employee;
	}
}