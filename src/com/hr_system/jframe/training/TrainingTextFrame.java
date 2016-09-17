package com.hr_system.jframe.training;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextPane;

import com.hr_system.action.TrainingEvaluate;
import com.hr_system.bean.TrainingEvaluateBean;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainingTextFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TrainingEvaluateBean obj_tre;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingTextFrame frame = new TrainingTextFrame("test",
							null);
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
	public TrainingTextFrame(String str_type, final TrainingPlanBean obj) {
		final JFrame that = this;
		i = str_type.equals("培训评估") ? 1 : 0;

		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, str_type, TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 438, 466);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setBounds(6, 20, 426, 30);
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("\u57F9\u8BAD\u4E3B\u9898\uFF1A");
		panel_1.add(lblNewLabel);

		JLabel l_trpname = new JLabel("New label");
		panel_1.add(l_trpname);

		JLabel lblNewLabel_1 = new JLabel("  " + "\u8D1F\u8D23\u4EBA\uFF1A");
		panel_1.add(lblNewLabel_1);

		JLabel l_trpadmin = new JLabel("New label");
		panel_1.add(l_trpadmin);

		JLabel lblNewLabel_2 = new JLabel("  " + str_type.substring(2) + "人：");
		panel_1.add(lblNewLabel_2);

		JLabel l_uname = new JLabel("New label");
		panel_1.add(l_uname);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, str_type.substring(2) + "内容",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 60, 426, 340);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		final JTextPane textPane = new JTextPane();
		panel_2.add(textPane);

		final JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPane.getText().trim().equals("")) {
					System.out.println("内容不能不空");
					return;
				}
				if (obj_tre != null) {
					obj_tre.setTretext(textPane.getText().trim());
					TrainingEvaluate.update(obj_tre, i);
				} else {
					obj_tre = new TrainingEvaluateBean(0, AllObj.user.getUid(),
							obj.getTrpid(), textPane.getText().trim());
					TrainingEvaluate.add(obj_tre, i);
					button.setText("修改");
				}
			}
		});
		button.setBounds(110, 412, 90, 29);
		panel.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				that.dispose();
			}
		});
		button_1.setBounds(238, 412, 90, 29);
		panel.add(button_1);

		// 动态加载
		if (obj != null) {
			l_trpname.setText(obj.getTrpname());
			l_trpadmin.setText(obj.getTrpadmin());
		}
		if (AllObj.user != null) {
			l_uname.setText(AllObj.user.getUname());
			obj_tre = TrainingEvaluate.load(obj, i);
		}
		if (obj_tre != null) {
			textPane.setText(obj_tre.getTretext());
			button.setText("修改");
		}
	}
}
