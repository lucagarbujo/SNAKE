import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	//private Polyline x;
	private Canvas canvas;
	private GC gc;
	private boolean flag = false;
	private boolean flag1 = true;
	private char d = 'r';
	private Punto b= new Punto (0,0);
	//private Punto oggetto = new Punto (300,100); salvare posizione oggetto
	private int xOggetto;
	private int yOggetto;
	private BufferedWriter scrit;
	private BufferedWriter scrit2;
	private BufferedReader let;
	private BufferedReader let2;
	

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
		
		if(b.getX() == xOggetto && b.getY() == yOggetto){
			disegnaOggetto();
		}
		
		
		
		
		
	}
	
	public void disegnaOggetto(){
	
		xOggetto = (int)(1+Math.random()*30);
		yOggetto = (int) (1+Math.random()*24);
		gc = new GC (canvas);
		/*
		if(xOggetto%15 != 0 && yOggetto%15!=0){
			while(xOggetto%15 != 0 && yOggetto%15!=0){
				xOggetto = (int)(14+Math.random()*450);
				yOggetto = (int) (14+Math.random()*350);
			}
		}
		*/
		xOggetto = xOggetto*15;
		yOggetto = yOggetto*15;
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		gc.fillOval(xOggetto, yOggetto, 15, 15);
		gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		
		
	}
	
	public void muovi (Punto b){
		gc = new GC (canvas);
		controllaPosizione();
		switch (d){
		case 'u':
			
			if(b.getY()<= 0){
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillOval(b.getX(), b.getY(), 15, 15);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				
				b.setY(360);
				//controllaPosizione();
			}	
			
			
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillOval(b.getX(), b.getY(), 15, 15);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
			
			b.setY(b.getY()-15);
			gc.fillOval(b.getX(), b.getY(), 15, 15);
			//controllaPosizione();
			
			
		break;
		case 'd':
			
			if(b.getY()>=360){
				//MessageDialog.openInformation(shell, "finito", "finish");
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillOval(b.getX(), b.getY()-7, 15, 15);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				b.setY(-15);
			}
			
			
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX(), b.getY(), 15, 15);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
			
			b.setY(b.getY()+15);
			gc.fillOval(b.getX(), b.getY(), 15, 15);
			
		break;
		
		case 'l':
			
		
			
			if(b.getX()<= 0){
				
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillRectangle(b.getX(), b.getY(), 15, 15);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				b.setX(450);
			}
			
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillRectangle(b.getX(), b.getY(), 15, 15);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
			
			b.setX(b.getX()-15);
			gc.fillOval(b.getX(), b.getY(), 15, 15);
		break;
		
		case 'r':
			if(b.getX()+10>=450){
				
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
				gc.fillOval(b.getX(), b.getY(), 15, 15);
				gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
				b.setX(-15);
				
				
			}
			
			
			
			//clear
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			gc.fillOval(b.getX(), b.getY(), 15, 15);
			gc.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
			
			b.setX(b.getX()+15);
			gc.fillOval(b.getX(), b.getY(), 15, 15);
			
		break;
		
		}
	}
	public void loadAll(){
		//BufferedReader let;
		
		String riga = "";
		String riga2 = "";
		String dati [];
		String dati2 [];
		
		
			try {
				let = new BufferedReader(new FileReader("xym.txt"));
				let2 = new BufferedReader(new FileReader("xys.txt"));
				do{
				
				riga = let.readLine();
				riga2 = let2.readLine();
				dati = riga.split(" ");
				dati2 = riga2.split(" ");
				xOggetto = Integer.parseInt(dati[0]) ;
				yOggetto = Integer.parseInt(dati[1]) ;
				
				b.setX(Integer.parseInt(dati2[0]));
				b.setY(Integer.parseInt(dati2[1]));
				let.close();
				let2.close();
				
				}while(riga != null);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	public void saveAll(){
		//BufferedWriter scrit;
		String riga ="";
		String riga2 = "";
		
		try {
			scrit = new BufferedWriter(new FileWriter("xys.txt",false));
			scrit2 = new BufferedWriter(new FileWriter("xym.txt",false));
			riga = b.getX() + " " + b.getY();
			riga2 = xOggetto + " " + yOggetto;
			scrit2.write(riga2);
			scrit.write(riga);
			
			//scrit.newLine();
			scrit.close();
			scrit2.close();
			
				
				
				
				
			
			//MessageDialog.openInformation(shell, "Lettura File", "Voto : " + media);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		saveAll();
	
		
	}
	
		

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		//loadAll();
		while (!shell.isDisposed()) {
			
			if (!display.readAndDispatch()) {
				//display.sleep();
				
				if(flag == true){
					
				setInterval(150);
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
		canvas.setBounds(15, 15, 450, 360);
		
		
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
