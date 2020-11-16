package com.kodilla.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardDTO {
	private Long id;
	private Long customerId;
	private String cardType;
}
