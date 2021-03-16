package com.example.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, Long> {

		public Optional<Register> findByEmail(String email);
	
}
