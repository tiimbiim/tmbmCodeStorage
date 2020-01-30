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
import code.Driver;

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
		Driver t = new Driver();
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("Airline Reservation System");
		shell.setLayout(null);
	
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(291, 10, 400, 729);
		Button ticketBtn = new Button(shell, SWT.NONE);
		ticketBtn.setBounds(10, 10, 250, 50);
		ticketBtn.setText("Press to view the ticket info");
		Combo destCombo = new Combo(shell, SWT.NONE);
		Button passBtn = new Button(shell, SWT.NONE);
		passBtn.setBounds(10, 110, 250, 50);
		passBtn.setText("Press to view passenger info");
		Button ticketPurchaseBtn = new Button(shell, SWT.NONE);
		ticketPurchaseBtn.setBounds(10, 210, 250, 50);
		ticketPurchaseBtn.setText("Press to purchase a ticket");
		Button seatCheckBtn = new Button(shell, SWT.NONE);
		seatCheckBtn.setText("Press to check a seat");
		seatCheckBtn.setBounds(10, 311, 250, 50);
		Label label = new Label(shell,SWT.BORDER);
	 	Label nameLabel = new Label(shell,SWT.NONE);
		Label IDLabel = new Label(shell,SWT.NONE);
		Combo classCombo = new Combo(shell, SWT.NONE);
		classCombo.setText("Please select a class");
		Label pnLabel = new Label(shell, SWT.NONE);
		Label priceLabel = new Label(shell, SWT.NONE);
		Label requestLabel = new Label(shell, SWT.NONE);
		Label distLabel= new Label(shell, SWT.NONE);
		Label waitLabel = new Label(shell, SWT.NONE);
		Label seatRowLbl = new Label(shell, SWT.NONE);
		Label seatColLbl = new Label(shell, SWT.NONE);
		Text seatColText = new Text(shell, SWT.NONE);
		Text seatRowText = new Text(shell, SWT.NONE);
		Button checkSeat = new Button(shell, SWT.NONE);
		//seatRowText.setBounds(435, 210, 250, 50);
		//seatColText.setBounds(490, 210, 250, 50);
		
		seatCheckBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Checking available seats");
				
				lblNewLabel.setVisible(false);
				seatColLbl.setVisible(true);
				checkSeat.setVisible(true);
				seatRowLbl.setVisible(true);
				label.setVisible(true);
				nameLabel.setVisible(false);
				IDLabel.setVisible(false);
				classCombo.setVisible(false);
				pnLabel.setVisible(false);
				priceLabel.setVisible(false);
				requestLabel.setVisible(false);
				
				
				label.setText("Please enter the seat row number and \ncolumn number");

				label.setBounds(300,12,219,35);
				
				seatRowLbl.setBounds(300, 75, 200, 20);
				seatRowLbl.setText("Please enter a seat row number");
				
				seatColLbl.setBounds(300, 100, 200, 20);
				seatColLbl.setText("Please enter a seat column number");
				
				
				seatColText.setBounds(500, 75, 125, 20);
				seatRowText.setBounds(500, 100, 125, 20);
				
				checkSeat.setBounds(27, 650, 150, 30);
				checkSeat.setText("Press to check availability");
			
				checkSeat.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						//Label seatCheckLbl = new Label(shell, SWT.BORDER);
						Label seatCheckLbl2 = new Label(shell, SWT.BORDER);
						
						//seatCheckLbl.setBounds(500, 125, 125, 20);
						seatCheckLbl2.setBounds(500, 125, 125, 20);
						
						
						
					//	seatCheckLbl2.setText(Airplane.checkSeat(Integer.parseInt(seatRowText.getText()), Integer.parseInt(seatColText.getText())));
						
						//The button works and it sends back a message but it says that seats that are taken
						//are empty
						
						
					}
					});
			
				
				
			}
			});
		
		ticketBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Showing Ticket Info");
				
				lblNewLabel.setVisible(true);
				label.setVisible(false);
				nameLabel.setVisible(false);
				IDLabel.setVisible(false);
				classCombo.setVisible(false);
				pnLabel.setVisible(false);
				priceLabel.setVisible(false);
				requestLabel.setVisible(false);
				seatColLbl.setVisible(false);
				seatRowLbl.setVisible(false);
				checkSeat.setVisible(false);
				
		//		lblNewLabel.setText(Driver.printTicket());	
			}
			});
	
	passBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Showing Passenger Info");
				
				label.setVisible(false);
				nameLabel.setVisible(false);
				IDLabel.setVisible(false);
				classCombo.setVisible(false);
				pnLabel.setVisible(false);
				priceLabel.setVisible(false);
				requestLabel.setVisible(false);
				
			//	lblNewLabel.setText(Driver.toAdult(Driver.a));	
				//lblNewLabel.setText(testDriver.toKid(testDriver.c));
				//lblNewLabel.setText(testDriver.toSenior(testDriver.b)); 
			}
			});

		ticketPurchaseBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Random ran = new Random();
				//double salePrice = ran.nextDouble()*500 + 150;
				double discount = 0;//ran.nextDouble()*500 + 25;
				//double totalPrice;
				//double totalPrice = salePrice - discount;
				String flightNumb = "25896D74U";
				
				System.out.println("Purchasing a ticket");
				
				
				DecimalFormat decForm = new DecimalFormat("0.##");
				
				
				lblNewLabel.setVisible(false);	
				label.setVisible(true);
				nameLabel.setVisible(true);
				IDLabel.setVisible(true);
				classCombo.setVisible(true);
				pnLabel.setVisible(true);
				priceLabel.setVisible(true);
				requestLabel.setVisible(true);
				
				
				
				label.setBounds(300,12,219,35);
				label.setText("Please enter the required information" + "\n(Please enter in order)");
				
				
				nameLabel.setBounds(300, 75, 125, 12);
				nameLabel.setText("Please enter a name");
				
				Text nameText = new Text(shell, SWT.NONE);
				nameText.setBounds(435, 75, 250, 20);
				

				
				IDLabel.setBounds(300, 100, 125, 12);
				IDLabel.setText("Please enter an ID");
				
				Text IDText = new Text(shell, SWT.NONE);
				IDText.setBounds(435, 100, 250, 20);

				
				Label classLabel = new Label(shell, SWT.NONE);
				classLabel.setBounds(300, 125, 175, 20);
						
				classLabel.setText("Please select a class");
				
				classCombo.setBounds(435, 125, 175, 20);
				
				classCombo.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
					double totalPrice;
							totalPrice = MainWindow.fullPrice;
						
						if(classCombo.getText().equalsIgnoreCase("First"))
							MainWindow.fullPrice = ((Ticket.firstMod*flightDistance) - discount);
						
						else if(classCombo.getText().equalsIgnoreCase("Business"))
							MainWindow.fullPrice = ((Ticket.businessMod*flightDistance) - discount);
						
						else if(classCombo.getText().equalsIgnoreCase("Economy"))
							MainWindow.fullPrice = ((Ticket.econMod*flightDistance) - discount);
					
					}
				}); 

						pnLabel.setBounds(300, 150, 175, 15);
						pnLabel.setText("Please enter your phone number");
						
						Text pnText = new Text(shell, SWT.NONE);
						pnText.setBounds(485, 150, 200, 20);
						
						

						
						distLabel.setBounds(300, 175, 175, 20);
						distLabel.setText("Please select a destination");
						destCombo.setBounds(450, 175, 160, 20);

						destCombo.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								
								int flightDistance;
								
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
							
							
							
							
							if(classCombo.getText() != "" && destCombo.getText() != "") {
								priceLabel.setBounds(300, 200, 165, 12);
								priceLabel.setText("Total Price: $" + (decForm.format(MainWindow.fullPrice)));
							}
						}
						});
						
						Button addPassBtn = new Button(shell, SWT.NONE);
						addPassBtn.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								double distance = MainWindow.flightDistance;
								double totalPrice = MainWindow.fullPrice;
						//		Driver.liberator.addTicket(nameText.getText(), IDText.getText(), classCombo.getText(), pnText.getText(), discount, MainWindow.fullPrice, flightNumb, MainWindow.flightDistance , requestLabel.getText());
								
							}
						});
						addPassBtn.setBounds(27, 650, 150, 30);
						addPassBtn.setText("Press to purchase ticket");
						
					}
				});
		destCombo.setItems(new String[] {"Adelaid, Australia", "Kure, Japan", "Saigon, Viet Nam", "Berlin, Germany", "Stalingrad, Russia", "Washington, USA"});
		classCombo.setItems(new String[] {"First", "Business", "Economy"});
		
		Button waitBtn = new Button(shell, SWT.NONE);
		waitBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				label.setText("");
				nameLabel.setText("");
				IDLabel.setText("");
				classCombo.setText("");
				pnLabel.setText("");
				priceLabel.setText("");
				requestLabel.setText("");
				lblNewLabel.setVisible(false);
				waitLabel.setBounds(291, 10, 400, 729);
				
				//waitLabel.setText(testDriver.waitList.print());
			}
		});
		waitBtn.setBounds(10, 403, 256, 50);
		waitBtn.setText("Press to view waiting list");

		
	}
}

	

