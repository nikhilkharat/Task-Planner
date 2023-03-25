package com.work.repository;

import com.work.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SprintRepo extends JpaRepository<Sprint,Integer> {
}
