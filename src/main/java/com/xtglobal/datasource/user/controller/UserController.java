package com.xtglobal.datasource.user.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtglobal.datasource.model.user.User;
import com.xtglobal.datasource.repository.user.UserRepository;

@RestController
public class UserController
{
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void addData2DB()
	{
		userRepository.saveAll(Stream.of(new User(744,"Ashok"),new User(455,"Ramaiah")).collect(Collectors.toList()));
		
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}

}
