package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountsResponse {
	private List<AccountDTO> accounts;
}
