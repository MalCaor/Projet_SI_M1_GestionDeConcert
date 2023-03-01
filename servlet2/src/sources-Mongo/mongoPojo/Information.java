package mongoPojo;

import java.sql.Date;
import java.util.Objects;

public class Information {
	private String informationDe;
	private int informationDeID;
	private String date ;
	private String auteur ;
	private String information ; 
	private String type;
	
	public String getInformationDe() {
		return informationDe;
	}
	public void setInformationDe(String informationDe) {
		this.informationDe = informationDe;
	}
	public int getInformationDeID() {
		return informationDeID;
	}
	public void setInformationDeID(int informationDeID) {
		this.informationDeID = informationDeID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	public String toString() {
		return "auteur :" + auteur +"\n information : "+information;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(auteur, date, information, informationDe, informationDeID, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Information other = (Information) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(date, other.date)
				&& Objects.equals(information, other.information) && Objects.equals(informationDe, other.informationDe)
				&& informationDeID == other.informationDeID && Objects.equals(type, other.type);
	}
	
}
