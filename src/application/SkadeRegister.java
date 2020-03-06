package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkadeRegister {
	private HashMap <Integer, Skadeanmälan> damageList = new HashMap <Integer, Skadeanmälan>();
	private ArrayList<String> incoming = new ArrayList<String>();
	private ArrayList<String> ongoing = new ArrayList<String>();
	private ArrayList<String> finished = new ArrayList<String>();
	private ArrayList<String> forwarded = new ArrayList<String>();


	public HashMap <Integer, Skadeanmälan> getSkadeLista() {
		return damageList;
	}

	public void setSkadeLista(HashMap <Integer, Skadeanmälan> damageList) {
		damageList = this.damageList;
	} 

	public ArrayList<String> getIncoming() {
		return incoming;
	}
	public void setInkommande(ArrayList<String> incoming) {
		this.incoming = incoming;
	}

	public ArrayList<String> getOngoing() {
		return ongoing;
	}
	public void setOngoing(ArrayList<String> ongoing) {
		this.ongoing = ongoing;
	}
	
	public ArrayList<String> getFinished() {
		return finished;
	}
	public void setFinished(ArrayList<String> finished) {
		this.finished = finished;
	}
	
	public ArrayList<String> getForwarded() {
		return forwarded;
	}
	public void setForwarded(ArrayList<String> forwarded) {
		this.forwarded = forwarded;
	}
	
	public void addDamage(Skadeanmälan skada) {
		damageList.put(skada.getDamageId(), skada);
	}
	
	// inkommande ärenden
	public ArrayList<String> showIncoming() {
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Inkommande")) {
				incoming.add(skada.getKey() + " " + skada.getValue().getTitle());
			}
			
		}
		Collections.sort(incoming);
		
		return incoming;
	}
	//pågående ärenden
	public ArrayList<String> showOngoing() {
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				ongoing.add(skada.getKey() + skada.getValue().getTitle());
			}
			
		}
		
		return ongoing;
	}
	//avslutade ärenden
	public ArrayList<String> showFinished() {
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Avslutad")) {
				finished.add(skada.getKey() + skada.getValue().getTitle());
			}
			
		}
		
		return finished;
	}
	//lista för vidarebefodrade ärenden
	public ArrayList<String> showForwarded() {
		for(Map.Entry<Integer, Skadeanmälan> skada : damageList.entrySet()) {
			if(skada.getValue().getStatus().equals("Pågående")) {
				forwarded.add(skada.getKey() + skada.getValue().getTitle());
			}
			
		}
		
		return forwarded;
	}
}
