package com.pfe.demo.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.demo.Entity.Personnel;
import com.pfe.demo.Entity.Role;
import com.pfe.demo.Repository.RoleRepository;
import com.pfe.demo.Repository.UserRepository;
import com.pfe.demo.Request.ForgotPasswordRequest;
import com.pfe.demo.Request.LoginRequest;
import com.pfe.demo.Request.SignupRequest;
import com.pfe.demo.Response.ForgotPasswordResponse;
import com.pfe.demo.Response.JwtResponse;
import com.pfe.demo.Response.MessageResponse;
import com.pfe.demo.Security.JwtUtils;
import com.pfe.demo.Service.UserDetailsImpl;
import com.pfe.demo.Service.UserDetailsServiceImpl;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class Auth {

@Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  UserDetailsServiceImpl detailsServiceImpl;
  @Autowired
  private UserDetailsServiceImpl userService;
 
 
    
    
  @GetMapping("/gett/{mat}")
  public UserDetails getPers(@PathVariable String mat) {
	  return detailsServiceImpl.loadUserByUsername(mat);
  }
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getMatriculeP(), loginRequest.getPassword()));

      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);
      
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      
      
      
      List<String> role = userDetails.getAuthorities().stream()
          .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    
    
    
    
    
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         "Bearer", 
                         userDetails.getIdEmploye(),
                         userDetails.getEmail(), 
                         userDetails.getMatriculeP(),
                          userDetails.getNom(),
                          userDetails.getPrenom(),
                          userDetails.getService(),
                          userDetails.getNumTel(),
                          userDetails.getPoste(),
                          userDetails.getPassword(),
                          userDetails.getChef(),
                          role));
  }
 
 @PostMapping("/signup")
  public ResponseEntity<Personnel> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	
	 String mat = generateNewPassword();
	 signUpRequest.setMatriculeP(mat);
	 System.out.println(mat);
    Personnel user = new Personnel( signUpRequest.getEmail(), 
    		signUpRequest.getMatriculeP(), 
    		signUpRequest.getNom(),
    		signUpRequest.getPrenom(),
    		signUpRequest.getNumTel(),

    		signUpRequest.getService(),
    		signUpRequest.getPoste(), 
    		encoder.encode(signUpRequest.getPassword()),
    		signUpRequest.getChef());

    int intRole = signUpRequest.getRole();
	Role userrole = roleRepository.findById(intRole)
            .orElseThrow(() -> new RuntimeException("Error: not found."));
	
	user.setRole(userrole);
		/*
//		 * if (strRoles == null) { Role userRole =
//		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
//		 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
//		 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
//		 * 
//		 * break; case "mod": Role modRole =
//		 * roleRepository.findByName(ERole.ROLE_MODERATOR) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(modRole); break;
//		 * case "rh": Role rhRole = roleRepository.findByName(ERole.ROLE_RH)
//		 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//		 * roles.add(rhRole); break; default: Role userRole =
//		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } }); }
//		 */
//
    //user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(user);
    

  }
 

 
 
 @PostMapping("/forgot-password")
 public ForgotPasswordResponse forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) throws EmailException {
     ForgotPasswordResponse response = new ForgotPasswordResponse();
     Personnel user = userService.findUserByEmail(forgotPasswordRequest.getEmail());
     if (user != null) {
         String newPassword = generateNewPassword();
         userService.updateUserPassword(user, newPassword);
         sendNewPasswordEmail(user.getEmail(), newPassword);
         response.setSuccess(true);
         response.setMessage("New password has been sent to your email.");
     } else {
         response.setSuccess(false);
         response.setMessage("User with the email address provided not found.");
     }
     return response;
 }

 private String generateNewPassword() {
	 int length = 10; // Set the desired length of the password
	    boolean useLetters = true; // Use letters (a-z, A-Z) in the password
	    boolean useNumbers = true; // Use numbers (0-9) in the password
	    return JwtUtils.random(length, useLetters, useNumbers);
     // Generate a new random password
     // You can use a library like Apache Commons Lang to generate a random password
 }

 private void sendNewPasswordEmail(String email, String newPassword) throws EmailException {
	
	 Email message = new SimpleEmail();
	    message.setHostName("smtp.gmail.com");
	    message.setSmtpPort(587);
	    message.setAuthenticator(new DefaultAuthenticator("", ""));
	    message.setStartTLSEnabled(true);
	    message.setFrom("");
	    message.setSubject("Your new password");
	    message.setMsg("Your new password is: " + newPassword);
	    message.addTo(email);

	    // Send email message
	    message.send();
}

}