// ���Ҳ�ò�����
package Develop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import ui.DTNSimTextUI;
//import java.io.IOException;
//import core.SimClock;


public class ViewEvents implements ActionListener, ItemListener{
	Main_Window main;
	DTNSimTextUI DSTUI;
	/**		�����ж��Ƿ���ͣ		*/
	protected boolean simPaused = false;

	public ViewEvents(Main_Window d) {
		this.main = d;
	}

	public void actionPerformed(ActionEvent actev) {

		
//		if(actev.getSource() == main.pause){		// �������ͣ
//			this.simPaused = true;
//		}
//		if(actev.getSource() == main.start) {
//			OneThread NewThread = new OneThread();  
//			Thread thread = new Thread(NewThread);  
//			thread.start(); 
//		}
		if(actev.getSource() == main.end) {
			System.exit(0);
		}
		
	}
	/**		���ڻ�ȡ�Ƿ���ͣ		*/
	public boolean getPaused(){
		return this.simPaused;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
	}
}
