package gui_test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
/**
 * һ����װ��LookAndFeel�Ӳ˵� �����ڸı������LookAndFeel ��ЩLookAndFeel��JRE �Դ��� LookAndFeel
 * ��Щ���������һ����������� �������ſɸ���LookAndFeel
 *
 * @author QIU_BaiChao
 */
public class test extends JMenu {
 
    private static final String defaultMenuName = "LookAndFeel";
 
    // �õ�ϵͳ�İ�װ������LookAndFeel
    UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
    // ��ť��,��һ��LookAndFeel�ĵ�ѡ��ť��������
    ButtonGroup buttonGroup = new ButtonGroup();
 
    // �����������LookAndFeelֻ�ܸ��� ��ͬһ���������LookAndFeel
    Component parent;
 
    public test(String menuName, final Component parent) {
        // ���ɸ�������ѡ��LookAndFeel�ĵ�ѡ��ť�Ӳ˵�
        // generateLookAndFeelSubMenu(parent);
        setParentComponent(parent);
        // ���ò˵���
        this.setText(menuName);
    }
 
    public test(Component parent) {
        this(defaultMenuName, parent);
    }
 
    public test() {
        super(defaultMenuName);
    }
 
    /**
     * ����LookAndFeel�ĵ�ѡ�Ӳ˵�
     *
     * @param parent
     */
    private void generateLookAndFeelSubMenu(final Component parent) {
    	final String liquid = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        for (int i = 0; i < info.length; i++) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(
                    info[i].getName(), i == 0);
            final String className = info[i].getClassName();
            // �����¼�����
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evn) {
                    try {
                    	System.out.println(className);
                        //UIManager.setLookAndFeel(className);
                        UIManager.setLookAndFeel(liquid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // ���������LookAndFeel
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
        menu.setText("���ѡ��");
        menu.setParentComponent(frame);
        bar.add(menu);
        frame.getContentPane().add(BorderLayout.NORTH, bar);
        frame.getContentPane().add(BorderLayout.CENTER, new JButton("Hello"));
        frame.setVisible(true);
    }
 
}
