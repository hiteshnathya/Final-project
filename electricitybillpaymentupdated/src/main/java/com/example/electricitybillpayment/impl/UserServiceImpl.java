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
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMeterNumber(userDto.getMeterNumber());
        user.setBoardState(userDto.getBoardState());
        user.setCity(userDto.getCity());
        userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}