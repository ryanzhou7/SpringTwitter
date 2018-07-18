package com.ryanzhou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFollowerId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "follower_id")
    private Long followerId;

    public UserFollowerId() {}

    public UserFollowerId(Long companyId, Long employeeId) {
        this.userId = companyId;
        this.followerId = employeeId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserFollowerId)) return false;
        UserFollowerId that = (UserFollowerId) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getFollowerId(), that.getFollowerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFollowerId());
    }
}
