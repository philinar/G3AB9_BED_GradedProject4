package com.gl.EmployeeMgmtRestAPI.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.EmployeeMgmtRestAPI.model.User;
import com.gl.EmployeeMgmtRestAPI.repository.UserRepository;
import com.gl.EmployeeMgmtRestAPI.security.config.SecurityDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
       
		return new SecurityDetails(user);
	}

}