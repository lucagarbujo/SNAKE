package org.eclipse.wb.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Shell;

public class MioThread implements Runnable{
	
	private int x;
	private int y;
	

	public MioThread() {
		x = 0;
		y=0;
	}
	
	public MioThread (int x, int y){
		setX(x);
		setY(y);
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
			setY(getY()+10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
