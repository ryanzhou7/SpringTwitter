package com.ryanzhou.repository;

import com.ryanzhou.model.Follower;
import com.ryanzhou.model.UserFollowerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, UserFollowerId> {
}
