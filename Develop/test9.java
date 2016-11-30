package Develop;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class test9 {  
    public static void main(String[] args) {  
	  	
    	final String lookandfeel = "javax.swing.plaf.nimbus.NimbusLookAndFeel";				//	设置皮肤
        try {
			UIManager.setLookAndFeel(lookandfeel);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JFrame frame = new JFrame("Crystal");  
        frame.setLayout(new FlowLayout());  
        JLabel title = new JLabel("bbs.beyole.com");  
        JLabel enter = new JLabel("进入");  
        JLabel exit = new JLabel("退出");  
        JButton test = new JButton("test");
        frame.setSize(400, 400);   
        frame.add(title);  
        frame.add(enter);  
        frame.add(exit);  
        frame.add(test);
        frame.setVisible(true);  
    }  
}  