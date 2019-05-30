package com.sms.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sms.exception.ResourceNotFoundException;
import com.sms.model.Login;
import com.sms.repository.LoginRepository;

@Service
public class CurrentUserDetailService implements UserDetailsService {

	@Autowired
	LoginRepository adminRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Login adminLogin = adminRepository.findByUsername(username).orElseThrow(() -> 
			new UsernameNotFoundException("User not found with username  :" + username));
 		return UserPrincipal.create(adminLogin);
	}
	
	
	
	@Transactional
    public UserDetails loadUserById(Long id) throws ResourceNotFoundException {
        Login adminLogin = adminRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("user", "id", id));

        return UserPrincipal.create(adminLogin);
    }


}
