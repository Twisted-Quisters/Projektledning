package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkadeRegister {
	private HashMap <Integer, Skadeanmälan> damageList = new HashMap <Integer, Skadeanmälan>();
	


	public HashMap <Integer, Skadeanmälan> getSkadeLista() {
		return damageList;
	}

	public void setSkadeLista(HashMap <Integer, Skadeanmälan> damageList) {
		damageList = this.damageList;
	} 
	
	public void addDamage(Skadeanmälan skada) {
		damageList.put(skada.getDamageId(), skada);
	}
	
	// inkommande ärenden
	public ArrayList<String> showIncoming() {
		ArrayList<Integer> incoming = new ArrayList<Integer>();
		ArrayList<String> sortIncoming = new ArrayList<String>();
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Inkommande")) {
				incoming.add(skada.getKey());
			}
			
		}
		Collections.sort(incoming);
		for(Integer id : incoming) {
			for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
				if(id.equals(skada.getKey())) {
					sortIncoming.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortIncoming;
	}
	
	//pågående ärenden
	public ArrayList<String> showOngoing() {
		ArrayList<Integer> ongoing = new ArrayList<Integer>();
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
	
	//avslutade ärenden
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
	
	//vidarebefodrade ärenden
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
				if(id.equals(skada.getKey())) {
					sortForwarded.add(skada.getKey() + " " + skada.getValue().getTitle());
				}
			}
		}
		return sortForwarded;
	}
}
