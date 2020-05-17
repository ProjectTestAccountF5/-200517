package ShopView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import CommonService.CommonServiceImpl;
import CommonService.ICommonService;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.scene.image.*;

public class BasketController extends Controller implements Initializable{
	ICommonService comServ;
	static private Parent root;
	//JLabel label = new JLabel();
	//JLabel label2 = new JLabel();
	//JLabel label3 = new JLabel();
	//JButton button = new JButton();
	//JButton button2 = new JButton();
	//Label label4 = new Label();

	ActionListener ac = new ActionHandler();
	ActionListener ac2 = new ActionHandler2();
	//JFrame frame = new JFrame("장바구니");

/*
 * @FXML private Label PrdSize1;
 * 
 * @FXML private Label Qty1;
 * 
 * @FXML private Label Color1;
 * 
 * @FXML private Label Price1;
 */
	
	Label label;
	Label label2;
	Label label3;
	
	Button button;
	Button button2;


@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
}
class ActionHandler implements ActionListener{

	  public void actionPerformed(ActionEvent e){
		  
JOptionPane.showMessageDialog(null, "주문 완료 되었습니다.", "감사합니다 ^^", JOptionPane.INFORMATION_MESSAGE);
	   System.out.println("장바구니 추가 완료되었습니다.");

	  }
}
	  class ActionHandler2 implements ActionListener{

		  public void actionPerformed(ActionEvent e){
		
	
			  label.setVisible(false);
			  label2.setVisible(false);
			  label3.setVisible(false);
			  button.setVisible(false);
			  button2.setVisible(false);
		  }
	  }
	private void Alert(String string) {
		// TODO Auto-generated method stub
		
	}

	
@Override
public void setRoot(Parent root) {
	// TODO Auto-generated method stub
	this.root= root;
}
public Popup SetCartInfo(ArrayList<String> info) {
	comServ = new CommonServiceImpl();
	System.out.println("info.get(0) : "+info.get(0));

	/*
	Dimension dim = new Dimension(1100,200);
	Dimension buttondim = new Dimension(100,30);

	

	frame.setLocation(500, 150);
	frame.setPreferredSize(dim);
	frame.setVisible(true);
	
	label = new JLabel();
	label2 = new JLabel();
	label3 = new JLabel();

	button = new JButton();
    button2 = new JButton();
	
	button.setPreferredSize(buttondim);
	
	ImageIcon image = new ImageIcon(new ImageIcon("src/"+info.get(5)).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	
	System.out.println("/"+info.get(5));
	
	label3.setIcon(image);
	
	label.setText("      " + info.get(0)+
			"                "
			+info.get(1)+"                "
			+info.get(2)+"                "
			+info.get(3)+"                "
			+info.get(4)+"                ");
	
	label.setLocation(100, 200);
	
	button.setText("구매하기");
	button2.setPreferredSize(buttondim);
	button2.setText("삭제하기");
	button.setBackground(Color.GRAY);
	button2.setBackground(Color.GRAY);
	button.addActionListener(ac);
	button2.addActionListener(ac2);
	frame.add(label3);
	frame.add(label2);
	frame.add(label);
	frame.add(button);
	frame.add(button2);
	frame.setLayout(new FlowLayout());
	frame.pack();
	*/
	
	label = new Label();
	label2 = new Label();
	label3 = new Label();

	button = new Button();
	button2 = new Button();
	HBox frame = new HBox();
	ImageView image = new ImageView(new Image(info.get(5)));
	image.setFitHeight(100);
	image.setFitWidth(100);
	System.out.println("/"+info.get(5));
	
	label3.setGraphic(image);
	label.setText("      " + info.get(0)+
			"                "
			+info.get(1)+"                "
			+info.get(2)+"                "
			+info.get(3)+"                "
			+info.get(4)+"                ");
	label.setLayoutX(100);
	label.setLayoutY(200);
	
	button.setText("구매하기");
	button2.setText("삭제하기");
	button.setStyle("-fx-background-color : gray");
	button2.setStyle("-fx-background-color : gray");
	
	frame.getChildren().addAll(label3,label2, label,button, button2);
	frame.setAlignment(Pos.CENTER);
	//frame.getChildren().addAll(label2,button);
		
	
	Popup basketpopup;
	basketpopup = comServ.showPopUp(root.getScene(), "장바구니", frame, "None");
	if(basketpopup.isShowing())
	{basketpopup.hide();
	}
	return basketpopup;
	
}


	

       
}

	
