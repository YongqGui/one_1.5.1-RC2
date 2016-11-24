/*
 * The design of the interface  of simulator by	YongqGui
 */
package Develop;

//import jat.application.orbitviewer.orbitviewerEvents;

import gui.DTNSimGUI;
import gui.EventLogPanel;
import gui.InfoPanel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

import ui.DTNSimTextUI;

import java.awt.event.*;

//import javax.swing.plaf.nimbus.NimbusLookAndFeel;
//import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
//import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main_Window extends JFrame implements ActionListener, ChangeListener{
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 900;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 700;

	public JButton start;
	public JButton end;
	public JButton pause;
	public JButton report;
	private static JSplitPane JSP1;
	private static JSplitPane JSP2;
	private static JSplitPane JSP3;
	protected boolean simPaused = true;
	public ActionListener e;

	
	public Main_Window(EventLog elp) {
		super("卫星仿真系统");										//   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
	    JPanel desktop = new JPanel();
	    getContentPane().add(desktop);
	    
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
	    JPanel fileMenus = new JPanel();
	    fileMenus.setLayout(new GridLayout(2,1));
	    fileMenus.add(mb);
	    
	    //设置用来放置一排按钮,这里和第一排肯定要用两个面板
	    start = new JButton("开始");
		start.addActionListener(this);
	    pause = new JButton("暂停");
	    pause.addActionListener(this);
	    end = new JButton("结束");
	    end.addActionListener(this);
	    report = new JButton("报告");
	    report.addActionListener(this);
	    
	    JButton parameter = new JButton("参数");
        parameter.addActionListener(new ActionListener() {	//按钮出来之后要弹出参数配置界面
            public void actionPerformed(ActionEvent e) {
                new RouterInfo();
            }
        });
	    
	    JPanel ButtonMenus = new JPanel();
	    ButtonMenus.setLayout(new BoxLayout(ButtonMenus, BoxLayout.X_AXIS));
	    ButtonMenus.add(start);
	    ButtonMenus.add(pause);
	    ButtonMenus.add(end);
	    ButtonMenus.add(report);
	    ButtonMenus.add(parameter);
	    fileMenus.add(ButtonMenus);
	    
	  
	    //---------------------------设置节点列表----------------------------//	  	
	    JPanel NodeList = new JPanel();
	    NodeList.setLayout(new GridLayout(20,1));
	    NodeList.setBorder(new TitledBorder("Nodes"));
	    for (int i = 0; i<20; i++)
	    	NodeList.add(new JButton("Node" + i));
	  
	  
	    JLabel label1=new JLabel("Label 1",JLabel.CENTER);  
 
	    //---------------------------设置事件窗口----------------------------//
	    JPanel Event = new JPanel();
        Event.setLayout(new BoxLayout(Event,BoxLayout.Y_AXIS));	//	沿着Y轴进行布局
	    
//      JScrollPane EventLog = new JScrollPane();
//	    EventLog.setBorder(new TitledBorder("输出事件窗口"));
//	    EventLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
//      DTNSimTextUI gui = new DTNSimTextUI();
//		EventLog elp = new EventLog(null); 		// 原有系统事件窗口
		
	    JSP1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,label1,new JScrollPane(elp));
	    JSP1.setResizeWeight(0.8);							//设置splitPane1的分隔线位置，0.1是相对于splitPane1的大小而定。
	    
        
	    JSP2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,JSP1,NodeList);
	  	JSP2.setResizeWeight(0.99);
	  	JSP3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,fileMenus,JSP2);	
	  	JSP3.setResizeWeight(0.01);

	  	add(JSP3);
//		UIManager.setLookAndFeel(javax.swing.plaf.metal.MetalLookAndFeel);							//	设置皮肤
//	  	SwingUtilities.updateComponentTreeUI(com.sun.java.swing.plaf.windows.WindowsLookAndFeel);
	}
	  
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.start) {
			this.simPaused = false;
		}
		else if (e.getSource() == this.end){
			System.exit(0);
		}
		else if (e.getSource() == this.pause){
			this.simPaused = true;
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getPaused(){
		return this.simPaused;
	}
}






