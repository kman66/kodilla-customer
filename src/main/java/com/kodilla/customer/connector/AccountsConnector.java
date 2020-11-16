package com.kodilla.customer.connector;

import com.kodilla.customer.mapper.GetAccountsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accounts")
public interface AccountsConnector {
	@GetMapping("/v1/accounts")
	GetAccountsResponse getAccounts(@RequestParam("customerId") Long customerId);
}
