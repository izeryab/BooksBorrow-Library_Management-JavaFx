import java.util.Date;
import java.io.Serializable;

/**
 * Class Librarian Design to Handle Librarian Data
 * */
public class Librarian implements Serializable {
//Data members
	private static final long serialVersionUID = 1L;
	private String name,email,city,address,contact,password;
	private Date date;
	private int id;
	//Constructor
	public Librarian(){
		this.id=0;
		this.setDate(new Date());
		this.name="";
		this.password="";
		this.email="";
		this.city="";
		this.address="";
		this.contact="";
	}
	//Constructor
	public Librarian(int id,Date date,String name,String password,String email,String city,String address,String contact){
		this.id=id;
		this.setDate(date);
		this.name=name;
		this.password=password;
		this.email=email;
		this.city=city;
		this.address=address;
		this.contact=contact;
	}
	
/**
 *Getter and Setter for Attributes 
 */	

	
	//Get Name
	public String getName(){
		return name;
	}
	//Set Name
	public void setName(String name){
		this.name=name;
	}
	//Get
	
	public String getPassword(){
		return password;
	}
	//Set
	public void setPassword(String password){
		this.password=password;
	}
	//Get
	
	public String getEmail(){
		return email;
	}
	//Set
	public void setEmail(String email){
		this.email=email;
	}
	//Get
	
	public String getCity(){
		return city;
	}
	//Set
	public void setCity(String city){
		this.city=city;
	}
	//Get
	
	public String getAddress(){
		return address;
	}
	//Set
	public void setAddress(String address){
		this.address=address;
	}
	//Get
	
	public String getContact(){
		return contact;
	}
	//Set
	public void setContact(String contact){
		this.contact=contact;
	}
	//Get

	public Date getDate() {
		return date;
	}
	//Set
	public void setDate(Date date) {
		this.date = date;
	}
	//Get

	public int getId() {
		return id;
	}
	//Set
	public void setId(int id) {
		this.id = id;
	}
	
	
}
