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
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Salary;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.bean.SalaryBean;
import com.hr_system.util.AddMenu;
import com.hr_system.util.AllObj;
import com.hr_system.util.SelectUserFrame;

import javax.swing.JTable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalarySettingFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5737109390221736809L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalarySettingFrame frame = new SalarySettingFrame();
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
	public SalarySettingFrame() {

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
				EtchedBorder.LOWERED, null, null), "薪酬设置",
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
				Salary.up_table(table);
			}
		});

		JLabel label = new JLabel("\u6708\u4EFD\uFF1A");
		panel_2.add(label);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(6);
		panel_2.add(btnNewButton);

		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					System.out.println("未选中需要修改的信息");
					return;
				}
				if (table.getValueAt(row, 3).toString().equals("正式定薪")) {
					System.out.println("正式定薪数据不可修改");
					Salary.up_table(table);
					return;
				}
				SalaryBean obj = AllObj.sala_show.get(row);
				int[] int2up = new int[7];
				for (int i = 0; i < int2up.length; i++) {
					try {
						int2up[i] = Integer.parseInt(table
								.getValueAt(row, i + 4).toString().trim());
					} catch (NumberFormatException e2) {
						System.out.println("只能输入整数");
						Salary.up_table(table);
						return;
					}
				}
				String saldate = table.getValueAt(row, 11).toString().trim();
				Salary.update(obj, int2up, saldate);
				Salary.up_table(table);
			}
		});
		panel_2.add(button_1);

		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((Boolean) table2.getValueAt(0, 0)) {
					int[] int_sala = new int[7];
					try {
						for (int i = 0; i < int_sala.length; i++) {
							if (table2.getValueAt(0, i + 3) == null) {
								int_sala[i] = 0;
							} else {
								int_sala[i] = Integer.parseInt(table2
										.getValueAt(0, i + 3).toString());
							}
						}
					} catch (NumberFormatException e2) {
						System.out.println("工资数据只能输入整形");
						return;
					}
					if (table2.getValueAt(0, 10) == null) {
						return;
					}
					String saldate = table2.getValueAt(0, 10).toString();
					EmployeeBean obj = null;
					for (EmployeeBean x : AllObj.user_list) {
						if (x.getUname().equals(
								table2.getValueAt(0, 2).toString())) {
							obj = x;
							break;
						}
					}
					for (SalaryBean x : AllObj.sala_list) {
						if (x.getUid() == obj.getUid()
								&& x.getSaldate().equals(saldate)) {
							System.out.println("该员工已设置该月份薪资数据");
							return;
						}
					}
					Salary.add(obj, int_sala, saldate);
					Salary.up_table(table);
				} else {
					return;
				}
			}
		});
		panel_2.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 745, 245);
		panel_1.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				for (int i = 1; i < 3; i++) {
					table2.setValueAt(table.getValueAt(row, i), 0, i);
				}
				for (int i = 3; i < 10; i++) {
					table2.setValueAt(table.getValueAt(row, i + 1), 0, i);
				}
				// 新增栏，默认为当前选择项的下一个月
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String cur_month = table.getValueAt(row, 11).toString();
				Calendar cal = Calendar.getInstance();
				cal.set(Integer.parseInt(cur_month.substring(0, 4)),
						Integer.parseInt(cur_month.substring(5, 7)), 1);
				table2.setValueAt(sdf.format(cal.getTime()), 0, 10);
			}
		});
		table.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				if (col == 11) {
					String str = String.valueOf(table.getValueAt(row, col))
							.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
					if (!str.matches("^\\d{4}-\\d{2}$")) {
						System.out.println("时间不合法");
						table.setValueAt(sdf.format(new Date()), row, col);
						return;
					}
					try {
						sdf.parse(str);
					} catch (ParseException e) {
						System.out.println("时间不合法");
						table.setValueAt(sdf.format(new Date()), row, col);
						return;
					}
					try {
						table.setValueAt(sdf.format(sdf.parse(str)), row, col);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		});
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 330, 745, 40);
		panel_1.add(scrollPane_1);
		// table2
		String[] col = new String[] { "新增", "员工部门", "员工姓名", "基本工资", "住房公积金",
				"基本养老", "健康保险", "失业保险", "报销款", "绩效奖", "月份" };
		DefaultTableModel model = new DefaultTableModel(col, 1) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 1 || col == 2) {
					return false;
				} else {
					return true;
				}
			}
		};
		table2 = new JTable(model) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public Class getColumnClass(int col) {
				if (col == 0) {
					return Boolean.class;
				} else {
					return String.class;
				}
			}
		};
		table2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				int col = table2.getSelectedColumn();
				int row = table2.getSelectedRow();
				if (col == -1 || row == -1
						|| table2.getValueAt(row, col) == null) {
					return;
				}
				if (col == 10) {
					String str = table2.getValueAt(row, col).toString().trim();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
					if (!str.matches("^\\d{4}-\\d{2}$")) {
						System.out.println("时间不合法");
						table2.setValueAt(sdf.format(new Date()), row, col);
						return;
					}
					try {
						sdf.parse(str);
					} catch (ParseException e) {
						System.out.println("时间不合法");
						table2.setValueAt(sdf.format(new Date()), row, col);
						return;
					}
					try {
						table2.setValueAt(sdf.format(sdf.parse(str)), row, col);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		});
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table2.getSelectedColumn();
				if (col == 2) {
					AllObj.user_selected = null;
					new SelectUserFrame(table2).setVisible(true);
				}
			}
		});
		table2.setPreferredScrollableViewportSize(table2.getPreferredSize());
		table2.setValueAt(false, 0, 0);
		scrollPane_1.setViewportView(table2);

		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		table2.setDefaultRenderer(Object.class, tcr);
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
		String appname = comboBox_app.getSelectedItem().toString().trim();
		String depname = comboBox_dep.getSelectedItem().toString().trim();
		String uname = textField.getText().trim();
		String saldate = textField_1.getText().trim();
		Salary.filter(appname, depname, uname, saldate);
		Salary.up_table(table);
	}
}
