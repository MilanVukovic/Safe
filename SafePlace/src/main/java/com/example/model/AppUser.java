package com.example.model;

public class AppUser {
	 
    private Long iduser;
    private String username;
    private String encrytedPassword;
    private String email;
 
    public AppUser() {
 
    }
 
    public AppUser(Long iduser, String username, String encrytedPassword, String email) {
        this.iduser = iduser;
        this.username = username;
        this.encrytedPassword = encrytedPassword;
        this.email = email;
    }
 
    public Long getIduser() {
        return iduser;
    }
 
    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }
 
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
    

   
    
    @Override
    public String toString() {
        return this.username + "/" + this.encrytedPassword;
    }

	
 
}