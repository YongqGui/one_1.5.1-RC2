/*
 * The design of the interface  of simulator by	YongqGui
 */
package Develop;

//import jat.application.orbitviewer.orbitviewerEvents;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

import core.SimClock;

import java.awt.event.*;
import java.io.File;

public class Main_Window extends JFrame implements ActionListener, ChangeListener{
	private static final String PATH_GRAPHICS = "buttonGraphics/";	
	private static final String ICON_PLAY = "Play16.gif";
	private static final String ICON_PAUSE = "Pause16.gif";
	private static final String ICON_FastForward = "FastForward16.gif";
	private static final String ICON_REPORT = "Report.gif";
	private static final String ICON_Stop = "Stop.gif";
	private static final String ICON_Parameter = "Parameter.gif";	
	private static final String ICON_Bigger = "Bigger.gif";
	private static final String ICON_Smaller = "Smaller.gif";
	
	/** Default width for the GUI window */
	public static final int WIN_DEFAULT_WIDTH = 1000;
	/** Default height for the GUI window */
	public static final int WIN_DEFAULT_HEIGHT = 750;

	public JPanel ButtonMenus;
	public JButton playButton;
	public JButton end;
	public JButton report;
	public JButton FastForward;
	public JButton parameter;
	public JButton Smaller;
	public JButton Bigger;
	private static JSplitPane JSP1;
	private static JSplitPane JSP2;
	private static JSplitPane JSP3;
	protected boolean simPaused = true;
    private JFileChooser chooser;
	private JTabbedPane tabs = new JTabbedPane();
	private JDesktopPane desktopPane;
	
	public ActionListener e;


	
	public Main_Window(EventLog elp) {
		super("���Ƿ���ϵͳ");
		
		final String liquid =  "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	  	try {
			UIManager.setLookAndFeel(liquid);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			//	����Ƥ��
	  	this.getContentPane().setBackground(Color.lightGray);			// ���ñ�����ɫ
	  	
	  	
		setSize(WIN_DEFAULT_WIDTH,WIN_DEFAULT_HEIGHT);
	    JPanel desktop = new JPanel();
	    getContentPane().add(desktop);
	    
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
	    final JMenu[] menus = {
	    		new JMenu("File   "), new JMenu("Edit   "),
				new JMenu("Properties   "),new JMenu("Tools   "),
				new JMenu("Windows   "),new JMenu("Help   "),
	    };
	    final JMenuItem[] items = {
			  	new JMenuItem("open"), new JMenuItem("Fi"),
				new JMenuItem("Fo"),  new JMenuItem("Zip"),
				new JMenuItem("Zap"), new JMenuItem("Zot"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Free"), new JMenuItem("Zot"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Olly"), new JMenuItem("Oxen"),
				new JMenuItem("Free"),
	    };
	    
//	    open.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                // TODO Auto-generated method stub
//                int result = chooser.showOpenDialog(null);
//                if(result == JFileChooser.APPROVE_OPTION){
//                    String name = chooser.getSelectedFile().getPath();
//                    label.setIcon(new ImageIcon(name));
//                }
//           }
//        });
	    
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
	    ButtonMenus = new JPanel();
	    ButtonMenus.setLayout(new BoxLayout(ButtonMenus, BoxLayout.X_AXIS));
	    playButton = addButton(simPaused ? ICON_PLAY : ICON_PAUSE);
	    
	    end = new JButton();
	    end.addActionListener(this);
	    end.setIcon(createImageIcon(ICON_Stop));
	    //end.setContentAreaFilled(false);
	    
	    report = new JButton();
	    report.setIcon(createImageIcon(ICON_REPORT));
	    //report.setContentAreaFilled(false);
	    report.addActionListener(this);
	    
	    FastForward = new JButton();
	    FastForward.setIcon(createImageIcon(ICON_FastForward));
	    FastForward.addActionListener(this);
	    
	    Smaller = new JButton();
	    Smaller.setIcon(createImageIcon(ICON_Smaller));
	    Smaller.addActionListener(this);
	    
	    Bigger = new JButton();
	    Bigger.setIcon(createImageIcon(ICON_Bigger));
	    Bigger.addActionListener(this);

	    parameter = new JButton();
	    parameter.setIcon(createImageIcon(ICON_Parameter));
	    //parameter.setContentAreaFilled(false);
        parameter.addActionListener(new ActionListener() {	//��ť����֮��Ҫ�����������ý���
            public void actionPerformed(ActionEvent e) {
                new RouterInfo();
            }
        });
        
	    ButtonMenus.add(end);
	    ButtonMenus.add(FastForward);
	    ButtonMenus.add(Smaller);
	    ButtonMenus.add(Bigger);
	    ButtonMenus.add(report);
	    ButtonMenus.add(parameter);
	    fileMenus.add(ButtonMenus);
	    
	  
	    //---------------------------���ýڵ��б�----------------------------//	  	
	    JPanel NodeList = new JPanel();
	    NodeList.setLayout(new GridLayout(30,1));
	    NodeList.setBorder(new TitledBorder("Nodes"));
	    for (int i = 0; i<30; i++)
	    	NodeList.add(new JButton("N" + i));
	  
	    //---------------------------���ö�ά����----------------------------//	  	
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		//System.out.println(desktopPane.getBackground());

		
		JInternalFrame internalFrame1 = new JInternalFrame("��ά����", true, true, true, true);
		internalFrame1.setLocation(50, 50);
		internalFrame1.setSize(500, 300);
		internalFrame1.setVisible(true);
		
	    JLabel label = new JLabel();
	    String name = "C:\\Users\\YongqGui\\Workspaces\\MyEclipse 2015 CI\\JAVA3D\\images\\earth.png";
	    label.setIcon(new ImageIcon(name));
	    internalFrame1.add(label);
	    desktopPane.add("��ά����",internalFrame1);
	    
	    //---------------------------������ά����----------------------------//	  	
		JInternalFrame internalFrame = new JInternalFrame("��ά����", true, true, true, true);
		internalFrame.setLocation(20, 20);
		internalFrame.setSize(500, 300);
		internalFrame.setVisible(true);
		
	    MoveGlobe applet = new MoveGlobe();
	    applet.init();
	    internalFrame.getContentPane().add(applet);
	    desktopPane.add("��ά����",internalFrame);
	    
	    //---------------------------�����¼�����----------------------------//
	    JPanel Event = new JPanel();
        Event.setLayout(new BoxLayout(Event,BoxLayout.Y_AXIS));						//	����Y����в���
		
	    JSP1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,desktopPane,new JScrollPane(elp));
	    JSP1.setResizeWeight(0.8);													//	����splitPane1�ķָ���λ�ã�0.1�������splitPane1�Ĵ�С������
	    
	    JScrollPane Jscrollp = new JScrollPane(NodeList);		
	    Jscrollp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	//	����ˮƽ������
	    JSP2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,JSP1,Jscrollp);
	  	JSP2.setResizeWeight(0.99);
	  	JSP3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,fileMenus,JSP2);	
	  	JSP3.setResizeWeight(0.01);

	  	add(JSP3);


	}
	  
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.playButton) {
			setPaused(simPaused);
		}
		else if (e.getSource() == this.end){
			System.exit(0);
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getPaused(){
		return this.simPaused;
	}
	
	private ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(PATH_GRAPHICS+path);
		return new ImageIcon(imgURL);
	}
	
	private JButton addButton(String iconPath) {
		JButton button = new JButton(createImageIcon(iconPath));
		button.addActionListener(this);
		//button.setContentAreaFilled(false);
		ButtonMenus.add(button);
		return button;
	}
	
	/**
	 * Sets simulation to pause or play.
	 * @param paused If true, simulation is put to pause
	 */
	public void setPaused(boolean paused) {
		if (!paused) {
			this.playButton.setIcon(createImageIcon(ICON_PLAY));
			this.simPaused = true;
		}
		else {
			this.playButton.setIcon(createImageIcon(ICON_PAUSE));
			this.simPaused = false;
		}
	}
}






