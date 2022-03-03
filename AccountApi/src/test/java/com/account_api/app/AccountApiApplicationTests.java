package com.account_api.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.account_api.app.models.Account;
import com.account_api.app.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class AccountApiApplicationTests {
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@MockBean
	AccountService accountService;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void getAllAccountsTestPass() throws Exception {
		Account a1 = new Account();
		Account a2 = new Account();
		List<Account> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		String listJson = objectMapper.writeValueAsString(list);
		Mockito.when(accountService.getAccounts(Mockito.anyInt(),Mockito.anyInt())).thenReturn(ResponseEntity.of(Optional.of(list)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts?page=1&size=4")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(listJson, response.getContentAsString());
	}
	
	@Test
	void getAllAccountsTestFail() throws Exception {
		Account a1 = new Account();
		Account a2 = new Account();
		List<Account> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		String listJson = objectMapper.writeValueAsString(list);
		Mockito.when(accountService.getAccounts(Mockito.anyInt(),Mockito.anyInt())).thenReturn(ResponseEntity.of(Optional.of(list)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(listJson, response.getContentAsString());
	}
	
	@Test
	void getAccountByIdTestPass() throws Exception {
		Account account = new Account();
		String accountJson = objectMapper.writeValueAsString(account);
		Mockito.when(accountService.getAccountById(Mockito.anyInt())).thenReturn(ResponseEntity.of(Optional.of(account)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts/1")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(accountJson, response.getContentAsString());
	}
	
	@Test
	void getAccountByIdTestFail() throws Exception {
		Account account = new Account();
		String accountJson = objectMapper.writeValueAsString(account);
		Mockito.when(accountService.getAccountById(Mockito.anyInt())).thenReturn(ResponseEntity.of(Optional.of(account)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts/1")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(accountJson, response.getContentAsString());
	}
}
