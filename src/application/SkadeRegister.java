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
	
	//lista av pågående ärenden
	public ArrayList<String> showOngoing() {
		ArrayList<String> sortOngoing = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				ongoing.add(skada.getKey());
			}
			
		}
		Collections.sort(ongoing);
		for(Integer id : ongoing) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortOngoing.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortOngoing;
	}
	//lista av prioritet 1
	public ArrayList<String> showPriority1() {
		ArrayList<Integer> priority1 = new ArrayList<Integer>();
		ArrayList<String> sortPriority1 = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				ongoing.add(skada.getKey());
			}
			
		}
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			for(Integer ongoing : ongoing) {
				if(ongoing.equals(skada.getKey())) {
					if(skada.getValue().getPriority() == 1) {
						priority1.add(skada.getKey());
					}	
				}	
			}
		}
		Collections.sort(priority1);
		for(Integer id : priority1) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortPriority1.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortPriority1;
	}
	//lista av prioritet 2
	public ArrayList<String> showPriority2() {
		ArrayList<Integer> priority2 = new ArrayList<Integer>();
		ArrayList<String> sortPriority2 = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			for(Integer ongoing : ongoing) {
				if(ongoing.equals(skada.getKey())) {
					if(skada.getValue().getPriority() == 2) {
						priority2.add(skada.getKey());
					}	
				}	
			}
		}
		Collections.sort(priority2);
		for(Integer id : priority2) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortPriority2.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortPriority2;
	}
	//lista av prioritet 3
	public ArrayList<String> showPriority3() {
		ArrayList<Integer> priority3 = new ArrayList<Integer>();
		ArrayList<String> sortPriority3 = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			for(Integer ongoing : ongoing) {
				if(ongoing.equals(skada.getKey())) {
					if(skada.getValue().getPriority() == 3) {
						priority3.add(skada.getKey());
					}	
				}	
			}
		}
		Collections.sort(priority3);
		for(Integer id : priority3) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortPriority3.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortPriority3;
	}
	//lista av avslutade ärenden
	public ArrayList<String> showFinished() {
		ArrayList<Integer> finished = new ArrayList<Integer>();
		ArrayList<String> sortFinished = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Avslutad")) {
				finished.add(skada.getKey());
			}
			
		}
		Collections.sort(finished, Collections.reverseOrder());
		for(Integer id : finished) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortFinished.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortFinished;
	}
	
	//lista av vidarebefodrade ärenden
	public ArrayList<String> showForwarded() {
		ArrayList<Integer> forwarded = new ArrayList<Integer>();
		ArrayList<String> sortForwarded = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				forwarded.add(skada.getKey());
			}
			
		}
		Collections.sort(forwarded, Collections.reverseOrder());
		for(Integer id : forwarded) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id == skada.getKey()) {
					sortForwarded.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortForwarded;
	}
	//metod för att hitta ett ärende
	public Skadeanmälan getSkada(String damageId) {
		int id = Integer.parseInt(damageId);
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if (id == skada.getKey()) {
				return skada.getValue();
			}
		}
		return null;
	}
}
