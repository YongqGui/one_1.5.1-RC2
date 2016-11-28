package gui_test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
/**
 * 一个封装了LookAndFeel子菜单 可用于改变组件的LookAndFeel 这些LookAndFeel是JRE 自带的 LookAndFeel
 * 这些组件必须与一个父组件的相 关联，才可更新LookAndFeel
 *
 * @author QIU_BaiChao
 */
public class test extends JMenu {
 
    private static final String defaultMenuName = "LookAndFeel";
 
    // 得到系统的安装的所有LookAndFeel
    UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
    // 按钮组,将一组LookAndFeel的单选按钮放在里面
    ButtonGroup buttonGroup = new ButtonGroup();
 
    // 父组件，更新LookAndFeel只能更新 在同一个父组件的LookAndFeel
    Component parent;
 
    public test(String menuName, final Component parent) {
        // 生成各个可以选择LookAndFeel的单选按钮子菜单
        // generateLookAndFeelSubMenu(parent);
        setParentComponent(parent);
        // 设置菜单名
        this.setText(menuName);
    }
 
    public test(Component parent) {
        this(defaultMenuName, parent);
    }
 
    public test() {
        super(defaultMenuName);
    }
 
    /**
     * 生成LookAndFeel的单选子菜单
     *
     * @param parent
     */
    private void generateLookAndFeelSubMenu(final Component parent) {
    	final String liquid = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        for (int i = 0; i < info.length; i++) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(
                    info[i].getName(), i == 0);
            final String className = info[i].getClassName();
            // 增加事件处理
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evn) {
                    try {
                    	System.out.println(className);
                        //UIManager.setLookAndFeel(className);
                        UIManager.setLookAndFeel(liquid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // 更新组件的LookAndFeel
                    SwingUtilities.updateComponentTreeUI(parent);
                }
            });
            buttonGroup.add(item);
            add(item);
        }
    }
 
    public Component getParentComponent() {
        return parent;
    }
 
    public void setParentComponent(Component parent) {
        this.parent = parent;
        generateLookAndFeelSubMenu(parent);
    }
 
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocation(200, 200);
        JMenuBar bar = new JMenuBar();
        test menu = new test();
        menu.setText("外观选择");
        menu.setParentComponent(frame);
        bar.add(menu);
        frame.getContentPane().add(BorderLayout.NORTH, bar);
        frame.getContentPane().add(BorderLayout.CENTER, new JButton("Hello"));
        frame.setVisible(true);
    }
 
}
