package gui_test;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RouterInfo extends JFrame{
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 700;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 500;
	
	public RouterInfo(){
		super("��������   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
		//---------------------------����tabҳ��----------------------------//		
		final JTabbedPane tabs = new JTabbedPane();
		//final JTextField txt = new JTextField(20);

		JPanel jp1 = RouteInfoSetting();	
		JPanel jp2 = CacheSetting();
		JPanel jp3 = MovementSetting();		
		JPanel jp4 = LinkSetting();

		tabs.add("·��ģ��",jp1);		
		tabs.add("����ģ��",jp2);
		tabs.add("�˶�ģ��",jp3);		
		tabs.add("��·ģ��",jp4);
		add(tabs);
		
		setVisible(true);
	}
	
	public JPanel RouteInfoSetting(){
		JPanel jp1 = new JPanel();
		JPanel jp = new JPanel();
		//---------------------------����·�ɲ���ҳ��----------------------------//	
		JPanel RouteFirst = new JPanel();
		RouteFirst.setBorder(new TitledBorder("һ�����ý���"));
		RouteFirst.setLayout(new GridLayout(8,1,10,10));
		//��һ��
	    JLabel label1=new JLabel("·��Э��ѡ��",JLabel.RIGHT);
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

		
		//�ڶ���
	    JLabel label2=new JLabel("Message��С��",JLabel.RIGHT);
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
		
		//������
	    JLabel label3=new JLabel("Message����ʱ�䣺",JLabel.RIGHT);
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
		
		//---------------------------���ö���·�ɲ���ҳ��----------------------------//			
		JPanel RouteSecond = new JPanel();
		RouteSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp1.setLayout(new GridLayout(1,2));
		jp1.add(RouteFirst);
		jp1.add(RouteSecond);
		
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    JButton Reset = new JButton("Ĭ��");
	    JButton Concel = new JButton("ȡ��");
	    JButton Verify = new JButton("ȷ��");
		ButtonMenu.add(Box.createHorizontalStrut(250));
		ButtonMenu.add(Reset);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Concel);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Verify);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp1);
		jp.add(Box.createVerticalStrut(20));
		jp.add(ButtonMenu);
		return jp;
	}
	
	public JPanel CacheSetting(){
		JPanel jp2 = new JPanel();
		JPanel jp = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel CacheFirst = new JPanel();
		CacheFirst.setBorder(new TitledBorder("һ�����ý���"));
		CacheFirst.setLayout(new GridLayout(10,1,10,10));
		
		//	��һ��
	    JLabel label1=new JLabel("����ȷ��",JLabel.LEFT);

	    
	    ButtonGroup g = new ButtonGroup();
	    JRadioButton	    rb1 = new JRadioButton("", false),
	    					rb2 = new JRadioButton("", false);
	    g.add(rb1);
	    g.add(rb2);
		
	    JPanel jsp1 = new JPanel();
	    jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.X_AXIS));
	    jsp1.add(label1);
	    jsp1.add(rb1);
	    CacheFirst.add(jsp1);
	    
	    //  �ڶ���
	    JLabel label2=new JLabel("����ת��",JLabel.LEFT);
	    JPanel jsp2 = new JPanel();
	    jsp2.setLayout(new BoxLayout(jsp2,BoxLayout.X_AXIS));
	    jsp2.add(label2);
	    jsp2.add(rb2);
	    CacheFirst.add(jsp2);
	    
	    // ������
	    JLabel label3=new JLabel("�ڵ㻺���С��",JLabel.LEFT);
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
	    CacheFirst.add(jsp3);
	    
	    // ������
	    JLabel label4 = new JLabel("�ļ���������",JLabel.LEFT);
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
	    CacheFirst.add(jsp4);
	    
	    // ������
	    JLabel label5=new JLabel("�ļ������С��",JLabel.RIGHT);
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
		CacheFirst.add(jsp5);
		
	    // ������
	    JLabel label6 = new JLabel("��Ƭ��Ŀ��",JLabel.LEFT);
		JTextField txt6 = new JTextField(5);
		JLabel label61 = new JLabel("��",JLabel.CENTER);
		JPanel jsp6 = new JPanel();
	    jsp6.setLayout(new BoxLayout(jsp6, BoxLayout.X_AXIS));
	    jsp6.add(label6);
	    jsp6.add(Box.createHorizontalStrut(56));
	    jsp6.add(txt6);
		jsp6.add(Box.createHorizontalStrut(10));
	    jsp6.add(label61);
	    jsp6.add(Box.createHorizontalGlue());
		jsp6.add(Box.createHorizontalStrut(50));
	    CacheFirst.add(jsp6);
	    
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel CacheSecond = new JPanel();
		CacheSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp2.setLayout(new GridLayout(1,2));
		jp2.add(CacheFirst);
		jp2.add(CacheSecond);
		
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    JButton Reset = new JButton("Ĭ��");
	    JButton Concel = new JButton("ȡ��");
	    JButton Verify = new JButton("ȷ��");
		ButtonMenu.add(Box.createHorizontalStrut(250));
		ButtonMenu.add(Reset);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Concel);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Verify);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp2);
		jp.add(Box.createVerticalStrut(20));
		jp.add(ButtonMenu);
		
		return jp;
	}
	
	public JPanel MovementSetting(){
		JPanel jp3 = new JPanel();
		JPanel jp = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel MovementFirst = new JPanel();
		MovementFirst.setBorder(new TitledBorder("һ�����ý���"));
		MovementFirst.setLayout(new GridLayout(8,1,10,10));
		
		//��һ��
	    JLabel label1=new JLabel("�������ã�",JLabel.RIGHT);
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
		MovementFirst.add(jsp1);
		
		//  �ڶ���
	    JLabel label2=new JLabel("���ģ�ͣ�",JLabel.RIGHT);
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
		MovementFirst.add(jsp2);
		
		//  ������
	    JLabel label3 = new JLabel("�ڵ���Ŀ��",JLabel.LEFT);
		JTextField txt3 = new JTextField(5);
		JLabel label31 = new JLabel("��",JLabel.CENTER);
		JPanel jsp3 = new JPanel();
	    jsp3.setLayout(new BoxLayout(jsp3, BoxLayout.X_AXIS));
	    jsp3.add(label3);
	    jsp3.add(Box.createHorizontalStrut(30));
	    jsp3.add(txt3);
		jsp3.add(Box.createHorizontalStrut(10));
	    jsp3.add(label31);
	    jsp3.add(Box.createHorizontalGlue());
		jsp3.add(Box.createHorizontalStrut(60));
	    MovementFirst.add(jsp3);
	    
	    //  ������
	    JLabel label4 = new JLabel("���ƽ����Ŀ��",JLabel.LEFT);
		JTextField txt4 = new JTextField(5);
		JLabel label41 = new JLabel("��",JLabel.CENTER);
		JPanel jsp4 = new JPanel();
	    jsp4.setLayout(new BoxLayout(jsp4, BoxLayout.X_AXIS));
	    jsp4.add(label4);
	    jsp4.add(Box.createHorizontalStrut(4));
	    jsp4.add(txt4);
		jsp4.add(Box.createHorizontalStrut(10));
	    jsp4.add(label41);
	    jsp4.add(Box.createHorizontalGlue());
		jsp4.add(Box.createHorizontalStrut(60));
	    MovementFirst.add(jsp4);
	    
	    //  ������
	    JLabel label5 = new JLabel("����뾶��",JLabel.LEFT);
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
	    MovementFirst.add(jsp5);
		
		//  ������
	    JLabel label6 = new JLabel("�����ʣ�",JLabel.LEFT);
		JTextField txt6 = new JTextField(5);
		//JLabel label61 = new JLabel("��",JLabel.CENTER);
		JPanel jsp6 = new JPanel();
	    jsp6.setLayout(new BoxLayout(jsp6, BoxLayout.X_AXIS));
	    jsp6.add(label6);
	    jsp6.add(Box.createHorizontalStrut(43));
	    jsp6.add(txt6);
		jsp6.add(Box.createHorizontalStrut(10));
	    //jsp6.add(label61);
	    jsp6.add(Box.createHorizontalGlue());
		jsp6.add(Box.createHorizontalStrut(73));
	    MovementFirst.add(jsp6);
		
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel MovementSecond = new JPanel();
		MovementSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp3.setLayout(new GridLayout(1,2));
		jp3.add(MovementFirst);
		jp3.add(MovementSecond);
		
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    JButton Reset = new JButton("Ĭ��");
	    JButton Concel = new JButton("ȡ��");
	    JButton Verify = new JButton("ȷ��");
		ButtonMenu.add(Box.createHorizontalStrut(250));
		ButtonMenu.add(Reset);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Concel);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Verify);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp3);
		jp.add(Box.createVerticalStrut(20));
		jp.add(ButtonMenu);
		return jp;
	}
	
	public JPanel LinkSetting(){
		JPanel jp4 = new JPanel();
		JPanel jp = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel LinkFirst = new JPanel();
		LinkFirst.setBorder(new TitledBorder("һ�����ý���"));
		LinkFirst.setLayout(new GridLayout(8,1,10,10));
		
		//��һ��
	    JLabel label1=new JLabel("��·ģ�ͣ�",JLabel.RIGHT);
		JComboBox LinkC = new JComboBox();
		String[] description = {
				    "����ͷ", "΢����·",
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
		LinkFirst.add(jsp1);
		
		
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel LinkSecond = new JPanel();
		LinkSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp4.setLayout(new GridLayout(1,2));
		jp4.add(LinkFirst);
		jp4.add(LinkSecond);
		
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    JButton Reset = new JButton("Ĭ��");
	    JButton Concel = new JButton("ȡ��");
	    JButton Verify = new JButton("ȷ��");
		ButtonMenu.add(Box.createHorizontalStrut(250));
		ButtonMenu.add(Reset);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Concel);
		ButtonMenu.add(Box.createHorizontalStrut(30));
		ButtonMenu.add(Verify);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.add(jp4);
		jp.add(Box.createVerticalStrut(20));
		jp.add(ButtonMenu);
		return jp;
	}
	
}