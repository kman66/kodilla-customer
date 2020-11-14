package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDTO;
import com.kodilla.customer.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final AccountsProvider accountsProvider;

	public List<AccountDTO> findCustomerAccounts(Long customerId) {
		return accountsProvider.getCustomerAccounts(customerId);
	}
}
