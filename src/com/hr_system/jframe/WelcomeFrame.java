package com.hr_system.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import com.hr_system.action.Welcome;
import com.hr_system.util.AddMenu;
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
		// final JFrame that = this;
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

		AddMenu.menu(panel);

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
		txtpnxxxx.setEditable(false);
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

		final JLabel lblNewLabel_1 = new JLabel("");
		panel_4.add(lblNewLabel_1);
		// lblNewLabel_1.setText("");

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
		txtpnxxxx.setText(Welcome.show_info());
	}
}
