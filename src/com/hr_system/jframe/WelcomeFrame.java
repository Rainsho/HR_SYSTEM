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
import com.hr_system.jframe.forum.ForumFrame;
import com.hr_system.jframe.hrmange.ContractManageFrame;
import com.hr_system.jframe.hrmange.EmpManageFrame;
import com.hr_system.jframe.hrmange.EmpRegistFrame;
import com.hr_system.jframe.recruitment.CandiFrame;
import com.hr_system.jframe.recruitment.RecruFrame;
import com.hr_system.jframe.salary.SalaryQueryFrame;
import com.hr_system.jframe.salary.SalarySettingFrame;
import com.hr_system.jframe.training.TrainingApplyFrame;
import com.hr_system.jframe.training.TrainingCheckFrame;
import com.hr_system.jframe.training.TrainingEvaluateFrame;
import com.hr_system.jframe.training.TrainingFeedbackFrame;
import com.hr_system.jframe.training.TrainingPlanFrame;
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

		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u4EBA\u4E8B\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// that.dispose();
				new EmpManageFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u6CE8\u518C\u7528\u6237");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// that.dispose();
				new EmpRegistFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u4EBA\u4E8B\u53D8\u52A8");
		menuItem_2.setEnabled(false);
		mnNewMenu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("\u5408\u540C\u7BA1\u7406");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ContractManageFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_3);

		JMenu mnNewMenu_1 = new JMenu("\u57F9\u8BAD\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);

		JMenuItem menuItem_4 = new JMenuItem("\u57F9\u8BAD\u8BA1\u5212");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TrainingPlanFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u57F9\u8BAD\u7533\u8BF7");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TrainingApplyFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_5);

		JMenuItem menuItem_13 = new JMenuItem("\u7533\u8BF7\u5BA1\u6838");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingCheckFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_13);

		JMenuItem menuItem_6 = new JMenuItem("\u57F9\u8BAD\u8BC4\u4EF7");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingEvaluateFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("\u57F9\u8BAD\u53CD\u9988");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingFeedbackFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_7);

		JMenu mnNewMenu_2 = new JMenu("\u85AA\u916C\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItem_8 = new JMenuItem("\u85AA\u916C\u8BBE\u7F6E");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalarySettingFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_8);

		JMenuItem menuItem_14 = new JMenuItem("\u85AA\u916C\u5BA1\u6838");
		menuItem_14.setEnabled(false);
		mnNewMenu_2.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("\u85AA\u916C\u5BA1\u6279");
		menuItem_15.setEnabled(false);
		mnNewMenu_2.add(menuItem_15);

		JMenuItem menuItem_9 = new JMenuItem("\u85AA\u916C\u67E5\u8BE2");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryQueryFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_9);

		JMenu mnNewMenu_3 = new JMenu("\u62DB\u8058\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);

		JMenuItem menuItem_10 = new JMenuItem("\u62DB\u8058\u4FE1\u606F");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecruFrame().setVisible(true);
			}
		});
		mnNewMenu_3.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("\u5E94\u8058\u4FE1\u606F");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CandiFrame().setVisible(true);
			}
		});
		mnNewMenu_3.add(menuItem_11);

		JMenu mnNewMenu_4 = new JMenu("\u516C\u544A\u7BA1\u7406");
		menuBar.add(mnNewMenu_4);

		JMenuItem menuItem_12 = new JMenuItem("\u7CFB\u7EDF\u516C\u544A");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForumFrame().setVisible(true);
			}
		});
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
