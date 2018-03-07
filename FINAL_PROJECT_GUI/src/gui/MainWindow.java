package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.text.DecimalFormat;

import code.Airplane;
import code.Ticket;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

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
	public static double flightDistance;
	public static double fullPrice;
	private Text text;
	
	public void createContents() {
		Airplane n = new Airplane();
		testDriver t = new testDriver();
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Airline Reservation System");
		shell.setLayout(null);
	
		Label lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setBounds(235, 12, 411, 729);
		Combo combo = new Combo(shell, SWT.NONE);
		Combo destCombo = new Combo(shell, SWT.NONE);

		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Label label = new Label(shell,SWT.BORDER);
				Label nameLabel = new Label(shell,SWT.NONE);
				Label IDLabel = new Label(shell,SWT.NONE);
				Label classLabel = new Label(shell, SWT.NONE);
				Label pnLabel = new Label(shell, SWT.NONE);
				Label priceLabel = new Label(shell, SWT.NONE);
				Label requestLabel = new Label(shell, SWT.NONE);
				Label distLabel= new Label(shell, SWT.NONE);
				
				lblNewLabel.setVisible(true);
				
				Random ran = new Random();
				double salePrice = ran.nextDouble()*500 + 150;
				double discount = ran.nextDouble()*500000 + 10000;
				//double totalPrice;
				double totalPrice = salePrice - discount;
				String flightNumb = "25896D74U";
				
				
				if(!combo.getText().equalsIgnoreCase("Purchase a ticket")) {
					label.setVisible(false);
					nameLabel.setVisible(false);
					IDLabel.setVisible(false);
					classLabel.setVisible(false);
					pnLabel.setVisible(false);
					priceLabel.setVisible(false);
					requestLabel.setVisible(false);
				} else {
					label.setVisible(true);
					nameLabel.setVisible(true);
					IDLabel.setVisible(true);
					classLabel.setVisible(true);
					pnLabel.setVisible(true);
					priceLabel.setVisible(true);
					requestLabel.setVisible(true);
				}
				
				
				
				if(combo.getText().equals("Show Ticket Info")) {
					System.out.println("Showing Ticket Info");
					
					label.setText("");
					nameLabel.setText("");
					IDLabel.setText("");
					classLabel.setText("");
					pnLabel.setText("");
					priceLabel.setText("");
					requestLabel.setText("");
					
					lblNewLabel.setText(testDriver.printTicket());
				
				
				
				}
				else if(combo.getText().equals("Purchase a ticket")) {
					System.out.println("Purchasing a Ticket");

					
					//Random ran = new Random();
					DecimalFormat decForm = new DecimalFormat("0.##");
					
					
					lblNewLabel.setVisible(false);	
					
					
					label.setBounds(235,12,219,30);
					label.setText("Please enter the required information");
					
					
					nameLabel.setBounds(100, 75, 125, 12);
					nameLabel.setText("Please enter a name");
					
					Text nameText = new Text(shell, SWT.NONE);
					nameText.setBounds(235, 75, 250, 20);
					
					/******************************
					 ******************************/
					
					IDLabel.setBounds(100, 100, 125, 12);
					IDLabel.setText("Please enter an ID");
					
					Text IDText = new Text(shell, SWT.NONE);
					IDText.setBounds(235, 100, 250, 20);
					
					/******************************
					 ******************************/
					
					classLabel.setBounds(80, 125, 150, 15);
					classLabel.setText("Please enter a class");
					
					Text classText = new Text(shell, SWT.NONE);
					classText.setBounds(235, 125, 250, 20);
					
					classText.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							
						double totalPrice = ((salePrice*flightDistance) - discount);
								totalPrice = MainWindow.fullPrice;
							
							if(classText.getText().equalsIgnoreCase("First"))
								MainWindow.fullPrice = ((salePrice*flightDistance) - discount) * Ticket.firstMod;
							
							else if(classText.getText().equalsIgnoreCase("Business"))
								MainWindow.fullPrice = ((salePrice*flightDistance) - discount) * Ticket.businessMod;
							
							else
								MainWindow.fullPrice = ((salePrice*flightDistance) - discount) * Ticket.econMod;
							
						}
						});
				
					/******************************
					 ******************************/
					
					pnLabel.setBounds(40, 150, 175, 15);
					pnLabel.setText("Please enter your phone number");
					
					Text pnText = new Text(shell, SWT.NONE);
					pnText.setBounds(235, 150, 250, 20);
					
					/******************************
					 ******************************/
				/*	
					if(distLabel.getText() != "" && destCombo.getText() != "")
					priceLabel.setBounds(65, 175, 165, 12);
					priceLabel.setText("Total Price: $" + decForm.format(totalPrice));
				
				*/
					
					/******************************
					 ******************************/
					
					distLabel.setBounds(20, 225, 175, 20);
					distLabel.setText("Please select a destination");
					destCombo.setBounds(235, 225, 175, 20);

					destCombo.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							
							flightDistance = 0;
							
						if(destCombo.getText().equals("Adelaid, Australia"))
							flightDistance = 8150;
						
						else if(destCombo.getText().equals("Kure, Japan"))
							flightDistance = 5900;
						
						else if(destCombo.getText().equals("Saigon, Viet Nam"))
							flightDistance = 8150;
						
						else if(destCombo.getText().equals("Berlin, Germany"))
							flightDistance = 5800;
						
						else if(destCombo.getText().equals("Stalingrad, Russia"))
							flightDistance = 6625;
						
						else
							flightDistance = 1150;
						
						
						double totalPrice = ((salePrice*flightDistance) - discount);
						
						if(distLabel.getText() != "" && destCombo.getText() != "")
							priceLabel.setBounds(65, 175, 165, 12);
							priceLabel.setText("Total Price: $" + decForm.format(totalPrice));
						
						
						
						
						}
					});
					
					
					/******************************
					 ******************************/
					
					requestLabel.setBounds(20, 200, 210, 15);
					requestLabel.setText("Please enter any disabilities or requests");
					
					Text requestText = new Text(shell, SWT.NONE);
					requestText.setBounds(235, 200, 250, 20);
					
					Button addPassBtn = new Button(shell, SWT.NONE);
					addPassBtn.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							double distance = MainWindow.flightDistance;
							double totalPrice = MainWindow.fullPrice;
							testDriver.liberator.addTicket(nameText.getText(), IDText.getText(), classText.getText(), pnText.getText(), discount, totalPrice, flightNumb, distance , requestLabel.getText());
							
						}
					});
					addPassBtn.setBounds(27, 390, 150, 25);
					addPassBtn.setText("Press to add passenger");
					
				}
				
				
				else
					lblNewLabel.setText("");

				
			}
		});

	
		combo.setItems(new String[] {"Show Wait List Info", "Show Plane Seating", "Show Ticket Info", "Add a new passenger", "Purchase a ticket"});
		combo.setBounds(10, 10, 219, 23);
		destCombo.setItems(new String[] {"Adelaid, Australia", "Kure, Japan", "Saigon, Viet Nam", "Berlin, Germany", "Stalingrad, Russia", "Washington, USA"});
		

		
	}
}

