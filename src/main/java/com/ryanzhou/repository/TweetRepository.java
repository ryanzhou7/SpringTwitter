package com.ryanzhou.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryanzhou.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
