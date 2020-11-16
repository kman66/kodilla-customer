package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.CardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCardsResponse {
	private List<CardDTO> cards;
}
