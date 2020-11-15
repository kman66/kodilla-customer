package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountsResponse {
	private List<AccountDTO> accounts;
}
