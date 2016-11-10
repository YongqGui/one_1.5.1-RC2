package gui_test;

//: gui/SimpleMenus.java
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
//import static net.mindview.util.SwingConsole.*;

public class Menu {
	private JTextField t = new JTextField(15);
	private ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {	//	应该是获取text文件数据
			t.setText(((JMenuItem)e.getSource()).getText());
		}
	};
	private JMenu[] menus = {
			new JMenu("Winken"), new JMenu("Blinken"),
			new JMenu("Nod"),new JMenu("WORDge"),
	};
	private JMenuItem[] items = {
			new JMenuItem("Fee"), new JMenuItem("Fi"),
			new JMenuItem("Fo"),  new JMenuItem("Zip"),
			new JMenuItem("Zap"), new JMenuItem("Zot"),
			new JMenuItem("Olly"), new JMenuItem("Oxen"),
			new JMenuItem("Free"), new JMenuItem("Zot"),
			new JMenuItem("Olly"), new JMenuItem("Oxen"),
	};
	public Menu() {
		for(int i = 0; i < items.length; i++) {
			items[i].addActionListener(al);
			menus[i % 3].add(items[i]);
		}
		JMenuBar mb = new JMenuBar();
		for(JMenu jm : menus)
			mb.add(jm);					//把JMenu 加入到JMenuBar中
		//setJMenuBar(mb);
		//setLayout(new FlowLayout());
		//add(t);
	}
} ///:~




//------------------------------设置菜单----------------------------//
private JMenu[] menus = {
		new JMenu("Winken"), new JMenu("Blinken"),
		new JMenu("Nod"),new JMenu("WORDge"),
};
private JMenuItem[] items = {
		new JMenuItem("Fee"), new JMenuItem("Fi"),
		new JMenuItem("Fo"),  new JMenuItem("Zip"),
		new JMenuItem("Zap"), new JMenuItem("Zot"),
		new JMenuItem("Olly"), new JMenuItem("Oxen"),
		new JMenuItem("Free"), new JMenuItem("Zot"),
		new JMenuItem("Olly"), new JMenuItem("Oxen"),
};
for (int i=0;i<items.length; i++){
	menus[i%3].add(items[i]);
};
JMenuBar mb = new JMenuBar();
for (JMenu jm:menus){
	mb.add(jm);
};
