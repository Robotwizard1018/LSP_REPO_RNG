package org.howard.edu.lsp.midterm.question2;

import java.util.*;
import java.io.*;


public class Book {
	
	private String title;
	private String author;
	private String ISBN;
	private int yearPublished;
	
	
	public Book(String title, String author, String ISBN, int yearPublished){
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.yearPublished = yearPublished;
	}
	
	public String getAuthor() {
		return this.author;
	}

	public String getISBN() {
		return this.ISBN;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)){
			return false;
		}
		Book bookB = (Book) obj;
		return this.ISBN.equals(bookB.getISBN()) && this.author.equals(bookB.getAuthor());
		
	}
	
	@Override
	public String toString() {
		return "Title: " + this.title + ", Author: " + this.author +
			   ", ISBN: " + this.ISBN + ", Year Published: " + this.yearPublished;
	}

	
	
	
	
	
	
}

