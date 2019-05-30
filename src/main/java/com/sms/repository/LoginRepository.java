package com.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	Optional<Login> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Optional<Login> findByEmail(String email);
	
	Optional<Login> findByResetToken(String resetToken);
	
	Optional<Login> findByEmailAndResetToken(String email, Long resetToken );
	
	Optional<Login> findByPasswordAndUsername(String pwd, String username);
	
}
