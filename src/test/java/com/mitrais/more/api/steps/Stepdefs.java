package com.mitrais.more.api.steps;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mitrais.more.api.MoreAppBackendApplication;
import com.mitrais.more.api.config.security.JwtTokenProvider;
import com.mitrais.more.api.controllers.AuthController;
import com.mitrais.more.api.payload.LoginRequest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ContextConfiguration(classes = MoreAppBackendApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
public class Stepdefs extends ParentSteps {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	private AuthController authController;
	
	private String body;
	
	private ResultActions resultActions;
	
	@MockBean
	private AuthenticationManager authManager;
	
	@MockBean
	private JwtTokenProvider jwtTokenProv;
	
	
	private TestRestTemplate restTemplate;
	private HttpHeaders headers;
	private LoginRequest loginRequest;
	private ResponseEntity<String> response = null;
	
	
	@Before
	public void setup() {
		//this.mockMvc = webAppContextSetup(webApplicationContext).build();
		this.loginRequest = new LoginRequest();
		this.restTemplate = new TestRestTemplate();
		this.headers = new HttpHeaders();
		
	}
	
	@Given("^username is \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void username_is_and_password_is(String arg1, String arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    this.body = "{\r\n" + 
	    		"  \"username\": \""+ arg1 + "\",\r\n" + 
	    		"  \"password\": \""+ arg2 + "\"\r\n" + 
	    		"}";
	    
	    loginRequest.setUsername(arg1);
	    loginRequest.setPassword(arg2);
	}

	@When("^I submit to system$")
	public void i_submit_to_system() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//this.mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
		
//	    this.resultActions = this.mockMvc.perform(post("http://localhost:8080/api/auth/signin")
//	    		.contentType(MediaType.APPLICATION_JSON)
//	    		.content(this.body));
		
		String url = "http://localhost:8080/api/auth/signin";
		HttpEntity<LoginRequest> httpEntity = new HttpEntity<LoginRequest>(loginRequest, headers);

		response = restTemplate.exchange(
				url,
				HttpMethod.POST, httpEntity, String.class);	
	}

	@Then("^I get \"([^\"]*)\"$")
	public void i_get(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //this.resultActions.andExpect(status().isOk());
	    //MvcResult result = this.resultActions.andReturn();
	    assertEquals(Integer.parseInt(arg1), this.response.getStatusCodeValue());
	}
}
