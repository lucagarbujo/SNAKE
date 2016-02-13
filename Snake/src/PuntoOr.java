
public class PuntoOr extends Punto {
	
	private char orientamento;

	public PuntoOr() {
		
		super();
		this.orientamento = 'A';
	
	}

	public PuntoOr(int x, int y, char c) {
		super(x, y);
		setOrientamento(c);
	}

	public PuntoOr(PuntoOr p) {
		super(p);
		setOrientamento(p.orientamento);
		
	}

	public char getOrientamento() {
		return orientamento;
	}

	public void setOrientamento(char c) {
		if(c == 'A' || c == 'B' || c == 'S' || c == 'D'){
		this.orientamento = c;
		}
	}
	
	public boolean Equals (PuntoOr p){
		if(super.equals(p) && p.orientamento == orientamento){
			return true;
		}
	return false;
	}

	
	public String toString() {
		return "PuntoOr [orientamento=" + orientamento + "]" + super.toString();
	}
	
	
	
	

}
