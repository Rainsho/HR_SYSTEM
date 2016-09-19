package com.hr_system.jframe.forum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;

import com.hr_system.action.InfoA;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddInfoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected EmployeeBean obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInfoFrame frame = new AddInfoFrame(null);
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
	public AddInfoFrame(final EmployeeBean obj) {
		final JFrame that = this;
		this.obj = obj;

		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4E3B\u9898",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 464, 50);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		final JTextPane textPane = new JTextPane();
		panel.add(textPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6B63\u6587",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 464, 310);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		final JTextPane textPane_1 = new JTextPane();
		panel_1.add(textPane_1);

		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infotitle = textPane.getText().trim();
				String infocontent = textPane_1.getText().trim();
				if (infotitle.length() < 2) {
					System.out.println("标题小于2字符");
					return;
				}
				if (infocontent.length() < 4) {
					System.out.println("正文小于4字符");
					return;
				}
				InfoA.add(obj.getUid(), infotitle, infocontent);
				InfoA.up_table(AllObj.jtb);
			}
		});
		button.setBounds(100, 380, 80, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllObj.jtb = null;
				that.dispose();
			}
		});
		button_1.setBounds(280, 380, 80, 30);
		contentPane.add(button_1);
	}

}
