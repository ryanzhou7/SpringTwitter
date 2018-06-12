package com.ryanzhou.repository;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ryanzhou.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest { 
	
	@Autowired
	UserRepository userRepository;
	
	private String name = "Bob";
	private Long id = 1L;
	/*
	 * User ID, auto generated starting from 1
	 */
	
	@Test
	public void testWriteRead() {
		assertThat(userRepository.count()).isEqualTo(0);
		User user = new User(name);
		userRepository.save(user);
		assertThat(userRepository.count()).isEqualTo(1);
		User getUser = userRepository.getOne(user.getId());
		assertThat(getUser.getId()).isEqualTo(1L);
		assertThat(getUser.getUserName()).isEqualTo(name);	
	}

}
