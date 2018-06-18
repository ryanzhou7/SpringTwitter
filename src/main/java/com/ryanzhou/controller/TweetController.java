package com.ryanzhou.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanzhou.model.Tweet;

@RestController
@RequestMapping("/api/users/{userId}")
public class TweetController {

	@PostMapping("/tweets")
	public Tweet createTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
		return null;
	}
	
	@DeleteMapping("/tweets/{tweetId}")
	public void deleteTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
		
	}
	
	@PutMapping("/tweets/{tweetId}")
	public Tweet updateTweet(@PathVariable Long userId, @RequestBody Tweet tweet) {
		return null;
	}
	
	@GetMapping("/tweets/{tweetId}")
	public Tweet readTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
		return null;
	}
	
	@GetMapping("/tweets")
	public List<Tweet> readTweets(@PathVariable Long userId) {
		return null;
	}
	
}
