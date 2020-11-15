package com.kodilla.customer.mapper;

import com.kodilla.customer.dto.CardDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetCardsResponse {
	private final List<CardDTO> cards;
}
