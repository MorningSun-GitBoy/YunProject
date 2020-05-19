package App;

import GUI.UserInterface;
import GUI.MainInterface;
public class App {
	public static void main(String[] args) {
		new Thread(()->{
			Users us = new Users();
			UserInterface ui = new UserInterface();
			us.signin("", "");;
		}
		).start();
	}
}
