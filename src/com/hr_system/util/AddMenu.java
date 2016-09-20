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

		JMenu mnNewMenu = new JMenu("人事管理");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("员工管理");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpManageFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("注册用户");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpRegistFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("人事变动");
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

		JMenuItem menuItem_3 = new JMenuItem("合同管理");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ContractManageFrame().setVisible(true);
			}
		});
		mnNewMenu.add(menuItem_3);

		JMenu mnNewMenu_1 = new JMenu("培训管理");
		menuBar.add(mnNewMenu_1);

		JMenuItem menuItem_4 = new JMenuItem("培训计划");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TrainingPlanFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("培训申请");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TrainingApplyFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_5);

		JMenuItem menuItem_13 = new JMenuItem("培训审核");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingCheckFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_13);

		JMenuItem menuItem_6 = new JMenuItem("培训评估");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingEvaluateFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("培训反馈");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrainingFeedbackFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(menuItem_7);

		JMenu mnNewMenu_2 = new JMenu("薪酬管理");
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItem_8 = new JMenuItem("薪酬设置");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalarySettingFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_8);

		JMenuItem menuItem_14 = new JMenuItem("薪酬审核");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryCheckFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_14);

		JMenuItem menuItem_15 = new JMenuItem("薪酬审批");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryFinalFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_15);

		JMenuItem menuItem_9 = new JMenuItem("薪酬查询");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SalaryQueryFrame().setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_9);

		JMenu mnNewMenu_3 = new JMenu("招聘管理");
		menuBar.add(mnNewMenu_3);

		JMenuItem menuItem_10 = new JMenuItem("招聘信息");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecruFrame().setVisible(true);
			}
		});
		mnNewMenu_3.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("应聘信息");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CandiFrame().setVisible(true);
			}
		});
		mnNewMenu_3.add(menuItem_11);

		JMenu mnNewMenu_4 = new JMenu("公告管理");
		menuBar.add(mnNewMenu_4);

		JMenuItem menuItem_12 = new JMenuItem("系统公告");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForumFrame().setVisible(true);
			}
		});
		mnNewMenu_4.add(menuItem_12);

		// 权限分配，to be done...
		if (AllObj.user != null) {
			// 非管理员及人事部ban掉人事管理、薪酬设置、审批、审核
			if (AllObj.user.getPerid() != 1 && AllObj.user.getDepid() != 3) {
				mnNewMenu.setEnabled(false);
				menuItem_8.setEnabled(false);
				menuItem_14.setEnabled(false);
				menuItem_15.setEnabled(false);
			}
			// 人事部经理审核薪资，总经理审批薪资
			if (AllObj.user.getDepid() == 3) {
				switch (AllObj.user.getRankid()) {
				case 1:
					menuItem_14.setEnabled(false);
					break;
				case 2:
					menuItem_15.setEnabled(false);
					break;
				default:
					menuItem_14.setEnabled(false);
					menuItem_15.setEnabled(false);
					break;
				}
			}
			// 普通用户ban掉培训计划、审核、评价
			if (AllObj.user.getPerid() == 3) {
				menuItem_4.setEnabled(false);
				menuItem_13.setEnabled(false);
				menuItem_6.setEnabled(false);
			}
		}
	}
}
