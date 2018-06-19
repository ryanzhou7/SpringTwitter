package com.ryanzhou.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;
import com.ryanzhou.repository.TweetRepository;
import com.ryanzhou.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TweetControllerIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	private final String url = "http://localhost:";
	private String fullUrlForUser;
	private final String api =  "/api/users";
	
	@Autowired
	UserRepository userRepository;
	
	private User user;
	
	@Autowired
	TweetRepository tweetRepository;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Before 
	public void init() {
		user = userRepository.save(new User("Bob"));
		fullUrlForUser = url+port+api+"/"+user.getId()+"/tweets";
	}
	
	@Test
	public void createTweetTest() throws Exception{
		String message = "My create tweet";
		Tweet tweet = new Tweet(user, message);
		Tweet tweetResult = testRestTemplate.postForObject(fullUrlForUser, tweet, Tweet.class);
		assertThat(tweetResult.getMessage().equals(message));
	}
	
	
	@Test
	public void readTweetTest() throws Exception{
		String message = "My read tweet";
		Tweet tweet = new Tweet(user, message);
		tweet = tweetRepository.save(tweet);
		Tweet tweetResult = testRestTemplate.getForObject(fullUrlForUser+"/"+tweet.getId(), Tweet.class);
		assertThat(tweetResult.equals(tweet));
	}
	
	
	@Test
	public void updateTweetTest() throws Exception{
		Tweet tweet = new Tweet(user, "My first update tweet");
		tweet = tweetRepository.save(tweet);
		String updatedMessage = "My 2nd updated tweet";
		tweet.setMessage(updatedMessage);
		Tweet tweetResult = testRestTemplate.postForObject(fullUrlForUser+"/"+tweet.getId(), tweet, Tweet.class);
		assertThat(tweetResult.getMessage().equals(updatedMessage));
	}
	
	@Test
	public void deleteTweetTest() throws Exception{
		String message = "My delete tweet";
		Tweet tweet = new Tweet(user, message);
		tweet = tweetRepository.save(tweet);
		assertThat(tweetRepository.existsById(tweet.getId())).isTrue();
		testRestTemplate.delete(fullUrlForUser+"/"+tweet.getId());
		assertThat(tweetRepository.existsById(tweet.getId())).isFalse();
	}
	
	@Test
	public void readTweetsTest() throws Exception{
		Tweet tweet1 = new Tweet(user, "My read tweetS");
		Tweet tweet2 = new Tweet(user, "My 2nd read tweetS");
		tweet1 = tweetRepository.save(tweet1);
		tweet2 = tweetRepository.save(tweet2);
		Tweet[] tweetsResult = testRestTemplate.getForObject(fullUrlForUser, Tweet[].class);
		assertThat(tweetsResult).usingElementComparator(
				(Tweet actual, Tweet expected)->{ return actual.isEqualTo(expected)?0:1;})
		.containsExactlyInAnyOrder(tweet1, tweet2);
	}
}
