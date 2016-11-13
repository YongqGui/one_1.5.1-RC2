/*
 * The design of the interface  of simulator	YongqGui
 */
package gui_test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.awt.event.*;


public class Main_Window extends JFrame {
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 900;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 700;


	private static JSplitPane JSP1;
	private static JSplitPane JSP2;
	private static JSplitPane JSP3;

 
	public Main_Window() {
		super("���Ƿ���ϵͳ   copyright by USTC");
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
	    
	    //������������һ�Ű�ť,����͵�һ�ſ϶�Ҫ���������
	    JButton start = new JButton("��ʼ");
	    JButton end = new JButton("����");
	    JButton parameter = new JButton("����");
        parameter.addActionListener(new ActionListener() {	//��ť����֮��Ҫ�����������ý���
            public void actionPerformed(ActionEvent e) {
                new RouterInfo();
            }
        });
	    
	    JPanel ButtonMenus = new JPanel();
	    ButtonMenus.setLayout(new BoxLayout(ButtonMenus, BoxLayout.X_AXIS));
	    ButtonMenus.add(start);
	    ButtonMenus.add(end);
	    ButtonMenus.add(parameter);
	    fileMenus.add(ButtonMenus);
	    
	  
	    //---------------------------���ýڵ��б�----------------------------//	  	
	    JPanel NodeList = new JPanel();
	    NodeList.setLayout(new GridLayout(20,1));
	    NodeList.setBorder(new TitledBorder("Nodes"));
	    for (int i = 0; i<20; i++)
	    	NodeList.add(new JButton("Node" + i));
	  
	  
	    JLabel label1=new JLabel("Label 1",JLabel.CENTER);  
 
	    //---------------------------�����¼�����----------------------------//	 
	    JScrollPane EventLog = new JScrollPane();
	    EventLog.setBorder(new TitledBorder("����¼�����"));
	    EventLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	    
	    JSP1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,label1,EventLog);
	    JSP1.setResizeWeight(0.8);												//����splitPane1�ķָ���λ�ã�0.1�������splitPane1�Ĵ�С������
	    JSP2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,JSP1,NodeList);
	  	JSP2.setResizeWeight(0.99);
	  	JSP3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,fileMenus,JSP2);	
	  	JSP3.setResizeWeight(0.01);

	  }

	  public static void main(String[] args) throws Exception {
		    JFrame frame = new Main_Window();
		    frame.add(JSP3);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);		    
	  }
	  
}






