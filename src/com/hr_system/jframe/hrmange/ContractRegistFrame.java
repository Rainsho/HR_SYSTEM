package com.hr_system.jframe.hrmange;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import com.hr_system.action.ContractManage;
import com.hr_system.action.EmpManage;
import com.hr_system.bean.ContractBean;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextPane;

public class ContractRegistFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6210802303031604072L;
	private JPanel contentPane;
	private JTextField t_uname;
	private JTextField t_depname;
	private JTextField t_conname;
	private JTextField t_condate;
	private JSpinner spinner;
	private JComboBox comboBox;
	private JTextPane t_coninfo;
	protected static EmployeeBean emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractRegistFrame frame = new ContractRegistFrame();
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
	public ContractRegistFrame() {
		final JFrame that = this;
		// 预加载员工信息，填写时检查是否存在
		if (AllObj.depname.size() == 0 || AllObj.rankname.size() == 0
				|| AllObj.pername.size() == 0) {
			EmpManage.load();
		}

		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "\u6DFB\u52A0\u5408\u540C", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 385, 440);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u5408\u540C\u6301\u6709\u4EBA\uFF1A");
		label.setBounds(50, 50, 80, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6301\u6709\u4EBA\u90E8\u95E8\uFF1A");
		label_1.setBounds(50, 90, 80, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u5408\u540C\u540D\u79F0\uFF1A");
		label_2.setBounds(50, 130, 80, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u7B7E\u7EA6\u65F6\u95F4\uFF1A");
		label_3.setBounds(50, 170, 80, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u5408\u540C\u6027\u8D28\uFF1A");
		label_4.setBounds(49, 253, 80, 15);
		panel.add(label_4);

		final JLabel l_status = new JLabel("");
		l_status.setBounds(265, 50, 80, 16);
		panel.add(l_status);

		t_uname = new JTextField();
		t_uname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				// 检查name是否存在
				t_depname.setText("");// 防止uname匹配到后做修改
				for (EmployeeBean x : AllObj.user_list) {
					if (x.getUname().equals(t_uname.getText().trim())) {
						emp = x;
						t_depname.setText(AllObj.depname.get(x.getDepid()));
						l_status.setText("");
						return;
					}
				}
				l_status.setText("该员工不存在");
			}
		});
		t_uname.setBounds(150, 47, 100, 21);
		panel.add(t_uname);
		t_uname.setColumns(10);

		t_depname = new JTextField();
		t_depname.setBounds(150, 87, 100, 21);
		panel.add(t_depname);
		t_depname.setColumns(10);
		t_depname.setEditable(false);

		JLabel label_6 = new JLabel("\u5408\u540C\u5E74\u9650\uFF1A");
		label_6.setBounds(50, 210, 80, 15);
		panel.add(label_6);

		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!l_status.getText().equals(""))
						|| t_uname.getText().equals("") || emp == null) {
					System.out.println("合同信息不完整，请补充完整！");
					return;
				}
				String uname = t_uname.getText().trim();
				String depname = t_depname.getText().trim();
				String conname = t_conname.getText().trim();
				String condate = t_condate.getText().trim();
				int conyear = Integer.parseInt(spinner.getValue().toString());
				String contype = comboBox.getSelectedItem().toString();
				String coninfo = t_coninfo.getText();
				ContractBean cont = new ContractBean(0, uname, depname,
						conname, condate, conyear, contype, coninfo, emp
								.getUid());
				ContractManage.add(cont);
			}
		});
		button.setBounds(50, 395, 93, 30);
		panel.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
				if (AllObj.jtb != null && AllObj.jlb != null) {
					ContractManage.up_table(
							AllObj.jtb,
							AllObj.page * 10,
							Math.min(AllObj.page * 10 + 9,
									AllObj.cont_show.size() - 1));
					ContractManage.up_label(AllObj.jlb);
				}
			}
		});
		button_1.setBounds(200, 395, 93, 30);
		panel.add(button_1);

		t_conname = new JTextField();
		t_conname.setColumns(10);
		t_conname.setBounds(150, 127, 100, 21);
		panel.add(t_conname);

		spinner = new JSpinner();
		spinner.setBounds(150, 203, 100, 28);
		spinner.setModel(new SpinnerNumberModel(3, 1, 99, 1));
		panel.add(spinner);

		t_condate = new JTextField();
		t_condate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// 检查日期合法性
				if (Tools.checkdate(t_condate.getText().trim()) == null) {
					t_condate.setText(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date()));
				} else {
					t_condate.setText(Tools.checkdate(t_condate.getText()
							.trim()));
				}
			}
		});
		t_condate.setColumns(10);
		t_condate.setBounds(150, 167, 100, 21);
		panel.add(t_condate);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5408\u540C\u5185\u5BB9",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 285, 280, 93);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		t_coninfo = new JTextPane();
		panel_1.add(t_coninfo);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"\u52B3\u52A8\u5408\u540C", "\u4EE3\u7406\u5408\u540C",
				"\u6D3E\u9063\u5408\u540C", "\u5176\u4ED6\u5408\u540C" }));
		comboBox.setBounds(150, 248, 100, 27);
		panel.add(comboBox);

		// 动态加载
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t_condate.setText(sdf.format(new Date()));

	}
}
