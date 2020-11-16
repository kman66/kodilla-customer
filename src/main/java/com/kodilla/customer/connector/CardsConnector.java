package com.kodilla.customer.connector;

import com.kodilla.customer.mapper.GetCardsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards")
public interface CardsConnector {
	@GetMapping("/v1/cards")
	GetCardsResponse getCards(@RequestParam Long customerId);
}
