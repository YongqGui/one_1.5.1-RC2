package gui_test;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Main_Window1 extends JFrame {
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 900;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 700;
	/** log panel's initial weight in the split panel */
	private static final double SPLIT_PANE_LOG_WEIGHT = 0.2;
	
	private JScrollPane playFieldScroll;
	
	//---------------------------设置tab页面----------------------------//
	  private String[] flavors = { "路由模块", "运动模块", "缓存模块","链路模块" };
	  private static JTabbedPane tabs = new JTabbedPane();
	  //private JTextField txt = new JTextField(20);
	  public Main_Window1() {
		   int i = 0;
		   for(String flavor : flavors)
		     tabs.addTab(flavors[i],new JButton("Tabbed pane " + i++));
		   //add(BorderLayout.SOUTH, txt);
		   add(tabs);
	  }
	  

      static JLabel label1=new JLabel("Label 1",JLabel.CENTER); 
      static JLabel label2=new JLabel("Label 2",JLabel.CENTER);
      static JLabel label3=new JLabel("Label 3",JLabel.CENTER);
      static JLabel label4=new JLabel("Label 4",JLabel.CENTER);

      static JSplitPane JSP1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,label1,label2);
      static JSplitPane JSP2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,JSP1,label3);
      static JSplitPane JSP3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,label4,JSP2);

      
	  public static void main(String[] args) throws Exception {
		    JFrame frame = new Main_Window1();
		    JSP1.setResizeWeight(0.8);								//	设置splitPane1的分隔线位置，0.1是相对于splitPane1的大小而定。
		    JSP2.setResizeWeight(0.95);
		    JSP3.setResizeWeight(0.05);
		    frame.add(JSP3);
		    frame.setTitle("The ONE Simulator");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(WIN_DEFAULT_WIDTH, WIN_DEFAULT_HEIGHT);
		    frame.setVisible(true);		    
	  }
	  
	  
	  
}






