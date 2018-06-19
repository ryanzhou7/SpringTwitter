package com.ryanzhou.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;
import com.ryanzhou.repository.TweetRepository;
import com.ryanzhou.repository.UserRepository;

@RestController
@RequestMapping("/api/users/{userId}/tweets")
public class TweetController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TweetRepository tweetRepository;

	@PostMapping
	public Tweet createTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
		tweet.setUser(userRepository.getOne(userId));
		return tweetRepository.save(tweet);
	}

	@DeleteMapping("/{tweetId}")
	public void deleteTweet(@PathVariable Long tweetId) {
		tweetRepository.deleteById(tweetId);
	}

	@PutMapping("/{tweetId}")
	public Tweet updateTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
		tweet.setUser(userRepository.getOne(userId));
		return tweetRepository.save(tweet);
	}

	@GetMapping("/{tweetId}")
	public Tweet readTweet(@PathVariable Long tweetId) {
		return tweetRepository.getOne(tweetId);
	}

	@GetMapping
	public List<Tweet> readTweets(@PathVariable Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			// TODO throw exception
			return null;
		}
		return tweetRepository.findAllByUser(optionalUser.get());
	}
}
