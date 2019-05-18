package com.example.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends NamedParameterJdbcDaoSupport implements EmployeeRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = jdbcTemplate.query("select * from employee", (rs, rowNum) -> new Employee(rs.getInt("EMPID"),
                rs.getString("NAME"), rs.getString("CITY")));
		return employees;
	}

	@Override
	public int saveEmployee(final Employee employee) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("EID", employee.getEmpId());
		parameterSource.addValue("NAME", employee.getName());
		parameterSource.addValue("CITY", employee.getCity());
		
		String sql = "insert into employee(EMPID, NAME, CITY) values (:EID, :NAME, :CITY)";
		return namedParameterJdbcTemplate.update(sql, parameterSource);
	}

	@Override
	public Employee loadEmployee(int empId) {
		String query = "select * from Employee where empId = :EMPID";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("EMPID", empId);
		return namedParameterJdbcTemplate.queryForObject(query, parameterSource, 
				(rs, rowNum) -> new Employee(rs.getInt("EMPID"), rs.getString("NAME"), rs.getString("CITY")));
	}

	@Override
	public void deleteEmployee(int empId) {
		String query = "delete from employee where empid = :EMPID";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("EMPID", empId);
		namedParameterJdbcTemplate.update(query, parameterSource);
	}

	@Override
	public void updateEmployee(Employee employee) {
		String query = "update Employee set NAME = :NAME, CITY = :CITY where EMPID = :EMPID";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("EMPID", employee.getEmpId());
		parameterSource.addValue("NAME", employee.getName());
		parameterSource.addValue("CITY", employee.getCity());
		
		namedParameterJdbcTemplate.update(query, parameterSource);
	}
	
	

}
