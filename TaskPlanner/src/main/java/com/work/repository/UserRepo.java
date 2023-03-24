package com.work.repository;

import com.work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByMobileNumber(String mobileNumber);
}
