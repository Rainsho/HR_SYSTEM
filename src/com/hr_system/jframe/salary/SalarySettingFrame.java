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
import com.hr_system.bean.SalaryBean;
import com.hr_system.util.AllObj;
import javax.swing.JTable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		// Ԥ���˵�λ��****
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
		// Ԥ���˵�λ��****
		// Ԥ������λ��****
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "н������",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// Ԥ������λ��****

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

		JButton btnNewButton = new JButton("����");
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

		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// table.add(new int[]{1,2,3});
			}
		});
		panel_2.add(button);

		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					System.out.println("δѡ����Ҫ�޸ĵ���Ϣ");
					return;
				}
				if (table.getValueAt(row, 3).toString().equals("��ʽ��н")) {
					System.out.println("��ʽ��н���ݲ����޸�");
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
						System.out.println("ֻ����������");
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 745, 245);
		panel_1.add(scrollPane);

		table = new JTable();
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
						System.out.println("ʱ�䲻�Ϸ�");
						table.setValueAt(sdf.format(new Date()), row, col);
						return;
					}
					try {
						sdf.parse(str);
					} catch (ParseException e) {
						System.out.println("ʱ�䲻�Ϸ�");
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
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);

		// ����table���ݾ���
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		table2.setDefaultRenderer(Object.class, tcr);
		// ��̬����
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}
		for (String x : AllObj.depname.values()) {
			comboBox_dep.addItem(x);
		}
		if (AllObj.appname.size() == 0) {
			Salary.load();
		}
		// ��������״̬
		for (int x : new int[] { 5, 2, 3, 6, 7, 8 }) {
			comboBox_app.addItem(AllObj.appname.get(x));
		}
		// ���ر������
		Salary.up_table(table);
		Salary.up_table2(table2);

	}
}
