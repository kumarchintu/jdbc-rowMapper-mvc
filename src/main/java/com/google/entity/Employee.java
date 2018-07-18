package com.google.entity;

public class Employee {
	private Integer eno;
	private String ename;
	private Double salary;
	
	public Employee(Integer eno, String ename, Double salary) {
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
	}

	public Employee() {
	}
	
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return eno + " " + ename + " " + salary;
	}
	
	
	
}
