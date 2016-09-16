package com.hr_system.jframe.training;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import com.hr_system.action.EmpManage;
import com.hr_system.action.Training;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.Tools;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TrainingPlanFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField t_trpid;
	private JTextField t_trppeople;
	private JTextField t_trpname;
	private JTextField t_trpadmin;
	private JTextField t_trpfee;
	private JTextField t_trpdate;
	private JTextField t_trpmonth;
	private JTextField t_trpplace;
	private JTextPane t_trpinfo;
	private JPanel panel_4;
	private JComboBox comboBox_1;
	private JRadioButton radioButton;
	protected TrainingPlanBean obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingPlanFrame frame = new TrainingPlanFrame();
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
	public TrainingPlanFrame() {

		// Ԥ���˵�λ��****
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
		// Ԥ���˵�λ��****
		// Ԥ������λ��****
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "��ѵ�ƻ�",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 60, 765, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// Ԥ������λ��****
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 25, 745, 40);
		panel_1.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_2.setLayout(fl_panel_2);

		JLabel lblNewLabel = new JLabel("��ѵ���ţ�");
		panel_2.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("��ѵ���⣺");
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(8);

		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String depname = comboBox.getSelectedItem().toString().trim();
				String trpname = textField.getText().trim();
				Training.filter(depname, trpname);
				Training.up_table(table);
			}
		});
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 75, 745, 290);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 180, 278);
		panel_3.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1
						|| table.getSelectedColumn() == -1
						|| !radioButton.isSelected()) {
					return;
				}
				// ���jtextfield
				Training.clearpanel(panel_4);
				t_trpinfo.setText("");// ����panel_4
				// ���jtextfield
				TrainingPlanBean obj = AllObj.trin_show.get(table
						.getSelectedRow());
				t_trpid.setText(obj.getTrpid() + "");
				t_trppeople.setText(obj.getTrppeople());
				t_trpname.setText(obj.getTrpname());
				t_trpadmin.setText(obj.getTrpadmin());
				t_trpfee.setText(obj.getTrpfee() + "");
				t_trpdate.setText(obj.getTrpdate());
				t_trpmonth.setText(obj.getTrpmonth() + "");
				t_trpplace.setText(obj.getTrpplace());
				t_trpinfo.setText(obj.getTrpinfo());
				comboBox_1.setSelectedItem(obj.getDepname());
			}
		});
		scrollPane.setViewportView(table);

		panel_4 = new JPanel();
		panel_4.setBounds(198, 6, 541, 278);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel label = new JLabel("��ѵ��ţ�");
		label.setBounds(20, 12, 70, 16);
		panel_4.add(label);

		t_trpid = new JTextField();
		t_trpid.setEditable(false);
		t_trpid.setBounds(94, 6, 80, 28);
		panel_4.add(t_trpid);
		t_trpid.setColumns(10);

		JLabel label_1 = new JLabel("��ѵ���ţ�");
		label_1.setBounds(194, 12, 70, 16);
		panel_4.add(label_1);

		JLabel label_2 = new JLabel("��ѵ����");
		label_2.setBounds(368, 12, 70, 16);
		panel_4.add(label_2);

		t_trppeople = new JTextField();
		t_trppeople.setColumns(10);
		t_trppeople.setBounds(442, 6, 80, 28);
		panel_4.add(t_trppeople);

		JLabel label_3 = new JLabel("\u57F9\u8BAD\u4E3B\u9898\uFF1A");
		label_3.setBounds(20, 46, 70, 16);
		panel_4.add(label_3);

		t_trpname = new JTextField();
		t_trpname.setColumns(10);
		t_trpname.setBounds(94, 40, 80, 28);
		panel_4.add(t_trpname);

		JLabel label_4 = new JLabel("�����ˣ�");
		label_4.setBounds(194, 46, 70, 16);
		panel_4.add(label_4);

		t_trpadmin = new JTextField();
		t_trpadmin.setColumns(10);
		t_trpadmin.setBounds(268, 40, 80, 28);
		panel_4.add(t_trpadmin);

		JLabel label_6 = new JLabel("\u57F9\u8BAD\u8D39\u7528\uFF1A");
		label_6.setBounds(368, 46, 70, 16);
		panel_4.add(label_6);

		t_trpfee = new JTextField();
		t_trpfee.setColumns(10);
		t_trpfee.setBounds(442, 40, 80, 28);
		panel_4.add(t_trpfee);

		JLabel label_7 = new JLabel("\u57F9\u8BAD\u65E5\u671F\uFF1A");
		label_7.setBounds(20, 80, 70, 16);
		panel_4.add(label_7);

		t_trpdate = new JTextField();
		t_trpdate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				// ������ںϷ���
				if (Tools.checkdate(t_trpdate.getText().trim()) == null) {
					t_trpdate.setText(new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date()));
				} else {
					t_trpdate.setText(Tools.checkdate(t_trpdate.getText()
							.trim()));
				}
			}
		});
		t_trpdate.setColumns(10);
		t_trpdate.setBounds(94, 74, 254, 28);
		panel_4.add(t_trpdate);

		JLabel label_8 = new JLabel("\u57F9\u8BAD\u6708\u65F6\uFF1A");
		label_8.setBounds(368, 80, 70, 16);
		panel_4.add(label_8);

		t_trpmonth = new JTextField();
		t_trpmonth.setColumns(10);
		t_trpmonth.setBounds(442, 74, 80, 28);
		panel_4.add(t_trpmonth);

		JLabel label_9 = new JLabel("\u57F9\u8BAD\u5730\u70B9\uFF1A");
		label_9.setBounds(20, 114, 70, 16);
		panel_4.add(label_9);

		t_trpplace = new JTextField();
		t_trpplace.setColumns(10);
		t_trpplace.setBounds(94, 108, 254, 28);
		panel_4.add(t_trpplace);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\u57F9\u8BAD\u5185\u5BB9",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(20, 142, 328, 130);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		t_trpinfo = new JTextPane();
		panel_5.add(t_trpinfo);

		final JButton button_1 = new JButton("\u4FEE\u6539\u57F9\u8BAD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioButton.isSelected()) {
					int col = table.getSelectedColumn();
					int row = table.getSelectedRow();
					// ����Ƿ�ѡ���޸Ķ���
					if (row == -1 || col == -1) {
						System.out.println("δѡ��Ҫ�޸ĵ���ѵ�ƻ�");
						return;
					}
					// ��������Ƿ�Ƿ�
					if (Tools.checkdate(t_trpdate.getText().trim()) == null) {
						return;
					}
					// �޸�obj
					obj = AllObj.trin_show.get(row);
					obj.setDepname(comboBox_1.getSelectedItem().toString()
							.trim());
					for (Integer x : AllObj.depname.keySet()) {
						if (AllObj.depname.get(x).equals(obj.getDepname())) {
							obj.setDepid(x);
							break;
						}
					}
					obj.setTrppeople(t_trppeople.getText().trim());
					obj.setTrpname(t_trpname.getText().trim());
					obj.setTrpadmin(t_trpadmin.getText().trim());
					obj.setTrpfee(Integer.parseInt(t_trpfee.getText().trim()));
					obj.setTrpdate(Tools.checkdate(t_trpdate.getText().trim()));
					obj.setTrpmonth(Integer.parseInt(t_trpmonth.getText()
							.trim()));
					obj.setTrpplace(t_trpplace.getText().trim());
					obj.setTrpinfo(t_trpinfo.getText().trim());
					// �������ݿ�
					Training.update(obj);
					Training.up_table(table);
				} else {
					// ��������Ƿ�Ƿ�
					if (Tools.checkdate(t_trpdate.getText().trim()) == null) {
						return;
					}
					// ����Ƿ��п�textfield
					if (Training.panelhasempty(panel_4)
							|| t_trpinfo.getText().trim().equals("")) {
						System.out.println("��ѵ��Ϣ������");
						return;
					}
					// �½�obj
					TrainingPlanBean obj = new TrainingPlanBean();
					obj.setDepname(comboBox_1.getSelectedItem().toString()
							.trim());
					for (Integer x : AllObj.depname.keySet()) {
						if (AllObj.depname.get(x).equals(obj.getDepname())) {
							obj.setDepid(x);
							break;
						}
					}
					obj.setTrppeople(t_trppeople.getText().trim());
					obj.setTrpname(t_trpname.getText().trim());
					obj.setTrpadmin(t_trpadmin.getText().trim());
					obj.setTrpfee(Integer.parseInt(t_trpfee.getText().trim()));
					obj.setTrpdate(Tools.checkdate(t_trpdate.getText().trim()));
					obj.setTrpmonth(Integer.parseInt(t_trpmonth.getText()
							.trim()));
					obj.setTrpplace(t_trpplace.getText().trim());
					obj.setTrpinfo(t_trpinfo.getText().trim());
					// �������ݿ�
					Training.add(obj);
					Training.clearpanel(panel_4);
					t_trpinfo.setText("");// ����panel_4
					Training.up_table(table);
					radioButton.setSelected(true);
				}
			}
		});
		button_1.setBounds(388, 191, 117, 29);
		panel_4.add(button_1);

		final JButton button_2 = new JButton("\u5220\u9664\u57F9\u8BAD");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					System.out.println("δѡ��Ҫɾ������ѵ�ƻ�");
					return;
				}
				Training.delete(AllObj.trin_show.get(row));
				Training.up_table(table);
			}
		});
		button_2.setBounds(388, 232, 117, 29);
		panel_4.add(button_2);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(268, 8, 80, 27);
		panel_4.add(comboBox_1);

		radioButton = new JRadioButton("\u4FEE\u6539");
		radioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (radioButton.isSelected()) {
					button_1.setText("�޸���ѵ");
					table.setEnabled(true);
					table.setRowSelectionAllowed(true);
				}
			}
		});
		radioButton.setSelected(true);
		radioButton.setBounds(378, 156, 60, 23);
		panel_4.add(radioButton);

		final JRadioButton radioButton_1 = new JRadioButton("\u65B0\u589E");
		radioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (radioButton_1.isSelected()) {
					button_1.setText("������ѵ");
					table.setRowSelectionAllowed(false);
					table.setEnabled(false);
					Training.clearpanel(panel_4);
					t_trpinfo.setText("");// ����panel_4
				}
			}
		});
		radioButton_1.setBounds(452, 156, 60, 23);
		panel_4.add(radioButton_1);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);

		// ����table���ݾ���
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		// ��̬����
		if (AllObj.depname.size() == 0) {
			EmpManage.load();
		}
		for (String x : AllObj.depname.values()) {
			comboBox.addItem(x);
			comboBox_1.addItem(x);
		}
		Training.load();
		Training.up_table(table);

	}
}
