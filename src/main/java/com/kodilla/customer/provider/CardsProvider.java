package com.kodilla.customer.provider;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.dto.CardDTO;
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
public class CardsProvider {

	private final CardsConnector cardsConnector;

	@HystrixCommand(fallbackMethod = "fallbackGetCards")
	public List<CardDTO> getCustomerCards(Long customerId) {
		return cardsConnector.getCards(customerId)
				.getCards()
				.stream()
				.map(card -> new CardDTO(
						card.getId(),
						card.getCustomerId(),
						card.getCardType()
				)).collect(Collectors.toList());
	}

	public List<CardDTO> fallbackGetCards(Long customerId) {
		log.warn("Can not get cards for customer: {}", customerId);
		return Collections.emptyList();
	}
}
