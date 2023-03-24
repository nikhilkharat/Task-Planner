package com.work.repository;

import com.work.entity.CurrentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<CurrentSession,Integer> {

    public CurrentSession findByUuid(String uuid);
}
