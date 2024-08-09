/**
 * This test is an example of using SpringBootTest
 * Bootstraps an application to allow testing of component interactions
 * Also shows use of a mock web environment with WebTestClient
 * 
 * Requires spring-boot-starter-webflux dependency
 */

package com.polarbookshop.catalogservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.polarbookshop.catalogservice.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
	// Configures a Random Port web application with a servlet container listening on a random port
	// can also use MOCK, DEFINED_PORT and NONE
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CatalogServiceApplicationTests {

	// Utility for making REST calls
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void whenPostRequestThenBookCreated(){
		var expectedBook = new Book("1231231231", "Title", "Author", 9.90);
 
		webTestClient
			.post()
			.uri("/books")
			.bodyValue(expectedBook)
			.exchange()
			.expectStatus().isCreated()
			.expectBody(Book.class).value(actualBook -> {
				assertThat(actualBook).isNotNull();
				assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
			});
	}
	
	@Test
	void contextLoads() {
	}

}
