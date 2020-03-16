package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {
	
	//Registers
	SkadeRegister skadeReg = new SkadeRegister();
	
	//Declaring panes to fix layout
	@FXML
	private Pane pnl_home;
	@FXML 
	private Pane pnl_incoming;
	@FXML 
	private Pane pnl_damageInfo;
	@FXML 
	private Pane pnl_ongoing;
	@FXML 
	private Pane pnl_priority1;
	@FXML 
	private Pane pnl_priority2;
	@FXML 
	private Pane pnl_priority3;
	
	
	
	//Declaring TableView
	@FXML
	private TableView<Skadeanmälan> incomingTable;
	@FXML
	private TableColumn<Skadeanmälan, Integer> idColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> titleColumn;
	
	//Declaring ComboBox
	@FXML
	private ComboBox<String> cbPriorityList;
	@FXML
	private ComboBox<String> cbStatusList;
	
	
	
	//Declaring Labels
	@FXML 
	private Label damageId;
	@FXML 
	private Label damageType;
	@FXML  
	private Label status;
	@FXML  
	private Label priority;
	@FXML 
	private Label time;
	@FXML  
	private Label place;
	@FXML  
	private Label title;
	@FXML  
	private Label ansvarig;
	
	//Declaring TextArea
	@FXML  
	private TextArea action;
	@FXML  
	private TextArea comment;
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		idColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		incomingTable.setItems(skadeReg.showIncoming());
		
		//Dummy data
		Skadeanmälan s1 = new Skadeanmälan();
		s1.setDamageId(2);
		s1.setTime("12:00");
		s1.setStatus("Inkommande");
		s1.setTitle("tjoho");
		s1.setPlace("EC1: 138");
		skadeReg.addDamage(s1);
		
		Skadeanmälan s2 = new Skadeanmälan();
		s2.setDamageId(1);
		s2.setTime("12:00");
		s2.setStatus("Inkommande");
		s2.setTitle("test");
		s2.setPlace("EC2: 069");
		skadeReg.addDamage(s2);
		
		
		//initializing TableView
		incomingTable.getItems().setAll(skadeReg.showIncoming());
	}
			
	//Buttons to change views
		public void buttonHome(ActionEvent homeScreen) {
			pnl_home.toFront();
		}
		public void buttonIncoming(ActionEvent incomingScreen) {
			pnl_incoming.toFront();
		}
		public void buttonIncomingDamageInfo(ActionEvent incomingDamageInfoScreen) {
			pnl_damageInfo.toFront();
			Skadeanmälan skada = incomingTable.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			
			
		}
		public void buttonOngoing(ActionEvent ongoingScreen) {
			pnl_ongoing.toFront();
		}
		public void buttonPriority1(ActionEvent priority1Screen) {
			pnl_priority1.toFront();
		}
		//Adds priority to comboBox
		public void comboBoxPriorityList() {
			ArrayList<String> priorityList = new ArrayList<String>();
			priorityList.add("1");
			priorityList.add("2");
			priorityList.add("3");
			ObservableList<String> olPriorityList = FXCollections.observableArrayList(priorityList);
			cbPriorityList.setItems(olPriorityList);
		}
		//Adds priority to comboBox
		public void comboBoxStatusList() {
			ArrayList<String> statusList = new ArrayList<String>();
			statusList.add("Pågående");
			statusList.add("Avslutad");				
			statusList.add("Vidarebefodrad");
			ObservableList<String> olStatusList = FXCollections.observableArrayList(statusList);
			cbPriorityList.setItems(olStatusList);
				}
	
}
