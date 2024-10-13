package com.spring.cloud.auth.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.cloud.auth.management.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

   @Query("SELECT s FROM User s WHERE s.userName = :userName")
   User findByUserName(String userName);
}
