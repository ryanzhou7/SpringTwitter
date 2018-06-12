package com.ryanzhou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryanzhou.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
