package com.spring.cloud.auth.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.auth.management.entity.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

}
