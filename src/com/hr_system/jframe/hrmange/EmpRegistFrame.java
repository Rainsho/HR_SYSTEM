package com.hr_system.jframe.hrmange;

import java.awt.EventQueue;

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

public class EmpRegistFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6210802303031604072L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpRegistFrame frame = new EmpRegistFrame();
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
	public EmpRegistFrame() {
		final JFrame that = this;
		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u6CE8\u518C\u65B0\u7528\u6237", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
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

		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				EmployeeBean obj = new EmployeeBean(0, dep_id, rank_id, per_id,
						nm, ps, gen, tel);
				// 检查后增加新增方法！
				if (EmpRegist.ck(obj)) {
					System.out.println("该员工已存在");
				} else {
					EmpRegist.add(obj);
				}
			}
		});
		button.setBounds(49, 368, 93, 30);
		panel.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		button_1.setBounds(199, 368, 93, 30);
		panel.add(button_1);

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
	}
}
