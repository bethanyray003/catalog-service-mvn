package com.polarbookshop.catalogservice.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.Instant;


public record Book(
	@Id
	Long id,
	
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
	Double price,

	@CreatedDate
	Instant createdDate,

	@LastModifiedDate
	Instant lastModifiedDate,

	@Version
	int version
){

	public static Book of(String isbn, String title, String author, Double price){
		return new Book(null, isbn, title, author, price, null, null, 0);
	}
}

