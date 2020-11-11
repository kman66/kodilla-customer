package com.kodilla.customer;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	CustomerController customerController;

	@Test
	public void shouldFetchCustomerForGivenCustomerId() throws Exception {
		// given
		CustomerDTO customerDTO = new CustomerDTO(1234L, "Jan", "Kowalski");
		GetCustomerResponse customerResponse = new GetCustomerResponse(customerDTO);
		Mockito.when(customerController.getCustomer(1234L)).thenReturn(customerResponse);
		// when & then
		mockMvc.perform(get("/v1/customer/1234")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.aMapWithSize(3)))
				.andExpect(jsonPath("$.id", Matchers.is(1234)))
				.andExpect(jsonPath("$.firstName", Matchers.is("Jan")))
				.andExpect(jsonPath("$.lastName", Matchers.is("Kowalski")));
	}

	@Test
	public void shouldThrowExceptionWhenCustomerNotFound() throws Exception {
		// given
		Mockito.when(customerController.getCustomer(1111L)).thenThrow(new CustomerNotFoundException());
		// when & then
		mockMvc.perform(get("/v1/customer/1111")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}