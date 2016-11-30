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
	public JTextField simTime;
	public JTextField interval;
	public JTextField warmUp;
	private static final String CONFIGURATION_FILE_LOCATION = 
			"C:\\Users\\YongqGui\\Workspaces\\MyEclipse 2015 CI\\one_1.5.1-RC2\\default_settings.txt";		//	�����ļ�·��
	
	public RouterInfo(){
		super("��������");										//   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
		//---------------------------����tabҳ��----------------------------//		
		final JTabbedPane tabs = new JTabbedPane();
		this.setLayout(null);
		JPanel jp1 = RouteInfoSetting();	
		JPanel jp2 = CacheSetting();
		JPanel jp3 = MovementSetting();		
		JPanel jp4 = LinkSetting();
		JPanel jp5 = MainSetting();

		tabs.add("·��ģ��",jp1);		
		tabs.add("����ģ��",jp2);
		tabs.add("�˶�ģ��",jp3);		
		tabs.add("��·ģ��",jp4);
		tabs.add("�������",jp5);
		
		//---------------------------���ü�����ť----------------------------//	
		JPanel ButtonMenu = new JPanel();
		ButtonMenu.setLayout(new BoxLayout(ButtonMenu, BoxLayout.X_AXIS));
	    Reset = new JButton("Ĭ��");									// Ϊ��ť���������
	    Reset.addActionListener(this);
	    Concel = new JButton("ȡ��");
	    Concel.addActionListener(this);
	    Confirm = new JButton("ȷ��");
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
		this.setResizable(false);							//	���ý��治�����
		setVisible(true);
	}
	
	public JPanel RouteInfoSetting(){
		JPanel jp1 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------����·�ɲ���ҳ��----------------------------//	
		JPanel RouteFirst = new JPanel();
		RouteFirst.setBorder(new TitledBorder("һ�����ý���"));
		//RouteFirst.setLayout(new GridLayout(8,1,10,10));
		RouteFirst.setLayout(null);
		//��һ��
	    JLabel label1=new JLabel("·��Э��ѡ��",JLabel.LEFT);
		RouterC = new JComboBox();
		String[] description = {
				    "FirstContactRouter", "DirectDeliveryRouter", 
				    "EpidemicRouter","EASR",
				    "netgrid routing","Cluster routing"
		};
		
	    for(int i = 0; i < 6; i++)
	    	RouterC.addItem(description[i]);
		
		label1.setBounds(10, 25, 100, 30);
		RouterC.setBounds(130, 25, 160, 30);
		RouteFirst.add(label1);
		RouteFirst.add(RouterC);

		//		�ڶ��У�·��ģʽѡ��ָ��·����������·�ɣ�
		JLabel rlabel1 = new JLabel("·��ģʽѡ��",JLabel.LEFT);
		JLabel rlabel2 = new JLabel("����ȷ��",JLabel.LEFT);
		JLabel rlabel3 = new JLabel("ָ��·��",JLabel.LEFT);
		ButtonGroup g = new ButtonGroup();
	    JRadioButton	    rb1 = new JRadioButton("", false),
	    					rb2 = new JRadioButton("", false);
	    rb1.setSelected(true);
	    g.add(rb1);
	    g.add(rb2);
	    
		rlabel1.setBounds(10, 65, 100, 30);
		rlabel2.setBounds(130,65, 55, 30);
		rb1.setBounds(189,65, 20, 30);
		rlabel3.setBounds(215,65, 55, 30);
		rb2.setBounds(272,65,20, 30);
		RouteFirst.add(rlabel1);
		RouteFirst.add(rlabel2);
		RouteFirst.add(rlabel3);
		RouteFirst.add(rb1);
		RouteFirst.add(rb2);
		//������ 		
		JLabel qlabel1 = new JLabel("���Ͷ���ģʽ��",JLabel.LEFT);
		JLabel qlabel2 = new JLabel("Random",JLabel.LEFT);
		JLabel qlabel3 = new JLabel("FIFO",JLabel.LEFT);
		ButtonGroup q = new ButtonGroup();
	    JRadioButton	    qb1 = new JRadioButton("", false),
	    					qb2 = new JRadioButton("", false);
	    qb1.setSelected(true);
	    q.add(qb1);
	    q.add(qb2);
	    qlabel1.setBounds(10, 105, 100, 30);
	    qlabel2.setBounds(131,105, 55, 30);
	    qb1.setBounds(189,105, 20, 30);
	    qlabel3.setBounds(215,105, 55, 30);
	    qb2.setBounds(272,105,20, 30);
	    
		RouteFirst.add(qlabel1);
		RouteFirst.add(qlabel2);
		RouteFirst.add(qlabel3);
		RouteFirst.add(qb1);
		RouteFirst.add(qb2);
		
		//������
	    JLabel label2=new JLabel("��Ϣ��С��",JLabel.LEFT);
		final JTextField txt1 = new JTextField("1");
		final JTextField txt2 = new JTextField("10");
		JLabel label21 = new JLabel("~",JLabel.CENTER);
		JLabel label22 = new JLabel("M",JLabel.CENTER);
		
		label2.setBounds(10, 145, 100, 30);
		txt1.setBounds(130, 145, 60, 30);
		label21.setBounds(190, 145, 10, 30);
		txt2.setBounds(200, 145, 60, 30);
		label22.setBounds(265, 145, 10, 30);
		RouteFirst.add(label2);
		RouteFirst.add(txt1);
		RouteFirst.add(label21);
		RouteFirst.add(txt2);
		RouteFirst.add(label22);
		//������
	    JLabel label3=new JLabel("��Ϣ����ʱ�䣺",JLabel.LEFT);
		final JTextField txt3 = new JTextField("1");
		final JTextField txt4 = new JTextField("5");
		JLabel label31 = new JLabel("~",JLabel.CENTER);
		JLabel label32 = new JLabel("Min",JLabel.CENTER);
		
		label3.setBounds(10, 185, 100, 30);
		txt3.setBounds(130, 185, 60, 30);
		label31.setBounds(190, 185, 10, 30);
		txt4.setBounds(200, 185, 60, 30);
		label32.setBounds(265, 185, 20, 30);
		RouteFirst.add(label3);
		RouteFirst.add(txt3);
		RouteFirst.add(label31);
		RouteFirst.add(txt4);
		RouteFirst.add(label32);
		
		//������
	    JLabel label4=new JLabel("�ڵ㻺���С��",JLabel.LEFT);
	    JLabel label5=new JLabel("M",JLabel.LEFT);
		JTextField txt5 = new JTextField("1000");
		label4.setBounds(10, 225, 100, 30);
		txt5.setBounds(130,225, 130, 30);
		label5.setBounds(265, 225, 20, 30);
		RouteFirst.add(label4);
		RouteFirst.add(txt5);
		RouteFirst.add(label5);

	    //������
	    JLabel label61=new JLabel("�ڵ㴫�����ʣ�",JLabel.LEFT);
	    JLabel label62=new JLabel("kbps",JLabel.LEFT);
		JTextField txt6 = new JTextField("100");
		label61.setBounds(10, 265, 100, 30);
		txt6.setBounds(130,265, 130, 30);
		label62.setBounds(265, 265, 40, 30);
		RouteFirst.add(label61);
		RouteFirst.add(txt6);
		RouteFirst.add(label62);
		
		//�ڰ���
	    JLabel label71=new JLabel("�ڵ㴫��뾶��",JLabel.LEFT);
	    JLabel label72=new JLabel("Km",JLabel.LEFT);
		JTextField txt7 = new JTextField("5000");
		label71.setBounds(10, 305, 100, 30);
		txt7.setBounds(130,305, 130, 30);
		label72.setBounds(265, 305, 40, 30);
		RouteFirst.add(label71);
		RouteFirst.add(txt7);
		RouteFirst.add(label72);
		
		RouteFirst.setSize(320, 200);
		//---------------------------���ö���·�ɲ���ҳ��----------------------------//			
		final JPanel RouteSecond = new JPanel();
		RouteSecond.setBorder(new TitledBorder("�������ý���"));
		RouteSecond.setLayout(null);
		//	���ü�����
		RouterC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// ��������Ĭ�ϴ��ڵĲ�������
				
				
				
				
				// ���������Ҫ��ӵĲ���
				if(RouterC.getSelectedIndex()==4 || RouterC.getSelectedIndex()==5){
					RouteSecond.removeAll();
					
					JLabel rlabel1 = new JLabel("����ģʽѡ��",JLabel.LEFT);
					JLabel rlabel2 = new JLabel("ʵʱ�������ģʽ",JLabel.LEFT);
					JLabel rlabel3 = new JLabel("�����Ϣ�洢ģʽ",JLabel.LEFT);
					ButtonGroup g = new ButtonGroup();
				    JRadioButton	    rb1 = new JRadioButton("", false),
				    					rb2 = new JRadioButton("", false);
				    g.add(rb1);
				    g.add(rb2);
				    rlabel1.setBounds(10, 20, 200, 30);
				    rlabel2.setBounds(90, 55, 120, 30);
				    rb1.setBounds(215,55, 20, 30);
				    rlabel3.setBounds(90, 90, 120, 30);
				    rb2.setBounds(215,90, 20, 30);
				    
				    RouteSecond.add(rlabel1);
				    RouteSecond.add(rlabel2);
				    RouteSecond.add(rlabel3);
				    RouteSecond.add(rb1);
				    RouteSecond.add(rb2);
				    
				    
					JLabel rlabel21 = new JLabel("���ֲ�����",JLabel.LEFT);
					JComboBox jcombo = new JComboBox();
					String[] description = {
							    "1", "2","3","4"
					};
					for(int i = 0; i < 4; i++)
				    	jcombo.addItem(description[i]);
					rlabel21.setBounds(10, 130, 70, 30);
					jcombo.setBounds(90, 130, 80, 30);
					RouteSecond.add(rlabel21);
					RouteSecond.add(jcombo);
				    
				    RouteSecond.repaint();
				}
				else{
					RouteSecond.removeAll();
				    RouteSecond.repaint();
				}
			}
		});
		
		jp1.setLayout(null);
		RouteFirst.setBounds(10, 0, 330, 350);
		RouteSecond.setBounds(340, 0, 330, 350);
		jp1.add(RouteFirst);
		jp1.add(RouteSecond);
		
		return jp1;
	}
	
	public JPanel CacheSetting(){
		JPanel jp2 = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel CacheFirst = new JPanel();
		CacheFirst.setBorder(new TitledBorder("һ�����ý���"));
		CacheFirst.setLayout(null);
		//	��һ��
	    JLabel label1=new JLabel("����ȷ��",JLabel.LEFT);
	    JLabel label2=new JLabel("����ת��",JLabel.LEFT);
	    
	    ButtonGroup g = new ButtonGroup();
	    JRadioButton	    rb1 = new JRadioButton("", false),
	    					rb2 = new JRadioButton("", false);
	    rb1.setSelected(true);
	    g.add(rb1);
	    g.add(rb2);
	    
	    label1.setBounds(10, 20, 60, 30);
	    rb1.setBounds(70, 20, 20, 30);
	    label2.setBounds(110, 20, 60, 30);
	    rb2.setBounds(170, 20, 20, 30);
	    CacheFirst.add(label1);
	    CacheFirst.add(rb1);
	    CacheFirst.add(label2);
	    CacheFirst.add(rb2);
	    
	    // ������
	    JLabel label3=new JLabel("�ڵ㻺���С��",JLabel.LEFT);
		JTextField txt3 = new JTextField("1000");
		JLabel label31 = new JLabel("M",JLabel.LEFT);		
		label3.setBounds(10, 60, 100, 30);
		txt3.setBounds(130,60, 130, 30);
		label31.setBounds(265, 60, 20, 30);
		CacheFirst.add(label3);
		CacheFirst.add(txt3);
		CacheFirst.add(label31);

	    
	    // ������
	    JLabel label4 = new JLabel("�ļ���������",JLabel.LEFT);
		JTextField txt4 = new JTextField("1");
		JLabel label41 = new JLabel("Min",JLabel.LEFT);

		label4.setBounds(10, 100, 100, 30);
		txt4.setBounds(130,100, 130, 30);
		label41.setBounds(265, 100, 20, 30);
		CacheFirst.add(label4);
		CacheFirst.add(txt4);
		CacheFirst.add(label41);
	    
	    // ������
	    JLabel label5=new JLabel("�ļ������С��",JLabel.LEFT);
		final JTextField txt5 = new JTextField("1");
		final JTextField txt51 = new JTextField("10");
		JLabel label51 = new JLabel("~",JLabel.LEFT);
		JLabel label52 = new JLabel("M",JLabel.LEFT);

		label5.setBounds(10, 140, 100, 30);
		txt5.setBounds(130, 140, 60, 30);
		label51.setBounds(190, 140, 10, 30);
		txt51.setBounds(200, 140, 60, 30);
		label52.setBounds(265, 140, 20, 30);
		CacheFirst.add(label5);
		CacheFirst.add(txt5);
		CacheFirst.add(label51);
		CacheFirst.add(txt51);
		CacheFirst.add(label52);
		
	    // ������
	    JLabel label6 = new JLabel("��Ƭ��Ŀ��",JLabel.LEFT);
		JTextField txt6 = new JTextField("10");
		JLabel label61 = new JLabel("��",JLabel.LEFT);
		label6.setBounds(10, 180, 100, 30);
		txt6.setBounds(130,180, 130, 30);
		label61.setBounds(265, 180, 20, 30);
		CacheFirst.add(label6);
		CacheFirst.add(txt6);
		CacheFirst.add(label61);

	    
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel CacheSecond = new JPanel();
		CacheSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp2.setLayout(null);
		CacheFirst.setBounds(10, 0, 330, 350);
		CacheSecond.setBounds(340, 0, 330, 350);
		jp2.add(CacheFirst);
		jp2.add(CacheSecond);
		
		return jp2;
	}
	
	public JPanel MovementSetting(){
		JPanel jp3 = new JPanel();
		//JPanel jp = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel MovementFirst = new JPanel();
		MovementFirst.setBorder(new TitledBorder("һ�����ý���"));
		//MovementFirst.setLayout(new GridLayout(8,1,10,10));
		MovementFirst.setLayout(null);
		
		//��һ��
	    JLabel label1=new JLabel("�������ã�",JLabel.LEFT);
		JComboBox WalkerC = new JComboBox();
		String[] description = {
				    "Walker1", "Walker2","Walker3","Walker4",
		};
		
	    for(int i = 0; i < 4; i++)
	    	WalkerC.addItem(description[i]);
	    
	    label1.setBounds(10, 25, 100, 30);
	    WalkerC.setBounds(130, 25, 120, 30);
	    MovementFirst.add(label1);
	    MovementFirst.add(WalkerC);

		
		//  �ڶ���
	    JLabel label2=new JLabel("���ģ�ͣ�",JLabel.LEFT);
		JComboBox OrbitC = new JComboBox();
		String[] description1 = {
				    "TwoBody1", "TwoBody2","TwoBody3","TwoBody4",
		};
		
	    for(int i = 0; i < 4; i++)
	    	OrbitC.addItem(description1[i]);
	    
	    label2.setBounds(10, 65, 100, 30);
	    OrbitC.setBounds(130, 65, 120, 30);
	    MovementFirst.add(label2);
	    MovementFirst.add(OrbitC);

		
		//  ������
	    JLabel label3 = new JLabel("�ڵ���Ŀ��",JLabel.LEFT);
		JTextField txt3 = new JTextField("50");
		JLabel label31 = new JLabel("��",JLabel.LEFT);
	    label3.setBounds(10, 105, 100, 30);
	    txt3.setBounds(130, 105, 120, 30);
	    label31.setBounds(255, 105, 20, 30);
	    MovementFirst.add(label3);
	    MovementFirst.add(txt3);
	    MovementFirst.add(label31);

		
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel MovementSecond = new JPanel();
		MovementSecond.setLayout(null);
		MovementSecond.setBorder(new TitledBorder("�������ý���"));
		
		//��һ�� ������M/N/P
		JLabel mslabel1 = new JLabel("������M/N/P��",JLabel.LEFT);
		JLabel mslabel11 = new JLabel("M-�ܵĽڵ�����",JLabel.LEFT);
		JTextField mstxt11 = new JTextField(5);
		JLabel mslabel12 = new JLabel("N-���ƽ������",JLabel.LEFT);
		JTextField mstxt12 = new JTextField(5);
		JLabel mslabel13 = new JLabel("P-��λ���ӣ�",JLabel.LEFT);
		JTextField mstxt13 = new JTextField(5);
		JLabel mslabel2 = new JLabel("����뾶��",JLabel.LEFT);
		JTextField mstxt2 = new JTextField(5);
		JLabel mslabel3 = new JLabel("�����ʣ�",JLabel.LEFT);
		JTextField mstxt3 = new JTextField(5);
		
		mslabel1.setBounds(10, 20, 100, 30);
		mslabel11.setBounds(35, 60, 100, 30);
		mstxt11.setBounds(145,60, 100, 30);
		mslabel12.setBounds(35, 100, 100, 30);
		mstxt12.setBounds(145, 100, 100, 30);
		mslabel13.setBounds(35, 140, 100, 30);
		mstxt13.setBounds(145, 140, 100, 30);
		
		mslabel2.setBounds(10, 185, 100, 30);
		mstxt2.setBounds(145, 185, 100, 30);
		mslabel3.setBounds(10, 225, 100, 30);
		mstxt3.setBounds(145, 225, 100, 30);
		
		MovementSecond.add(mslabel1);
		MovementSecond.add(mslabel11);
		MovementSecond.add(mstxt11);
		MovementSecond.add(mslabel12);
		MovementSecond.add(mstxt12);
		MovementSecond.add(mslabel13);
		MovementSecond.add(mstxt13);
		MovementSecond.add(mslabel2);
		MovementSecond.add(mstxt2);
		MovementSecond.add(mslabel3);
		MovementSecond.add(mstxt3);
		
		//jp3.setLayout(new GridLayout(1,2));
		jp3.setLayout(null);
		MovementFirst.setBounds(10, 0, 330, 350);
		MovementSecond.setBounds(340, 0, 330, 350);
		jp3.add(MovementFirst);
		jp3.add(MovementSecond);
		
		return jp3;
	}
	
	public JPanel LinkSetting(){
		JPanel jp4 = new JPanel();
		//---------------------------���û������ҳ��----------------------------//	
		JPanel LinkFirst = new JPanel();
		LinkFirst.setBorder(new TitledBorder("һ�����ý���"));
		LinkFirst.setLayout(null);
		
		
		//��һ��
	    JLabel label1=new JLabel("��·ģ�ͣ�",JLabel.RIGHT);		
		JLabel label2 = new JLabel("����ͷ");
		JTextField text1 = new JTextField("1");
		JLabel label3 = new JLabel("΢����·");
		JTextField text2 = new JTextField("1");
		JLabel label4 = new JLabel("��");
		JLabel label5 = new JLabel("��");
		
		label1.setBounds(10, 20, 60, 30);
		label2.setBounds(100, 20, 60, 30);
		text1.setBounds(170, 20, 60, 30);
		label4.setBounds(240, 20, 20, 30);
		label3.setBounds(100, 60, 60, 30);
		text2.setBounds(170, 60, 60, 30);
		label5.setBounds(240, 60, 20, 30);
		
		LinkFirst.add(label1);
		LinkFirst.add(label2);
		LinkFirst.add(text1);
		LinkFirst.add(label3);
		LinkFirst.add(text2);
		LinkFirst.add(label4);
		LinkFirst.add(label5);
		
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel LinkSecond = new JPanel();
		LinkSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp4.setLayout(null);
		LinkFirst.setBounds(10, 0, 330, 350);
		LinkSecond.setBounds(340, 0, 330, 350);
		jp4.add(LinkFirst);
		jp4.add(LinkSecond);
		
		return jp4;
	}
	
	public JPanel MainSetting(){
		JPanel jp5 = new JPanel();
		//---------------------------�����������ҳ��----------------------------//	
		JPanel LinkFirst = new JPanel();
		LinkFirst.setBorder(new TitledBorder("һ�����ý���"));
		LinkFirst.setLayout(null);
		
		//��һ��
	    JLabel label1 = new JLabel("��ά�߽磺",JLabel.RIGHT);
		JTextField txt1 = new JTextField("10000");
		JTextField txt2 = new JTextField("10000");
		JTextField txt3 = new JTextField("10000");	    
		JLabel km = new JLabel("Km");

		label1.setBounds(0, 25, 80, 30);
		txt1.setBounds(95, 25, 50, 30);
		txt2.setBounds(155, 25, 50, 30);
		txt3.setBounds(215, 25, 50, 30);
		km.setBounds(270, 25, 20, 30);
		LinkFirst.add(label1);
		LinkFirst.add(txt1);
		LinkFirst.add(txt2);
		LinkFirst.add(txt3);
		LinkFirst.add(km);
		
		//�ڶ��� ����ʱ������
		JLabel label2 = new JLabel("����ʱ�䣺",JLabel.RIGHT);
		JLabel time = new JLabel("s");
		simTime = new JTextField("43200",JTextField.CENTER);
		simTime.addActionListener(this);
		label2.setBounds(0, 65, 80, 30);
		simTime.setBounds(95, 65, 170, 30);
		time.setBounds(270, 65, 20, 30);
		LinkFirst.add(label2);
		LinkFirst.add(simTime);
		LinkFirst.add(time);
		
		
		//������ ���沽��
		JLabel label3 = new JLabel("���沽����",JLabel.RIGHT);
		JLabel time2 = new JLabel("s");
		interval = new JTextField("0.1");
		label3.setBounds(0, 105, 80, 30);
		interval.setBounds(95, 105, 170, 30);
		time2.setBounds(270, 105, 20, 30);
		LinkFirst.add(label3);
		LinkFirst.add(interval);
		LinkFirst.add(time2);
		
		//������ Ԥ��ʱ��
		JLabel label4 = new JLabel("Ԥ��ʱ�䣺",JLabel.RIGHT);
		JLabel time3 = new JLabel("s");
		warmUp = new JTextField("1000");
		label4.setBounds(0, 145, 80, 30);
		warmUp.setBounds(95, 145, 170, 30);
		time3.setBounds(270, 145, 20, 30);
		LinkFirst.add(label4);
		LinkFirst.add(warmUp);
		LinkFirst.add(time3);
		
		
		//---------------------------���ö����������ҳ��----------------------------//			
		JPanel LinkSecond = new JPanel();
		LinkSecond.setBorder(new TitledBorder("�������ý���"));
		
		jp5.setLayout(null);
		LinkFirst.setBounds(10, 0, 330, 350);
		LinkSecond.setBounds(340, 0, 330, 350);
		jp5.add(LinkFirst);
		jp5.add(LinkSecond);
		
		
		return jp5;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.Confirm) {
			this.ParaSet();
			this.setVisible(false);
		}
		if (e.getSource() == this.Concel) {
			this.setVisible(false);
		}
		if (e.getSource() == this.Reset) {
			
		}
		
	}
	

	//--------------------------- �������� --------------------------//
	public void ParaSet(){
		this.RouteParaSet();
		this.CacheParaSet();
		this.MoveParaSet();
		this.LinkParaSet();
	}

	private void LinkParaSet() {
		// TODO Auto-generated method stub
		
	}

	private void MoveParaSet() {
		// TODO Auto-generated method stub
		
	}

	private void CacheParaSet() {
		// TODO Auto-generated method stub
		
	}

	public void RouteParaSet(){
		Settings settings = new Settings();
		settings.setSetting(CONFIGURATION_FILE_LOCATION,"Group.router",String.valueOf(RouterC.getSelectedItem()));
		settings.setSetting(CONFIGURATION_FILE_LOCATION,"Scenario.endTime",String.valueOf(simTime.getText()));
		settings.setSetting(CONFIGURATION_FILE_LOCATION,"Scenario.updateInterval",String.valueOf(interval.getText()));
		settings.setSetting(CONFIGURATION_FILE_LOCATION,"MovementModel.warmup",String.valueOf(warmUp.getText()));
	}

}
