package com.hr_system.jframe.hrmange;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import com.hr_system.action.EmpManage;
import com.hr_system.util.AllObj;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpContractFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1368558700518695526L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblxnm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpContractFrame frame = new EmpContractFrame();
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
	public EmpContractFrame() {
		EmpManage.load();

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5458\u5DE5\u7BA1\u7406",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 745, 40);
		panel_1.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_2.setLayout(fl_panel_2);

		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		panel_2.add(lblNewLabel);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(8);

		JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD\uFF1A");
		panel_2.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(8);

		JLabel lblNewLabel_2 = new JLabel("\u90E8\u95E8\uFF1A");
		panel_2.add(lblNewLabel_2);

		final JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("\u804C\u52A1\uFF1A");
		panel_2.add(lblNewLabel_3);

		final JComboBox comboBox_1 = new JComboBox();
		panel_2.add(comboBox_1);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpManage.filter(textField.getText().trim(), textField_1
						.getText().trim(), comboBox.getSelectedItem()
						.toString(), comboBox_1.getSelectedItem().toString());
				EmpManage.up_table(table, 0,
						Math.min(10, AllObj.user_show.size()) - 1);
				EmpManage.up_label(lblxnm);
			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u65B0\u589E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllObj.jtb = table;
				AllObj.jlb = lblxnm;
				new EmpRegistFrame().setVisible(true);
			}
		});
		panel_2.add(btnNewButton_1);

		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					System.out.println("没有选择需要修改的记录！");
					return;
				}
				AllObj.jtb = table;
				AllObj.jlb = lblxnm;
				new EmpModifyFrame(AllObj.user_show.get(10 * AllObj.page + row))
						.setVisible(true);
			}
		});
		panel_2.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 745, 240);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new String[] { "ID", "姓名", "密码",
				"部门", "职务", "性别", "电话" }, 0));
		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setBounds(10, 325, 745, 40);
		panel_1.add(panel_3);

		JButton btnNewButton_2 = new JButton("\u4E0A\u4E00\u9875");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (--AllObj.page < 0) {
					AllObj.page = (int) Math.ceil(AllObj.user_show.size() / 10.0) - 1;
				}
				EmpManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.user_show.size() - 1));
				EmpManage.up_label(lblxnm);
			}
		});
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (++AllObj.page > Math.ceil(AllObj.user_show.size() / 10.0) - 1) {
					AllObj.page = 0;
				}
				EmpManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.user_show.size() - 1));
				EmpManage.up_label(lblxnm);
			}
		});
		panel_3.add(btnNewButton_3);

		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(4);

		JButton btnGo = new JButton("go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().trim().equals("")) {
					return;
				}
				int x = Integer.parseInt(textField_2.getText().trim());
				if (x < 1 || x > Math.ceil(AllObj.user_show.size() / 10.0)) {
					return;
				}
				AllObj.page = x - 1;
				EmpManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.user_show.size() - 1));
				EmpManage.up_label(lblxnm);
			}
		});
		panel_3.add(btnGo);

		lblxnm = new JLabel();
		panel_3.add(lblxnm);

		// 动态加载
		for (String x : AllObj.depname.values()) {
			comboBox.addItem(x);
		}
		for (String x : AllObj.rankname.values()) {
			comboBox_1.addItem(x);
		}
		for (int i = 0; i < Math.min(10, AllObj.user_show.size()); i++) {
			((DefaultTableModel) table.getModel()).addRow(EmpManage
					.E2V(AllObj.user_show.get(i)));
		}
		EmpManage.up_label(lblxnm);
		// 扩展功能
	}
}
