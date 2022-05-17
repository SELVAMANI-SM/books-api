package com.books.validation;

import com.books.exception.ValidationException;
import com.books.model.Book;

public class BookValidation {
public static void bookCheck(Book book) throws ValidationException
{
	checkName(book.getName());
	checkDepartment(book.getDepartment());
	CheckRs(book.getRs());
	
	checkBookLink(book.getEBookLink());

	checkImageLink(book.getImageLink());

}

public  static void CheckRs(Integer rs) throws ValidationException {
	if(rs==0)
	{
		throw new ValidationException("Invalid amount");
	}
	
}

public static void checkImageLink(String imageLink) throws ValidationException {
	if(imageLink==null||imageLink.trim()=="")
	{
		throw new ValidationException("Invalid Image Link");
	}
	
}



public static void checkBookLink(String eBookLink) throws ValidationException {
	if(eBookLink==null||eBookLink.trim()=="")
	{
		throw new ValidationException("Invalid E-Book  Link");
	}
	
}





public static void checkDepartment(String department) throws ValidationException {

	if(department==null||department.trim()=="")
	{
		throw new ValidationException("Invalid depart ");
	}
}

public static void checkName(String name) throws ValidationException {
	
	if(name==null||name.trim()=="")
	{
		throw new ValidationException("Invalid Name ");
	}
}
public static void bookUpdateCheck(Book book) throws ValidationException
{
	checkIdUpdate(book.getId());
	checkNameUpdate(book.getName());
	checkDepartmentUpdate(book.getDepartment());
	
	checkBookLinkUpdate(book.getEBookLink());
	checkRsLinkUpdate(book.getRs());
	checkImageLinkUpdate(book.getImageLink());

}

public static void checkRsLinkUpdate(Integer rs) throws ValidationException {
	if(rs==0)
	{
		throw new ValidationException("Invalid Rs");
	}
	
	
}

private static void checkIdUpdate(Integer id) throws ValidationException {
	if(id<0)
	{
		throw new ValidationException("Invalid ID");
	}
	
}

private static void checkNameUpdate(String name) throws ValidationException {
	if(name==null||name.trim()=="")
	{
		throw new ValidationException("Invalid Book Name ");
	}
	
}

public static void checkDepartmentUpdate(String department) throws ValidationException {
	if(department==null||department.trim()=="")
	{
		throw new ValidationException("Invalid depart");
	}
	
}

public static void checkAuthorUpdate(String author) throws ValidationException {
	if(author==null||author.trim()=="")
	{
		throw new ValidationException("Invalid Author ");
	}
	
}

public static void checkStatusUpdate(String status) throws ValidationException {
	if(status==null||status.trim()=="")
	{
		throw new ValidationException("Invalid Status ");
	}
	
}

public static void checkBookLinkUpdate(String eBookLink) throws ValidationException {
	if(eBookLink==null||eBookLink.trim()=="")
	{
		throw new ValidationException("Invalid E-Book  Link");
	}
	
}


public static void checkImageLinkUpdate(String imageLink) throws ValidationException {
	if(imageLink==null||imageLink.trim()=="")
	{
		throw new ValidationException("Invalid Image Link");
	}
	
}


}
