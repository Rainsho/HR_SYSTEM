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
import javax.swing.JTextPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Training;
import com.hr_system.action.TrainingApply;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrainingApplyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField t_trpid;
	private JTextField t_trppeople;
	private JTextField t_trpname;
	private JTextField t_trpadmin;
	private JTextField t_trpfee;
	private JTextField t_trpdate;
	private JTextField t_trpmonth;
	private JTextField t_trpplace;
	private JTextPane t_trpinfo;
	private JPanel panel_4;
	protected TrainingPlanBean obj;
	private JTextField t_appname;
	private JTextField t_depname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingApplyFrame frame = new TrainingApplyFrame();
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
	public TrainingApplyFrame() {

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
				EtchedBorder.LOWERED, null, null), "\u57F9\u8BAD\u7533\u8BF7",
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

		JLabel lblNewLabel = new JLabel("培训部门：");
		panel_2.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);

		JLabel label_5 = new JLabel("\u7533\u8BF7\u72B6\u6001\uFF1A");
		panel_2.add(label_5);

		final JComboBox comboBox_2 = new JComboBox();
		panel_2.add(comboBox_2);

		JLabel lblNewLabel_1 = new JLabel("培训主题：");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(8);

		JButton btnNewButton = new JButton("检索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (AllObj.user == null) {
					System.out.println("请先登陆");
					return;
				}
				String depname = comboBox.getSelectedItem().toString().trim();
				String trpname = textField.getText().trim();
				String appname = comboBox_2.getSelectedItem().toString().trim();
				TrainingApply.filter(depname, trpname, appname);
				Training.up_table(table);
			}
		});
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
				t_trpinfo.setText("");// 不在panel_4
				// 填充jtextfield
				TrainingPlanBean obj = AllObj.trin_show.get(table
						.getSelectedRow());
				t_trpid.setText(obj.getTrpid() + "");
				t_trppeople.setText(obj.getTrppeople());
				t_trpname.setText(obj.getTrpname());
				t_trpadmin.setText(obj.getTrpadmin());
				t_trpfee.setText(obj.getTrpfee() + "");
				t_trpdate.setText(obj.getTrpdate());
				t_trpmonth.setText(obj.getTrpmonth() + "");
				t_trpplace.setText(obj.getTrpplace());
				t_trpinfo.setText(obj.getTrpinfo());
				t_depname.setText(obj.getDepname());
				if (AllObj.user == null) {
					t_appname.setText("未登陆");
				} else {
					t_appname.setText(AllObj.appname.get(AllObj.triapp.get(obj)));
				}
			}
		});
		scrollPane.setViewportView(table);

		panel_4 = new JPanel();
		panel_4.setBounds(198, 6, 541, 278);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel label = new JLabel("培训编号：");
		label.setBounds(20, 12, 70, 16);
		panel_4.add(label);

		t_trpid = new JTextField();
		t_trpid.setEditable(false);
		t_trpid.setBounds(94, 6, 80, 28);
		panel_4.add(t_trpid);
		t_trpid.setColumns(10);

		JLabel label_1 = new JLabel("培训部门：");
		label_1.setBounds(194, 12, 70, 16);
		panel_4.add(label_1);

		JLabel label_2 = new JLabel("培训对象：");
		label_2.setBounds(368, 12, 70, 16);
		panel_4.add(label_2);

		t_trppeople = new JTextField();
		t_trppeople.setEditable(false);
		t_trppeople.setColumns(10);
		t_trppeople.setBounds(442, 6, 80, 28);
		panel_4.add(t_trppeople);

		JLabel label_3 = new JLabel("\u57F9\u8BAD\u4E3B\u9898\uFF1A");
		label_3.setBounds(20, 46, 70, 16);
		panel_4.add(label_3);

		t_trpname = new JTextField();
		t_trpname.setEditable(false);
		t_trpname.setColumns(10);
		t_trpname.setBounds(94, 40, 80, 28);
		panel_4.add(t_trpname);

		JLabel label_4 = new JLabel("负责人：");
		label_4.setBounds(194, 46, 70, 16);
		panel_4.add(label_4);

		t_trpadmin = new JTextField();
		t_trpadmin.setEditable(false);
		t_trpadmin.setColumns(10);
		t_trpadmin.setBounds(268, 40, 80, 28);
		panel_4.add(t_trpadmin);

		JLabel label_6 = new JLabel("\u57F9\u8BAD\u8D39\u7528\uFF1A");
		label_6.setBounds(368, 46, 70, 16);
		panel_4.add(label_6);

		t_trpfee = new JTextField();
		t_trpfee.setEditable(false);
		t_trpfee.setColumns(10);
		t_trpfee.setBounds(442, 40, 80, 28);
		panel_4.add(t_trpfee);

		JLabel label_7 = new JLabel("\u57F9\u8BAD\u65E5\u671F\uFF1A");
		label_7.setBounds(20, 80, 70, 16);
		panel_4.add(label_7);

		t_trpdate = new JTextField();
		t_trpdate.setEditable(false);
		t_trpdate.setColumns(10);
		t_trpdate.setBounds(94, 74, 254, 28);
		panel_4.add(t_trpdate);

		JLabel label_8 = new JLabel("\u57F9\u8BAD\u6708\u65F6\uFF1A");
		label_8.setBounds(368, 80, 70, 16);
		panel_4.add(label_8);

		t_trpmonth = new JTextField();
		t_trpmonth.setEditable(false);
		t_trpmonth.setColumns(10);
		t_trpmonth.setBounds(442, 74, 80, 28);
		panel_4.add(t_trpmonth);

		JLabel label_9 = new JLabel("\u57F9\u8BAD\u5730\u70B9\uFF1A");
		label_9.setBounds(20, 114, 70, 16);
		panel_4.add(label_9);

		t_trpplace = new JTextField();
		t_trpplace.setEditable(false);
		t_trpplace.setColumns(10);
		t_trpplace.setBounds(94, 108, 254, 28);
		panel_4.add(t_trpplace);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u57F9\u8BAD\u5185\u5BB9",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(20, 142, 328, 130);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		t_trpinfo = new JTextPane();
		t_trpinfo.setEditable(false);
		panel_5.add(t_trpinfo);

		final JButton button_1 = new JButton("\u7533\u8BF7\u57F9\u8BAD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AllObj.user == null) {
					System.out.println("请先登陆");
					return;// 下次直接disable掉
				}
				String str = t_appname.getText().trim();
				if (str.equals("")) {
					System.out.println("请选择欲申请的培训");
					return;
				}
				if (!str.equals("未申请")) {
					System.out.println("已申请，请等待审核");
					return;
				}
				// 后台处理
				TrainingPlanBean obj = AllObj.trin_show.get(table
						.getSelectedRow());
				if (AllObj.trp_in.keySet().contains(obj.getTrpid())) {
					TrainingApply.update(obj, 1);
				} else {
					TrainingApply.add(obj);
				}
				t_appname.setText("已申请");
			}
		});
		button_1.setBounds(388, 191, 117, 29);
		panel_4.add(button_1);

		final JButton button_2 = new JButton("\u53D6\u6D88\u7533\u8BF7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AllObj.user == null) {
					System.out.println("请先登陆");
					return;
				}
				if (t_appname.getText().trim().equals("")
						|| t_appname.getText().trim().equals("未申请")) {
					System.out.println("您未申请该培训");
					return;
				}
				// 后台处理
				TrainingPlanBean obj = AllObj.trin_show.get(table
						.getSelectedRow());
				TrainingApply.update(obj, 4);
				Training.up_table(table);
				t_appname.setText("未申请");
			}
		});
		button_2.setBounds(388, 232, 117, 29);
		panel_4.add(button_2);

		JLabel label_10 = new JLabel("\u7533\u8BF7\u72B6\u6001\uFF1A");
		label_10.setBounds(368, 114, 70, 16);
		panel_4.add(label_10);

		t_appname = new JTextField();
		t_appname.setEditable(false);
		t_appname.setColumns(10);
		t_appname.setBounds(442, 108, 80, 28);
		panel_4.add(t_appname);

		t_depname = new JTextField();
		t_depname.setEditable(false);
		t_depname.setColumns(10);
		t_depname.setBounds(268, 6, 80, 28);
		panel_4.add(t_depname);

		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		// 动态加载
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}
		comboBox.addItem("全部");
		for (String x : AllObj.depname.values()) {
			comboBox.addItem(x);
		}
		Training.load();
		Training.up_table(table);
		// 加载申请状态
		comboBox_2.addItem("全部");
		for (Integer x : AllObj.appname.keySet()) {
			if (x <= 4) {
				comboBox_2.addItem(AllObj.appname.get(x));
			}
		}
		if (AllObj.user != null) {
			TrainingApply.load();
		}

	}
}
