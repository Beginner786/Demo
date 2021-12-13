package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserRoles;

@Repository
public interface UserRolesRepo extends JpaRepository<UserRoles, Integer>{

}
