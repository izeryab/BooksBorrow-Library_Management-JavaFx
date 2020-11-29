
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * Admin Class Design For Admin Panel
 * 
 * */
public class Admin {
	//adding login object to go back to login screen from admin after logout 
	 LogIn l = new LogIn();
	 //main stage
	 static Stage window;
	 //Main Login Scene and Panel Scene
     static Scene  scene4, scene5;
     //Context Check Managing Librarian or Student
     String current="Student";
     //Initially on Librarian
     boolean studentpanel=false;
     //Buttons
      Button add,delete,Logout,savebt,btnswitch;
     //Tableview for Librarian
      TableView<Librarian> tableL;
      //Table view for Student
     TableView<Student> tableS;
     //Date picker
     DatePicker datep;
     //Textfields
     static TextField nametf,addresstf,contacttf,citytf,passtf,emailtf,idtf;
     //Observable lists for librarian data
     static ObservableList<Librarian> librarians = FXCollections.observableArrayList();
   //Observable lists for Student data
     static ObservableList<Student> Students = FXCollections.observableArrayList();
     
     
     //Constructor
    Admin(String title, int width, int height){
    	//setting stage
    	window = new Stage();
    	//adding stage title
    	window.setTitle(title);
    	//setting size of stage
    	window.setWidth(width);
    	window.setHeight(height);
    	//adding stage icon
    	window.getIcons().add(new Image("file:images/adminlogo.jpg"));
       //Main Layout
        Group adminlayout = new Group();
        
        //Animation for Fade Effect
        FadeTransition ft = new FadeTransition(Duration.millis(500), adminlayout);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		
		//Add Button to add data to table
	    add = new Button("Add ");
	    //styling
		add.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		add.setFont(Font.font(15));
		//resizing
		add.setPrefSize(130, 25);
		//Position
		add.setTranslateX(900);
		add.setTranslateY(370);
		//Adding event on add button and calling method addbuttonclicked
		add.setOnAction(e -> addButtonClicked());
		
		//delete Button to delete data from table
		delete = new Button("Delete ");
		//styling
		delete.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		delete.setFont(Font.font(15));
		delete.setPrefSize(130, 25);
		//position
		delete.setTranslateX(900);
		delete.setTranslateY(410);
		//adding action event on delete button and calling method deletebutton clicked
		delete.setOnAction( e -> deleteButtonClicked());
		
		//Save Button to save table data into file
		savebt = new Button("Save"); 
		//styling
		savebt.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		savebt.setFont(Font.font(15));
		savebt.setPrefSize(130, 25);
		//position
		savebt.setTranslateX(900);
		savebt.setTranslateY(450);
		//adding action on save button click and calling method
		savebt.setOnAction( e -> saveButtonClicked());
		
	//logout button to go back to main scene
		Logout = new Button("Log Out"); 
		//styling
		Logout.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		Logout.setFont(Font.font(15));
		Logout.setPrefSize(130, 25);
		//position
		Logout.setTranslateX(900);
		Logout.setTranslateY(490);
	//Button to switch context between managing student and managing librarian 
		btnswitch= new Button("Go to"+current);
		//styling
		btnswitch.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		btnswitch.setFont(Font.font(15));
		btnswitch.setPrefSize(130, 25);
		//position
		btnswitch.setTranslateX(900);
		btnswitch.setTranslateY(530);
		
		//for Adding Librarian
			Label labelname = new Label("Add Librarian");
			labelname.setFont(Font.font(25));
			labelname.setTranslateX(890);
		

			
			Label idlabel = new Label("ID: ");
			idlabel.setFont(Font.font(18));
			idlabel.setTranslateX(820);
			idlabel.setTranslateY(50);
		//Text field for Id 				
			idtf = new TextField();
			idtf.setPromptText("Enter ID");
			//positon
			idtf.setTranslateX(870);
			idtf.setTranslateY(50);
			//size
			idtf.setPrefWidth(200);
	
			Label datelabel = new Label("Date: ");
			datelabel.setFont(Font.font(18));
			datelabel.setTranslateX(810);
			datelabel.setTranslateY(90);
		//date picker to add date
			datep = new DatePicker();
			datep.setPromptText("Enter Date");
			//position
			datep.setTranslateX(870);
			datep.setTranslateY(90);
			//size
			datep.setPrefWidth(200);
						
			Label libname = new Label("Name: ");
			libname.setTranslateX(803);
			libname.setTranslateY(130);
			libname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        //TextField To Enter Name
			nametf = new TextField();
			nametf.setPromptText("Enter the Name:");
			//position of tedxtfield
			nametf.setTranslateX(870);
			nametf.setTranslateY(130);
			//size
			nametf.setPrefSize(200, 10);
	        
			Label libpass = new Label("Password: ");
			libpass.setTranslateX(790);
			libpass.setTranslateY(170);
			libpass.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			
			//textfield for password	 
			passtf = new TextField();
			//position
			passtf.setTranslateX(870);
			passtf.setTranslateY(170);
			//promt text for feild
			passtf.setPromptText("Enter Password");
			//size
			passtf.setPrefSize(200, 10);
		
			Label libemail = new Label("Email: ");
			libemail.setTranslateX(790);
			libemail.setTranslateY(210);
			libemail.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
					
			//Textfield for Email
			emailtf = new TextField();
			//position
			emailtf.setTranslateX(870);
			emailtf.setTranslateY(210);
			//promt text
			emailtf.setPromptText("Enter Email");
			//size
			emailtf.setPrefSize(200, 10);
			
			Label libaddress = new Label("Address: ");
			libaddress.setTranslateX(790);
			libaddress.setTranslateY(250);
			libaddress.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			//TExtField for Address 
			addresstf = new TextField();
			//position
			addresstf.setTranslateX(870);
			addresstf.setTranslateY(250);
			//prompt text
			addresstf.setPromptText("Enter Address");
			//size
			addresstf.setPrefSize(200, 10);
			
			Label libcity = new Label("City: ");
			libcity.setTranslateX(790);
			libcity.setTranslateY(290); 
			libcity.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			
			//TExtfield for City	
			citytf = new TextField();
			//position
			citytf.setTranslateX(870);
			citytf.setTranslateY(290);
			//promt text
			citytf.setPromptText("Enter City");
			//size
			citytf.setPrefSize(200, 10);
			
			Label libcontact = new Label("Contact: ");
			libcontact.setTranslateX(790);
			libcontact.setTranslateY(330);
			libcontact.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
			
			//TExtField for Contact
			contacttf = new TextField();
			//position
			contacttf.setTranslateX(870);
			contacttf.setTranslateY(330);
			//promt text
			contacttf.setPromptText("Enter Contact Number");
			//Size
			contacttf.setPrefSize(200, 10);
			
			
			
		
			//Adding Animation Effect
	        Rectangle  rect1 = new Rectangle(780,0,400,6);
	        rect1.setFill(Color.ORANGERED);
	        rect1.setOpacity(0.8f);
	        //Scale Transtion Animation 
	       ScaleTransition sc = new ScaleTransition(Duration.millis(3000),rect1);
	       sc.setToY(200);
	       sc.setCycleCount(1);
	       sc.play(); 
	        
	       //Adding all the component of Screen to layout
	        adminlayout.getChildren().addAll(LibrarianTable(),rect1);        
			adminlayout.getChildren().addAll(idlabel,idtf,datep,datelabel,labelname,libname,nametf,libpass,libemail,libaddress,libcity,libcontact,addresstf,contacttf,citytf,passtf,emailtf);
			adminlayout.getChildren().addAll(btnswitch,add,delete,Logout,savebt);
			//method for adding events
			addActionEvents();
			
			/**
			 * 
			 * This event Action used to switch between Librarian and Student.
			 * If Currently Admin is Managing Student than click on btnswitch will change the context to Student.
			 * */
			btnswitch.setOnAction(e->{
				if(current.equals("Student"))
				{
				labelname.setText("Add "+current);
				//view for change set to go to librarian
				current="Liabrarian";
				btnswitch.setText("Go to "+current);
				studentpanel=true;
				//if student panel than add Student Table to AdminLayout
				adminlayout.getChildren().add(StudentTable());
				}
				else {
					//current is not Student than change current to librarian
					labelname.setText("Add "+current);
					current="Student";
					btnswitch.setText("Go to "+current);
					studentpanel=false;
					//if not student panel than add Librarian Table to AdminLayout
					
					adminlayout.getChildren().add(LibrarianTable());
			
				}
			});
			//Setting scene for admin panel
			scene5 = new Scene(adminlayout,900,700);
			window.setScene(scene5);
			window.show();
			window.setResizable(false);
    }

//method to save data of table view to file
	private void saveButtonClicked() {
		Alert savealert = new Alert(AlertType.INFORMATION);
    	savealert.setHeaderText(null);
    	savealert.setContentText("Your data has been saved successfully!");
    	savealert.showAndWait();
    //if student section then save the data of table view to students.ser
		if(studentpanel) {
			try {	
		    	FileOutputStream fos = new FileOutputStream("data/students.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(new ArrayList<Student>(Students));
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	    //if librarian section then save the data of table view to librarian.ser

		else {
		try {	
	    	FileOutputStream fos = new FileOutputStream("data/librarians.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<Librarian>(librarians));
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		}
	}
    
	//Method to get data from Librarian file and store in to list
	public ObservableList<Librarian> getLibrarians() {
		try {
			FileInputStream fis = new FileInputStream("data/librarians.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Librarian> list = (List<Librarian>) ois.readObject();
			librarians = FXCollections.observableList(list);
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
     	return librarians;
	}
	//Method to get data from Student file and store in to list
	public ObservableList<Student> getStudent() {
		try {
			FileInputStream fis = new FileInputStream("data/students.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Student> list = (List<Student>) ois.readObject();
			Students = FXCollections.observableList(list);
			ois.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    	return Students;
	}
	//Method to validate data of text feilds
	private boolean validateInput(){
		
		if( idtf.getText().isEmpty() ||nametf.getText().isEmpty() || passtf.getText().isEmpty() ||
			emailtf.getText().isEmpty() || citytf.getText().isEmpty() || 
				addresstf.getText().isEmpty()){
			//if textfeilds are empty show error alert
			Alert warningalert = new Alert(AlertType.WARNING);
			warningalert.setHeaderText("TextFields are empty!");
			warningalert.setContentText("Please input the data");
			warningalert.showAndWait();
			
			return false;
			
		}
			
		return true;
	}
	
	private boolean emailValidate(){
	//	Librarian librarian = new Librarian();
		//if(libemailtf.getText().contains("@.com")){
		//	librarian.setEmail(libemailtf.getText());
			//return false;
				
	//	}
		/*
		else{
			Alert warningalert = new Alert(AlertType.ERROR);
			warningalert.setHeaderText(null);
			warningalert.setContentText("Email is incorrect!");
			warningalert.showAndWait();
		}*/
		return true;
	}
	//Method to clear Text feilds
	public void cleartf() {
		idtf.clear();
		nametf.clear();
		passtf.clear();
		emailtf.clear();
		addresstf.clear();
		citytf.clear();
		contacttf.clear();

	}
	//Method to add data into Table view
	public void addButtonClicked() {
		//if data is valid check wheter we have student panel aur librarian panel
		if((validateInput() && emailValidate())) {
			if(studentpanel) {
				//if student panel
				//create object of Student
				Student student = new Student();
				//Assign data to student by getting data from textfeilds
				student.setEmail(emailtf.getText());
				student.setId(Integer.parseInt(idtf.getText()));
				student.setDate(java.sql.Date.valueOf(datep.getValue()));
				student.setName(nametf.getText());
				student.setPassword(passtf.getText());
				student.setAddress(addresstf.getText());
				student.setCity(citytf.getText());
				student.setContact((contacttf.getText()));
				//add student object to Student table view
				tableS.getItems().add(student);
				//clear text feilds
				cleartf();
			}
			else { 
				//if librarian panel
				//create object of Librarian
	
				Librarian librarian = new Librarian();
				//Assign data to Librarian by getting data from textfeilds
				
				librarian.setEmail(emailtf.getText());
				librarian.setId(Integer.parseInt(idtf.getText()));
				librarian.setDate(java.sql.Date.valueOf(datep.getValue()));
				librarian.setName(nametf.getText());
				librarian.setPassword(passtf.getText());
				librarian.setAddress(addresstf.getText());
				librarian.setCity(citytf.getText());
				librarian.setContact((contacttf.getText()));	
				//add Librarian object to Librarian table view
				
				tableL.getItems().add(librarian);
				//clear textfields
				idtf.clear();
				cleartf();	
				}
		}
	}
	//Method to delete data from table view
	public void deleteButtonClicked() {
  /**
   * Ask for confirmation
   * */
    	
    	  	Alert alert = new Alert(AlertType.CONFIRMATION,"Are you sure to delete?",ButtonType.YES,ButtonType.NO);
        	alert.setHeaderText(null);
      
        	Optional<ButtonType> result = alert.showAndWait();
        	/**
        	 * if confirm check for if it is student panel or librarian panel
        	 * */
        	if(result.get() == ButtonType.YES){
        		if(studentpanel) {
        			//remove the selected students from table view
        			try {
        			ObservableList<Student> studentSelected, allstudent;
        			allstudent = tableS.getItems();
        			System.out.println(tableS.getSelectionModel().getSelectedItem());
        			studentSelected = tableS.getSelectionModel().getSelectedItems();
        			studentSelected.forEach(allstudent::remove);
        			}
        			catch (Exception e) {
						// TODO: handle exception
					System.out.println(e.getMessage());
        			}
        		}
        		else {
        			//remove the selected librarians from table view

        			ObservableList<Librarian> librarianSelected, alllibrarian;
        		    alllibrarian = tableL.getItems();
        		    librarianSelected = tableL.getSelectionModel().getSelectedItems();
        		    librarianSelected.forEach(alllibrarian::remove);		
        		}
        	}
        	
        	else{
        	alert.close();
        	}
          		
    	
    }
	//Method for Creating Group Librarian Table
    @SuppressWarnings("unchecked")
	public Group LibrarianTable() {
    	Group L=new Group();	
		 //ID column
       TableColumn<Librarian, Integer> idColumn = new TableColumn<>("Id");
       idColumn.setMinWidth(50);
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		
       //Date column
       TableColumn<Librarian, String> dateColumn = new TableColumn<>("Date");
       dateColumn.setMinWidth(80);
       dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		
       //Name column
       TableColumn<Librarian, String> nameColumn = new TableColumn<>("Name");
       nameColumn.setMinWidth(100);
       nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

       //password column
       TableColumn<Librarian, String> passwordColumn = new TableColumn<>("Password");
       passwordColumn.setMinWidth(100);
       passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
       
       //email column
       TableColumn<Librarian, String> emailColumn = new TableColumn<>("Email");
       emailColumn.setMinWidth(150);
       emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		
       //City column
       TableColumn<Librarian, String> cityColumn = new TableColumn<>("City");
       cityColumn.setMinWidth(100);
       cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

       //Address column
       TableColumn<Librarian, String> addressColumn = new TableColumn<>("Address");
       addressColumn.setMinWidth(100);
       addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

       //contact column
       TableColumn<Librarian, String> contactColumn = new TableColumn<>("Contact");
       contactColumn.setMinWidth(100);
       contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
	//Table view for librarian	
		tableL = new TableView<>();
		//size
		tableL.setPrefHeight(570);
		tableL.setPrefWidth(780);
		//get data of table from file
		tableL.setItems(getLibrarians());
		//addind table columns
       tableL.getColumns().addAll(idColumn,dateColumn,nameColumn,passwordColumn,emailColumn,cityColumn,addressColumn,contactColumn);
   	tableL.setItems(getLibrarians());
   //Adding table to Group layout
       L.getChildren().add(tableL);
	//return Group Layout
    	return L;
    }
    
	//Method for Creating Group Student Table
    @SuppressWarnings("unchecked")
	public Group StudentTable() {
    	//Table view for Student
    	tableS = new TableView<>();
    	//size
		tableS.setPrefHeight(570);
		tableS.setPrefWidth(780);
		//Getting Table data
		tableS.setItems(getStudent());
    	 //ID column
        TableColumn<Student, Integer> idColumns = new TableColumn<>("Id");
        idColumns.setMinWidth(50);
        idColumns.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		
        //Date column
        TableColumn<Student, String> dateColumns = new TableColumn<>("Date");
        dateColumns.setMinWidth(80);
        dateColumns.setCellValueFactory(new PropertyValueFactory<>("date"));
		
        //Name column
        TableColumn<Student, String> nameColumns = new TableColumn<>("Name");
        nameColumns.setMinWidth(100);
        nameColumns.setCellValueFactory(new PropertyValueFactory<>("name"));

        //password column
        TableColumn<Student, String> passwordColumns = new TableColumn<>("Password");
        passwordColumns.setMinWidth(100);
        passwordColumns.setCellValueFactory(new PropertyValueFactory<>("password"));
        
        //email column
        TableColumn<Student, String> emailColumns = new TableColumn<>("Email");
        emailColumns.setMinWidth(150);
        emailColumns.setCellValueFactory(new PropertyValueFactory<>("email"));
		
        //City column
        TableColumn<Student, String> cityColumns = new TableColumn<>("City");
        cityColumns.setMinWidth(100);
        cityColumns.setCellValueFactory(new PropertyValueFactory<>("city"));

        //Address column
        TableColumn<Student, String> addressColumns = new TableColumn<>("Address");
        addressColumns.setMinWidth(100);
        addressColumns.setCellValueFactory(new PropertyValueFactory<>("address"));

        //contact column
        TableColumn<Student, String> contactColumns = new TableColumn<>("Contact");
        contactColumns.setMinWidth(100);
        contactColumns.setCellValueFactory(new PropertyValueFactory<>("contact"));
    
        tableS.getColumns().addAll(idColumns,dateColumns,nameColumns,passwordColumns,emailColumns,cityColumns,addressColumns,contactColumns);
        Group S=new Group();
        tableS.setItems(getStudent());

        S.getChildren().add(tableS);
        return S;
    
    }
    //Method for adding event of logout from admin panel and go to Login Page
	public  void addActionEvents(){
		Logout.setOnAction(e->{				
				try {
					l.start(window);
					window.setWidth(LogIn.width);
					window.setHeight(LogIn.height);
				} catch (Exception ex) {
					// TODO: handle exception
				}
		});
    }
	
}


