package com.durgesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.config.JwtTokenUtil;
import com.durgesh.model.JwtRequest;
import com.durgesh.model.JwtResponse;
import com.durgesh.model.UserDTO;
import com.durgesh.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	 
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@GetMapping("/signin")
	public ResponseEntity<?> signIn(@RequestParam String username, @RequestParam String password,
			@RequestHeader(value = "Authorization", required = true) String accessToken) throws Exception {

		/*
		 * final UserDetails userDetails = userDetailsService
		 * .loadUserByUsername(authenticationRequest.getUsername());
		 * 
		 * final String token = jwtTokenUtil.generateToken(userDetails);
		 */
		
		String token = accessToken.substring(accessToken.indexOf(' ') + 1);
		String accessTokenUsername = jwtTokenUtil.getUsernameFromToken(token);
		String accessTokenPassword = jwtTokenUtil.getPasswordFromToken(token);

		try {

			if (accessTokenUsername.equalsIgnoreCase(username) && accessTokenPassword.equals(password)) {
				return ResponseEntity.status(HttpStatus.OK).body("login successfully");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and password wrong ! Please try again");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("login failed ! Please try again");
		}
	}
}