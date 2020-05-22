package BoardEx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import BoardEx.DB.BoardDBManageImpl;
import BoardEx.DB.IBoardDBManage;
import BoardEx.DB.ListController;
import CommonService.CommonServiceImpl;
import CommonService.ICommonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Window;

public class ReadController implements Initializable{
	static private ICommonService comServ;
	static private ListController lstctrler;
	static private IBoardDBManage dbmanager;
	public static String readnum;
	static private Parent root;
	@FXML
	HTMLEditor contentHtml;
	@FXML
	TextField titleTxt;
	@FXML
	Button rewriteBtn;
	
	static public int boardstate;

	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		lstctrler = new ListController(); 
		dbmanager = new BoardDBManageImpl();
	}
	public void setBoardstate(int boardstate) {
		this.boardstate = boardstate;
	}
	public void setReadNum(String Number) {
		this.readnum = Number;
		titleTxt = (TextField)root.lookup("#titleTxt");
		contentHtml = (HTMLEditor)root.lookup("#contentHtml");
		rewriteBtn = (Button)root.lookup("#rewriteBtn");
		System.out.println(root);
		System.out.println("리드넘 : " + readnum);
		List<String> readList = new ArrayList<String>();
		System.out.println(dbmanager.ReadProc(Number));
		readList = dbmanager.ReadProc(Number);
		System.out.println("인계받은 리드넘"+readList);
		System.out.println(titleTxt);
		titleTxt.setText(readList.get(2));
		contentHtml.setHtmlText(readList.get(7));


	}
	public void RewriteProc(ActionEvent e) {
		if(contentHtml.isDisable()) {
			titleTxt.setEditable(true);
			contentHtml.setDisable(false);
			rewriteBtn.setText("완료");
			return;
		}
		if(!contentHtml.isDisable()) {
			titleTxt.setEditable(false);
			contentHtml.setDisable(true);
			rewriteBtn.setText("수정");
			String title = titleTxt.getText();
			String rewriteHtml = contentHtml.getHtmlText();
			dbmanager.UpdateBoard(readnum, title, rewriteHtml);
			return;
		}
	}
	public void ListBtnProc(ActionEvent e) {	
		if(boardstate==1) {
		BorderPane borderPane = (BorderPane)comServ.getScene(e);
	
		Parent root = comServ.Load("../BoardEx/DB/BoardListEx.fxml");
		borderPane.setBottom(null);
		borderPane.setCenter(root);
		lstctrler.setBoardState(boardstate);
		}
		if(boardstate==2) {
			BorderPane boardRootA = (BorderPane)comServ.Load("../BoardEx/DB/BoardListEx.fxml");
			BorderPane boardRootB = (BorderPane)comServ.Load("../BoardEx/DB/BoardListEx.fxml");
			HBox bottomHBox = (HBox)(root.getParent().getParent()); 
			VBox leftVbox = (VBox)bottomHBox.getChildren().get(0);
			 VBox rightVbox = (VBox)bottomHBox.getChildren().get(1); 
			 BorderPane reviewPane = (BorderPane)leftVbox.lookup("#reviewPane"); 
			 BorderPane qnaPane =(BorderPane)rightVbox.lookup("#qnaPane"); 
			 System.out.println("리뷰페인: "+ reviewPane + "qna페인 : "+qnaPane);
			 reviewPane.getChildren().clear();
			 qnaPane.getChildren().clear();
			 ScrollPane a = (ScrollPane)boardRootA.getCenter();
			 System.out.println(a.getContent());
			 a.getContent().setId("aTableView");
			 reviewPane.setCenter(a);
			 ScrollPane b = (ScrollPane)boardRootB.getCenter();
			 b.getContent().setId("bTableView");
			 qnaPane.setCenter(b);
			 
			 System.out.println("rp" + ((ScrollPane)reviewPane.getCenter()).getContent() + "qnap"   + ((ScrollPane)qnaPane.getCenter()).getContent());
			 System.out.println(boardstate);
			 
			 lstctrler.setRoot((Parent)reviewPane,(Parent)qnaPane);
			 lstctrler.setBoardState(boardstate);
		}
	}
	public void DeleteBoardProc(ActionEvent e) {
		dbmanager.DeleteBoard(readnum);

		BorderPane borderPane = (BorderPane)comServ.getScene(e);
		root = (Parent)borderPane;
		BorderPane bp = (BorderPane)root;
		bp.setLeft(null);
		bp.setCenter(comServ.Load("../BoardEx/DB/BoardListEx.fxml"));
		bp.getScene().getWindow().sizeToScene();
		System.out.println("딜리트프록"+boardstate);
		ListController lstctrler = new ListController();
		lstctrler.setRoot(this.root);
		lstctrler.setBoardState(boardstate);
	}

	public void UpdateBoardProc(ActionEvent e) {
		dbmanager.DeleteBoard(readnum);
		BorderPane borderPane = (BorderPane)comServ.getScene(e);
		Parent root = comServ.Load("../BoardEx/DB/BoardListEx.fxml");
		borderPane.setTop(null);
		borderPane.setBottom(null);
		borderPane.setCenter(root);
		Window window = borderPane.getScene().getWindow();


	}

}
