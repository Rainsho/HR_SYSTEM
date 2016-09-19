package com.hr_system.jframe.recruitment;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTable;

import com.hr_system.action.Candi;
import com.hr_system.action.EmpManage;
import com.hr_system.action.Recru;
import com.hr_system.bean.RecruBean;
import com.hr_system.util.AddMenu;
import com.hr_system.util.AllObj;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CandiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextPane textPane;
	private JTextPane textPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandiFrame frame = new CandiFrame();
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
	public CandiFrame() {
		final JFrame that = this;

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
				EtchedBorder.LOWERED, null, null), "应聘信息",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// 预留内容位置****
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null,
				"\u53D1\u5E03\u4E2D\u7684\u62DB\u8058", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 20, 380, 180);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				RecruBean obj = AllObj.recr_list.get(row);
				textPane.setText(obj.getRecinfo());
				textPane_1.setText("");
				Candi.filter(obj.getRecid());
				Candi.up_table_1(table_1);
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null,
				"\u5E94\u8058\u4EBA\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 210, 380, 160);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table_1.getSelectedColumn();
				int row = table_1.getSelectedRow();
				if (col == -1 || row == -1) {
					return;
				}
				textPane_1.setText(AllObj.cand_show.get(row).getCaninfo());
			}
		});
		scrollPane_1.setViewportView(table_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null,
				"\u62DB\u8058\u8BE6\u7EC6\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_4.setBounds(400, 20, 175, 287);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		textPane = new JTextPane();
		textPane.setEditable(false);
		panel_4.add(textPane);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null,
				"\u5E94\u8058\u4EBA\u8D44\u6599", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.setBounds(579, 20, 175, 287);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));

		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		panel_5.add(textPane_1);

		JButton button = new JButton("\u65B0\u589E\u7533\u8BF7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = table.getSelectedColumn();
				int row = table.getSelectedRow();
				if (col == -1 || row == -1) {
					System.out.println("未选择申请的招聘计划");
					return;
				}
				RecruBean obj = AllObj.recr_list.get(row);
				AllObj.jtb = table_1;
				new AddCandiFrame(obj).setVisible(true);
			}
		});
		button.setBounds(462, 325, 93, 30);
		panel_1.add(button);

		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		button_1.setBounds(599, 325, 93, 30);
		panel_1.add(button_1);

		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		table_1.setDefaultRenderer(Object.class, tcr);

		// 动态加载
		if (AllObj.recr_map.size() == 0) {
			Recru.load();
		}
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}
		Candi.load();
		Candi.up_table(table);
		Candi.up_table_1(table_1);
	}
}
