package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.AccountDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse {
	private final List<AccountDTO> accounts;
}
