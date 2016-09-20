package com.hr_system.jframe.training;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Salary;
import com.hr_system.action.Training;
import com.hr_system.action.TrainingCheck;
import com.hr_system.bean.TrainingApplyBean;
import com.hr_system.util.AddMenu;
import com.hr_system.util.AllObj;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainingCheckFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingCheckFrame frame = new TrainingCheckFrame();
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
	public TrainingCheckFrame() {

		// 预留菜单位置****
		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		// 预留菜单位置****

		AddMenu.menu(panel);

		// 预留内容位置****
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "申请审核",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// 预留内容位置****
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 745, 70);
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblNewLabel = new JLabel("培训部门：");
		panel_2.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		comboBox.addItem("全部");

		JLabel label_5 = new JLabel("\u7533\u8BF7\u72B6\u6001\uFF1A");
		panel_2.add(label_5);

		final JComboBox comboBox_2 = new JComboBox();
		panel_2.add(comboBox_2);
		comboBox_2.addItem("全部");

		JLabel lblNewLabel_1 = new JLabel("培训主题：");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(6);

		JLabel label_11 = new JLabel("\u7533\u8BF7\u4EBA\uFF1A");
		panel_2.add(label_11);

		textField_1 = new JTextField();
		textField_1.setColumns(6);
		panel_2.add(textField_1);

		JButton button = new JButton("检索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String depname = comboBox.getSelectedItem().toString().trim();
				String appname = comboBox_2.getSelectedItem().toString().trim();
				String trpname = textField.getText().trim();
				String uname = textField_1.getText().trim();
				TrainingCheck.filter(depname, appname, trpname, uname);
				TrainingCheck.up_table(table);
			}
		});
		panel_2.add(button);

		final JButton button_1 = new JButton("\u5BA1\u6838\u901A\u8FC7");
		panel_2.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1
						|| table.getSelectedColumn() == -1) {
					System.out.println("未选择要审批的申请");
					return;
				}
				TrainingApplyBean obj = AllObj.tria_tc_show.get(table
						.getSelectedRow());
				TrainingCheck.update(obj, 2);
				TrainingCheck.up_table(table);
			}
		});

		final JButton button_2 = new JButton("\u5BA1\u6838\u4E0D\u901A\u8FC7");
		panel_2.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1
						|| table.getSelectedColumn() == -1) {
					System.out.println("未选择要审批的申请");
					return;
				}
				TrainingApplyBean obj = AllObj.tria_tc_show.get(table
						.getSelectedRow());
				TrainingCheck.update(obj, 3);
				TrainingCheck.up_table(table);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 745, 265);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		// 动态加载
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}

		for (String x : AllObj.depname.values()) {
			comboBox.addItem(x);
		}
		// 加载申请状态
		if (AllObj.appname.size() == 0) {
			Training.load();
		}
		for (Integer x : AllObj.appname.keySet()) {
			if (x <= 3) {
				comboBox_2.addItem(AllObj.appname.get(x));
			}
		}
		// load
		Salary.load();
		TrainingCheck.load();
		TrainingCheck.up_table(table);
	}
}
