package com.study.springboot.service;

import java.util.List;

import com.study.springboot.domain.User;
import com.study.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * User 服务.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.security.service.UserService#removeUser(java.lang.Long)
	 */
	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.security.service.UserService#listUsers()
	 */
	@Override
	public List<User> listUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

}
