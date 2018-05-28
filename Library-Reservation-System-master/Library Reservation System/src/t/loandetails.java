package t;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class loandetails
{
	public final StringProperty booknum;
	public final StringProperty bookname;
	public final StringProperty borrowdate;
	public final StringProperty returndate;
	

	
	public loandetails(String booknum, String bookname, String borrowdate, String returndate)
	{
		this.booknum = new SimpleStringProperty(booknum);
		this.bookname = new SimpleStringProperty(bookname);
		this.borrowdate = new SimpleStringProperty(borrowdate);
		this.returndate = new SimpleStringProperty(returndate);
	}
	
	public String getBooknum()
	{
		return booknum.get();
	}
	
	public String getBookname()
	{
		return bookname.get();
	}
	
	public String getBorrowdate()
	{
		return borrowdate.get();
	}
	
	public String getReturndate()
	{
		return returndate.get();
	}
	
	public void setBooknum(String value)
	{
		booknum.set(value);
	}
	
	public void setBookname(String value)
	{
		bookname.set(value);
	}
	
	public void setBorrowdate(String value)
	{
		borrowdate.set(value);
	}
	
	public void setReturndate(String value)
	{
		returndate.set(value);
	}
	
	public StringProperty booknumProperty()
	{
		return booknum;
	}
	
	public StringProperty booknameProperty()
	{
		return bookname;
	}
	
	public StringProperty borrowdateProperty()
	{
		return borrowdate;
	}
	
	public StringProperty returndateProperty()
	{
		return returndate;
	}
	
}
