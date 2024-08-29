package com.example.electricitybillpayment.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electricitybillpayment.domain.User;
import com.example.electricitybillpayment.dto.UserDto;
import com.example.electricitybillpayment.repository.UserRepository;
import com.example.electricitybillpayment.service.UserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
	

@Autowired
public UserRepository userRepository;
	
	@Override
	public void saveUser(UserDto userDto) {
	User user=new User();
	user.setFirstName(userDto.getFirstName());
	user.setLastName(userDto.getLastName());
	user.setEmail(userDto.getEmail());
	user.setPassword(userDto.getPassword());
     userRepository.save(user);
		
	}
	/*
private final UserRepository  userRepository;
public UserServiceImpl(UserRepository userRepository) {
	this.userRepository=userRepository;
}
@Override
public void saveUser(UserDto userDto) {
	User user=new User();
	BeanUtils.copyProperties(userDto, user);
    userRepository.save(user);
}*/
     @Override
	public User findByEmailAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email,password);
		//Optional<User> userOptional=userRepository.findByEmailAndPassword(email, password);
		//return userOptional.orElse(null);
	}
	
}
