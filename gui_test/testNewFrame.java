package gui_test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
  
class testNewFrame extends JFrame{
 
    public testNewFrame(String title) {
        super(title);
        JButton button =new JButton("dialog");
        button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JFrame frame=new JFrame("hello,I'm sub Frame");
                frame.setSize(200,200);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        button.setBackground(Color.red);
        button.setBounds(100, 100, 100, 100);
        add(button);
        setSize(400,400);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new testNewFrame("MainWindow");
    }
}

