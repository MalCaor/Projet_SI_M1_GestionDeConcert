package donnees;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Billet implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bil_id")
    private Short bil_id;
    @Column(name = "bill_concert")
    private Concert concert;
  
    public Billet() {
    	super();
    }

	public Short getBil_id() {
		return bil_id;
	}

	public void setBil_id(Short bil_id) {
		this.bil_id = bil_id;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bil_id, concert);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billet other = (Billet) obj;
		return Objects.equals(bil_id, other.bil_id) && Objects.equals(concert, other.concert);
	}
}
