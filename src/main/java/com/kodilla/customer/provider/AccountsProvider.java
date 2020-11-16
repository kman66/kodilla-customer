package com.kodilla.customer.provider;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.dto.AccountDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsProvider {

	private final AccountsConnector accountsConnector;

	@HystrixCommand(fallbackMethod = "fallbackGetAccounts")
	public List<AccountDTO> getCustomerAccounts(Long customerId) {
		return accountsConnector.getAccounts(customerId)
				.getAccounts()
				.stream()
				.map(account -> new AccountDTO(
						account.getId(),
						account.getNrb(),
						account.getCurrency(),
						account.getAvailableFunds()
				)).collect(Collectors.toList());
	}

	public List<AccountDTO> fallbackGetAccounts(Long customerId) {
		log.warn("Can not get accounts for customer: {}", customerId);
		return Collections.emptyList();
	}
}
