package com.hr_system.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.hr_system.action.Login;
import com.hr_system.bean.EmployeeBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2054822230384646304L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("HR\u7CFB\u7EDFv1.0");
		final JFrame that = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u767B\u5F55",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 414, 242);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(84, 43, 54, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(184, 40, 120, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setBounds(84, 83, 54, 15);
		panel.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(184, 80, 120, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u8EAB  \u4EFD\uFF1A");
		label_2.setBounds(84, 123, 54, 15);
		panel.add(label_2);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"\u7BA1\u7406\u5458", "\u90E8\u95E8\u7ECF\u7406",
				"\u666E\u901A\u5458\u5DE5" }));
		comboBox.setBounds(184, 120, 120, 21);
		panel.add(comboBox);

		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = textField.getText().trim();
				String upassword = textField_1.getText().trim();
				int perid = comboBox.getSelectedIndex() + 1;
				EmployeeBean user = Login.login(uname, upassword, perid);
				if (user != null) {
					System.out.println("login successful");
					that.dispose();
					new WelcomeFrame().setVisible(true);
				} else {
					System.out.println("login failed");
				}
			}
		});
		button.setBounds(60, 180, 93, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(224, 180, 93, 23);
		panel.add(button_1);
	}
}
