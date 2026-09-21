package com.cst323.demo.data;

import com.cst323.demo.data.entity.LoginInfoEntity;
import com.cst323.demo.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class LoginDataService implements LoginDataInterface<LoginModel>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LoginDataService(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean create(LoginModel login) {
		
		String sql = "INSERT INTO\r\n"
				+ "logininfo(USERNAME, PASSWORD) VALUES(?, ?)";
				
		try 
		{
			jdbcTemplate.update(sql, login.getUsername(), login.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	@Override
	public LoginInfoEntity findByUsername(String username) {
		
		String sql = "SELECT * FROM logininfo WHERE USERNAME = ?";
		SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, username);
		srs.next();

		return new LoginInfoEntity(srs.getLong("ID"), srs.getString("USERNAME"), srs.getString("PASSWORD"));
	}
	
}
