package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import com.example.mapper.AppUserMapper;
import com.example.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {
 
	List<AppUser> userList;

    @Autowired
    public AppUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public AppUser findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AppUserMapper.BASE_SQL + " where u.username = ? ";
 
        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    public List<AppUser> getUserList()
    {
    	userList = new ArrayList<>();
    	String query = "select * from app_user";
    	
    	List<Map<String, Object>> zeilen =getJdbcTemplate().queryForList(query);
    	for(Map zeile : zeilen)
    	{
    		AppUser benutzer =new AppUser();
    		benutzer.setIduser((Long) zeile.get("iduser"));
    		benutzer.setUsername((String) zeile.get("username"));
    		benutzer.setEncrytedPassword((String) zeile.get("passwort"));
    		userList.add(benutzer);
    	}
    	return userList;
    }
}