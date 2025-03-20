package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a book with a title, author, ISBN, and publication year.
 */
public class Book {
	
	private String title;
	private String author;
	private String ISBN;
	private int yearPublished;
	
	/**
     * Constructs a new Book object with the given details.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param ISBN the ISBN of the book
     * @param yearPublished the year the book was published
     */
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
	
	 /**
     * Checks equality based on ISBN and author.
     *
     * @param obj the object to compare
     * @return true if obj is a Book and has the same ISBN and author
     */
    @Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)){
			return false;
		}
		Book bookB = (Book) obj;
		return this.ISBN.equals(bookB.getISBN()) && this.author.equals(bookB.getAuthor());
		
	}
	
    /**
     * Returns overridden toString for a string representation of the book.
     *
     * @return the formatted book details string
     */
    @Override
	public String toString() {
		return "Title: " + this.title + ", Author: " + this.author +
			   ", ISBN: " + this.ISBN + ", Year Published: " + this.yearPublished;
	}

	

	
	
	
}

