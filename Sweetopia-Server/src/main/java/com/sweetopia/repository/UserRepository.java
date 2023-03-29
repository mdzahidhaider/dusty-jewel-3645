package com.sweetopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
