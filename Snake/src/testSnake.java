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
	private char d = 'd';
	private Punto b= new Punto (10,50);
	

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
	
	public void muovi (Punto b,char d){
		

			
			
		
		   gc = new GC (canvas);
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
			
			
		
		//MessageDialog.openInformation(shell, "finito", "finish");
		
		
	}
	
	public void setInterval(int time){
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		muovi(b,d);
		
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
			public void keyPressed(KeyEvent e){
				switch(e.keyCode){
				case 16777217 :
					d= 'u';
					
					break;
				case :
					
					break;
				case :
					
					break;
				case :
					
					break;
				}
			
			}
		});
		
		
			
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		canvas.setBounds(10, 10, 449, 362);
		
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			flag = true;
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
