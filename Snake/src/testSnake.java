import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.MioThread;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class testSnake {

	protected Shell shell;
	private Polyline x;
	private Canvas canvas;
	private GC gc;
	private boolean flag = false;
	private boolean flag1 = true;
	private char d = 'd';
	private Punto b= new Punto (150,50);
	//private Punto oggetto = new Punto (300,100); salvare posizione oggetto
	private int xOggetto;
	private int yOggetto;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			testSnake window = new testSnake();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void controllaPosizione(){
		
		if(b.getX()+12 >=xOggetto && b.getX()+10<xOggetto+10 &&  b.getY()+10>yOggetto && b.getY()+10<yOggetto+10 ||
		b.getX()+10 >=xOggetto && b.getX()+10<xOggetto && b.getY() == yOggetto){
			//System.out.println("collisione");
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(xOggetto, yOggetto, 10, 10);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			disegnaOggetto();
		}
		if(b.getX()+10>=xOggetto && b.getX()+10<xOggetto+10 && b.getY()<yOggetto+10 && b.getY()>yOggetto){
			System.out.println("collisione");
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(xOggetto, yOggetto, 10, 10);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			disegnaOggetto();
		}
		
		
		
		
		
	}
	
	public void disegnaOggetto(){
	
		xOggetto = (int)(Math.random()*439);
		yOggetto = (int) (Math.random()*352);
		gc = new GC (canvas);
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		gc.fillRectangle(xOggetto, yOggetto, 10, 10);
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		
		
	}
	
	public void muovi (Punto b){
		gc = new GC (canvas);
		controllaPosizione();
		switch (d){
		case 'u':
			
			if(b.getY()+10 < 0){
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillRectangle(b.getX(), b.getY()+10, 15, 10);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				b.setY(362);
				//controllaPosizione();
			}	
			
			b.setY(b.getY()-10);
			gc.drawRectangle(b.getX(), b.getY(), 10, 10);
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX(), b.getY()+11, 15, 10);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			//controllaPosizione();
			
		break;
		case 'd':
			
			if(b.getY()>362){
				//MessageDialog.openInformation(shell, "finito", "finish");
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillRectangle(b.getX(), b.getY()-10, 15, 10);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				b.setY(-10);
			}
			
			b.setY(b.getY()+10);
			gc.drawRectangle(b.getX(), b.getY(), 10, 10);
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX(), b.getY()-10, 15, 10);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			
		break;
		
		case 'l':
			
		
			
			if(b.getX()+10 < 0){
				System.out.println("ciao");
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillRectangle(b.getX()+10, b.getY(), 15, 10);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				b.setX(449);
			}
			b.setX(b.getX()-10);
			gc.drawRectangle(b.getX(), b.getY(), 11, 10);
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX()+11, b.getY(), 15, 11);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		break;
		
		case 'r':
			if(b.getX()>449){
				
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillRectangle(b.getX()-10, b.getY(), 15, 10);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				b.setX(0);
				
			}
			b.setX(b.getX()+10);
			gc.drawRectangle(b.getX(), b.getY(), 10, 10);
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX()-15, b.getY(), 15, 11);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			
		break;
		
		}
	}
	
	public void setInterval(int time){
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		muovi(b);
	
		
	}
	
		

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			
			if (!display.readAndDispatch()) {
				//display.sleep();
				if(flag == true){
			
				setInterval(200);
			}
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		
		shell.setSize(505, 473);
		shell.setText("SWT Application");
		
		canvas = new Canvas(shell, SWT.NONE);
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				switch(e.keyCode){
				case 16777217 :
					d= 'u';
				break;
				case 16777219:
					d = 'l';
				break;
				
				case 16777218:
					d = 'd';
				break;
				case 16777220:
					d = 'r';
				}
			}
		});
		
		
		
			
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		canvas.setBounds(10, 10, 449, 362);
		
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			flag = true;
			if(flag1 == true){
			disegnaOggetto();
			}
			flag1= false;
			//muovi (b);
			}
		
				
				
		});
		btnStart.setBounds(25, 400, 75, 25);
		btnStart.setText("Start");
		
		Button btnPause = new Button(shell, SWT.NONE);
		btnPause.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				flag = false;
			}
		});
		btnPause.setBounds(106, 400, 75, 25);
		btnPause.setText("Pause");
		
		
		
		
		

	}
}
