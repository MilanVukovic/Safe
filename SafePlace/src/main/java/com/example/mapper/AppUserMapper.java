package com.example.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.model.AppUser;

public class AppUserMapper implements RowMapper<AppUser> {

   public static final String BASE_SQL //
           = "Select u.iduser, u.username, u.passwort, u.mail From user u ";

   @Override
   public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

       Long iduser = rs.getLong("iduser");
       String username = rs.getString("username");
       String passwort = rs.getString("passwort");
       String mail = rs.getString("mail");

       return new AppUser(iduser, username, passwort, mail);
   }

}