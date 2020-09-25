package com.nttdata.casestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

	// to establish connection with database
	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy", "root", "root");
			if (con != null) {
				System.out.println("Database Connection established");
			}
		} catch (Exception e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
		return con;

	}

	// This method is used to insert the book details
	public int createBook() throws Exception {

		PreparedStatement statement = null;
		Connection con = null;
		int result = 0;
		try {
			con = BookDao.getConnection();
			BookPojo book = new BookPojo();
			String sql = "INSERT INTO BOOK(BOOKNAME,AUTHORNAME,EDITION) VALUES (?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, book.getBookName());
			statement.setString(2, book.getAuthorName());
			statement.setInt(3, book.getEdition());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
		return result;
	}

	// This method is used Fetch the details of a book using ISBN number
	public boolean readBook(BookPojo book) throws Exception {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement statement = null;
		try {
			con = BookDao.getConnection();
			String sql = ("SELECT * FROM BOOK WHERE ISBNNUMBER= " + book.getIsbnNumber());
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			if (rs.first()) {
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					int isbnNumber = rs.getInt("isbnNumber");
					String bookName = rs.getString("bookName");
					String authorName = rs.getString("Author_name");
					int edition = rs.getInt("Edition");
					System.out.println("ISBN Number:" + isbnNumber + "\n");
					System.out.println("Book name :" + bookName + "\n");
					System.out.println("Author name:" + authorName + "\n");
					System.out.println("Edition:" + edition + "\n");
				}
			} else {
				System.out.println("Invalid ISBN number");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
		return true;
	}

	// This method is used to update details of book
	public int updateBook(BookPojo book) throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			con = BookDao.getConnection();
			String sql = "UPDATE BOOK SET BOOKNAME=? ,AUTHORNAME= ?, EDITION =? where ISBNNUMBER= ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, book.getBookName());
			statement.setString(2, book.getAuthorName());
			statement.setInt(3, book.getEdition());
			statement.setInt(4, book.getIsbnNumber());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
		return result;
	}

	// This method is to delete the book details using ISBN number
	public int deleteBook() throws Exception {
		Connection con = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			con = BookDao.getConnection();
			BookPojo book = new BookPojo();
			String sql = "DELETE FROM BOOK WHERE ISBNNUMBER=?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, book.getIsbnNumber());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			statement.close();
			con.close();
		}
		return result;
	}
}
