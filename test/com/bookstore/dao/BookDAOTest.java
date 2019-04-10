package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import antlr.collections.List;

@SuppressWarnings("unused")
public class BookDAOTest  extends BaseDAOTest {
    private static BookDAO bookDao;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	BaseDAOTest.setUpBeforeClass();
	bookDao=new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("java");
		category.setCategoryId(6);
		newBook.setCategory(category );
		
		newBook.setTitle("EEjhouiu");
		newBook.setAuthor("Joshua ");
		newBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
		newBook.setPrice(38.87f);
		newBook.setIsbn("0321356683");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
		Date publishDate = dateFormat.parse("05/28/2008");
		newBook.setPublishedDate(publishDate);
		
		String imagePath = "C:\\Users\\krishna\\Desktop\\BooksPicture\\effectivejava.jpg";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newBook);
	    System.out.println(createdBook.getBookId());
		assertTrue(createdBook.getBookId()>0);
	
	}
	@Test
	public void testCreate2ndBook() throws ParseException, IOException {
		Book newBook = new Book();
		
		Category category = new Category("maths");
		category.setCategoryId(13);
		newBook.setCategory(category );
		
		newBook.setTitle("Java 8 In action");
		newBook.setAuthor("suresh prabhu");
		newBook.setDescription("New coverage of java, j2ee, annotations, autoboxing");
		newBook.setPrice(38.87f);
		newBook.setIsbn("0321356683");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
		Date publishDate = dateFormat.parse("08/28/2014");
		newBook.setPublishedDate(publishDate);
		
		String imagePath = "C:\\Users\\krishna\\Desktop\\BooksPicture\\java8.jpg";
		
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDao.create(newBook);
	    System.out.println(createdBook.getBookId());
		assertTrue(createdBook.getBookId()>0);
	
	}
@Test
public void testUpdateBook() throws ParseException, IOException {
	Book existBook = new Book();
	existBook.setBookId(1);
	Category category = new Category("oracle");
	category.setCategoryId(28);
	existBook.setCategory(category );
	
	existBook.setTitle("EEjho 3r edition");
	existBook.setAuthor("Joshua ");
	existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
	existBook.setPrice(70f);
	existBook.setIsbn("03216683");
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");		
	Date publishDate = dateFormat.parse("05/28/2008");
	existBook.setPublishedDate(publishDate);
	
	String imagePath = "C:\\Users\\krishna\\Desktop\\BooksPicture\\effectivejava.jpg";
	
	byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
	existBook.setImage(imageBytes);
	
	Book updatedBook = bookDao.update(existBook);
    System.out.println(updatedBook.getBookId());
	assertEquals(updatedBook.getTitle(),"EEjho 3r edition");

}
@Test(expected=EntityNotFoundException.class)
public void testDeleteBook(){
	Integer bookId=105;
	bookDao.delete(bookId);
	
}
@Test
public void testDeleteSuccess(){
	Integer bookId=17;
	bookDao.delete(bookId);
	assertTrue(true);
}
@Test
public void testGetBook(){
	Integer bookId=99;
	Book book=bookDao.get(bookId);
	assertNull(book);
}
@Test
public void testGetBookSuccess(){
	Integer bookId=19;
	bookDao.delete(bookId);
	assertTrue(true);
}
@Test
public void testListAll(){
	java.util.List<Book> listBooks=bookDao.listAll();
	
	for(Book aBook:listBooks){
		System.out.println(aBook.getTitle()+" -"+aBook.getAuthor());
	}
	assertFalse(listBooks.isEmpty());
	
}
@Test
public void testFindByTitleNotExist(){
	String title="Thinking in java";
  Book book=bookDao.findByTitle(title);
  assertNull(book);
}
@Test
public void testFindByTitleExist(){
	String title="Java 8 in action";
	  Book book=bookDao.findByTitle(title);
	  System.out.println(book.getAuthor());
	  System.out.println(book.getPrice());
	  assertNotNull(book);
}
@Test
public void testCount(){
	long totalBooks=bookDao.count();
	assertEquals(16,totalBooks);
	
}
}
