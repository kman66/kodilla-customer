package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(
		stubsMode = StubRunnerProperties.StubsMode.LOCAL,
		ids = {
				"com.kodilla:accounts:+:stubs:9000"
		}
)
class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	void findCustomerAccounts() {
		// given
		Long customerId = 1234L;
		// when
		List<AccountDTO> accounts = productService.findCustomerAccounts(customerId);
		// then
		assertEquals(2, accounts.size());
	}

}