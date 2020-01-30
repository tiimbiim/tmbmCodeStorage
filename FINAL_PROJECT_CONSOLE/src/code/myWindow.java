package code;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class myWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel m_contentPane;
	
	public static void main (String[] args)
	{
		try {
			myWindow frame = new myWindow();
			frame.setVisible(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public myWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,500,803,550);
		m_contentPane = new JPanel();
		m_contentPane.setLayout(null);
		setContentPane(m_contentPane);
		m_contentPane.setBorder(new EmptyBorder(5,5,5,5));
		
		JButton button = new JButton("Press to be a goon");
		button.setBounds(100,100,500,200);     //x, y (more = down), width, length
		m_contentPane.add(button);
	}

}
