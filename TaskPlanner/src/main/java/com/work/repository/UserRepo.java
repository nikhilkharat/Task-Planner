package com.work.repository;

import com.work.entity.User;
import com.work.entity.UserTaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByMobileNumber(String mobileNumber);


//    @Query("select new com.work.entity.UserTaskDto(u.fullName, s.duration, s.localDateTime, s.department, t.taskName, t.taskDetails FROM User u JOIN u.sprintList s JOIN s.taskList t where u.fullName=?1")
//    public List<UserTaskDto>findByFullName(String fullName);
}
