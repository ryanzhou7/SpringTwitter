package com.ryanzhou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;
import com.ryanzhou.repository.TweetRepository;
import com.ryanzhou.repository.UserRepository;

@SpringBootApplication
public class SpringTweetsApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TweetRepository tweetRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringTweetsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User userA = userRepository.save(new User("Amy"));
		User userB = userRepository.save(new User("Bob"));
		User userC = userRepository.save(new User("Creed"));
		tweetRepository.save(new Tweet(userA, "Hi I'm Amy!"));
		tweetRepository.save(new Tweet(userA, "Now it's my 2nd tweet!"));
		tweetRepository.save(new Tweet(userB, "Hello -Bob(not sure if I should include my name in tweets)"));
		tweetRepository.save(new Tweet(userC, "Creed in the house!!"));
	}
}
