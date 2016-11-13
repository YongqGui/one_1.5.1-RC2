package gui_test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class testRouterInfo extends JFrame{
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 700;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 500;
	
	public testRouterInfo(){
		super("参数界面   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
		//---------------------------设置tab页面----------------------------//		
		final JTabbedPane tabs = new JTabbedPane();
		final JTextField txt = new JTextField(20);

		JPanel jp1 = new JPanel();		
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();		
		JPanel jp4 = new JPanel();
		tabs.add("路由模块",jp1);		
		tabs.add("运动模块",jp2);
		tabs.add("缓存模块",jp3);		
		tabs.add("链路模块",jp4);
		
	    tabs.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	          txt.setText("Tab selected: " +
	            tabs.getSelectedIndex());
	        }
	      });
	    add(BorderLayout.SOUTH, txt);
		add(tabs);
		
		jp1 = RouteInfoSetting();
		
		
		/*	关闭页面
	    WindowListener wndCloser = new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	        }
	      };
	    addWindowListener(wndCloser);*/
	    
		setVisible(true);
	}
	
	public JPanel RouteInfoSetting(){
		JPanel jp1 = new JPanel();
		//---------------------------设置路由参数页面----------------------------//	
		JPanel RouteFirst = new JPanel();
		RouteFirst.setBorder(new TitledBorder("一级配置界面"));
		RouteFirst.setLayout(new GridLayout(10,1,10,10));
		//第一行
	    JLabel label1=new JLabel("路由协议选择：",JLabel.RIGHT);
		JComboBox RouterC = new JComboBox();
		String[] description = {
				    "Dijkstra", "FirstContactRouter", "DirectDeliveryRouter", 
				    "EpidemicRouter","GridRouter",
		};
		
	    for(int i = 0; i < 4; i++)
	    	RouterC.addItem(description[i]);
	    
		JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(Box.createHorizontalStrut(30));
	    jsp1.add(RouterC);	    
	    jsp1.add(Box.createHorizontalGlue());
		jsp1.add(Box.createHorizontalStrut(50));
		RouteFirst.add(jsp1);

		
		//第二行
	    JLabel label2=new JLabel("Message大小：",JLabel.RIGHT);
		final JTextField txt1 = new JTextField(5);
		final JTextField txt2 = new JTextField(5);
		JLabel label21 = new JLabel("~",JLabel.CENTER);
		JLabel label22 = new JLabel("M",JLabel.CENTER);
		JPanel jsp2 = new JPanel();
	    jsp2.setLayout(new BoxLayout(jsp2, BoxLayout.X_AXIS));
		jsp2.add(label2);
	    jsp2.add(Box.createHorizontalStrut(30));
		jsp2.add(txt1);
		jsp2.add(Box.createHorizontalStrut(5));
		jsp2.add(label21);
		jsp2.add(Box.createHorizontalStrut(5));
		jsp2.add(txt2);
		jsp2.add(Box.createHorizontalStrut(10));
		jsp2.add(label22);
	    jsp2.add(Box.createHorizontalGlue());
		jsp2.add(Box.createHorizontalStrut(55));
		RouteFirst.add(jsp2);
		
		//第三行
	    JLabel label3=new JLabel("Message生存时间：",JLabel.RIGHT);
		final JTextField txt3 = new JTextField(5);
		final JTextField txt4 = new JTextField(5);
		JLabel label31 = new JLabel("~",JLabel.CENTER);
		JLabel label32 = new JLabel("Min",JLabel.CENTER);
		JPanel jsp3 = new JPanel();
	    jsp3.setLayout(new BoxLayout(jsp3, BoxLayout.X_AXIS));
		jsp3.add(label3);
	    jsp3.add(Box.createHorizontalStrut(4));
		jsp3.add(txt3);
		jsp3.add(Box.createHorizontalStrut(5));
		jsp3.add(label31);
		jsp3.add(Box.createHorizontalStrut(5));
		jsp3.add(txt4);
		jsp3.add(Box.createHorizontalStrut(10));
		jsp3.add(label32);
	    jsp3.add(Box.createHorizontalGlue());
		jsp3.add(Box.createHorizontalStrut(45));
		RouteFirst.add(jsp3);
		
		//---------------------------设置二级路由参数页面----------------------------//			
		JPanel RouteSecond = new JPanel();
		RouteSecond.setBorder(new TitledBorder("二级配置界面"));
		
		jp1.setLayout(new GridLayout(1,2));
		jp1.add(RouteFirst);
		jp1.add(RouteSecond);
		
		return jp1;
	}
	
	
	
}
