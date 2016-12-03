/* 	
 * ���Ҫʵ�ֹ��ڷ�������ϵĴ���ȫ����������  
 **/
package Develop;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sun.j3d.utils.applet.MainFrame;

import ui.DTNSimTextUI;
import core.Settings;
import core.SimClock;

import java.awt.*;

public class OneSimUI extends DTNSimTextUI{
	private long lastUpdateRt;									// real time of last ui update
	private long startTime; 									// simulation start time
	private  EventLog eventLog;
	/** namespace of scenario settings ({@value})*/
	public static final String SCENARIO_NS = "Scenario";
	/** end time -setting id ({@value})*/
	public static final String END_TIME_S = "endTime";
	/** update interval -setting id ({@value})*/
	public static final String UP_INT_S = "updateInterval";
	/** How often the UI view is updated (milliseconds) */     
	public static final long UI_UP_INTERVAL = 60000;
	public Main_Window main;

	/**
	 * Initializes the simulator model.
	 */
	private void NewWindow() {
		/**��ʼ��ͼ�ν���*/
		this.eventLog = new EventLog(this);
		main = new Main_Window(eventLog);
		scen.addMessageListener(eventLog);
		scen.addConnectionListener(eventLog);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);	
		
		start3D();
	}

	private void start3D(){
	    JFrame frame = new JFrame();
	    frame.setSize(460, 460);
	    frame.setTitle("��ά����");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MoveGlobe applet = new MoveGlobe();
	    applet.init();
	    frame.getContentPane().add(applet);
	    //frame.setLocationRelativeTo(main);
	    frame.setLocation(220,160);
	    frame.setVisible(true);
	}
	/**
	 * Starts the simulation.
	 */
	public void start() {
		initModel();
		runSim();
	}
	
	private void startGUI() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
			    public void run() {
					try {
						NewWindow();
					} catch (AssertionError e) {
						processAssertionError(e);
					}
			    }
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	protected void processAssertionError(AssertionError e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runSim(){
		Settings s = new Settings(SCENARIO_NS);
		
		startGUI();
		while(main.getPaused() == true){			// ����ȴ�ȷ�����ò���
			try {
				 synchronized (this){
					wait(10);
				 }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setParameter();
		double simTime = SimClock.getTime();
		double endTime = scen.getEndTime();
		
		// ----------------------- ���ڲ��Բ��� --------------------------------//
		System.out.println("����ʱ��"+"  "+endTime);
		System.out.println("����ʱ�䣺"+"  "+scen.getUpdateInterval());
		// ----------------------- ���ڲ��Բ��� --------------------------------//
		
		
		startTime = System.currentTimeMillis();
		lastUpdateRt = startTime;
	
		while (simTime < endTime && !simCancelled){			
			if (main.getPaused()) {
				try {
					 synchronized (this){
						wait(10);
					 }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					world.update();
				} catch (AssertionError e) {
					e.printStackTrace();
					done();
					return;
				}
				simTime = SimClock.getTime();
			}
			this.update(false);
		}
		
		double duration = (System.currentTimeMillis() - startTime)/1000.0;
		
		simDone = true;
		done();
		this.update(true); // force final UI update
		
		print("Simulation done in " + String.format("%.2f", duration) + "s");
	
	}
	/**
	 * Updates user interface if the long enough (real)time (update interval)
	 * has passed from the previous update.
	 * @param forced If true, the update is done even if the next update
	 * interval hasn't been reached.
	 */
	private void update(boolean forced) {
		long now = System.currentTimeMillis();
		long diff = now - this.lastUpdateRt;
		double dur = (now - startTime)/1000.0;
		if (forced || (diff > UI_UP_INTERVAL)) {
			// simulated seconds/second 
			double ssps = ((SimClock.getTime() - lastUpdate)*1000) / diff;
			this.lastUpdateRt = System.currentTimeMillis();
			this.lastUpdate = SimClock.getTime();
		}		
	}
	
	private void print(String txt) {
		System.out.println(txt);
	}
	
	/**
	 * ���ӽ����������ò���֮�󣬽���������д�뵽scen�У�������Ӧ������������ԭ�г����ȡ��
	 */
	private void setParameter(){
		Settings s = new Settings(SCENARIO_NS);
		double interval =  s.getDouble(UP_INT_S);	//	����ʱ��
		scen.setUpdateInterval(interval);
		
		double endTime = s.getDouble(END_TIME_S);	//	����ʱ��
		scen.setEndTime(endTime);
	}
}
