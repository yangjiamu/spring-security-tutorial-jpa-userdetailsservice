package com.study.springboot.service;

import com.study.springboot.domain.User;

import java.util.List;


/**
 * User 服务接口.
 */

public interface UserService {

	void removeUser(Long id);
	
	List<User> listUsers();
}
