// 这样就用不到这个文件了

package Develop;

import ui.DTNSimTextUI;

public class OneThread implements Runnable{
	public void run() {
		DTNSimTextUI DSTUI = new DTNSimTextUI();
		DSTUI.start();
	}
}
