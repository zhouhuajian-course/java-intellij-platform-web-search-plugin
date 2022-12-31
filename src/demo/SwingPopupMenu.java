package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/tutorial/uiswing/
public class SwingPopupMenu {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
        //         method1();
        //     }
        // });
        // method1();
        method2();
    }

    private static void method1() {
        JFrame frame = new JFrame();
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenu menu = new JMenu("网页搜素");

        JMenuItem menuItem1 = new JMenuItem("必应搜索");
        JMenuItem menuItem2 = new JMenuItem("百度搜索");
        JMenuItem menuItem3 = new JMenuItem("搜狗搜索");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getActionCommand());
            }
        };

        menuItem1.addActionListener(actionListener);
        menuItem2.addActionListener(actionListener);
        menuItem3.addActionListener(actionListener);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        popupMenu.add(menu);
        contentPane.setComponentPopupMenu(popupMenu);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void method2() {
        JFrame frame = new JFrame();
        JPanel contentPane = (JPanel) frame.getContentPane();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenu menu = new JMenu("网页搜素");

        // JMenuItem menuItem1 = new JMenuItem("必应搜索");
        // JMenuItem menuItem2 = new JMenuItem("百度搜索");
        // JMenuItem menuItem3 = new JMenuItem("搜狗搜索");
        //
        // ActionListener actionListener = new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent actionEvent) {
        //         System.out.println(actionEvent.getActionCommand());
        //     }
        // };
        //
        // menuItem1.addActionListener(actionListener);
        // menuItem2.addActionListener(actionListener);
        // menuItem3.addActionListener(actionListener);
        // menu.add(menuItem1);
        // menu.add(menuItem2);
        // menu.add(menuItem3);

        class WebSearchAction extends AbstractAction {
            WebSearchAction(String name) {
                super(name);
            }
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getActionCommand());
            }
        }
        Action action1 = new WebSearchAction("必应搜索2");
        Action action2 = new WebSearchAction("百度搜索2");
        Action action3 = new WebSearchAction("搜狗搜索2");
        menu.add(action1);
        menu.add(action2);
        menu.add(action3);

        popupMenu.add(menu);
        contentPane.setComponentPopupMenu(popupMenu);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
