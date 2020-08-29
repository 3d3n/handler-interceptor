package com.example.httphandler;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class HttphandlerApplicationTests extends AbstractTest{

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}


	@Test
	public void createProduct() throws Exception {
		try {
			String uri = "/hello";
			String firstName = "foo";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
					.post(uri)
					.header("TOKEN", "YES")
					.param("name", firstName))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			System.out.println("status: " + status);
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			System.out.println("content: " + content);
			assertEquals(content, "Hello " + firstName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
