/* 	
 * 最后要实现关于仿真界面上的处理全部放在这里  
 **/
package Develop;

import gui.EventLogPanel;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ui.DTNSimTextUI;
import core.SimClock;

public class OneSimUI extends DTNSimTextUI{
	private long lastUpdateRt;									// real time of last ui update
	private long startTime; 									// simulation start time
	private  EventLog eventLog = new EventLog(this);
	
	/** How often the UI view is updated (milliseconds) */     
	public static final long UI_UP_INTERVAL = 60000;
	public Main_Window main;

	/**
	 * Initializes the simulator model.
	 */
	private void NewWindow() {
		/**初始化图形界面*/
		main = new Main_Window(eventLog);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);	
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
		
		double simTime = SimClock.getTime();
		double endTime = scen.getEndTime();
		
		startGUI();
		
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
			print(String.format("%.1f %d: %.2f 1/s", dur, 
					SimClock.getIntTime(),ssps));
			
			this.lastUpdateRt = System.currentTimeMillis();
			this.lastUpdate = SimClock.getTime();
		}		
	}
	
	private void print(String txt) {
		System.out.println(txt);
	}

}
