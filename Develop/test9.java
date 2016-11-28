package Develop;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class test9 {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Crystal");  
        frame.setLayout(null);  
        JLabel title = new JLabel("bbs.beyole.com");  
        JLabel enter = new JLabel("进入");  
        JLabel exit = new JLabel("退出");  
        frame.setSize(200, 100);  
        title.setBounds(40, 5, 150, 20);  
        enter.setBounds(30, 30, 80, 20);  
        exit.setBounds(110, 30, 80, 20);  
        frame.add(title);  
        frame.add(enter);  
        frame.add(exit);  
        frame.setVisible(true);  
	  	//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");				//	设置皮肤
        try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
}  