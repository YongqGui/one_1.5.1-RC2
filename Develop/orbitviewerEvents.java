/* JAT: Java Astrodynamics Toolkit
 * 
  Copyright 2012 Tobias Berthold

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package Develop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ui.DTNSimTextUI;

import java.io.IOException;

public class orbitviewerEvents implements ActionListener, ItemListener {
	Main_Window main;
	DTNSimTextUI DSTUI;

	public orbitviewerEvents(Main_Window d) {
		this.main = d;
	}

	public void actionPerformed(ActionEvent ev) {

		
		if(ev.getSource() == main.start) {
			OneThread NewThread = new OneThread();  
			Thread thread = new Thread(NewThread);  
			thread.start(); 
			System.out.println("Insert Done!");
		}
		if(ev.getSource() == main.end) {
			System.exit(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItemSelectable();
	}
}
