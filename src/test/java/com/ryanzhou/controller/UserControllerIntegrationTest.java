package com.ryanzhou.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import java.util.logging.Logger;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanzhou.model.User;
import com.ryanzhou.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	private final String url = "http://localhost:";
	private String fullUrl;
	private final String api =  "/api/users";
	
	@Autowired
	UserRepository userRepository;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	private ResponseEntity<User> createUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = testRestTemplate
				.exchange(fullUrl, HttpMethod.POST, request, User.class);
		return response;
	}
	
	@Before 
	public void init() {
		fullUrl = url+port+api;
	}
	
	@Test
	public void createUserTest() throws Exception{
		User user = new User("Bob");
		ResponseEntity<User> response = createUser(user);		  
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		User responseBody = response.getBody();
		assertNotNull(responseBody);
		user.setId(responseBody.getId());
		assertThat(user.compare(user, responseBody)).isZero();
		userRepository.deleteAll();
	}
	
	@Test
	public void deleteUserTest() throws Exception{
		userRepository.deleteAll();
		assertThat(userRepository.count()).isZero();
		User user = new User("Bob");
		ResponseEntity<User> response = createUser(user);
		long id = response.getBody().getId();
		assertThat(userRepository.existsById(id)).isTrue();
		testRestTemplate.delete(fullUrl+"/"+id);
		assertThat(userRepository.existsById(id)).isFalse();
		userRepository.deleteAll();
	}
	
	@Test
	public void readUserTest() throws Exception{
		User user = new User("Bob");
		ResponseEntity<User> response = createUser(user);
		long id = response.getBody().getId();
		User userResult = testRestTemplate.getForObject(fullUrl+"/"+id, User.class);
		assertNotNull(userResult);
		user.setId(userResult.getId());
		assertThat(user.compare(user, userResult)).isZero();
	}
}
