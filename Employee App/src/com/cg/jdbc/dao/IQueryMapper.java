package com.cg.jdbc.dao;

public interface IQueryMapper {
	public String INSERT_QUERY = "INSERT INTO EMPLOYEE VALUES(EMPSEQ.NEXTVAL,?,?,?,?)";
	
	public String GET_EMP_CODE = "SELECT MAX(ENO) FROM EMPLOYEE";
	
	public String GET_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";

}
