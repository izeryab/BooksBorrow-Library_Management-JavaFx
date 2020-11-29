

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LogIn extends Application{
//main window of login screen
	static Stage window;
//scenes for login
	static Scene scene00,scene0, scene1, scene2, scene3;
//width of scene
	static double width=490;
//height of scene
	static double height=500;
//test user data for testing application
	static String test="librarian1";
//Button object's variable
	static Button adminlogin,login,goback,librarianlogin,stlogin,stgoback;
//Librarian Scene 
	static LibrarianSection booksection;
//Admin scene
	static Admin ac;	
//Test data for admin login
     String user = "admin", pass = "admin"; 
   
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public  void start(Stage primaryStage) throws Exception {
	//setup stage start
		window = primaryStage;
	//Set titile of Stage
		window.setTitle("Books Borrow System");
	//set stage resizable false
		window.setResizable(false);
	//setting the icon of stage
		window.getIcons().add(new Image("file:images/adminlogo.PNG"));
	//Group layout for main LoginScene
		Group root = new Group();
	//Method for adding components
		addComponent(root);
	//method for adding animartion in main login scene
		addAnimations(root);
	//setting the scene for login
	    scene1 = new Scene(root,width,height);
		window.setScene(scene1);
	//show the stage
		window.show();
	}
	//Method for animation
	private void addAnimations(Group root) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
		}
//Method for adding components in Group layout
	public void addComponent(Group root){
		//background image of Group
		ImageView iv1 =  new ImageView(new Image("file:images/books.jpg")); 
	//image height
		iv1.setFitHeight(520);
		//image width
		iv1.setFitWidth(500);
	//	iv1.setY(100);
//opacity of background image
		iv1.setOpacity(0.2);	
		
		
		//Name of Library
			final String content = "BOOK BORROW SYSTEM";
//main scene label
			final Text labelname = new Text(10, 20, content);
		 //defining X and Y position for label
			labelname.setTranslateX(80);
		    labelname.setTranslateY(110);
		 //Label color and font
		    labelname.setFill(Color.BLUE);
		    labelname.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		    //adding animation to label
		    final Animation animation = new Transition() {
		        {
		        	//setting speed of animation
		            setCycleDuration(Duration.millis(3000));
		        }
		        //setting content of animation
		        protected void interpolate(double frac) {
		            final int length = content.length();
		            final int n = Math.round(length * (float) frac);
		            labelname.setText(content.substring(0, n));
		        }
		    };
		    //play animation
		    animation.play();

		//AdminButton
		adminlogin = new Button("Admin Login");
		//styling
		adminlogin.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		//adding border
		adminlogin.setBorder(new Border(new BorderStroke(Color.BLACK, 
	    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		adminlogin.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		adminlogin.setPrefSize(140, 50);
		adminlogin.setTranslateX(180);
		adminlogin.setTranslateY(180);
		
				/// Admin_login Form START	
			Group adminForm = new Group();
   
	        //username label
			Label username = new Label("User Name:");
	        //setting position of username label and styling
			username.setTranslateX(65);
	        username.setTranslateY(200);
	        username.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	       
	        //Textfeild for username
	        TextField usertf = new TextField();
	        //setting position of usertf label and styling
	        usertf.setTranslateX(190);
	        usertf.setTranslateY(200);
	        usertf.setPrefWidth(230);
	        usertf.setPrefHeight(35);
	        //test data
	        usertf.setText(user);
	        //setting prompt text
	        usertf.setPromptText("Enter User Name");
	        
	        //label password
	        Label passname = new Label("Password:");
	       //setting position
	        passname.setTranslateX(75);
	        passname.setTranslateY(260);
	        //styling
	        passname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        
	        //Password Field
	        PasswordField passtf = new PasswordField();
	        //setting position
	        passtf.setTranslateX(190);
	        passtf.setTranslateY(260);
	        passtf.setPrefWidth(230);
	        passtf.setPrefHeight(35);
	        //test data(you can set to empty at the top)
	        passtf.setText(user);
	        //promt text
	        passtf.setPromptText("Enter Password");
	        
	        //logIn Button
	        login = new Button("Log In");
	        //setting position
	        login.setTranslateX(200);
	        login.setTranslateY(320);
	        //setting size of button
	        login.setPrefSize(80, 30);
	        //styling
	        login.setStyle("-fx-text-fill: white; -fx-background-color: #3D4DF2;");
	        
	        //Go Back Button
	        goback = new Button("Go Back");
	        //positioning
	        goback.setTranslateX(300);
	        goback.setTranslateY(320);
	        //resizing
	        goback.setPrefSize(60, 30);
	        //styling
	        goback.setStyle("-fx-text-fill: white; -fx-background-color: #3D4DF2;");
	
	        //validity label
			Label incorrect = new Label("Please enter valid username OR password");
			incorrect.setStyle("-fx-background-color: #bc0000; -fx-text-fill: white;");
			 //positioning
			incorrect.setTranslateX(190);
			incorrect.setTranslateY(180);
			
			//background image
			ImageView logoadmin = new ImageView(new Image("file:images/adminlogo.png"));
			 //positioning
			logoadmin.setFitWidth(150);
			logoadmin.setFitHeight(150);
			logoadmin.setTranslateX(180);
			logoadmin.setTranslateY(20);
			
			//adding all components to main Group
			adminForm.getChildren().addAll(logoadmin,goback,login,passtf,passname,usertf,username);
	        scene2 = new Scene(adminForm,490,500,Color.WHITE);
	        
	   
		//student_login_Button
		librarianlogin = new Button("Librarian Login");
		//styling
		librarianlogin.setStyle("-fx-background-color: #9F30F5; -fx-text-fill: white;");
		librarianlogin.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		librarianlogin.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

		//resizing
		librarianlogin.setPrefSize(140, 50);
		//setting position of button
		librarianlogin.setTranslateX(180);
		librarianlogin.setTranslateY(250);
		
		
		
			   
		/// Librarian login Form START
		Group librarianForm = new Group();		
	        
			//Label Username
	        Label stusername = new Label("User Name:");
	        //setting position
	        stusername.setTranslateX(80);
	        stusername.setTranslateY(220);
	        //styling
	        stusername.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        //username textFeild
	        TextField stuser = new TextField();
	        //setting prompt text
	        stuser.setPromptText("Enter User Name");
	        //setting positoin
	        stuser.setTranslateX(190);
	        stuser.setTranslateY(220);
	        //resizing
	        stuser.setPrefWidth(190);
	        stuser.setPrefHeight(30);
	        //adding test data(you can set to empty at top)
	        stuser.setText(test);
	        
	        //label for password
	        Label stpassname = new Label("Password:");
	        //setting position of label
	        stpassname.setTranslateX(95);
	        stpassname.setTranslateY(270);
	        //styling and Setting font
	        stpassname.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
	        
	        //Password feild for login of librarian
	        PasswordField stpass = new PasswordField();
	        //prompt text
	        stpass.setPromptText("Enter password");
	        //setting position
	        stpass.setTranslateX(190);
	        stpass.setTranslateY(270);
	        stpass.setPrefWidth(190);
	        stpass.setPrefHeight(30);
	        //adding test data to feild
	        stpass.setText(test);
	        
	        //Login button for librarian login
	        stlogin = new Button("Log In");
	        //setting position
	        stlogin.setTranslateX(190);
	        stlogin.setTranslateY(320);
	        //resizing
	        stlogin.setPrefSize(80, 30);
	       //styling
	        stlogin.setStyle("-fx-text-fill: white; -fx-background-color: #3D4DF2;");
	        
	        //go back to main scene button
	        stgoback = new Button("Go Back");
	        //setting position
	        stgoback.setTranslateX(290);
	        stgoback.setTranslateY(320);
	        //resizing
	        stgoback.setPrefSize(60, 30);
	        //styling
	        stgoback.setStyle("-fx-text-fill: white; -fx-background-color: #3D4DF2;");
	        //setting scene for librarian
	        scene3 = new Scene(librarianForm,490,500);
	        //background color of scene
	        scene3.setFill(Color.WHITE);
	        //setting scene in stage
	        window.setScene(scene3);
	        
	        //image for librarian
	        ImageView logolibrarian = new ImageView(new Image("file:images/stlogo.png"));
	        //set position
	        logolibrarian.setFitWidth(150);
	        logolibrarian.setFitHeight(150);
			logolibrarian.setTranslateX(180);
			logolibrarian.setTranslateY(20);
	        
			//adding all component of librarian login form to Main layout of librarian login
	        librarianForm.getChildren().addAll(logolibrarian,stgoback,stlogin,stpass,stpassname,stuser,stusername); 
	        //action on librarian login button
	        stlogin.setOnAction(e->{
	        		//open booksection stage of librarian login
							   booksection = new LibrarianSection("Book  Section",500,500);
								//closing login pages
							   window.close();
				});
			//Login button of Admin login
	        login.setOnAction(e->{
				//validating data of login
	        	if(user.equals(usertf.getText().trim()) && pass.equals(passtf.getText().trim())){	
					//creating admin object 
	        		ac = new Admin("Books Borrow System", 1100, 600);
					//closing login screen
	        		window.close();
				} else
					//if not valid data then show incorrect label as message
					adminForm.getChildren().add(incorrect);
				});
	        
	        //Method to add action events on login screen
	      addActionEventsinLoginClass();
	      //adding image to main screen  
		root.getChildren().addAll(iv1);
		//adding component to main layout
		root.getChildren().addAll(labelname,librarianlogin,adminlogin);
	}

	public static void addActionEventsinLoginClass(){
		   //go back button change scene to login 
        stgoback.setOnAction(e->window.setScene(scene1));
        //adminlogin set scene to admin Scene
    	adminlogin.setOnAction(e->window.setScene(scene2));
    	//Go back to main page
        goback.setOnAction(e->window.setScene(scene1));
        //librarian login button set scene to librarian scene
    	librarianlogin.setOnAction(e->window.setScene(scene3));

	}
	

}
