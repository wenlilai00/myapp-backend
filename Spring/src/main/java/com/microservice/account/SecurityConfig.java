package com.microservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.microservice.account.service.UserInfoService;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

	@Autowired
	private UserInfoService userInfoService;
	/* configure filter chain for apis */
	@Bean //<-- to register this filterchain with spring 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer:: disable)
            .authorizeHttpRequests(authorize -> authorize
            	.antMatchers(HttpMethod.GET,"/api/login").authenticated()	
            	.antMatchers(HttpMethod.POST,"/api/customer/add/{regionId}").permitAll()
            	.antMatchers(HttpMethod.GET,"/api/employee/getall").hasAnyAuthority("HR","MANAGER")	
            	.antMatchers(HttpMethod.POST,"/api/employee/add").hasAuthority("EMPLOYEE")
            	.antMatchers(HttpMethod.POST,"/api/country/add").authenticated()
            	.antMatchers(HttpMethod.POST,"/api/project/add/{regionId}").authenticated()
            	.antMatchers(HttpMethod.GET,"/api/customer/getall").permitAll()	
            	.antMatchers(HttpMethod.POST,"/api/hr/add").permitAll()
            	.antMatchers(HttpMethod.POST,"/api/manager/add").hasAuthority("HR")
            	.antMatchers(HttpMethod.POST,"/api/employee/add/{managerId}").hasAuthority("HR")
            	.antMatchers(HttpMethod.POST,"/api/region/add/{countryId}").permitAll()
            	.antMatchers(HttpMethod.GET,"/api/region/all").permitAll()
            	.antMatchers(HttpMethod.GET,"/api/hr/stat").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/hr/manager/employee").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/jobtype").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/manager/all").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/search/employee/manager/{searchStr}").permitAll()
            	.antMatchers(HttpMethod.GET,"/api/manager/employee").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.POST,"/api/task/employee/{eid}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.GET,"/api/task/{eid}").hasAnyAuthority("MANAGER","EMPLOYEE")
            	.antMatchers(HttpMethod.GET,"/api/task/archive/{tid}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.GET, "/api/employee/getallproject/{id}").permitAll()
            	.antMatchers(HttpMethod.GET, "/api/employee/getid/{userInfoid}").permitAll()
            	.antMatchers(HttpMethod.POST,"/api/leave/post").hasAuthority("EMPLOYEE")
            	.antMatchers(HttpMethod.GET,"/api/leave/all").hasAuthority("EMPLOYEE")
            	.antMatchers(HttpMethod.GET,"/api/leave/update/{leaveId}/{status}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.GET,"/api/leave/archive/{leaveId}").hasAuthority("EMPLOYEE")
            	.antMatchers(HttpMethod.GET,"/api/manager/leave/all").hasAuthority("MANAGER")

            	.anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
	
	/* AuthenticationManager : in-memory / jdbc */
	@Bean
	public AuthenticationManager authenticationManager(){
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getEncoder());
		dao.setUserDetailsService(userInfoService);
		ProviderManager manager = new ProviderManager(dao);
		return manager; 
	}
	@Bean
	public PasswordEncoder getEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder; 
	}
	 
}

 