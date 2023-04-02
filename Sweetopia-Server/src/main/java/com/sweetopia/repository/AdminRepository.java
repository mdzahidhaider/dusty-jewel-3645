package com.sweetopia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetopia.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	public Optional<Admin> findByEmailAndUserPassword(String username,String password);
	public Optional<Admin> findByEmail(String email);

}
