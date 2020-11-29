
	import java.util.Date;
	import java.io.Serializable;

public class Student implements Serializable {
//serial uid for data
		private static final long serialVersionUID = 1L;
//attributes of clalss
		private String name,email,city,address,contact,password;
		private Date date;
		private int id;
		
		//Empty Constructor
		public Student(){
			this.id=0;
			this.setDate(new Date());
			this.name="";
			this.password="";
			this.email="";
			this.city="";
			this.address="";
			this.contact="";
		}
		//@param Contructor
		public Student(int id,Date date,String name,String password,String email,String city,String address,String contact){
			this.id=id;
			this.setDate(date);
			this.name=name;
			this.password=password;
			this.email=email;
			this.city=city;
			this.address=address;
			this.contact=contact;
		}
		
		
//getter and setter for name
		public String getName(){
			return name;
		}
	
		public void setName(String name){
			this.name=name;
		}
		//getter and setter for password
		public String getPassword(){
			return password;
		}
		
		public void setPassword(String password){
			this.password=password;
		}
		//getter and setter for email
		public String getEmail(){
			return email;
		}
		
		public void setEmail(String email){
			this.email=email;
		}
		//getter and setter for city
		public String getCity(){
			return city;
		}
		
		public void setCity(String city){
			this.city=city;
		}
		//getter and setter for address
		public String getAddress(){
			return address;
		}
		
		public void setAddress(String address){
			this.address=address;
		}
		//getter and setter for contacts
		public String getContact(){
			return contact;
		}
		
		public void setContact(String contact){
			this.contact=contact;
		}
//getter and setter for date
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
//getter and setter for id
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
//method for showing student data
		@Override
		public String toString() {
			return "Student [name=" + name + ", email=" + email + ", city=" + city + ", address=" + address
					+ ", contact=" + contact + ", password=" + password + ", date=" + date + ", id=" + id + "]";
		}
		
		
	}


