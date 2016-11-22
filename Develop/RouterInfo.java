/*
 * The design of the interface  of simulator by	YongqGui
 */
package Develop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import core.Settings;


public class RouterInfo extends JFrame implements ActionListener, ChangeListener{
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 700;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 500;
	public JButton Confirm;
	public JButton Reset;
	public JButton Concel;
	public JComboBox RouterC;
	
	private static final String CONFIGURATION_FILE_LOCATION = 
			"C:\\Users\\YongqGui\\Workspaces\\MyEclipse 2015 CI\\one_1.5.1-RC2\\default_settings.txt";		//	设置文件路径
	
	public RouterInfo(){
		super("参数配置");										//   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
		//---------------------------设置tab页面----------------------------//		
		final JTabbedPane tabs = new JTabbedPane();
		this.setLayout(null);
		JPanel jp1 = RouteInfoSetting();	
		JPanel jp2 = CacheSetting();
		JPanel jp3 = MovementSetting();		
		JPanel jp4 = LinkSetting();

		tabs.add("路由模块",jp1);		
		tabs.add("缓存模块",jp2);
		tabs.add("运动模块",jp3);		
		tabs.add("链路模块",jp4);
		
		//---------------------------设置几个按钮----------------------------//	
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    Reset = new JButton("默认");									// 为按钮加入监听器
	    Reset.addActionListener(this);
	    Concel = new JButton("取消");
	    Concel.addActionListener(this);
	    Confirm = new JButton("确认");
	    Confirm.addActionListener(this);
	    
		ButtonMenu.add(Box.createHorizontalStrut(250));
		ButtonMenu.add(Reset);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Concel);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Confirm);
		
		tabs.setBounds(0, 0, 666, 380);
		ButtonMenu.setBounds(150, 405, 500, 30);
		add(tabs);
		add(ButtonMenu);
		this.setLocationRelativeTo(null);
		this.setResizable(false);							//	设置界面不可最大化
		setVisible(true);
	}
	
	public JPanel RouteInfoSetting(){
		JPanel jp1 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------设置路由参数页面----------------------------//	
		JPanel RouteFirst = new JPanel();
		RouteFirst.setBorder(new TitledBorder("一级配置界面"));
		//RouteFirst.setLayout(new GridLayout(8,1,10,10));
		RouteFirst.setLayout(null);
		//第一行
	    JLabel label1=new JLabel("路由协议选择：",JLabel.RIGHT);
		RouterC = new JComboBox();
		String[] description = {
				    "Dijkstra", "FirstContactRouter", "DirectDeliveryRouter", 
				    "EpidemicRouter","GridRouter",
		};
		
	    for(int i = 0; i < 5; i++)
	    	RouterC.addItem(description[i]);
//	    RouterC.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	          System.out.println("index: "+ RouterC.getSelectedIndex() + "   " +
//	           ((JComboBox)e.getSource()).getSelectedItem());
//	        }
//	      });
	    
		JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(Box.createHorizontalStrut(30));
	    jsp1.add(RouterC);	    
	    jsp1.add(Box.createHorizontalGlue());
		jsp1.add(Box.createHorizontalStrut(50));

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
		
		
		jsp1.setBounds(10, 20, 300, 30);
		jsp2.setBounds(10, 65, 300, 30);
		jsp3.setBounds(10, 105, 300, 30);
		RouteFirst.add(jsp1);
		RouteFirst.add(jsp2);
		RouteFirst.add(jsp3);
		RouteFirst.setSize(320, 200);
		//---------------------------设置二级路由参数页面----------------------------//			
		JPanel RouteSecond = new JPanel();
		RouteSecond.setBorder(new TitledBorder("二级配置界面"));
		RouteSecond.setSize(320, 200);
		
		
		jp1.setLayout(null);
		RouteFirst.setBounds(10, 0, 320, 350);
		RouteSecond.setBounds(330, 0, 320, 350);
		jp1.add(RouteFirst);
		jp1.add(RouteSecond);
		
		return jp1;
	}
	
	public JPanel CacheSetting(){
		JPanel jp2 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------设置缓存参数页面----------------------------//	
		JPanel CacheFirst = new JPanel();
		CacheFirst.setBorder(new TitledBorder("一级配置界面"));
		//CacheFirst.setLayout(new GridLayout(10,1,10,10));
		CacheFirst.setLayout(null);
		//	第一行
	    JLabel label1=new JLabel("逐跳确认",JLabel.LEFT);

	    
	    ButtonGroup g = new ButtonGroup();
	    JRadioButton	    rb1 = new JRadioButton("", false),
	    					rb2 = new JRadioButton("", false);
	    g.add(rb1);
	    g.add(rb2);
		
	    JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(rb1);

	    
	    //  第二行
	    JLabel label2=new JLabel("快速转发",JLabel.LEFT);
	    JPanel jsp2 = new JPanel();
	    jsp2.setLayout(new BoxLayout(jsp2,BoxLayout.X_AXIS));
	    jsp2.add(label2);
	    jsp2.add(rb2);

	    
	    // 第三行
	    JLabel label3=new JLabel("节点缓存大小：",JLabel.LEFT);
		JTextField txt3 = new JTextField(5);
		JLabel label31 = new JLabel("M",JLabel.CENTER);
		JPanel jsp3 = new JPanel();
	    jsp3.setLayout(new BoxLayout(jsp3, BoxLayout.X_AXIS));
	    jsp3.add(label3);
	    jsp3.add(Box.createHorizontalStrut(30));
	    jsp3.add(txt3);
		jsp3.add(Box.createHorizontalStrut(10));
	    jsp3.add(label31);
	    jsp3.add(Box.createHorizontalGlue());
		jsp3.add(Box.createHorizontalStrut(54));

	    
	    // 第四行
	    JLabel label4 = new JLabel("文件请求间隔：",JLabel.LEFT);
		JTextField txt4 = new JTextField(5);
		JLabel label41 = new JLabel("Min",JLabel.CENTER);
		JPanel jsp4 = new JPanel();
	    jsp4.setLayout(new BoxLayout(jsp4, BoxLayout.X_AXIS));
	    jsp4.add(label4);
	    jsp4.add(Box.createHorizontalStrut(30));
	    jsp4.add(txt4);
		jsp4.add(Box.createHorizontalStrut(10));
	    jsp4.add(label41);
	    jsp4.add(Box.createHorizontalGlue());
		jsp4.add(Box.createHorizontalStrut(44));

	    
	    // 第五行
	    JLabel label5=new JLabel("文件请求大小：",JLabel.RIGHT);
		final JTextField txt5 = new JTextField(5);
		final JTextField txt51 = new JTextField(5);
		JLabel label51 = new JLabel("~",JLabel.CENTER);
		JLabel label52 = new JLabel("M",JLabel.CENTER);
		JPanel jsp5 = new JPanel();
	    jsp5.setLayout(new BoxLayout(jsp5, BoxLayout.X_AXIS));
		jsp5.add(label5);
	    jsp5.add(Box.createHorizontalStrut(30));
		jsp5.add(txt5);
		jsp5.add(Box.createHorizontalStrut(5));
		jsp5.add(label51);
		jsp5.add(Box.createHorizontalStrut(5));
		jsp5.add(txt51);
		jsp5.add(Box.createHorizontalStrut(10));
		jsp5.add(label52);
	    jsp5.add(Box.createHorizontalGlue());
		jsp5.add(Box.createHorizontalStrut(55));

		
	    // 第六行
	    JLabel label6 = new JLabel("分片数目：",JLabel.LEFT);
		JTextField txt6 = new JTextField(5);
		JLabel label61 = new JLabel("个",JLabel.CENTER);
		JPanel jsp6 = new JPanel();
	    jsp6.setLayout(new BoxLayout(jsp6, BoxLayout.X_AXIS));
	    jsp6.add(label6);
	    jsp6.add(Box.createHorizontalStrut(56));
	    jsp6.add(txt6);
		jsp6.add(Box.createHorizontalStrut(10));
	    jsp6.add(label61);
	    jsp6.add(Box.createHorizontalGlue());
		jsp6.add(Box.createHorizontalStrut(50));
		
		jsp1.setBounds(10, 20, 300, 30);
		jsp2.setBounds(10, 65, 300, 30);
		jsp3.setBounds(10, 105, 300, 30);
		jsp4.setBounds(10, 145, 300, 30);
		jsp5.setBounds(10, 185, 300, 30);
		jsp6.setBounds(10, 225, 300, 30);
	    CacheFirst.add(jsp1);
	    CacheFirst.add(jsp2);
	    CacheFirst.add(jsp3);
	    CacheFirst.add(jsp4);
		CacheFirst.add(jsp5);
	    CacheFirst.add(jsp6);
	    
		//---------------------------设置二级缓存参数页面----------------------------//			
		JPanel CacheSecond = new JPanel();
		CacheSecond.setBorder(new TitledBorder("二级配置界面"));
		
		jp2.setLayout(null);
		CacheFirst.setBounds(10, 0, 320, 350);
		CacheSecond.setBounds(330, 0, 320, 350);
		jp2.add(CacheFirst);
		jp2.add(CacheSecond);
		
		return jp2;
	}
	
	public JPanel MovementSetting(){
		JPanel jp3 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------设置缓存参数页面----------------------------//	
		JPanel MovementFirst = new JPanel();
		MovementFirst.setBorder(new TitledBorder("一级配置界面"));
		//MovementFirst.setLayout(new GridLayout(8,1,10,10));
		MovementFirst.setLayout(null);
		
		//第一行
	    JLabel label1=new JLabel("星座配置：",JLabel.RIGHT);
		JComboBox WalkerC = new JComboBox();
		String[] description = {
				    "Walker1", "Walker2","Walker3","Walker4",
		};
		
	    for(int i = 0; i < 4; i++)
	    	WalkerC.addItem(description[i]);
	    
		JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(Box.createHorizontalStrut(30));
	    jsp1.add(WalkerC);	    
	    jsp1.add(Box.createHorizontalGlue());
		jsp1.add(Box.createHorizontalStrut(40));

		
		//  第二行
	    JLabel label2=new JLabel("轨道模型：",JLabel.RIGHT);
		JComboBox OrbitC = new JComboBox();
		String[] description1 = {
				    "TwoBody1", "TwoBody2","TwoBody3","TwoBody4",
		};
		
	    for(int i = 0; i < 4; i++)
	    	OrbitC.addItem(description1[i]);
	    
		JPanel jsp2 = new JPanel();
	    jsp2.setLayout(new BoxLayout(jsp2, BoxLayout.X_AXIS));
	    jsp2.add(label2);
	    jsp2.add(Box.createHorizontalStrut(30));
	    jsp2.add(OrbitC);	    
	    jsp2.add(Box.createHorizontalGlue());
		jsp2.add(Box.createHorizontalStrut(50));

		
		//  第三行
	    JLabel label3 = new JLabel("节点数目：",JLabel.LEFT);
		JTextField txt3 = new JTextField(5);
		JLabel label31 = new JLabel("个",JLabel.CENTER);
		JPanel jsp3 = new JPanel();
	    jsp3.setLayout(new BoxLayout(jsp3, BoxLayout.X_AXIS));
	    jsp3.add(label3);
	    jsp3.add(Box.createHorizontalStrut(30));
	    jsp3.add(txt3);
		jsp3.add(Box.createHorizontalStrut(10));
	    jsp3.add(label31);
	    jsp3.add(Box.createHorizontalGlue());
		jsp3.add(Box.createHorizontalStrut(60));

	    
	    //  第四行
	    JLabel label4 = new JLabel("轨道平面数目：",JLabel.LEFT);
		JTextField txt4 = new JTextField(5);
		JLabel label41 = new JLabel("个",JLabel.CENTER);
		JPanel jsp4 = new JPanel();
	    jsp4.setLayout(new BoxLayout(jsp4, BoxLayout.X_AXIS));
	    jsp4.add(label4);
	    jsp4.add(Box.createHorizontalStrut(4));
	    jsp4.add(txt4);
		jsp4.add(Box.createHorizontalStrut(10));
	    jsp4.add(label41);
	    jsp4.add(Box.createHorizontalGlue());
		jsp4.add(Box.createHorizontalStrut(60));

	    
	    //  第五行
	    JLabel label5 = new JLabel("轨道半径：",JLabel.LEFT);
		JTextField txt5 = new JTextField(5);
		JLabel label51 = new JLabel("Km",JLabel.CENTER);
		JPanel jsp5 = new JPanel();
	    jsp5.setLayout(new BoxLayout(jsp5, BoxLayout.X_AXIS));
	    jsp5.add(label5);
	    jsp5.add(Box.createHorizontalStrut(30));
	    jsp5.add(txt5);
		jsp5.add(Box.createHorizontalStrut(10));
	    jsp5.add(label51);
	    jsp5.add(Box.createHorizontalGlue());
		jsp5.add(Box.createHorizontalStrut(54));

		
		//  第六行
	    JLabel label6 = new JLabel("离心率：",JLabel.LEFT);
		JTextField txt6 = new JTextField(5);
		//JLabel label61 = new JLabel("个",JLabel.CENTER);
		JPanel jsp6 = new JPanel();
	    jsp6.setLayout(new BoxLayout(jsp6, BoxLayout.X_AXIS));
	    jsp6.add(label6);
	    jsp6.add(Box.createHorizontalStrut(43));
	    jsp6.add(txt6);
		jsp6.add(Box.createHorizontalStrut(10));
	    //jsp6.add(label61);
	    jsp6.add(Box.createHorizontalGlue());
		jsp6.add(Box.createHorizontalStrut(73));
		
		jsp1.setBounds(10, 20, 300, 30);
		jsp2.setBounds(10, 65, 300, 30);
		jsp3.setBounds(10, 105, 300, 30);
		jsp4.setBounds(10, 145, 300, 30);
		jsp5.setBounds(10, 185, 300, 30);
		jsp6.setBounds(10, 225, 300, 30);
		MovementFirst.add(jsp1);
		MovementFirst.add(jsp2);
	    MovementFirst.add(jsp3);
	    MovementFirst.add(jsp4);
	    MovementFirst.add(jsp5);
	    MovementFirst.add(jsp6);
		
		//---------------------------设置二级缓存参数页面----------------------------//			
		JPanel MovementSecond = new JPanel();
		MovementSecond.setBorder(new TitledBorder("二级配置界面"));
		
		//jp3.setLayout(new GridLayout(1,2));
		jp3.setLayout(null);
		MovementFirst.setBounds(10, 0, 320, 350);
		MovementSecond.setBounds(330, 0, 320, 350);
		jp3.add(MovementFirst);
		jp3.add(MovementSecond);
		
		return jp3;
	}
	
	public JPanel LinkSetting(){
		JPanel jp4 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------设置缓存参数页面----------------------------//	
		JPanel LinkFirst = new JPanel();
		LinkFirst.setBorder(new TitledBorder("一级配置界面"));
		//LinkFirst.setLayout(new GridLayout(8,1,10,10));
		LinkFirst.setLayout(null);
		
		
		//第一行
	    JLabel label1=new JLabel("链路模型：",JLabel.RIGHT);
		JComboBox LinkC = new JComboBox();
		String[] description = {
				    "激光头", "微波链路",
		};
		
	    for(int i = 0; i < 2; i++)
	    	LinkC.addItem(description[i]);
	    
		JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(Box.createHorizontalStrut(30));
	    jsp1.add(LinkC);	    
	    jsp1.add(Box.createHorizontalGlue());
		jsp1.add(Box.createHorizontalStrut(50));
		
		jsp1.setBounds(10, 20, 300, 30);
		LinkFirst.add(jsp1);
		
		
		//---------------------------设置二级缓存参数页面----------------------------//			
		JPanel LinkSecond = new JPanel();
		LinkSecond.setBorder(new TitledBorder("二级配置界面"));
		
		jp4.setLayout(null);
		LinkFirst.setBounds(10, 0, 320, 350);
		LinkSecond.setBounds(330, 0, 320, 350);
		jp4.add(LinkFirst);
		jp4.add(LinkSecond);
		
		return jp4;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.Confirm) {
			this.RouteParaSet();
			this.CacheParaSet();
			this.MoveParaSet();
			this.LinkParaSet();
			this.setVisible(false);
		}
		if (e.getSource() == this.Concel) {

		}
		if (e.getSource() == this.Reset) {
			
		}
	}
	public void RouteParaSet(){
		Settings settings = new Settings();
		settings.setSetting(CONFIGURATION_FILE_LOCATION,"Group.router",String.valueOf(RouterC.getSelectedItem()));
		
	}
	public void CacheParaSet(){
		
	}
	public void MoveParaSet(){
		
	}
	public void LinkParaSet(){
		
	}
}
