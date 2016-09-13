package com.hr_system.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import com.hr_system.util.AllObj;

import java.awt.Font;
import java.awt.GridLayout;

public class WelcomeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2761800798049455748L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeFrame() {
		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBounds(10, 10, 765, 40);
		contentPane.add(panel);

		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u4EBA\u4E8B\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u6CE8\u518C\u7528\u6237");
		mnNewMenu.add(menuItem_1);

		JMenu mnNewMenu_1 = new JMenu("\u57F9\u8BAD\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("\u85AA\u916C\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("\u62DB\u8058\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);

		JMenu mnNewMenu_4 = new JMenu("\u516C\u544A\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 60, 745, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel(
				"\u6B22\u8FCEXX\uFF0C\u767B\u5F55HR\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_1.add(lblNewLabel);

		// 扩展功能
		if (AllObj.user != null) {
			lblNewLabel.setText(String.format("欢迎%s，登录HR管理系统！",
					AllObj.user.getUname()));
		}
	}
}
