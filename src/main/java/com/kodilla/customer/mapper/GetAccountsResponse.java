package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class GetAccountsResponse {
	private List<AccountDTO> accounts;
}
