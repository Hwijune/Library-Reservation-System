package t;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class borrowdetails
{
	public final StringProperty num;
	public final StringProperty name;
	public final StringProperty author;
	public final StringProperty status;
	public final StringProperty tt5;
	public final StringProperty tt6;
	public final StringProperty tt7;
   
   public borrowdetails(String num, String name, String author, String status, String tt5, String tt6, String tt7)
   {
      this.num = new SimpleStringProperty(num);
      this.name = new SimpleStringProperty(name);
      this.author = new SimpleStringProperty(author);
      this.status = new SimpleStringProperty(status);
      this.tt5 = new SimpleStringProperty(tt5);
      this.tt6 = new SimpleStringProperty(tt6);
      this.tt7 = new SimpleStringProperty(tt7);
      
   }
   
   public String getNum()
   {
      return num.get();
   }
   
   public String getName()
   {
      return name.get();
   }
   
   public String getAuthor()
   {
      return author.get();
   }
   
   public String getStatus()
   {
      return status.get();
   }
   
   public String getTt5()
   {
      return status.get();
   }
   
   public String getTt6()
   {
      return status.get();
   }
   
   public String getTt7()
   {
      return status.get();
   }
   
   public void setNum(String value)
   {
      num.set(value);
   }
   
   public void setName(String value)
   {
      name.set(value);
   }
   
   public void setAuthor(String value)
   {
      author.set(value);
   }
   
   public void setStatus(String value)
   {
      status.set(value);
   }
   
   public void setTt5(String value)
   {
      tt5.set(value);
   }
   
   public void setTt6(String value)
   {
      tt6.set(value);
   }
   
   public void setTt7(String value)
   {
      tt7.set(value);
   }
   
   public StringProperty numProperty()
   {
      return num;
   }
   
   public StringProperty nameProperty()
   {
      return name;
   }
   
   public StringProperty authorProperty()
   {
      return author;
   }
   
   public StringProperty statusProperty()
   {
      return status;
   }
   
   public StringProperty tt5Property()
   {
      return tt5;
   }
   
   public StringProperty tt6Property()
   {
      return tt6;
   }
   
   public StringProperty tt7Property()
   {
      return tt7;
   }
}