package Develop;

import com.sun.j3d.utils.applet.MainFrame;

import java.awt.*;

import javax.swing.JFrame;

public class test {
	public static void main(String[] args) {
	//new MoveGlobe();
	//new MainFrame(new MoveGlobe(), 480, 480);
    JFrame frame = new JFrame();
    frame.setSize(680, 680);
    frame.setTitle("Java 2D Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MoveGlobe applet = new MoveGlobe();
    applet.init();
    frame.getContentPane().add(applet);
    //frame.pack();
    frame.setVisible(true);
}
}