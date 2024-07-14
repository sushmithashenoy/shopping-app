package com.lg.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomePageController.class)

public class HomePageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * test for the get end point "/index"
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIndexPage() throws Exception {
		this.mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * test for the get end point "/"
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDefaultIndexPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

}
