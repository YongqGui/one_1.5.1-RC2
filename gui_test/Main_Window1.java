/*
 * The design of the interface  of simulator	YongqGui
 */
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
	//private static final Component JSP3 = null;
	
	private JScrollPane playFieldScroll;
	private static JSplitPane JSP1;
	private static JSplitPane JSP2;
	private static JSplitPane JSP3;
	//---------------------------设置tab页面----------------------------//
	  private String[] flavors = { "路由模块", "运动模块", "缓存模块","链路模块" };
	  private static JTabbedPane tabs = new JTabbedPane();
	  //private JTextField txt = new JTextField(20);
	//---------------------------设置菜单页面----------------------------//	  
	public Main_Window1() {
	  final JMenu[] menus = {
				new JMenu("File   "), new JMenu("Edit   "),
				new JMenu("Properties   "),new JMenu("Tools   "),
				new JMenu("Windows   "),new JMenu("Help   "),
	  };
	  final JMenuItem[] items = {
			  	new JMenuItem("Fee"), new JMenuItem("Fi"),
				new JMenuItem("Fo"),  new JMenuItem("Zip"),
				new JMenuItem("Zap"), new JMenuItem("Zot"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Free"), new JMenuItem("Zot"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Free"),
	  };
	  for (int i=0;i<items.length; i++){
			menus[i%6].add(items[i]);
	  };
	  JMenuBar mb = new JMenuBar();
	  for (JMenu jm:menus){
		  mb.add(jm);
	  };
	  
	  /*
	  JMenu help = new JMenu("Help");
	  mb.add(Box.createHorizontalGlue());		//	限定菜单栏在水平线最右边
	  mb.add(help);
	  */
	  
	//---------------------------设置节点列表----------------------------//	  	
	  JPanel jpane1 = new JPanel();
	  jpane1.setLayout(new GridLayout(20,1));
	  for (int i = 0; i<20; i++)
		  jpane1.add(new JButton("Node" + i));
	  
	  
	  JLabel label1=new JLabel("Label 1",JLabel.CENTER); 
	  JLabel label2=new JLabel("事件输出窗口",JLabel.CENTER);    
	  JLabel label3=new JLabel("Label 3",JLabel.CENTER);      
	  //---------------------------设置事件窗口----------------------------//	 
	  //先暂时实现一个滚动面板即可。
	  JScrollPane jpane2 = new JScrollPane(label2);
	  jpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  //---------------------------设置事件窗口----------------------------//
	  //设置用来放置一排按钮
	  JPanel jpane3 = new JPanel(new GridLayout(2,1));
	  JButton b = new JButton("开始");
	  //b.setLocation(20, 20);
	  //b.setBounds(WIN_DEFAULT_HEIGHT, WIN_DEFAULT_HEIGHT, WIN_DEFAULT_WIDTH, WIN_DEFAULT_HEIGHT);
	  jpane3.add(mb);
	  jpane3.add(b);
	  
	  
      JSP1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,label1,jpane2);
	  JSP1.setResizeWeight(0.8);												//设置splitPane1的分隔线位置，0.1是相对于splitPane1的大小而定。
      JSP2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,JSP1,jpane1);
	  JSP2.setResizeWeight(0.99);
      JSP3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,jpane3,JSP2);	
	  JSP3.setResizeWeight(0.01);
	  }

	  public static void main(String[] args) throws Exception {
		    JFrame frame = new Main_Window1();
		    frame.add(JSP3);
		    frame.setTitle("卫星仿真界面   copyright by USTC");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(WIN_DEFAULT_WIDTH, WIN_DEFAULT_HEIGHT);
		    frame.setVisible(true);		    
	  }
	  
	  
	  
}






