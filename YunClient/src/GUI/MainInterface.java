package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainInterface extends JFrame{
	private JPanel mainpanel;
	public MainInterface() {
		super();
		this.setSize(250,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainpanel = new SigninPanel();
		this.add(mainpanel);
		this.setVisible(true);
	}
}
