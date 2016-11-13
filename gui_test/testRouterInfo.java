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
		super("��������   copyright by USTC");
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
		
		//---------------------------����tabҳ��----------------------------//		
		final JTabbedPane tabs = new JTabbedPane();
		final JTextField txt = new JTextField(20);

		JPanel jp1 = new JPanel();		
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();		
		JPanel jp4 = new JPanel();
		tabs.add("·��ģ��",jp1);		
		tabs.add("�˶�ģ��",jp2);
		tabs.add("����ģ��",jp3);		
		tabs.add("��·ģ��",jp4);
		
	    tabs.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	          txt.setText("Tab selected: " +
	            tabs.getSelectedIndex());
	        }
	      });
	    add(BorderLayout.SOUTH, txt);
		add(tabs);
		
		jp1 = RouteInfoSetting();
		
		
		/*	�ر�ҳ��
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
		//---------------------------����·�ɲ���ҳ��----------------------------//	
		JPanel RouteFirst = new JPanel();
		RouteFirst.setBorder(new TitledBorder("һ�����ý���"));
		RouteFirst.setLayout(new GridLayout(10,1,10,10));
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
		
		return jp1;
	}
	
	
	
}
