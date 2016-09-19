package com.hr_system.jframe.forum;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.InfoA;
import com.hr_system.action.Salary;
import com.hr_system.bean.InfoBean;
import com.hr_system.util.AddMenu;
import com.hr_system.util.AllObj;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForumFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t_infotitle;
	private JTextField t_uname;
	private JTable table;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForumFrame frame = new ForumFrame();
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
	public ForumFrame() {
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
		
		AddMenu.menu(panel);
		
		// 预留内容位置****
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "公告系统",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// 预留内容位置****
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 20, 745, 350);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 10, 365, 33);
		panel_3.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel label_2 = new JLabel("\u516C\u544A\u4E3B\u9898\uFF1A");
		panel_2.add(label_2);

		t_infotitle = new JTextField();
		t_infotitle.setColumns(6);
		panel_2.add(t_infotitle);

		JLabel label = new JLabel("\u53D1\u5E03\u4EBA\uFF1A");
		panel_2.add(label);

		t_uname = new JTextField();
		t_uname.setColumns(6);
		panel_2.add(t_uname);

		JButton button = new JButton("\u68C0\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infotitle = t_infotitle.getText().trim();
				String uname = t_uname.getText().trim();
				InfoA.filter(infotitle, uname);
				InfoA.up_table(table);
				textPane.setText("");
			}
		});
		panel_2.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 48, 365, 300);
		panel_3.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				InfoBean obj = AllObj.info_show.get(row);
				textPane.setText(obj.getInfocontent());
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(375, 10, 365, 33);
		panel_3.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button_1 = new JButton("\u65B0\u589E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AllObj.user == null) {
					System.out.println("请先登陆");
					return;
				}
				AllObj.jtb = table;
				new AddInfoFrame(AllObj.user).setVisible(true);
				textPane.setText("");
			}
		});
		panel_4.add(button_1);

		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				String infocontent = textPane.getText().trim();
				if (infocontent.length() < 4) {
					System.out.println("正文不能小于4个字符");
					return;
				}
				InfoBean obj = AllObj.info_show.get(row);
				InfoA.update(obj, infocontent);
				InfoA.up_table(table);
			}
		});
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				InfoBean obj = AllObj.info_show.get(row);
				InfoA.delete(obj);
				InfoA.up_table(table);
				textPane.setText("");
			}
		});
		panel_4.add(btnNewButton_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(375, 48, 365, 300);
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		textPane = new JTextPane();
		panel_5.add(textPane);

		// table center
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		// load
		if (AllObj.user_list.size() == 0) {
			EmpManage.load();
		}
		if (AllObj.user_map.size() == 0) {
			Salary.load();
		}
		InfoA.load();
		InfoA.up_table(table);
	}
}
