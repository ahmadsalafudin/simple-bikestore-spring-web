package com.batm.tokoBatch3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.batm.tokoBatch3.model.User;
import com.batm.tokoBatch3.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user")
	public String UserList(Model model) {
		model.addAttribute("user", userService.listUser());
		return "user";
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("user", new User());
		return "formAddUser";
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String simpanDataUser(Model model, User user) {
		model.addAttribute("user", userService.saveOrUpdate(user));
		return "redirect:/user";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.getIdUser(id));
		return "formEditUser";
	}

	@RequestMapping(value = "/user/hapus/{id}")
	public String hapus(@PathVariable Integer id) {
		userService.hapus(id);
		return "redirect:/user";
	}

}
