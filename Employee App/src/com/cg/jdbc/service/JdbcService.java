package com.cg.jdbc.service;

import java.util.List;

import com.cg.jdbc.dao.IJdbcAppDAO;
import com.cg.jdbc.dao.JdbcAppDAO;
import com.cg.jdbc.dto.Employee;
import com.cg.jdbc.exception.JDBCException;

public class JdbcService implements IJdbcService{
	IJdbcAppDAO dao = new JdbcAppDAO();
	@Override
	public int addEMployee(Employee emp) throws JDBCException {
		// TODO Auto-generated method stub
		return dao.addEMployee(emp);
	}
	@Override
	public List<Employee> getAllEmployee() throws JDBCException {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

}
