package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import java.awt.*;
import java.awt.event.ActionEvent;

import code.Airplane;
import code.testDriver;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class MainWindow {



	public Shell shell;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Airplane n = new Airplane();
		
		
		try {
			MainWindow window = new MainWindow();
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
	public void createContents() {
		Airplane n = new Airplane();
		testDriver t = new testDriver();
		shell = new Shell();
		shell.setSize(1920, 1080);
		shell.setText("Airline Reservation System");
		shell.setLayout(new GridLayout(1, false));
		
	}
}

