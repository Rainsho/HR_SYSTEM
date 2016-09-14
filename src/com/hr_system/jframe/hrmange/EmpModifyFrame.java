package com.hr_system.jframe.hrmange;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.hr_system.action.EmpManage;
import com.hr_system.action.EmpRegist;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class EmpModifyFrame extends JFrame {
	EmployeeBean emp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6210802303031604072L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * 删除主方法，改窗口只能确定修改对象后调用 Create the frame.
	 */
	public EmpModifyFrame(final EmployeeBean emp) {
		final JFrame that = this;
		this.emp = emp;
		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u4EBA\u4E8B\u53D8\u52A8",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(10, 10, 385, 440);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(50, 50, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(50, 90, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u90E8\u95E8\uFF1A");
		label_2.setBounds(50, 130, 54, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u804C\u52A1\uFF1A");
		label_3.setBounds(50, 170, 54, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setBounds(49, 253, 54, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\u6027\u522B\uFF1A");
		label_5.setBounds(49, 293, 54, 15);
		panel.add(label_5);

		textField = new JTextField();
		textField.setBounds(150, 47, 80, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(150, 87, 80, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 127, 80, 21);
		panel.add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(150, 167, 80, 21);
		panel.add(comboBox_1);

		JLabel label_6 = new JLabel("\u6743\u9650\uFF1A");
		label_6.setBounds(50, 210, 54, 15);
		panel.add(label_6);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(150, 207, 80, 21);
		panel.add(comboBox_2);

		textField_2 = new JTextField();
		textField_2.setBounds(149, 250, 80, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		final JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		radioButton.setBounds(149, 289, 50, 23);
		panel.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(207, 289, 50, 23);
		panel.add(radioButton_1);

		final JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取修改后的信息
				String nm = textField.getText().trim();
				String ps = textField_1.getText().trim();
				String tel = textField_2.getText().trim();
				String dep = comboBox.getSelectedItem().toString();
				String rank = comboBox_1.getSelectedItem().toString();
				String per = comboBox_2.getSelectedItem().toString();
				String gen = radioButton.isSelected() ? "男" : "女";
				int dep_id = 0, rank_id = 0, per_id = 0;
				for (Integer x : AllObj.depname.keySet()) {
					if (dep.equals(AllObj.depname.get(x))) {
						dep_id = x;
						break;
					}
				}
				for (Integer x : AllObj.rankname.keySet()) {
					if (rank.equals(AllObj.rankname.get(x))) {
						rank_id = x;
						break;
					}
				}
				for (Integer x : AllObj.pername.keySet()) {
					if (per.equals(AllObj.pername.get(x))) {
						per_id = x;
						break;
					}
				}
				// 数据检查
				String nm_tep = emp.getUname();// 临时存储uname，改变uname后使用regist的方法检查uname是否已存在
				if (!nm.equals(nm_tep)) {
					emp.setUname(nm);
					if (EmpRegist.ck(emp)) {
						System.out.println("该员工名已存在");
						emp.setUname(nm_tep);
						return;
					}
				}
				// 更新object
				emp.setDepid(dep_id);
				emp.setRankid(rank_id);
				emp.setPerid(per_id);
				emp.setUname(nm);
				emp.setUpassword(ps);
				emp.setUgender(gen);
				emp.setUtelphone(tel);
				// 更新数据库
				EmpRegist.modify(emp);
			}
		});
		button.setBounds(50, 353, 80, 30);
		panel.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
				if (AllObj.jtb != null && AllObj.jlb != null) {
					EmpManage.up_table(
							AllObj.jtb,
							AllObj.page * 10,
							Math.min(AllObj.page * 10 + 9,
									AllObj.user_show.size() - 1));
					EmpManage.up_label(AllObj.jlb);
				}
			}
		});
		button_1.setBounds(230, 353, 80, 30);
		panel.add(button_1);

		final JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpRegist.delete(emp);
				btnNewButton.setEnabled(false);
				button.setEnabled(false);
			}
		});
		btnNewButton.setBounds(140, 353, 80, 30);
		panel.add(btnNewButton);

		// 动态加载
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);

		if (AllObj.depname.size() == 0 || AllObj.rankname.size() == 0
				|| AllObj.pername.size() == 0) {
			EmpManage.load();
		}
		for (String x : AllObj.depname.values()) {
			comboBox.addItem(x);
		}
		for (String x : AllObj.rankname.values()) {
			comboBox_1.addItem(x);
		}
		for (String x : AllObj.pername.values()) {
			comboBox_2.addItem(x);
		}

		// load_emp_information
		textField.setText(emp.getUname());
		textField_1.setText(emp.getUpassword());
		textField_2.setText(emp.getUtelphone());
		comboBox.setSelectedItem(AllObj.depname.get(emp.getDepid()));
		comboBox_1.setSelectedItem(AllObj.rankname.get(emp.getRankid()));
		comboBox_2.setSelectedItem(AllObj.pername.get(emp.getPerid()));

		if (emp.getUgender().equals("男")) {
			radioButton.setSelected(true);
		} else {
			radioButton_1.setSelected(true);
		}
	}

}
