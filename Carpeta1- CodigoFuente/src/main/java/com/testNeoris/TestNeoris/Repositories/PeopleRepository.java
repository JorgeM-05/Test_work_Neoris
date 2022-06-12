package com.testNeoris.TestNeoris.Repositories;

import com.testNeoris.TestNeoris.Entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Integer> {
    public PeopleEntity findByUniqid(int uniqid);
}
