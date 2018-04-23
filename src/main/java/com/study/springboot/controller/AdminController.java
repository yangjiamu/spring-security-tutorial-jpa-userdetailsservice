package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.springboot.domain.User;
import com.study.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	private UserService userService;
	/**
	 * 查询所用用户
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {

		List<User> list = new ArrayList<>();	// 当前所在页面数据列表
		list = userService.listUsers();
		model.addAttribute("title", "管理员管理");
		model.addAttribute("userList", list);
		return new ModelAndView("users/list", "userModel", model);
	}
 

}
