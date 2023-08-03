package com.codemind.restapi.example.com.restapi.book.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookSevice {

	private static List<Book> list =  new ArrayList<>();
	
	static {
		list.add(new Book(12,"Java Reference","xyx"));
		list.add(new Book(34,"Python Reference","pqr"));
		list.add(new Book(46,"Js Reference","abc"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return list;
		
	}
	
	// get single book
	public Book getBookById(int id) {
		
		Book book = null;
	     book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	 
	}
	
	//adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete book
	public void deleteBook(int  bid) {
		list =list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
	}
	
	//update book
	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
