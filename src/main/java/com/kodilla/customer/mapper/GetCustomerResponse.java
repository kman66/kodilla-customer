package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.CustomerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetCustomerResponse extends CustomerDTO {

	public GetCustomerResponse(CustomerDTO customerDto) {
		super(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName());
	}
}
