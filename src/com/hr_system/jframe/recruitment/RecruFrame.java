package com.hr_system.jframe.recruitment;

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
import javax.swing.JTextPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Recru;
import com.hr_system.action.Training;
import com.hr_system.bean.RecruBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.Tools;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import java.awt.Color;

public class RecruFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField t_recid;
	private JTextField t_recname;
	private JTextField t_recquant;
	private JTextField t_recstartdate;
	private JTextField t_recstopdate;
	private JTextPane t_recinfo;
	private JPanel panel_4;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecruFrame frame = new RecruFrame();
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
	public RecruFrame() {

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
		// 预留内容位置****
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "招聘信息",
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

		JLabel lblNewLabel = new JLabel("\u62DB\u8058\u90E8\u95E8\uFF1A");
		panel_2.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5168\u90E8" }));
		panel_2.add(comboBox);

		JButton btnNewButton = new JButton("检索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// to be done
			}
		});

		JLabel label_5 = new JLabel("\u62DB\u8058\u804C\u4F4D\uFF1A");
		panel_2.add(label_5);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "\u5168\u90E8" }));
		panel_2.add(comboBox_1);
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 75, 745, 290);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 180, 278);
		panel_3.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1
						|| table.getSelectedColumn() == -1) {
					return;
				}
				// 清空jtextfield
				Training.clearpanel(panel_4);
				t_recinfo.setText("");// 不在panel_4
				RecruBean obj = AllObj.recr_show.get(table.getSelectedRow());
				comboBox_2.setSelectedItem(AllObj.depname.get(obj.getDepid()));
				comboBox_3.setSelectedItem(AllObj.rankname.get(obj.getRankid()));
				t_recid.setText(obj.getRecid() + "");
				t_recname.setText(obj.getRecname());
				t_recquant.setText(obj.getRecquant() + "");
				t_recstartdate.setText(obj.getRecstartdate());
				t_recstopdate.setText(obj.getRecstopdate());
				t_recinfo.setText(obj.getRecinfo());
			}
		});
		scrollPane.setViewportView(table);

		panel_4 = new JPanel();
		panel_4.setBounds(198, 6, 541, 278);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel label = new JLabel("\u62DB\u8058\u7F16\u53F7\uFF1A");
		label.setBounds(20, 12, 70, 16);
		panel_4.add(label);

		t_recid = new JTextField();
		t_recid.setEditable(false);
		t_recid.setBounds(94, 6, 80, 28);
		panel_4.add(t_recid);
		t_recid.setColumns(10);

		JLabel label_1 = new JLabel("\u62DB\u8058\u90E8\u95E8\uFF1A");
		label_1.setBounds(194, 12, 70, 16);
		panel_4.add(label_1);

		JLabel label_2 = new JLabel("\u62DB\u8058\u804C\u4F4D\uFF1A");
		label_2.setBounds(368, 12, 70, 16);
		panel_4.add(label_2);

		JLabel label_3 = new JLabel("\u62DB\u8058\u6807\u9898\uFF1A");
		label_3.setBounds(20, 49, 70, 16);
		panel_4.add(label_3);

		t_recname = new JTextField();
		t_recname.setColumns(10);
		t_recname.setBounds(94, 44, 140, 28);
		panel_4.add(t_recname);

		JLabel label_6 = new JLabel("\u57F9\u8BAD\u6570\u91CF\uFF1A");
		label_6.setBounds(308, 46, 70, 16);
		panel_4.add(label_6);

		t_recquant = new JTextField();
		t_recquant.setColumns(10);
		t_recquant.setBounds(382, 44, 140, 28);
		panel_4.add(t_recquant);

		JLabel label_7 = new JLabel("\u8D77\u59CB\u65F6\u95F4\uFF1A");
		label_7.setBounds(20, 85, 70, 16);
		panel_4.add(label_7);

		t_recstartdate = new JTextField();
		t_recstartdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				// 检查日期合法性
				if (Tools.checkdate(t_recstartdate.getText().trim()) == null) {
					t_recstartdate.setText(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date()));
				} else {
					t_recstartdate.setText(Tools.checkdate(t_recstartdate
							.getText().trim()));
				}
			}
		});
		t_recstartdate.setColumns(10);
		t_recstartdate.setBounds(94, 80, 140, 28);
		panel_4.add(t_recstartdate);

		JLabel label_9 = new JLabel("\u622A\u6B62\u65E5\u671F\uFF1A");
		label_9.setBounds(308, 85, 70, 16);
		panel_4.add(label_9);

		t_recstopdate = new JTextField();
		t_recstopdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				// 检查日期合法性
				if (Tools.checkdate(t_recstopdate.getText().trim()) == null) {
					t_recstopdate.setText(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date()));
				} else {
					t_recstopdate.setText(Tools.checkdate(t_recstopdate
							.getText().trim()));
				}
			}
		});
		t_recstopdate.setColumns(10);
		t_recstopdate.setBounds(382, 80, 140, 28);
		panel_4.add(t_recstopdate);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u62DB\u8058\u4FE1\u606F",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_5.setBounds(20, 122, 328, 150);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		t_recinfo = new JTextPane();
		panel_5.add(t_recinfo);

		final JButton button_1 = new JButton(
				"\u65B0\u589E\u62DB\u8058\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// to be done
			}
		});
		button_1.setBounds(388, 174, 117, 29);
		panel_4.add(button_1);

		final JButton button_2 = new JButton(
				"\u4FEE\u6539\u62DB\u8058\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// to be done
				int row = table.getSelectedRow();
				if (row == -1) {
					System.out.println("未选择要删除的培训计划");
					return;
				}
				Training.delete(AllObj.trin_show.get(row));
				Training.up_table(table);
			}
		});
		button_2.setBounds(388, 220, 117, 29);
		panel_4.add(button_2);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(268, 7, 80, 27);
		panel_4.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(442, 7, 80, 27);
		panel_4.add(comboBox_3);

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
			comboBox_2.addItem(x);
		}
		for (String x : AllObj.rankname.values()) {
			comboBox_1.addItem(x);
			comboBox_3.addItem(x);
		}
		Recru.load();
		Recru.up_table(table);
	}
}
