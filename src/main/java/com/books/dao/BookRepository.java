package com.books.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.books.connection.ConnectionUtilDao;
import com.books.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public static  List<Book> bookName( String name) throws Exception
	{
		List<Book> booksdetails=  new ArrayList<Book>();
		Connection connection=ConnectionUtilDao.sqlConnection();
		Statement statement=null;
		ResultSet result=null;
		String query="SELECT * FROM books WHERE NAME LIKE '%"+name+"%'";
		statement=connection.createStatement();
		result=statement.executeQuery(query);
		Book book=null;
		while(result.next())
		{
			book=new Book();
			Integer bookId=result.getInt("id");
			String bookName=result.getString("name");
			String dept=result.getString("department");
			Integer rs=result.getInt("rs");
			String eBookLink=result.getString("e_book_link");
			String imageLink=result.getString("image_link");
			
			book.setId(bookId);
			book.setName(bookName);
		    book.setDepartment(dept);
		    book.setRs(rs);
			book.setEBookLink(eBookLink);
			book.setImageLink(imageLink);
			
		
		
			
			booksdetails.add(book);
			
			
		}
		return booksdetails;
	}
	@Transactional
	@Modifying
	@Query("delete from Book u where u.id=:id")
	void deleteByBookId(@Param("id") Integer id);

	public List<Book> findByDepartment(String department);
}

