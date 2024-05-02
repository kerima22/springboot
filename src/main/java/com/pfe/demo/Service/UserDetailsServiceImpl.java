package com.pfe.demo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Personnel user = userRepository.findByMatriculeP(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
  public Personnel findUserByEmail(String email) {
      return userRepository.findByEmail(email);
  }
  public void updateUserPassword(Personnel user, String newPassword) {
      user.setPassword(newPassword);
      userRepository.save(user);
  }

}
