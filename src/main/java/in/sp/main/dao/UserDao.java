package in.sp.main.dao;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao 
{

	@Autowired 
	private JdbcTemplate jbdcTemplate;

	public Boolean insertUser(User user)
	{
		Boolean status = false;
		try {
			String Insert_query = "INSERT INTO users(name,email,gender,city) VALUES(?,?,?,?)";
			 int count=jbdcTemplate.update( Insert_query,user.getName(),user.getEmail(),user.getGender(),user.getCity());
            if(count>0) {
            	status= true;
            }
            else {
            	status= false;
            }
		}
		catch(Exception e)
		{
			status=false;
			e.printStackTrace();
		}
		return status;	
	}
	
	
	
	public boolean updateUser(User user) {
		boolean status= false;
		try
		{
			String UPDATE_QUERY= "UPDATE users SET name= ? , gender= ? ,city=? WHERE email= ?";
			int count= jbdcTemplate.update(UPDATE_QUERY , user.getName(),user.getGender(),user.getCity(),user.getEmail());
			if(count>0)
			{
				status=true;
			}
			else {
				status=false;
			}
		}
		catch(Exception e)
		{
			status= false;
			e.printStackTrace();
		}
		return status;		
	}
		
	
	
	public User getUserByEmail(String email)
	{
		String SELECT_QUERY= "SELECT * FROM  users WHERE  email=?";
	    return jbdcTemplate.queryForObject(SELECT_QUERY,new UserRowMapper(),email);
	}
	
	public static final class UserRowMapper implements RowMapper<User>
	{	
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			User user = new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));

			return user;
		}
	}
	
}
