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

import com.hr_system.action.ContractManage;
import com.hr_system.util.AllObj;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractManageFrame extends JFrame {

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
					ContractManageFrame frame = new ContractManageFrame();
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
	public ContractManageFrame() {
		ContractManage.load();

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "\u5408\u540C\u7BA1\u7406",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 745, 40);
		panel_1.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_2.setLayout(fl_panel_2);

		JLabel lblNewLabel = new JLabel("\u5408\u540C\u540D\u79F0\uFF1A");
		panel_2.add(lblNewLabel);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(8);

		JLabel lblNewLabel_1 = new JLabel("\u5408\u540C\u6027\u8D28\uFF1A");
		panel_2.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(8);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractManage.filter(textField.getText().trim(), textField_1
						.getText().trim());
				ContractManage.up_table(table, 0,
						Math.min(10, AllObj.cont_show.size()) - 1);
				ContractManage.up_label(lblxnm);
			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u5408\u540C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllObj.jtb = table;
				AllObj.jlb = lblxnm;
				new ContractRegistFrame().setVisible(true);
			}
		});
		panel_2.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 745, 240);
		panel_1.add(scrollPane);

		table = new JTable();
		table.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				if (col == 4) {
					String str = String.valueOf(table.getValueAt(row, col))
							.trim();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if (!str.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
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
				table.setValueAt("双击更新", row, 8);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int col = table.getSelectedColumn();
					int row = table.getSelectedRow();
					if (col == 8 && table.getValueAt(row, col).equals("双击更新")) {
						AllObj.jtb = table;
						AllObj.jlb = lblxnm;
						String conname = table.getValueAt(row, 3).toString();
						String condate = table.getValueAt(row, 4).toString();
						int conyear = Integer.parseInt(table.getValueAt(row, 5)
								.toString());
						String contype = table.getValueAt(row, 6).toString();
						String coninfo = table.getValueAt(row, 7).toString();
						ContractManage.update(
								AllObj.cont_show.get(10 * AllObj.page + row),
								conname, condate, conyear, contype, coninfo);
						ContractManage.up_table(
								AllObj.jtb,
								AllObj.page * 10,
								Math.min(AllObj.page * 10 + 9,
										AllObj.cont_show.size() - 1));
						ContractManage.up_label(AllObj.jlb);
					}
					if (col == 9) {
						AllObj.jtb = table;
						AllObj.jlb = lblxnm;
						ContractManage.delete(AllObj.cont_show.get(10
								* AllObj.page + row));
						ContractManage.up_table(
								AllObj.jtb,
								AllObj.page * 10,
								Math.min(AllObj.page * 10 + 9,
										AllObj.cont_show.size() - 1));
						ContractManage.up_label(AllObj.jlb);
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new String[] { "合同编号", "合同持有人",
				"持有人部门", "合同名称", "签约时间", "合同年限", "合同性质", "合同内容", "编辑", "删除" },
				0));
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
					AllObj.page = (int) Math.ceil(AllObj.cont_show.size() / 10.0) - 1;
				}
				ContractManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.cont_show.size() - 1));
				ContractManage.up_label(lblxnm);
			}
		});
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u4E0B\u4E00\u9875");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (++AllObj.page > Math.ceil(AllObj.cont_show.size() / 10.0) - 1) {
					AllObj.page = 0;
				}
				ContractManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.cont_show.size() - 1));
				ContractManage.up_label(lblxnm);
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
				if (x < 1 || x > Math.ceil(AllObj.cont_show.size() / 10.0)) {
					return;
				}
				AllObj.page = x - 1;
				ContractManage.up_table(table, AllObj.page * 10, Math.min(
						AllObj.page * 10 + 9, AllObj.cont_show.size() - 1));
				ContractManage.up_label(lblxnm);
			}
		});
		panel_3.add(btnGo);

		lblxnm = new JLabel();
		panel_3.add(lblxnm);

		// 动态加载
		ContractManage.up_table(table, 0,
				Math.min(10, AllObj.cont_show.size()) - 1);
		ContractManage.up_label(lblxnm);
		// 扩展功能
	}
}
