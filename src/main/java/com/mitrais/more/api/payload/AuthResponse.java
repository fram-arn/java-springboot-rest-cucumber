package com.mitrais.more.api.payload;

import java.util.Set;

public class AuthResponse {
	
	private JwtAuthenticationResponse jwtResponse;
	private Set<String> roles;
	
	public AuthResponse(JwtAuthenticationResponse jwtResponse, Set<String> roles) {
		// TODO Auto-generated constructor stub
		this.jwtResponse = jwtResponse;
		this.roles = roles;
	}

	public JwtAuthenticationResponse getJwtResponse() {
		return jwtResponse;
	}

	public void setJwtResponse(JwtAuthenticationResponse jwtResponse) {
		this.jwtResponse = jwtResponse;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
}
