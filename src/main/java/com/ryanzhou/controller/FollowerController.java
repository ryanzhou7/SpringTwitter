package com.ryanzhou.controller;

import com.ryanzhou.model.Follower;
import com.ryanzhou.model.UserFollowerId;
import com.ryanzhou.repository.FollowerRepository;
import com.ryanzhou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/followers")
public class FollowerController {

    @Autowired
    FollowerRepository followerRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public Follower createFollowing(@RequestParam(name="user_id", required=true) Long user_id,
                                    @RequestParam(name="follower_id", required=true) Long follower_id) throws Exception {
        Follower follow;
        if(isValidIds(user_id, follower_id)){
            follow = new Follower(new UserFollowerId(user_id, follower_id));
            followerRepository.save(follow);
        }
        else{
            throw new Exception("Invalid user or follower id");
        }
        return follow;
    }

    @DeleteMapping
    public void deleteFollowing(@RequestParam(name="user_id", required=true) Long user_id,
                                    @RequestParam(name="follower_id", required=true) Long follower_id) throws Exception {
        Follower follow;
        if(isValidIds(user_id, follower_id)){
            new UserFollowerId(user_id, follower_id);
            followerRepository.deleteById(new UserFollowerId(user_id, follower_id));
        }
        else{
            throw new Exception("Invalid user or follower id");
        }
    }

    private boolean isValidIds(Long id1, Long id2){
        return userRepository.findById(id1).isPresent() && userRepository.findById(id2).isPresent();
    }

}
