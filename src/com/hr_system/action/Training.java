package com.hr_system.action;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Training {

	public static void load() {
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			ORM.rs = ORM.sta
					.executeQuery("select a.*, b.depname from trainingplan as a, department as b where a.depid=b.depid");
			while (ORM.rs.next()) {
				TrainingPlanBean obj = new TrainingPlanBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getString(3),
						ORM.rs.getString(4), ORM.rs.getString(5),
						ORM.rs.getString(6), ORM.rs.getString(7),
						ORM.rs.getInt(8), ORM.rs.getString(9).substring(0, 10),
						ORM.rs.getInt(10), ORM.rs.getString(11));
				AllObj.trin_list.add(obj);
				AllObj.trin_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void up_table(JTable table) {
		String[] col = new String[] { "≈‡—µ±‡∫≈", "≈‡—µ≤ø√≈", "≈‡—µ÷˜Ã‚" };
		String[][] row = new String[AllObj.trin_show.size()][col.length];
		for (int i = 0; i < row.length; i++) {
			row[i][0] = AllObj.trin_show.get(i).getTrpid() + "";
			row[i][1] = AllObj.trin_show.get(i).getDepname();
			row[i][2] = AllObj.trin_show.get(i).getTrpname();
		}
		table.setModel(new DefaultTableModel(row, col) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	public static void filter(String depname, String trpname) {
		AllObj.trin_show.clear();
		for (TrainingPlanBean x : AllObj.trin_list) {
			if ((depname.equals(x.getDepname()))
					&& (trpname.equals("") || trpname.equals(x.getTrpname()))) {
				AllObj.trin_show.add(x);
			}
		}
	}

	public static void clearpanel(JPanel panel) {
		Component[] comp = panel.getComponents();
		for (Component x : comp) {
			if (x.getClass().getName().equals("javax.swing.JTextField")) {
				((JTextField) x).setText("");
			}
		}

	}

	public static void delete(TrainingPlanBean obj) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("delete from employee where uid=?");
			ORM.pst.setInt(1, obj.getTrpid());
			ORM.pst.execute();
			AllObj.user_list.remove(obj);
			AllObj.user_show.remove(obj);
			System.out.println("…æ≥˝≥…π¶£°");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void update(TrainingPlanBean obj) {
		// TODO Auto-generated method stub
		
	}

	public static void add(TrainingPlanBean obj) {
		// TODO Auto-generated method stub
		
	}
}
