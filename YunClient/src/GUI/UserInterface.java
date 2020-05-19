package GUI;

import App.*;
import java.awt.*;
import javax.swing.*;
public class UserInterface extends JFrame{
	private JPanel mainpanel;
	public UserInterface() {
		super();
		this.setSize(250,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainpanel = new SigninPanel();
		this.add(mainpanel);
		this.setVisible(true);
	}
}
