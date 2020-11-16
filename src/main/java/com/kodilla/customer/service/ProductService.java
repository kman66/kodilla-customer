package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDTO;
import com.kodilla.customer.dto.CardDTO;
import com.kodilla.customer.provider.AccountsProvider;
import com.kodilla.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final AccountsProvider accountsProvider;
	private final CardsProvider cardsProvider;

	public List<AccountDTO> findCustomerAccounts(Long customerId) {
		return accountsProvider.getCustomerAccounts(customerId);
	}

	public List<CardDTO> findCustomerCards(Long customerId) {
		return cardsProvider.getCustomerCards(customerId);
	}
}
