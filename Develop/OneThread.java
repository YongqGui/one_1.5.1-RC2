package Develop;

import ui.DTNSimTextUI;

public class OneThread implements Runnable{
	public void run() {
		DTNSimTextUI DSTUI = new DTNSimTextUI();
		DSTUI.start();
	}
}
