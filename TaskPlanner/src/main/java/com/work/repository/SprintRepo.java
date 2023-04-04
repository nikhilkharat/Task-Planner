package com.work.repository;

import com.work.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SprintRepo extends JpaRepository<Sprint,Integer> {

        @Query("SELECT u.fullName, s.duration, s.localDateTime, s.department, t.taskName, t.taskDetails FROM User u JOIN u.sprintList s JOIN s.taskList t WHERE u.fullName = :fullName")
    List<Object[]> findSprintInfoByFullName(@Param("fullName") String fullName);
}
