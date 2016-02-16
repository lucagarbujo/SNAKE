import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.wb.swt.SWTResourceManager;

public class Punto extends Thread{
	// attributi
	private int x;
	private int y;
	public static int xmin=0;
	public static int xmax=400;
	public static int ymin=0;
	public static int ymax=400;
	
	// costruttori

	public Punto() { 
		x = xmin;
		y = ymin;
	}
	public Punto(int x1, int y1) { 
		setX(x1);
        	setY(y1);
	}
	public Punto(Punto p) { 
		setX(p.x);
        	setY(p.y);	
        }
	
     	// setter/getter

	public void setX(int x1) {
		if(x1>=xmin && x1<=xmax) x=x1;
	   	if(x1 <xmin) 		 x=xmin;
                if(x1 >xmax)             x=xmax;
	}
	public void setY(int y1) {
		if(y1>=ymin && y1<=ymax) y=y1;
	   	if(y1 <ymin) 		 y=ymin;
                if(y1 >ymax)             y=ymax;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
     	// toString  
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
     	// equals
     	public boolean equals(Punto p){
           return (x==p.x && y==p.y);
     	}
     	
     public Punto clone(){
    	 return new Punto(this);
     }
     
     
    
}