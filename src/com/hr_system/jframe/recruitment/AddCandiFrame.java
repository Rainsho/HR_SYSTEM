package com.hr_system.jframe.recruitment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.hr_system.action.Candi;
import com.hr_system.bean.RecruBean;
import com.hr_system.util.AllObj;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCandiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected RecruBean obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCandiFrame frame = new AddCandiFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param obj
	 */
	public AddCandiFrame(final RecruBean obj) {
		final JFrame that = this;
		this.obj = obj;

		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u65B0\u589E\u5E94\u8058\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 364, 360);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u5E94\u8058\u90E8\u95E8\uFF1A");
		label.setBounds(20, 40, 80, 20);
		panel.add(label);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(90, 40, 80, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5E94\u8058\u804C\u4F4D\uFF1A");
		label_1.setBounds(194, 40, 80, 20);
		panel.add(label_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(264, 40, 80, 20);
		panel.add(textField_1);

		JLabel label_2 = new JLabel("\u59D3    \u540D\uFF1A");
		label_2.setBounds(20, 70, 80, 20);
		panel.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 70, 80, 20);
		panel.add(textField_2);

		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setBounds(194, 70, 80, 20);
		panel.add(label_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(264, 70, 80, 20);
		panel.add(textField_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"\u5E94\u8058\u4EBA\u8D44\u6599", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 100, 322, 250);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		final JTextPane textPane = new JTextPane();
		panel_1.add(textPane);

		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (obj == null) {
					return;
				}
				String[] info = new String[] { textField_2.getText().trim(),
						textField_3.getText().trim(), textPane.getText().trim() };
				// check
				for (String x : info) {
					if (x.equals("")) {
						System.out.println("信息不完整");
						return;
					}
				}
				Candi.add(obj, info);
				Candi.filter(obj.getRecid());
				Candi.up_table_1(AllObj.jtb);
			}
		});
		button.setBounds(80, 393, 80, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		button_1.setBounds(220, 393, 80, 30);
		contentPane.add(button_1);

		// load
		if (obj != null) {
			textField.setText(AllObj.depname.get(obj.getDepid()));
			textField_1.setText(AllObj.rankname.get(obj.getRankid()));
		}
	}
}
