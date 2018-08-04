package com.cg.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.jdbc.dto.Employee;
import com.cg.jdbc.exception.JDBCException;
import com.cg.util.DbUtil;

public class JdbcAppDAO implements IJdbcAppDAO {

	@Override
	public int addEMployee(Employee emp) throws JDBCException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		try {
			PreparedStatement stat = con.prepareStatement(IQueryMapper.INSERT_QUERY);
			
			stat.setString(1,emp.getName());
			stat.setString(2,emp.getGender());
			stat.setInt(3,emp.getAge());
			stat.setDouble(4,emp.getSalary());
			
			int result = stat.executeUpdate();
			if(result == 1){
				Statement stat1 = con.createStatement();
				ResultSet rs = stat1.executeQuery(IQueryMapper.GET_EMP_CODE);
				int id = rs.getInt(1);
				return id;
			}
			else
				throw new JDBCException("Unable to insert employee details");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployee() throws JDBCException {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(IQueryMapper.GET_ALL_EMPLOYEE);
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setGender(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setSalary(rs.getDouble(5));
				
				employees.add(emp);
			}
			return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCException(e.getMessage());
		}
	}
	
	

}
