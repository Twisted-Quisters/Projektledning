package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SkadeRegister {
	private HashMap <Integer, Skadeanmälan> damageList = new HashMap <Integer, Skadeanmälan>();
	private ArrayList<Integer> ongoing = new ArrayList<Integer>();
	private Skadeanmälan damageInfo = null;


	public HashMap <Integer, Skadeanmälan> getSkadeLista() {
		return damageList;
	}

	public void setSkadeLista(HashMap <Integer, Skadeanmälan> damageList) {
		this.damageList = damageList;
	}
	public ArrayList<Integer> getOngoing() {
		return ongoing;
	}
	public void setFinished(ArrayList<Integer> ongoing) {
		this.ongoing = ongoing;
	}
	public Skadeanmälan getDamageInfo() {
		return damageInfo;
	}
	public void setDamageInfo(Skadeanmälan damageInfo) {
		this.damageInfo = damageInfo;
	}
	
	public void addDamage(Skadeanmälan skada) {
		damageList.put(skada.getDamageId(), skada);
	}
	
	// lista av inkommande ärenden
	public ObservableList<Skadeanmälan> showIncoming() {
		ArrayList<Skadeanmälan> incoming = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Inkommande")) {
				incoming.add(skada.getValue());
			}
		}
		ObservableList<Skadeanmälan> olIncoming = FXCollections.observableArrayList(incoming);	
		
		return olIncoming;
		
	}
	//lista av prioritet 1
	public ObservableList<Skadeanmälan> showPriority1() {
		ArrayList<Skadeanmälan> priority1 = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				if(skada.getValue().getPriority() == 1) {
				priority1.add(skada.getValue());
				}
			}
		}

		ObservableList<Skadeanmälan> olPriority1 = FXCollections.observableArrayList(priority1);	
		return olPriority1;
	}
	//lista av prioritet 2
	public ObservableList<Skadeanmälan> showPriority2() {
		ArrayList<Skadeanmälan> priority2 = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				if(skada.getValue().getPriority() == 2) {
				priority2.add(skada.getValue());
				}
			}
		}

		ObservableList<Skadeanmälan> olPriority2 = FXCollections.observableArrayList(priority2);	
		return olPriority2;
	}
	//lista av prioritet 3
	public ObservableList<Skadeanmälan> showPriority3() {
		ArrayList<Skadeanmälan> priority3 = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				if(skada.getValue().getPriority() == 3) {
				priority3.add(skada.getValue());
				}
			}
		}

		ObservableList<Skadeanmälan> olPriority3 = FXCollections.observableArrayList(priority3);	
		return olPriority3;
	}
	//lista av avslutade ärenden
	public ObservableList<Skadeanmälan> showFinished() {
		ArrayList<Skadeanmälan> finished = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Avslutad")) {
				finished.add(skada.getValue());
			}
		}
		ObservableList<Skadeanmälan> olFinished = FXCollections.observableArrayList(finished);	
		
		return olFinished;
	}
	
	//lista av vidarebefodrade ärenden
	public ObservableList<Skadeanmälan> showForwarded() {
		ArrayList<Skadeanmälan> forwarded = new ArrayList<Skadeanmälan>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Vidarebefodrad")) {
				forwarded.add(skada.getValue());
			}
		}
		ObservableList<Skadeanmälan> olForwarded = FXCollections.observableArrayList(forwarded);	
		
		return olForwarded;
	}
	//metod för att hitta ett ärende
	public Skadeanmälan findSkada(String damageId) {
		int id = Integer.parseInt(damageId);
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if (id == skada.getKey()) {
				return skada.getValue();
			}
		}
		return null;
	}
}
