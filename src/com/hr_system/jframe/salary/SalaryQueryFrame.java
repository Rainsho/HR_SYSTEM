package com.hr_system.jframe.salary;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Salary;
import com.hr_system.util.AddMenu;
import com.hr_system.util.AllObj;

import javax.swing.JTable;

public class SalaryQueryFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5737109390221736809L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryQueryFrame frame = new SalaryQueryFrame();
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
	public SalaryQueryFrame() {

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
				EtchedBorder.LOWERED, null, null), "薪酬查询",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// 预留内容位置****
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 745, 40);
		panel_1.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_2.setLayout(fl_panel_2);

		JLabel label_5 = new JLabel("\u85AA\u916C\u72B6\u6001\uFF1A");
		panel_2.add(label_5);

		final JComboBox comboBox_app = new JComboBox();
		comboBox_app.setModel(new DefaultComboBoxModel(
				new String[] { "\u5168\u90E8" }));
		panel_2.add(comboBox_app);

		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\uFF1A");
		panel_2.add(lblNewLabel);

		final JComboBox comboBox_dep = new JComboBox();
		comboBox_dep.setModel(new DefaultComboBoxModel(
				new String[] { "\u5168\u90E8" }));
		panel_2.add(comboBox_dep);

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(6);

		JButton btnNewButton = new JButton("检索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String appname = comboBox_app.getSelectedItem().toString()
						.trim();
				String depname = comboBox_dep.getSelectedItem().toString()
						.trim();
				String uname = textField.getText().trim();
				String saldate = textField_1.getText().trim();
				Salary.filter(appname, depname, uname, saldate);
				Salary.up_table_q(table);
			}
		});

		JLabel label = new JLabel("\u6708\u4EFD\uFF1A");
		panel_2.add(label);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(6);
		panel_2.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 745, 295);
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
			comboBox_dep.addItem(x);
		}
		if (AllObj.appname.size() == 0 || AllObj.sala_list.size() == 0) {
			Salary.load();
		}
		// 加载申请状态
		for (int x : new int[] { 5, 2, 3, 6, 7, 8 }) {
			comboBox_app.addItem(AllObj.appname.get(x));
		}
		// 加载表格内容，加入身份区分后，在初始化时进行一次过滤
		// 普通用户
		if (AllObj.user != null) {
			if (AllObj.user.getPerid() == 3 && AllObj.user.getDepid() != 3) {
				comboBox_dep.setSelectedItem(AllObj.depname.get(AllObj.user
						.getDepid()));
				comboBox_dep.setEnabled(false);
				textField.setText(AllObj.user.getUname());
				textField.setEnabled(false);
			}
		}
		String appname = comboBox_app.getSelectedItem().toString().trim();
		String depname = comboBox_dep.getSelectedItem().toString().trim();
		String uname = textField.getText().trim();
		String saldate = textField_1.getText().trim();
		Salary.filter(appname, depname, uname, saldate);
		Salary.up_table_q(table);
	}
}
