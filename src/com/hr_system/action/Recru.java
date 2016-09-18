package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.RecruBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Recru {

	public static void load() {
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			ORM.rs = ORM.sta.executeQuery("select * from recruitmentinfo");
			AllObj.recr_list.clear();
			AllObj.recr_show.clear();
			while (ORM.rs.next()) {
				RecruBean obj = new RecruBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3),
						ORM.rs.getString(4), ORM.rs.getInt(5), ORM.rs
								.getString(6).substring(0, 10),
						ORM.rs.getString(7), ORM.rs.getString(8));
				if (ORM.rs.getString(7) != null) {
					obj.setRecstopdate(ORM.rs.getString(7).substring(0, 10));
				}
				AllObj.recr_list.add(obj);
				AllObj.recr_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

	}

	public static void up_table(JTable table) {
		String[] col = new String[] { "招聘部门", "招聘职位", "招聘数量", "招聘日期" };
		String[][] row = new String[AllObj.recr_show.size()][col.length];
		int i = 0, j = 0;
		for (RecruBean x : AllObj.recr_show) {
			Vector<String> vec = new Vector<String>();
			vec.add(AllObj.depname.get(x.getDepid()));
			vec.add(AllObj.rankname.get(x.getRankid()));
			vec.add(x.getRecquant() + "");
			vec.add(x.getRecstartdate());
			row[i++] = vec.toArray(row[j++]);
		}
		table.setModel(new DefaultTableModel(row, col) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

}
