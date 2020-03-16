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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {
	
	//Registers
	SkadeRegister skadeReg = new SkadeRegister();
	AnsvarigRegister ansvarReg = new AnsvarigRegister();
	
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
	@FXML
	private Pane pnl_finished;
	@FXML 
	private Pane pnl_forwarded;
	
	
	
	//Declaring TableView incoming
	@FXML
	private TableView<Skadeanmälan> incomingTable;
	@FXML
	private TableColumn<Skadeanmälan, Integer> incomingIdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> incomingTitleColumn;
	
	//TableView priorities
	@FXML
	private TableView<Skadeanmälan> priority1Table;
	@FXML
	private TableColumn<Skadeanmälan, Integer> priority1IdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> priority1TitleColumn;
	@FXML
	private TableView<Skadeanmälan> priority2Table;
	@FXML
	private TableColumn<Skadeanmälan, Integer> priority2IdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> priority2TitleColumn;
	@FXML
	private TableView<Skadeanmälan> priority3Table;
	@FXML
	private TableColumn<Skadeanmälan, Integer> priority3IdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> priority3TitleColumn;
	
	//TableView finished
	@FXML
	private TableView<Skadeanmälan> finishedTable;
	@FXML
	private TableColumn<Skadeanmälan, Integer> finishedIdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> finishedTitleColumn;
	
	//TableView forwarded
	@FXML
	private TableView<Skadeanmälan> forwardedTable;
	@FXML
	private TableColumn<Skadeanmälan, Integer> forwardedIdColumn;
	@FXML 
	private TableColumn<Skadeanmälan, String> forwardedTitleColumn;
	
	
	//Declaring ComboBox
	@FXML
	private ComboBox<String> cbPriorityList;
	@FXML
	private ComboBox<String> cbStatusList;
	@FXML
	private ComboBox<String> cbTypeList;
	@FXML
	private ComboBox<String> cbAnsvarigList;
	
	
	
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
		
		//Incoming
		incomingIdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		incomingTitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		//Priority
		priority1IdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		priority1TitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		priority2IdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		priority2TitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		priority3IdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		priority3TitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		//Finished
		finishedIdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		finishedTitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		//Finished
		forwardedIdColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, Integer>("damageId"));
		forwardedTitleColumn.setCellValueFactory(new PropertyValueFactory<Skadeanmälan, String>("title"));
		
		
		//Dummy data
		Skadeanmälan s1 = new Skadeanmälan();
		s1.setDamageId(2);
		s1.setTime("12:00");
		s1.setTitle("tjoho");
		s1.setPlace("EC1: 138");
		skadeReg.addDamage(s1);
		
		Skadeanmälan s2 = new Skadeanmälan();
		s2.setDamageId(1);
		s2.setTime("12:00");
		s2.setTitle("test");
		s2.setPlace("EC2: 069");
		skadeReg.addDamage(s2);
		
		Ansvarig a1 = new Ansvarig();
		a1.setNamn("Magnus");
		a1.setPersonalId(12345);
		ansvarReg.addAnsvarig(a1);
		
		Ansvarig a2 = new Ansvarig();
		a2.setNamn("Markus");
		a2.setPersonalId(5678);
		ansvarReg.addAnsvarig(a2);
		
		
		
		//initializing TableView
		incomingTable.getItems().setAll(skadeReg.showIncoming());
		priority1Table.getItems().setAll(skadeReg.showPriority1());
		priority2Table.getItems().setAll(skadeReg.showPriority2());
		priority3Table.getItems().setAll(skadeReg.showPriority3());
		finishedTable.getItems().setAll(skadeReg.showFinished());
		forwardedTable.getItems().setAll(skadeReg.showForwarded());
		
		//initializing ComboBox
		comboBoxPriorityList();
		comboBoxStatusList();
		comboBoxTypeList();
		System.out.println(ansvarReg.showAnsvarig());
		ObservableList<String> test = ansvarReg.showAnsvarig();
		//cbAnsvarigList.setItems(ansvarReg.showAnsvarig());
	}
			
	//Buttons to change views
		public void buttonHome(ActionEvent homeScreen) {
			pnl_home.toFront();
		}
		public void buttonIncoming(ActionEvent incomingScreen) {
			pnl_incoming.toFront();
		}
		public void buttonOngoing(ActionEvent ongoingScreen) {
			pnl_ongoing.toFront();
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
			priority.setText("Ingen prioritet ifylld");
			damageType.setText("Ingen typ ifylld");
			ansvarig.setText("Ingen ansvarig ifylld");
		}
		
		public void buttonPriority1(ActionEvent priority1Screen) {
			pnl_priority1.toFront();
		}
		public void buttonPriority1DamageInfo(ActionEvent priority1DamageInfoScreen) {
			pnl_damageInfo.toFront();
			Skadeanmälan skada = priority1Table.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			ansvarig.setText(skada.getAnsvarig().getNamn());
		}
		public void buttonPriority2(ActionEvent priority2Screen) {
			pnl_priority2.toFront();
			
		}
		
		public void buttonPriority2DamageInfo(ActionEvent priority2DamageInfoScreen) {
			pnl_damageInfo.toFront();
			Skadeanmälan skada = priority2Table.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			ansvarig.setText(skada.getAnsvarig().getNamn());
			
		}
		public void buttonPriority3(ActionEvent priority3Screen) {
			pnl_priority3.toFront();
		}
		
		public void buttonPriority3DamageInfo(ActionEvent priority3DamageInfoScreen) {
			pnl_damageInfo.toFront();
			Skadeanmälan skada = priority3Table.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			ansvarig.setText(skada.getAnsvarig().getNamn());
			
		}
		public void buttonFinished(ActionEvent finishedScreen) {
			pnl_finished.toFront();
		}
		
		public void buttonFinishedDamageInfo(ActionEvent incomingFinishedInfoScreen) {
			pnl_damageInfo.toFront();
			Skadeanmälan skada = finishedTable.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			ansvarig.setText(skada.getAnsvarig().getNamn());
			
		}
		public void buttonForwarded(ActionEvent forwardedScreen) {
			pnl_forwarded.toFront();
		}
		
		public void buttonForwardedDamageInfo(ActionEvent incomingForwardedInfoScreen) {
			
			pnl_damageInfo.toFront();
			Skadeanmälan skada = forwardedTable.getSelectionModel().getSelectedItem();
			skadeReg.setDamageInfo(skada);
			
			damageId.setText(Integer.toString(skada.getDamageId()));
			title.setText(skada.getTitle());
			status.setText(skada.getStatus());
			time.setText(skada.getTime());
			place.setText(skada.getPlace());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			ansvarig.setText(skada.getAnsvarig().getNamn());
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
			cbStatusList.setItems(olStatusList);
		}
		//Adds priority to comboBox
		public void comboBoxTypeList() {
			ArrayList<String> typeList = new ArrayList<String>();
			typeList.add("Möbel");
			typeList.add("Fönster");				
			typeList.add("Elektronik");
			typeList.add("Belysning");
			typeList.add("Rör/ledning");
			typeList.add("Ventilation");
			typeList.add("Golv");
			typeList.add("Vägg");
			typeList.add("Dörr");
			typeList.add("Utrymningssystem");
			ObservableList<String> olTypeList = FXCollections.observableArrayList(typeList);
			cbTypeList.setItems(olTypeList);
		}
				
		public void buttonUpdateDamage(ActionEvent update) {
			
			String currentDamageId = damageId.getText();
			Skadeanmälan skada = skadeReg.findSkada(currentDamageId);
			
			String statusUpdate = cbStatusList.getSelectionModel().getSelectedItem();
			skada.setStatus(statusUpdate);
			
			String priorityUpdate = cbPriorityList.getSelectionModel().getSelectedItem();
			skada.setPriority(Integer.parseInt(priorityUpdate));
			
			String typeUpdate = cbTypeList.getSelectionModel().getSelectedItem();
			skada.setDamageType(typeUpdate);
			

			status.setText(skada.getStatus());
			priority.setText(Integer.toString(skada.getPriority()));
			damageType.setText(skada.getDamageType());
			
			
			cbPriorityList.getSelectionModel().select(null);
			cbStatusList.getSelectionModel().select(null);
			cbTypeList.getSelectionModel().select(null);
			
			//uppdaterar tabellerna
			incomingTable.getItems().setAll(skadeReg.showIncoming());
			priority1Table.getItems().setAll(skadeReg.showPriority1());
			priority2Table.getItems().setAll(skadeReg.showPriority2());
			priority3Table.getItems().setAll(skadeReg.showPriority3());
			forwardedTable.getItems().setAll(skadeReg.showForwarded());
			finishedTable.getItems().setAll(skadeReg.showFinished());
			
		}
	
}
