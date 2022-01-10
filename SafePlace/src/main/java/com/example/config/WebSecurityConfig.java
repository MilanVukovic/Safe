package com.example.config;
 
import service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
@Configuration
@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    UserDetailsServiceImpl userDetailsService;
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/password").authenticated()
        .anyRequest().permitAll()
        .and()
            .formLogin()
            	.loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/passwordPage")
                .failureUrl("/login?error=true")
                .permitAll()
        .and()
        	.logout()
        		.logoutUrl("/doLogout")
        		.deleteCookies("SESSIONID")
        		.logoutSuccessUrl("/").permitAll();
    }
}
