package com.codemind.restapi.example.com.restapi.book.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class BookController {
	//@RequestMapping(value = "books", method = RequestMethod.GET)
	/*
	@GetMapping("/books")
	public Book getBooks() {
		Book book = new Book();
		book.setId(123);
		book.setTitle("java reference");
		book.setAuthor("xyz");
		
		return book;
	}*/
	@Autowired
	private BookSevice bookSevice;
	
	// get all books
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookSevice.getAllBooks();
	}
	
	// get single book
	@GetMapping("/books/{id}")
	public Book getbook(@PathVariable("id") int id) {
		return bookSevice.getBookById(id);
	}
	
	// add books
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookSevice.addBook(book);
		return b;
	}
	
	// delete books
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookSevice.deleteBook(bookId);
	}
	
	// update books
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookSevice.updateBook(book, bookId);
		return book;
	}

}
