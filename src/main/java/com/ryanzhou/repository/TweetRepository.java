package com.ryanzhou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;

public interface TweetRepository extends JpaRepository<Tweet, Long>{
	//TODO, refactor these methods
	public List<Tweet> findAllByUser(User user);
	public Tweet findByUserIdAndId(Long userId, Long tweetId);
	public void deleteByUserIdAndId(Long userId, Long tweetId);
	
	
}
