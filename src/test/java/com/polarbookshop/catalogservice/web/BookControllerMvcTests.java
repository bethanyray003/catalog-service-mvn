package com.polarbookshop.catalogservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.polarbookshop.catalogservice.domain.BookNotFoundException;
import com.polarbookshop.catalogservice.domain.BookService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNotExiwtingThenShouldReturn404() throws Exception{
        String isbn = "73737313940";

        // Defines the expected behavior for the BookService mock bean
        given(bookService.viewBookDetails(isbn)).willThrow(BookNotFoundException.class);

        // Perform the HTTP GET request and verify the result
        mockMvc.perform(get("/books/" + isbn))
        .andExpect(status().isNotFound());
    }
}
