package com.kodilla.customer.provider;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

	private final AccountsConnector accountsConnector;

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
}
