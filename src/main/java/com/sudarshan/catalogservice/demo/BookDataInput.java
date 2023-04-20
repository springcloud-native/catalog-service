package com.sudarshan.catalogservice.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sudarshan.catalogservice.domain.Book;
import com.sudarshan.catalogservice.domain.BookMemRepository;

@Component
@ConditionalOnProperty(name = "polar.proddata.enabled", havingValue = "true")
public class BookDataInput {
	
	private final BookMemRepository bookRepository;
	public BookDataInput(BookMemRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadBookTestData() {
		var book1 = Book.of("1", "Prod Book 1", "Author 1", 10.90, "Polarsophia");
		var book2 = Book.of("2", "Prod Book 2", "Author 2", 11.90, "Polarsophia");
		bookRepository.save(book1);
		bookRepository.save(book2);
	}

}
