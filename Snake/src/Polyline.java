import java.util.Arrays;

public class Polyline {
	private Punto ep[];
	private final int NUM_MAX_PUNTI = 50;
	
	public Polyline(){
		ep = new Punto [0];
		
		
	}
	public boolean agg (Punto c){
		
		if(NUM_MAX_PUNTI==ep.length){
			return false;
		}
		ep=Arrays.copyOf(ep, ep.length+1);
		ep[ep.length-1]=c.clone();
		return true;
		
		
	}
	public boolean eli(int pos){
	if(ep[pos]!= null){
		for(int i=pos; i<ep.length;i++){
			ep[i]=ep[i+1].clone();
		}
		ep=Arrays.copyOf(ep, ep.length-1);
		return true;
	}
	return false;
	
	}
	public Punto getPunto(int pos){
		
		if( ep[pos] == null){
			return null;
			
		}else {
			Punto a = new Punto();
			return a;
		}
		
		
		
	}
}
