package com.cg.jdbc.dao;

import java.util.List;

import com.cg.jdbc.dto.Employee;
import com.cg.jdbc.exception.JDBCException;

public interface IJdbcAppDAO {
	public int addEMployee(Employee emp) throws JDBCException;
	public List<Employee> getAllEmployee() throws JDBCException;

}
