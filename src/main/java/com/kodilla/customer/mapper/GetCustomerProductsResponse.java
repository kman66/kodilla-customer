package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerProductsResponse {
	private Long customerId;
	private String fullName;
	private List<AccountDTO> accounts;
}
