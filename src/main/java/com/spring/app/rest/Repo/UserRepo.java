package com.spring.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.app.rest.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
