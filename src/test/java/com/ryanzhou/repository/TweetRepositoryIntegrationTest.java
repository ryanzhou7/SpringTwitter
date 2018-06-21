package com.ryanzhou.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ryanzhou.model.Tweet;
import com.ryanzhou.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TweetRepositoryIntegrationTest {

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	UserRepository userRepository;


	private User user;

	@Before
	public void initUser() {
		user = new User("Bob");
		user = userRepository.save(user);
	}

	@Test
	public void findAllByUserTest() {
		Tweet tweet1 = tweetRepository.save(new Tweet(user, "Hi"));
		Tweet tweet2 = tweetRepository.save(new Tweet(user, "Hello"));
		List<Tweet> foundTweets = tweetRepository.findAllByUser(user);
		assertThat(foundTweets).hasSize(2);
		foundTweets.forEach((tweet)->{
			assertThat(tweet.getUser().equals(user)).isTrue();
		});
		assertThat(foundTweets).usingElementComparator(
				(Tweet expected, Tweet actual)->{return expected.equals(actual)?0:1;})
		.containsExactlyInAnyOrder(tweet1, tweet2);
	}

	@Test
	public void findByUserAndIdTest() {
		Tweet tweet1 = tweetRepository.save(new Tweet(user, "Hi"));
		Tweet tweetResult = tweetRepository.findByUserIdAndId(user.getId(), tweet1.getId());
		assertThat(tweetResult.equals(tweet1)).isTrue();
	}
	
	@Test
	public void deleteByUserAndIdTest() {
		Tweet tweet1 = tweetRepository.save(new Tweet(user, "Hi"));
		assertThat(tweetRepository.existsById(tweet1.getId())).isTrue();
		tweetRepository.deleteByUserIdAndId(user.getId(), tweet1.getId());
		assertThat(tweetRepository.existsById(tweet1.getId())).isFalse();
	}
}
