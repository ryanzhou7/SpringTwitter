package com.ryanzhou.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ListModel;

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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanzhou.model.User;
import com.ryanzhou.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate testRestTemplate;
	private final String url = "http://localhost:";
	private String fullUrl;
	private final String api = "/api/users";

	@Autowired
	UserRepository userRepository;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Before
	public void init() {
		fullUrl = url + port + api;
	}

	@Test
	public void createUserTest() throws Exception {
		User user = new User("Bob");
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<User> response = testRestTemplate.exchange(fullUrl, HttpMethod.POST, request, User.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		User responseBody = response.getBody();
		assertNotNull(responseBody);
		user.setId(responseBody.getId());
		assertThat(user.equals(responseBody)).isTrue();
		userRepository.deleteAll();
	}

	@Test
	public void deleteUserTest() throws Exception {
		User user = new User("Bob");
		user = userRepository.save(user);
		assertThat(userRepository.existsById(user.getId())).isTrue();
		testRestTemplate.delete(fullUrl + "/" + user.getId());
		assertThat(userRepository.existsById(user.getId())).isFalse();
	}

	@Test
	public void readUsersTest() throws Exception {
		User user1 = new User("Bob");
		user1 = userRepository.save(user1);
		User user2 = new User("Bill");
		user2 = userRepository.save(user2);

		User[] usersResult = testRestTemplate.getForObject(fullUrl, User[].class);
		assertThat(usersResult).usingElementComparator((u1, u2) -> {
			return u1.equals(u2) ? 0 : 1;
		}).containsExactlyInAnyOrder(user1, user2);

	}

	@Test
	public void readUserTest() throws Exception {
		User user = new User("Bob");
		user = userRepository.save(user);
		User userResult = testRestTemplate.getForObject(fullUrl + "/" + user.getId(), User.class);
		assertNotNull(userResult);
		assertThat(user.equals(userResult)).isTrue();
		userRepository.deleteAll();
	}

	@Test
	public void updateUserTest() throws Exception {
		User user = new User("Bob");
		user = userRepository.save(user);
		String newName = "Bill";
		user.setUserName(newName);
		User userResult = testRestTemplate.postForObject(fullUrl + "/" + user.getId(), user, User.class);
		assertThat(user.equals(userResult));
	}
}
