package com.example.electricitybillpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.electricitybillpayment.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
	//User findUserByEmail(String email);

	
	User findByEmailAndPassword(String email,String password);
	
	
}
