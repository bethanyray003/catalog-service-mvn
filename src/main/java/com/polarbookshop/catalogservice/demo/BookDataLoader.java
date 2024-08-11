package com.polarbookshop.catalogservice.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        var book1 = new Book("1234567891", "Northern Lights", "Lyra Silverstar", 15.99);
        var book2 = new Book("9876543219", "The Silmarillion", "JRR Tolkien", 10.0);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
