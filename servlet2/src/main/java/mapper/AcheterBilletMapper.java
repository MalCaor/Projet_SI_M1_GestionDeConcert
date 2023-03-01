package mapper;

public class AcheterBilletMapper {
	String operation;
	int nbBillet;
	int concertId;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getNbBillet() {
		return nbBillet;
	}
	public void setNbBillet(int nbBillet) {
		this.nbBillet = nbBillet;
	}
	public int getConcertId() {
		return concertId;
	}
	public void setConcertId(int concert) {
		this.concertId = concert;
	}
	@Override
	public String toString() {
		return getOperation()+getNbBillet()+getConcertId();
	}
}
