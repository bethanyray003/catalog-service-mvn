package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


public record Book(
	
	@NotBlank(message="Add a fucking ISBN you dolt!!")
	@Pattern(                                               
		regexp = "^([0-9]{10}|[0-9]{13})$", 
		message = "The ISBN format must be valid." 
	) 
	String isbn,

	@NotBlank(message="The fucking book needs a fucking title you DIPSHIT!!!")
	String title,

	@NotBlank(message="Oh, did this motherfucking book write itself???")
	String author,

	@NotNull(message="If you want to earn a living, GIVE A FUCKING PRICE!!")
	@Positive(message="So you're going to pay me to read this book??")
	Double price
){

}

