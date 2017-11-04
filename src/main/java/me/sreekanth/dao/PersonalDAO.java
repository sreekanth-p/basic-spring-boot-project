package me.sreekanth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonalDAO.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonalDAO(JdbcTemplate jdbcTemplate){
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public String getData(String email) {
		LOGGER.info("Inside getData()");
		String sql = "SELECT FIRSTNAME, LASTNAME FROM TEST_TABLE WHERE EMAIL = ?";
		return jdbcTemplate.query(sql, new Object[] { email}, new ResultSetExtractor<String>(){
	        @Override
	        public String extractData(ResultSet rs) throws SQLException {
	            StringBuilder sb = new StringBuilder();
	            while(rs.next()){
	                sb.append(rs.getString("firstname")).append(" ").append(rs.getString("lastname")); 
	            } 
	            if(sb.length() == 0) {
	            	return "Not Found";
	            }
	            return sb.toString();
		    }
		});
		
	}
    
}





