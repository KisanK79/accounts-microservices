package com.account_core.app;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.account_core.app.dto.AccountDto;
import com.account_core.app.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
class AccountCoreApplicationTests {
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
	void getAccountDetailsTest() throws Exception {
		AccountDto a1 = new AccountDto();
		AccountDto a2 = new AccountDto();
		List<AccountDto> list = new ArrayList<AccountDto>();
		list.add(a1);
		list.add(a2);
		String listJson = objectMapper.writeValueAsString(list);
		
		Mockito.when(accountService.getAllAcounts((org.springframework.data.domain.Pageable) Mockito.any(Pageable.class))).thenReturn(ResponseEntity.of(Optional.of(list)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accountDetails")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	
	@Test
	void getAccountByIdTest() throws Exception {
		AccountDto account = new AccountDto();	
		String accountJson = objectMapper.writeValueAsString(account);
		Mockito.when(accountService.getAccountById(Mockito.anyInt())).thenReturn(ResponseEntity.of(Optional.of(account)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accountDetails/1")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}

	
}
