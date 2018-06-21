package com.ryanzhou.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;

public interface TweetRepository extends JpaRepository<Tweet, Long>{
	public List<Tweet> findAllByUser(User user);
	public Tweet findByUserAndId(User user, Long tweetId);
	public void deleteByUserAndId(User user, Long tweetId);
}
