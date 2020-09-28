package com.nttdata.casestudy;

import static org.junit.Assert.*;
import java.sql.Connection;
import org.junit.Test;

public class bookTest {

	@Test
	public void testOpenConnection() {
		System.out.println("openConnection");
		Connection result = BookDao.getConnection();
		assertEquals(result != null, true);
	}

	@Test
	public void testCreateBook() throws Exception {
		BookDao dao = new BookDao();
		BookPojo book=new BookPojo();
		int check = dao.createBook(book);
		assertEquals(check, 1);
	}
	@Test
	public void testReadBook() throws Exception {
		BookDao dao = new BookDao();
		BookPojo book = new BookPojo();
		boolean check = dao.readBook(book);
		assertEquals(check, true);
	}


	@Test
	public void testUpdateBook() throws Exception {
		BookDao dao = new BookDao();
		BookPojo book = new BookPojo();
		int check = dao.updateBook(book);
		assertEquals(check, 0);

	}

	@Test
	public void testDeleteBook() throws Exception {
		BookDao dao = new BookDao();
		int check = dao.deleteBook();
		assertEquals(check, 0);
	}

}
