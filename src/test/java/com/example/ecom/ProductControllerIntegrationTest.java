package com.example.ecom;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ecom.controller.ProductController;
import com.example.ecom.main.EcomApplication;
import com.example.ecom.model.Product;
import com.example.ecom.model.ProductCategory;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
@ContextConfiguration(classes = EcomApplication.class)
public class ProductControllerIntegrationTest {
	private static final Logger log = LoggerFactory.getLogger(ProductControllerIntegrationTest.class);

	private MockMvc mvc;

	private ProductController productController;
	
	@MockBean
	ProductRepository productRepository;

	@MockBean
	ProductService productService;

	//@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		List<Product> prodLst = new ArrayList<>();
		Product shoe1 = new Product();
		shoe1.setProductName("Shoe1");
		shoe1.setProductCategory(new ProductCategory(1, "FootWear"));
		prodLst.add(shoe1);
		Product shoe2 = new Product();
		shoe2.setProductName("Shoe2");
		shoe2.setProductCategory(new ProductCategory(1, "FootWear"));
		prodLst.add(shoe2);
		Mockito.when(productRepository.getByProductCategory("FootWear")).thenReturn(prodLst);
		ProductController productController = new ProductController();
		this.mvc = MockMvcBuilders.standaloneSetup(productController).build();

	}

	//@Test
	public void givenProductWhenGetProductByIdTest() throws Exception {
		setUp();
		List<Product> prodLst = new ArrayList<>();
		Product shoe1 = new Product();
		shoe1.setProductName("Shoe1");
		shoe1.setProductCategory(new ProductCategory(1, "FootWear"));
		prodLst.add(shoe1);
		Product shoe2 = new Product();
		shoe2.setProductName("Shoe2");
		shoe2.setProductCategory(new ProductCategory(1, "FootWear"));
		prodLst.add(shoe2);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/Product/getProductsByCategory/Footwear", MediaType.APPLICATION_JSON).content("{}");
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		log.info("response : " + response.getContentAsString());
		
		assertEquals(HttpStatus.OK, response.getStatus());

	}
}