
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LibrarianSection {
//main stage
	static Stage window;
	//scenes of librarian section
	static  Scene mainscene,addBookScene,viewBookScene,issuedbookscene,viewissuedbookscene;
	//list to store Students 
	ObservableList<Student> Students = FXCollections.observableArrayList();
	//list to store Isuued books
	 ObservableList<IssueBooks> issuedbooks = FXCollections.observableArrayList();
	//Button	
    Button libLogout,/*returnbook,*/viewissuedbook,issuebook,viewbook,addbook,addbookbt,backbt,savebookbt,backbuttonoftbaleview,dltbtfrombookview,issubookbt,issuegobackbt;
    //Layout of Each Scene
    Group addbooklayout,veiwbooklayout,issubooklayout,viewissubooklayout;
    //TExt Fields
    TextField callnotf,booknametf,authornametf,publishernametf,quantitytf,bookidtf,studentidtf;
    //Table for Books Data
    TableView<Booksdata> viewtable;
    //Table for Issued Books
    TableView<IssueBooks> issuetable;
    //List for Books data
    ObservableList<Booksdata> booksdata = FXCollections.observableArrayList();
    
    //Constructor
	LibrarianSection(String title, int width, int height){
		//main stage
		window = new Stage();
		//setting title
		window.setTitle(title);
		//setting size
		window.setWidth(width);
		window.setHeight(height);
		//setting stage to not resizable
		window.setResizable(false);
		//add stage icon
		window.getIcons().add(new Image("file:images/IU.PNG"));
		//main main layout
		Group libroot = new Group();
		//methods to add main screen components
		addlib(libroot);
		issuedbooks=getIssueData();
		//add Book Data
		addbooklayout =  new Group();
		addBookScene = new Scene(addbooklayout,600,500);
		
		//viewBook Layout start
		veiwbooklayout = new Group();
		viewBookScene = new Scene(veiwbooklayout,500,500);
		//window.setScene(viewBookScene);

		//for Issue Book
				issubooklayout = new Group();
				issuedbookscene = new Scene(issubooklayout);
		//		window.setScene(issuedbookscene);
		
		//viewBook issue book layout
				viewissubooklayout = new Group();
				viewissuedbookscene = new Scene(viewissubooklayout,500,500);
				//window.setScene(viewissuedbookscene);
		//method for add books option
	    addBook();
	    //method fot viewBook option
		viewBook();
		//method for view issuedbooks 
		viewIssuedbook();
		//method for issue book option
		issueBook();
		//back to main menu button event
		backbt.setOnAction(e->window.setScene(mainscene));
			
		//logout to main login page 
		libLogout.setOnAction(e->{	
			LogIn l = new LogIn();
				//calling login screen stage
				try {
					l.start(window);
					window.setWidth(LogIn.width);
					window.setHeight(LogIn.height);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		});
		//addbook button event set scene for addbook
		addbook.setOnAction(e->window.setScene(addBookScene));
		//viewbook button event set scene for viewbook
		viewbook.setOnAction(e->window.setScene(viewBookScene));	
		//issuebook button event set scene for issuebook
		issuebook.setOnAction(e ->window.setScene(issuedbookscene));
		//viewissuedbook button event set scene for viewissuedbook
		viewissuedbook.setOnAction(e->window.setScene(viewissuedbookscene));
		//backbuttonoftbaleview button event set scene to main scene
		backbuttonoftbaleview.setOnAction(e->window.setScene(mainscene));
//setting main scene
		mainscene = new Scene(libroot);
		window.setScene(mainscene);
		//showing main stage
		window.show();
	}
	
	//Method to add components to Main Group layout of Librarian Section
public  void addlib(Group libroot){
//AddBook Button
    addbook = new Button("Add Books");
	//styling
    addbook.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
	addbook.setFont(Font.font(15));
	//resizing
	addbook.setPrefSize(130, 50);
	//setting position
	addbook.setTranslateX(170);
	addbook.setTranslateY(30);
//viewBook Button	
    viewbook = new Button("View Books");
    //styling
    viewbook.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
    viewbook.setFont(Font.font(15));
	//rsizing
    viewbook.setPrefSize(130, 50);
    //setting position
	viewbook.setTranslateX(170);
	viewbook.setTranslateY(100);
//issue book button
    issuebook = new Button("Issue Book");
	//styling
    issuebook.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
	issuebook.setFont(Font.font(15));
	//resizing
	issuebook.setPrefSize(130, 50);
	//setting postion
	issuebook.setTranslateX(170);
	issuebook.setTranslateY(170);
//view issued book button
    viewissuedbook = new Button("View Issued Books"); 
	//styling
    viewissuedbook.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
	viewissuedbook.setFont(Font.font(15));
	//resizing
	viewissuedbook.setPrefSize(130, 50);
	//setting position
	viewissuedbook.setTranslateX(170);
	viewissuedbook.setTranslateY(240);
/*
    returnbook = new Button("Return Books"); 
	returnbook.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
	returnbook.setFont(Font.font(15));
	returnbook.setPrefSize(130, 50);
	returnbook.setTranslateX(170);
	returnbook.setTranslateY(310);
	*/
	
//LibLogout Button for logout
	libLogout = new Button("Log Out");
	//styling
	libLogout.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white; -fx-background-radius: 25.0; -fx-border-radius: 15.0;-fx-border-color: white; ");
	libLogout.setFont(Font.font(15));
	//resizing
	libLogout.setPrefSize(130, 50);
	//setting position
	libLogout.setTranslateX(170);
	//libLogout.setTranslateY(380);
	libLogout.setTranslateY(310);
	
	//Backgroung ImageView
	ImageView bkimg = new ImageView(new Image("file:images/books.jpg"));
	//Setting position and Size
	bkimg.setFitHeight(500);
	bkimg.setFitWidth(500);
	//Setting Opacity
    bkimg.setOpacity(0.4f);
	//Adding add component of main librarian screen
	libroot.getChildren().addAll(bkimg,addbook,viewbook,issuebook,viewissuedbook,/*returnbook,*/libLogout);
	//adding animation
	FadeTransition ft1 = new FadeTransition(Duration.millis(1000), libroot);
	ft1.setFromValue(0.0);
	ft1.setToValue(1.0);
	ft1.play();
	
	
}

//method for save button click for Book Data
private void saveButtonClicked() {
	//Alert for information
	Alert savealert1 = new Alert(AlertType.INFORMATION);
	savealert1.setHeaderText(null);
	savealert1.setContentText("Your data has been saved successfully!");
	savealert1.showAndWait();
	//Writing data in file to save
	try {	
    	FileOutputStream fos = new FileOutputStream("data/booksdata.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new ArrayList<Booksdata>(booksdata));
		oos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//method for save button click for issue Book Data
private void saveissuebook() {
	//alert for success information
	Alert savealert1 = new Alert(AlertType.INFORMATION);
	savealert1.setHeaderText(null);
	savealert1.setContentText("Your data has been saved successfully!");
	savealert1.showAndWait();
	
	try {	
    	FileOutputStream fos = new FileOutputStream("data/issuebooks.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new ArrayList<IssueBooks>(issuedbooks));
		oos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//method to get Data from books data file and store the data into Observable List 
private ObservableList<Booksdata> getBooksData() {
	try {
		FileInputStream fis = new FileInputStream("data/booksdata.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		List<Booksdata> list = (List<Booksdata>) ois.readObject();
		//store retreived data in Observable list(books data)
		booksdata = FXCollections.observableList(list);
		ois.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
    return booksdata;
}

//method to delete data from table view
private void bookViewdeleteButton() {
	//confirmation alert
	Alert alert9 = new Alert(AlertType.CONFIRMATION,"Are you sure to delete?",ButtonType.YES,ButtonType.NO);
	alert9.setHeaderText(null);

	Optional<ButtonType> result = alert9.showAndWait();
	//if yes 
if(result.get() == ButtonType.YES){	
    ObservableList<Booksdata> booksdataSelected;
	ObservableList<Booksdata> allbooksdata;
	//delete the selected rows of table view
	allbooksdata = viewtable.getItems();
	booksdataSelected = viewtable.getSelectionModel().getSelectedItems();
	booksdataSelected.forEach(allbooksdata::remove);
} else{
	alert9.close();
}
}
	
//Method for validating Books data textfeild data
private boolean  bookValidation() {
//if textfeilds are empty 
	if(callnotf.getText().isEmpty() || booknametf.getText().isEmpty()||
			authornametf.getText().isEmpty() || publishernametf.getText().isEmpty()||
			quantitytf.getText().isEmpty()){
		//show alert to enter data
		Alert warningalert3 = new Alert(AlertType.WARNING);
		warningalert3.setHeaderText("TextFields are empty!");
		warningalert3.setContentText("Please input the data");
		warningalert3.showAndWait();
		//return false to show data is not valid
		return false;
	} else{
		//if not empty then show success
		Alert warningalert3 = new Alert(AlertType.INFORMATION);
		warningalert3.setHeaderText(null);
		warningalert3.setContentText("Data has been successfully added!");
		warningalert3.showAndWait();
	}	
		return true;
	
}
//Method for addbookdata
private void addBookButtonClicked() {
	//if data is valid
	if(bookValidation()){
		//Books data object
	Booksdata booksdata = new Booksdata();
	//setting data of books data by getting data from text feild
	booksdata.setCallno(callnotf.getText());
	booksdata.setBookname(booknametf.getText());
	booksdata.setAuthor(authornametf.getText());
	booksdata.setPublisher(publishernametf.getText());
	booksdata.setQuantity(Integer.parseInt(quantitytf.getText()));
	//add booksdata object to table view of Booksdata
	viewtable.getItems().add(booksdata);
	//clear all textfields 
clear();
	
}
}
//Method to clear text feilds 
private void clear() {
	callnotf.clear();
	booknametf.clear();
	authornametf.clear();
	publishernametf.clear();
	quantitytf.clear();
	
}
//Methods for adding component in addBook Screen Layout
private void addBook() {
	//Creating Labels
	Label addbooklabel = new Label("Add Book");
    Label addcallnolabel = new Label("Call No: ");
    Label addnbookamelabel = new Label("Name: ");
	Label addquantitylabel = new Label("Quantity: ");
	Label addpublisherlabel = new Label("Publisher: ");
	Label addauthorlabel = new Label("Author: ");

	//setting position
	addbooklabel.setTranslateX(210);
    addbooklabel.setTranslateY(20);
    addcallnolabel.setTranslateX(80);
    addcallnolabel.setTranslateY(80);
	addnbookamelabel.setTranslateX(80);
	addnbookamelabel.setTranslateY(127);
	addauthorlabel.setTranslateX(80);
	addauthorlabel.setTranslateY(170);
	addpublisherlabel.setTranslateX(80);
	addpublisherlabel.setTranslateY(210);
	addquantitylabel.setTranslateX(80);
	addquantitylabel.setTranslateY(250);
	
	//styling
    addcallnolabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
    addbooklabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 20));	
	addnbookamelabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
	addauthorlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));	
	addpublisherlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
	addquantitylabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));


	//text feild for CallNo of Book
	callnotf = new TextField();
	callnotf.setPromptText("Enter the Callno");
	//setting position
	callnotf.setTranslateX(190);
	callnotf.setTranslateY(80);
	//resizing
	callnotf.setPrefSize(200, 30);

//TextField for Book Name
	booknametf = new TextField();
	booknametf.setPromptText("Enter the Book Name");
//setting position
	booknametf.setTranslateX(190);
	booknametf.setTranslateY(127);
	//resizing
	booknametf.setPrefSize(200, 30);

	
//Author Name Text Feild
	authornametf = new TextField();
	authornametf.setPromptText("Enter the Author Name");
	//setting position
	authornametf.setTranslateX(190);
	authornametf.setTranslateY(170);
	//resizing
	authornametf.setPrefSize(200, 30);

//Publisher Text Feild
	publishernametf = new TextField();
	publishernametf.setPromptText("Enter the Publisher Name");
	//setting position
	publishernametf.setTranslateX(190);
	publishernametf.setTranslateY(210);
	//resizing
	publishernametf.setPrefSize(200, 30);
	
//TextField for Quantity
	quantitytf = new TextField();
	quantitytf.setPromptText("Enter the quantity ");
	//position
	quantitytf.setTranslateX(190);
	quantitytf.setTranslateY(250);
	//resizing
	quantitytf.setPrefSize(200, 30);
	
	//AddBook Button
	addbookbt = new Button("Add Book"); 
	//styling
	addbookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	addbookbt.setFont(Font.font(15));
	//resizing
	addbookbt.setPrefSize(100, 10);
	//setting postion
	addbookbt.setTranslateX(190);
	addbookbt.setTranslateY(300);

	//Back button to back to main Librarian Section
	backbt = new Button("Back"); 
	//styling
	backbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	backbt.setFont(Font.font(15));
	backbt.setPrefSize(80, 10);
	//setting position
	backbt.setTranslateX(300);
	backbt.setTranslateY(300);
	
	//Adding BackGroung Image
	ImageView bookimg = new ImageView(new Image("file:images/books.jpg"));
	bookimg.setFitHeight(500);
	bookimg.setFitWidth(500);
    //setting opacity of image
	bookimg.setOpacity(0.3f);
	//Adding all components of AddBook Screen to Addbooklayout
	addbooklayout.getChildren().addAll(bookimg,addbooklabel,addcallnolabel,callnotf,addnbookamelabel,booknametf,addauthorlabel,authornametf,addpublisherlabel,publishernametf,addquantitylabel,quantitytf,addbookbt,backbt);
	
	//Adding Animation
	FadeTransition ft2 = new FadeTransition(Duration.millis(1000), addbooklayout);
	ft2.setFromValue(0.0);
	ft2.setToValue(1.0);
	ft2.play();
	addbookbt.setOnAction(e ->addBookButtonClicked());
	
}
//Table for View Books option
@SuppressWarnings("unchecked")
private void viewBook() {
		
		//Callno column
	    TableColumn<Booksdata, String> callnoColumn = new TableColumn<>("Callno");
	    callnoColumn.setMinWidth(80);
	    callnoColumn.setCellValueFactory(new PropertyValueFactory<>("callno"));
		
	    //Name column
	    TableColumn<Booksdata, String> booknameColumn = new TableColumn<>("Bookname");
	    booknameColumn.setMinWidth(120);
	    booknameColumn.setCellValueFactory(new PropertyValueFactory<>("bookname"));

	    //Author column
	    TableColumn<Booksdata, String> authorColumn = new TableColumn<>("Author");
	    authorColumn.setMinWidth(100);
	    authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
	    
	    //publisher column
	    TableColumn<Booksdata, String> publisherColumn = new TableColumn<>("Publisher");
	    publisherColumn.setMinWidth(100);
	    publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		
	    //quantity column
	    TableColumn<Booksdata, String> quantityColumn = new TableColumn<>("Quantity");
	    quantityColumn.setMinWidth(100);
	    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//table view to show table data
		viewtable = new TableView<>();
		viewtable.setPrefHeight(430);
		//getting data from file through method and to table view
		viewtable.setItems(getBooksData());
		//adding columns to table
		viewtable.getColumns().addAll(callnoColumn,booknameColumn,authorColumn,publisherColumn,quantityColumn);

//back Button for going to main scene
		backbuttonoftbaleview = new Button("Back");
		//setting position
		backbuttonoftbaleview.setTranslateY(435);
		backbuttonoftbaleview.setTranslateX(90);
		//styling
		backbuttonoftbaleview.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
		backbuttonoftbaleview.setFont(Font.font(15));
		//resizing
		backbuttonoftbaleview.setPrefSize(100, 7);
		//setting action event on back button and set scene to main scene
		backbuttonoftbaleview.setOnAction(e ->window.setScene(mainscene));
		
		//Delete button for Deleting from Table view
		dltbtfrombookview = new Button("Delete");
		//position
		dltbtfrombookview.setTranslateY(435);
		dltbtfrombookview.setTranslateX(210);
		//styling
		dltbtfrombookview.setStyle("-fx-background-color:#A15CF8; -fx-text-fill: white;");
		dltbtfrombookview.setFont(Font.font(15));
		dltbtfrombookview.setPrefSize(100, 7);
		//Setting action event on delete button and calling method to delete
		dltbtfrombookview.setOnAction(e -> bookViewdeleteButton());
		
		//Save button to save data to file
		savebookbt = new Button("Save"); 
		//styling
		savebookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
		savebookbt.setFont(Font.font(15));
		savebookbt.setPrefSize(100, 10);
		//setting position
		savebookbt.setTranslateX(320);
		savebookbt.setTranslateY(435);
//Setting action event on save button and calling method to save data
		savebookbt.setOnAction(e -> saveButtonClicked());
		
		//scene loading segment at bottom of scene
		   Rectangle  rect2 = new Rectangle(0,430,5,50);
	       rect2.setFill(Color.SKYBLUE);
	       rect2.setOpacity(0.6f);
	       //adding animation of loading segment
	      ScaleTransition sc = new ScaleTransition(Duration.millis(5000),rect2);
	      sc.setToX(200);
	      sc.setCycleCount(1);
	      sc.play(); 
	       //Adding all components of viewbook screen to viewbooklayout
		veiwbooklayout.getChildren().addAll(rect2,viewtable,backbuttonoftbaleview,dltbtfrombookview,savebookbt);

		//adding animation Fade Effect
		FadeTransition ft4 = new FadeTransition(Duration.millis(1000), veiwbooklayout);
		ft4.setFromValue(0.0);
		ft4.setToValue(1.0);
		ft4.play();

}
//Method for issue book option
private void issueBook() {
		//background image
		ImageView bkimg1 = new ImageView(new Image("file:images/books.jpg"));
		//setting size
		bkimg1.setFitHeight(500);
		bkimg1.setFitWidth(500);
		//setting opacity
	    bkimg1.setOpacity(0.4f);
		
		 Label issuebooklabel = new Label("Issue Book");
		 issuebooklabel.setTranslateX(190);
		 issuebooklabel.setTranslateY(20);
		 issuebooklabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 25));

		
			Label issubooknamelabel = new Label("Book Id: ");
			issubooknamelabel.setTranslateX(80);
			issubooknamelabel.setTranslateY(117);
			issubooknamelabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
	        
			//TextFeild for Book id
			bookidtf = new TextField();
			bookidtf.setPromptText("Enter the Book Id");
			//setting position
			bookidtf.setTranslateX(190);
			bookidtf.setTranslateY(117);
			//setting size
			bookidtf.setPrefSize(200, 30);

			
			Label issueidlabel = new Label("Student ID: ");
			issueidlabel.setTranslateX(80);
			issueidlabel.setTranslateY(170);
			issueidlabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 15));
			//TExtField for Student id
			studentidtf = new TextField();
			studentidtf.setPromptText("Enter the Id:");
			studentidtf.setTranslateX(190);
			studentidtf.setTranslateY(170);
			studentidtf.setPrefSize(200, 30);

			//Button for issue book
			issubookbt = new Button("Issue Book");
			//position
			issubookbt.setTranslateX(190);
			issubookbt.setTranslateY(280);
			//styling
			issubookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
			issubookbt.setFont(Font.font(15));
			issubookbt.setPrefSize(100, 7);
			//Back button to back to main scene from issue book scene
			issuegobackbt = new Button("Back");
			//setting position
			issuegobackbt.setTranslateX(300);
			issuegobackbt.setTranslateY(280);
			//styling
			issuegobackbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
			issuegobackbt.setFont(Font.font(15));
			issuegobackbt.setPrefSize(80, 7);
			
			//adding action event to button to go back to main scene from issue book scene
			issuegobackbt.setOnAction(e ->window.setScene(mainscene));
			
			//adding event on issue book button
			issubookbt.setOnAction(e->{
				//get Student data to validate student id
				getStudent();
				//geting book data to validate book id
				getBooksData();
				
				Student s=null;
				Booksdata b=null;
				//Reading data from lists and validating the input data to check ids exist or not 
				for (Student student : Students) {
					System.out.println("student "+student.toString());
					
					if(studentidtf.getText().equals(student.getId()+"")) {
						//if id found assign student
						s=student;
						break;
					}
				}
				for (Booksdata book : booksdata) {
					System.out.println("book "+book.toString());
					
					if(bookidtf.getText().equals(book.getCallno())) {
						//if id found assign book
						b=book;
						break;
					}
				}
				
//				System.out.println("s "+s.toString());
	//			System.out.println("b "+b.toString());
				//Issue book object to add on issuebooks table view
				IssueBooks is = new IssueBooks(s.getId(), s.getName(), b.getCallno(), b.getBookname());
				//add object to observable list issued books
				issuedbooks.add(is);
	//			System.out.println(is.toString());
				
			});
		//adding all the components of issuebook screen to issuebook layout group
			issubooklayout.getChildren().addAll(bkimg1,issuebooklabel,issubooknamelabel,bookidtf,issueidlabel,studentidtf,issubookbt,issuegobackbt);

}
//Method to get Student data from files and set to Observable list
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
//Method to get Issued books data from files and set to Observable list

public ObservableList<IssueBooks > getIssueData() {
	try {
		FileInputStream fis = new FileInputStream("data/issuebooks.ser");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		List<IssueBooks > list = (List<IssueBooks >) ois.readObject();
		issuedbooks = FXCollections.observableList(list);
		ois.close();
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
	return issuedbooks;
}

//Method for viewIssuedBooks Option/Screen
@SuppressWarnings("unchecked")
private void viewIssuedbook() {
	
	//issueid column
    TableColumn<IssueBooks, String> issueid = new TableColumn<>("Id");
    issueid.setMinWidth(100);
    issueid.setCellValueFactory(new PropertyValueFactory<>("issue"));
	
  //studentid column
    TableColumn<IssueBooks, String> studentid = new TableColumn<>("Student Id");
    studentid.setMinWidth(100);
    studentid.setCellValueFactory(new PropertyValueFactory<>("Sid"));
	
    //Student Name column
    TableColumn<IssueBooks, String> studentnamecol = new TableColumn<>("StudentName");
    studentnamecol.setMinWidth(100);
    studentnamecol.setCellValueFactory(new PropertyValueFactory<>("sname"));

    //Book Callno column
    TableColumn<IssueBooks, String> booknocol = new TableColumn<>("BookCallNo");
    booknocol.setMinWidth(100);
    booknocol.setCellValueFactory(new PropertyValueFactory<>("bid"));
    
    //BookName column
    TableColumn<IssueBooks, String> booknamecol = new TableColumn<>("Book Name");
    booknamecol.setMinWidth(100);
    booknamecol.setCellValueFactory(new PropertyValueFactory<>("bname"));
	
    //Table view for issued books
	issuetable = new TableView<>();
	issuetable.setPrefHeight(430);
	//addind data to tablel
	issuetable.setItems(issuedbooks);
	//adding table columns
	issuetable.getColumns().addAll(issueid,studentid,studentnamecol,booknocol,booknamecol);
	//setting position of table
	issuetable.setTranslateX(1);
	
//Back button to go to main scene from issuebook scene
	backbuttonoftbaleview = new Button("Back");
	//position
	backbuttonoftbaleview.setTranslateY(435);
	backbuttonoftbaleview.setTranslateX(90);
	//stylings
	backbuttonoftbaleview.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	backbuttonoftbaleview.setFont(Font.font(15));
	backbuttonoftbaleview.setPrefSize(100, 7);
	
	//Delete Button to Delete Data from table view
	dltbtfrombookview = new Button("Delete");
	//position
	dltbtfrombookview.setTranslateY(435);
	dltbtfrombookview.setTranslateX(210);
	//styling
	dltbtfrombookview.setStyle("-fx-background-color:#A15CF8; -fx-text-fill: white;");
	dltbtfrombookview.setFont(Font.font(15));
	dltbtfrombookview.setPrefSize(100, 7);
	
	//adding event on delete button and calling method for delete
	dltbtfrombookview.setOnAction(e -> bookViewdeleteButton());
	
	//Button to save data to file
	savebookbt = new Button("Save"); 
	//stylings
	savebookbt.setStyle("-fx-background-color: #A15CF8; -fx-text-fill: white;");
	savebookbt.setFont(Font.font(15));
	savebookbt.setPrefSize(100, 10);
	//position
	savebookbt.setTranslateX(320);
	savebookbt.setTranslateY(435);
	//adding action to savebookbt to save table data into file
	savebookbt.setOnAction(e -> saveissuebook());
	
	//loading scene effect at bottom of scene
	   Rectangle  rect2 = new Rectangle(0,430,5,50);
       rect2.setFill(Color.SKYBLUE);
       rect2.setOpacity(0.6f);
       //adding animation to effect
      ScaleTransition sc = new ScaleTransition(Duration.millis(5000),rect2);
      sc.setToX(200);
      sc.setCycleCount(1);
      sc.play();
      
       //Adding all components to view issuedbook screen to viewissubooklayout
	viewissubooklayout.getChildren().addAll(rect2,issuetable,backbuttonoftbaleview,dltbtfrombookview,savebookbt);

	//adding animation to Fade Effect
	FadeTransition ft4 = new FadeTransition(Duration.millis(1000), veiwbooklayout);
	ft4.setFromValue(0.0);
	ft4.setToValue(1.0);
	ft4.play();

}


}
