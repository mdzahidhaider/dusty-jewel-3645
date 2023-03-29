package com.sweetopia.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
}
