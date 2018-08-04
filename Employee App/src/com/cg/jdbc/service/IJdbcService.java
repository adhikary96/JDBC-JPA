package com.cg.jdbc.service;

import java.util.List;

import com.cg.jdbc.dto.Employee;
import com.cg.jdbc.exception.JDBCException;

public interface IJdbcService {
	public int addEMployee(Employee emp) throws JDBCException;
	public List<Employee> getAllEmployee() throws JDBCException;

}
