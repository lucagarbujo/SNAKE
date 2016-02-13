import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

public class testSnake {

	protected Shell shell;
	private Polyline x;
	private GC gc;
	private Canvas canvas;

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

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
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
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				PuntoOr b= new PuntoOr (10,50,'B');
				gc = new GC (canvas);
				gc.drawRectangle(b.getX(), b.getY(), 10, 10);
				while(b.getY() != 362){
					
					b.setY(b.getY()+10);
					
					
					try {
						
						gc.drawRectangle(b.getX(), b.getY(), 10, 10);
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
		});
		canvas.setBounds(10, 10, 449, 362);
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.setBounds(199, 400, 75, 25);
		btnStart.setText("Start");
		
		
		
		
		

	}
}
