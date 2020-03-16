package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnsvarigRegister {
	private HashMap <Integer, Ansvarig> ansvarigLista = new HashMap <Integer, Ansvarig>();

	public HashMap <Integer, Ansvarig> getAnsvarigLista() {
		return ansvarigLista;
	}

	public void setAnsvarigLista(HashMap <Integer, Ansvarig> ansvarigLista) {
		this.ansvarigLista = ansvarigLista;
	}
	public void addAnsvarig(Ansvarig ansvarig) {
		ansvarigLista.put(ansvarig.getPersonalId(), ansvarig);
	}
	public ObservableList<String> showAnsvarig() {
		ArrayList<String> stringAnsvarigLista = new ArrayList<String>();
		for(Map.Entry<Integer, Ansvarig> anställd : ansvarigLista.entrySet()) {
			stringAnsvarigLista.add(anställd.getValue().getNamn());
			}
		ObservableList<String> olAnsvarigLista = FXCollections.observableArrayList(stringAnsvarigLista);	
		return olAnsvarigLista;
	}
}
