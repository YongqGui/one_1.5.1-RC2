package gui_test;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Develop.Main_Window;

public class test {
	public static void main(String[] args) throws Exception {
		//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		Main_Window window  = new Main_Window();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);	    
  }
}
