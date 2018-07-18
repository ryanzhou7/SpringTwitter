package com.ryanzhou.model;

import javax.persistence.*;

@Entity
@Table
public class Follower {

    @EmbeddedId
    private UserFollowerId id;

    public Follower(){}

    public Follower(UserFollowerId userFollowerId){
        id = userFollowerId;
    }

    public UserFollowerId getId() {
        return id;
    }

    public void setId(UserFollowerId id) {
        this.id = id;
    }
}
