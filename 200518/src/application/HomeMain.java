 package application;

import CommonService.CommonServiceImpl;
import CommonService.ICommonService;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Box;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class HomeMain extends Application {

	HomeController mainctrler;
	ICommonService comServ;
	static Parent root;
	Node mainPopUpNode;
	@Override
	public void start(Stage primaryStage) throws Exception {
		comServ = new CommonServiceImpl();
		mainctrler = new HomeController();
		mainPopUpNode = comServ.Load("../application/PopUp.fxml");
		Parent root = comServ.Load("../application/HomeMain.fxml");
		mainctrler.setRoot(root); 
		
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("SHOPPING MALL");
		primaryStage.setFullScreen(true);
		
		primaryStage.show();
		

		Popup firstPopup = comServ.showPopUp(primaryStage.getScene(), "ÆË¾÷Ã¢1", mainPopUpNode, "");
		

		Box homeBox = (Box)root.lookup("#homeBox");
		Box shopBox = (Box)root.lookup("#shopBox");
		Box boardBox = (Box)root.lookup("#boardBox");
		Box membershipBox = (Box)root.lookup("#membershipBox");
		Box loginBox = (Box)root.lookup("#loginBox");
		Box searchBox = (Box)root.lookup("#searchBox");
		StackPane homePane = (StackPane)root.lookup("#homePane");
		StackPane shopPane = (StackPane)root.lookup("#shopPane");
		StackPane boardPane = (StackPane)root.lookup("#boardPane");
		StackPane membershipPane = (StackPane)root.lookup("#membershipPane");
		StackPane loginPane = (StackPane)root.lookup("#loginPane");
		StackPane searchPane = (StackPane)root.lookup("#searchPane");
		mainctrler.setPopup(firstPopup);
		homeBox = mainctrler.BoxScene(homePane, homeBox);
		shopBox = mainctrler.BoxScene(shopPane, shopBox);
		boardBox = mainctrler.BoxScene(boardPane, boardBox);
		membershipBox = mainctrler.BoxScene(membershipPane, membershipBox);
		loginBox = mainctrler.BoxScene(loginPane, loginBox);
		searchBox = mainctrler.BoxScene(searchPane, searchBox);
		System.out.println(homePane.getScene()+ "/" + shopPane.getScene() + "/" );
	}	
	public static void main(String[] args) {
		launch(args);
	}
}
