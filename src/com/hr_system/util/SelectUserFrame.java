package com.hr_system.util;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import com.hr_system.action.EmpManage;
import com.hr_system.bean.EmployeeBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectUserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list_1;
	protected JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectUserFrame frame = new SelectUserFrame(null);
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
	public SelectUserFrame(final JTable table) {
		final JFrame that = this;
		this.table = table;

		setTitle("HR\u7CFB\u7EDFv1.0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9009\u62E9\u5458\u5DE5",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 324, 422);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 20, 147, 310);
		panel.add(scrollPane_1);

		final JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int s = list.getSelectedIndex();
				if (s == -1) {
					return;
				}
				String depname = list.getSelectedValue().toString();
				DefaultListModel dlm = new DefaultListModel();
				for (EmployeeBean x : AllObj.user_list) {
					if (depname.equals("全部")
							|| depname.equals(AllObj.depname.get(x.getDepid()))) {
						dlm.addElement(x.getUname());
					}
				}
				list_1.setModel(dlm);
			}
		});
		scrollPane_1.setViewportView(list);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(165, 20, 147, 310);
		panel.add(scrollPane2);

		list_1 = new JList();
		scrollPane2.setViewportView(list_1);

		JButton button = new JButton("\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_1.getSelectedIndex() == -1) {
					System.out.println("未选择员工");
					return;
				}
				for (EmployeeBean x : AllObj.user_list) {
					if (x.getUname().equals(
							list_1.getSelectedValue().toString())) {
						AllObj.user_selected = x;
						break;
					}
				}
				// System.out.println("已选择：" + AllObj.user_selected.getUname());
				// 线程问题，暂放这边处理
				if (AllObj.user_selected != null && table != null) {
					table.setValueAt(AllObj.user_selected.getUname(), 0, 2);
					table.setValueAt(
							AllObj.depname.get(AllObj.user_selected.getDepid()),
							0, 1);
				}
				// 线程问题，暂放这边处理
				that.dispose();
			}
		});
		button.setBounds(57, 362, 80, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		button_1.setBounds(187, 362, 80, 23);
		panel.add(button_1);

		// 动态加载
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}
		DefaultListModel dlm = new DefaultListModel();
		dlm.addElement("全部");
		for (Integer x : AllObj.depname.keySet()) {
			dlm.addElement(AllObj.depname.get(x));
		}
		list.setModel(dlm);
		dlm = new DefaultListModel();
		for (EmployeeBean x : AllObj.user_list) {
			dlm.addElement(x.getUname());
		}
		list_1.setModel(dlm);
	}

}
