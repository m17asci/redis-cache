package com.spring.test.repository;

import com.spring.test.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByTcIdentity(String tcIdentity);

    List<User> findAllByIdBetween(Long min, Long max);
}
