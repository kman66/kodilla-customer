package com.kodilla.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class AccountDTO {
	private Long id;
	private String nrb;
	private String currency;
	private BigDecimal availableFunds;
}
