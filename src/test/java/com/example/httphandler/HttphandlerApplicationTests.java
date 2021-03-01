package com.example.httphandler;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
	public void test() throws Exception {
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

	@Test
	public void test2() throws Exception {
		try {
			String uri = "/json";
			String firstName = "foo";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
					.post(uri)
					.header("TOKEN", "YES")
//					.param("name", firstName))
					.contentType(MediaType.APPLICATION_JSON))
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



//	@Test //GET
//	public void getProductsList() throws Exception {
//		String uri = "/products";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		Product[] productlist = super.mapFromJson(content, Product[].class);
//		assertTrue(productlist.length > 0);
//	}
//
//	@Test //POST
//	public void createProduct() throws Exception {
//		String uri = "/products";
//		Product product = new Product();
//		product.setId("3");
//		product.setName("Ginger");
//		String inputJson = super.mapToJson(product);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content(inputJson)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
//
//	@Test //PUT
//	public void updateProduct() throws Exception {
//		String uri = "/products/2";
//		Product product = new Product();
//		product.setName("Lemon");
//		String inputJson = super.mapToJson(product);
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//				.contentType(MediaType.APPLICATION_JSON_VALUE)
//				.content(inputJson)).andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is updated successsfully");
//	}
//
//	@Test //DELETE
//	public void deleteProduct() throws Exception {
//		String uri = "/products/2";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is deleted successsfully");
//	}

}
