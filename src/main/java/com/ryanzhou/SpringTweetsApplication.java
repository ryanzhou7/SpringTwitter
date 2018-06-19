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
	}
}
