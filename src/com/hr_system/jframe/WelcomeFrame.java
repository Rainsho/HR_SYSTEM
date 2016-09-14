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

import com.hr_system.action.Welcome;
import com.hr_system.jframe.hrmange.EmpMangeFrame;
import com.hr_system.jframe.hrmange.EmpRegistFrame;
import com.hr_system.util.AllObj;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;

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
		final JFrame that = this;
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
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
				new EmpMangeFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u6CE8\u518C\u7528\u6237");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
				new EmpRegistFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u4EBA\u4E8B\u53D8\u52A8");
		mnNewMenu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("\u5408\u540C\u7BA1\u7406");
		mnNewMenu.add(menuItem_3);

		JMenu mnNewMenu_1 = new JMenu("\u57F9\u8BAD\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);

		JMenuItem menuItem_4 = new JMenuItem("\u57F9\u8BAD\u8BA1\u5212");
		mnNewMenu_1.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u57F9\u8BAD\u7533\u8BF7");
		mnNewMenu_1.add(menuItem_5);

		JMenuItem menuItem_6 = new JMenuItem("\u57F9\u8BAD\u8BC4\u4EF7");
		mnNewMenu_1.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("\u57F9\u8BAD\u53CD\u9988");
		mnNewMenu_1.add(menuItem_7);

		JMenu mnNewMenu_2 = new JMenu("\u85AA\u916C\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItem_8 = new JMenuItem("\u85AA\u916C\u8BBE\u7F6E");
		mnNewMenu_2.add(menuItem_8);

		JMenuItem menuItem_9 = new JMenuItem("\u85AA\u916C\u67E5\u8BE2");
		mnNewMenu_2.add(menuItem_9);

		JMenu mnNewMenu_3 = new JMenu("\u62DB\u8058\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);

		JMenuItem menuItem_10 = new JMenuItem("\u62DB\u8058\u4FE1\u606F");
		mnNewMenu_3.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("\u5E94\u8058\u4FE1\u606F");
		mnNewMenu_3.add(menuItem_11);

		JMenu mnNewMenu_4 = new JMenu("\u516C\u544A\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);

		JMenuItem menuItem_12 = new JMenuItem("\u7CFB\u7EDF\u516C\u544A");
		mnNewMenu_4.add(menuItem_12);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 60, 745, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel(
				"\u6B22\u8FCEXX\uFF0C\u767B\u5F55HR\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 36));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u7CFB\u7EDF\u516C\u544A",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(20, 120, 745, 200);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JTextPane txtpnxxxx = new JTextPane();
		txtpnxxxx
				.setText("[\u516C\u544A\u7CFB\u7EDF\u5B8C\u6210\u540E\uFF0C\u6309\u5982\u4E0B\u683C\u5F0F\u663E\u793A\u901A\u77E5]\r\n\u516C\u544A\u6807\u9898\uFF1AXXXX\u53BB\u6B7B\r\n\u53D1\u5E03\u65F6\u95F4\uFF1A2016\u5E749\u670811\u65E5  09\u65F655\u5206\r\n\u516C\u544A\u6B63\u6587\uFF1AXXXX\u53BB\u6B7B\uFF0C\u5475\u5475\u5475\r\n");
		panel_2.add(txtpnxxxx);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setBounds(20, 330, 745, 60);
		contentPane.add(panel_3);

		JLabel label = new JLabel("\u5F53\u524D\u65F6\u95F4\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		panel_3.add(label);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.setBounds(20, 400, 745, 20);
		contentPane.add(panel_4);

		final JLabel lblNewLabel_1 = new JLabel(
				"\u4ECA\u5929\u5171\u6253\u5361X\u6B21\uFF0C\u5206\u522B\u4E3A\uFF1A");
		panel_4.add(lblNewLabel_1);
		//lblNewLabel_1.setText("");

		final JButton button = new JButton("\u6253\u5361");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.att(lblNewLabel_1);
				button.setEnabled(false);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		panel_3.add(button);

		// 扩展功能
		if (AllObj.user != null) {
			lblNewLabel.setText(String.format("欢迎%s，登录HR管理系统！",
					AllObj.user.getUname()));
		}
		new Thread(new Welcome(label)).start();
		// 扩展功能

	}
}
