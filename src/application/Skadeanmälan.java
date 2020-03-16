package application;

import javafx.beans.property.SimpleStringProperty;

public class Skadeanmälan {
 private int damageId;
 private String damageType;
 private String status = "Inkommande";
 private int priority;
 private String action;
 private String time;
 private String place;
 private String title;
 private String comment;
 private Ansvarig ansvarig;

 
 public int getDamageId() {
	 return damageId;
 }
 
 public void setDamageId(int damageId) {
		this.damageId = damageId;
 }
 
 public String getDamageType() {
	 return damageType;
 }
 
 public void setDamageType(String damageType) {
		this.damageType = damageType; 
 }
 
 public String getStatus() {
	 return status;
 }
 
 public void setStatus (String status) {
		this.status = status;
}
 
 public int getPriority () {
	 return priority;
 }
 
 public void setPriority(int priority) {
		this.priority = priority;
 }
 
 public String getAction () {
	 return action;
 }
 
 public void setAction(String action) {
		this.action = action;
 }
 public String getTime() {
	 return time;
 }
 
 public void setTime(String time) {
		this.time = time;
 }
 
 public String getPlace() {
	 return place;
 }
 
 public void setPlace(String place) {
		this.place = place;
 }
 
 public String getTitle() {
	 return title;
 }
 
 public void setTitle(String title) {
		this.title = title;
 }
 
 public String getComment() {
	 return comment;
 }
 
 public void setComment(String comment) {
		this.comment = comment;
 }
 public Ansvarig getAnsvarig() {
	 return ansvarig;
 }
 public void setAnsvarig(Ansvarig ansvarig) {
	 this.ansvarig = ansvarig;
 }
}

 
 
