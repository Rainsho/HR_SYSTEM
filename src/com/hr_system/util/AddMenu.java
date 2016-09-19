package com.hr_system.util;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import com.hr_system.jframe.forum.ForumFrame;
import com.hr_system.jframe.hrmange.ContractManageFrame;
import com.hr_system.jframe.hrmange.EmpManageFrame;
import com.hr_system.jframe.hrmange.EmpModifyFrame;
import com.hr_system.jframe.hrmange.EmpRegistFrame;
import com.hr_system.jframe.recruitment.CandiFrame;
import com.hr_system.jframe.recruitment.RecruFrame;
import com.hr_system.jframe.salary.SalaryCheckFrame;
import com.hr_system.jframe.salary.SalaryFinalFrame;
import com.hr_system.jframe.salary.SalaryQueryFrame;
import com.hr_system.jframe.salary.SalarySettingFrame;
import com.hr_system.jframe.training.TrainingApplyFrame;
import com.hr_system.jframe.training.TrainingCheckFrame;
import com.hr_system.jframe.training.TrainingEvaluateFrame;
import com.hr_system.jframe.training.TrainingFeedbackFrame;
import com.hr_system.jframe.training.TrainingPlanFrame;

public class AddMenu {
	public static void menu(JPanel panel) {

		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u4EBA\u4E8B\u7BA1\u7406");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpManageFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u6CE8\u518C\u7528\u6237");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpRegistFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("\u4EBA\u4E8B\u53D8\u52A8");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (AllObj.user == null) {
					System.out.println("请先登陆，或者在员工管理窗口选择要修改的员工信息");
					return;
				}
				new EmpModifyFrame(AllObj.user).setVisible(true);
			}
		});
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
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryCheckFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("\u85AA\u916C\u5BA1\u6279");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryFinalFrame().setVisible(true);
			}
		});
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
	}
}
