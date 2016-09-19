package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.CandiBean;
import com.hr_system.bean.RecruBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Candi {

	public static void load() {
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			ORM.rs = ORM.sta.executeQuery("select * from candidates");
			AllObj.cand_list.clear();
			AllObj.cand_show.clear();
			while (ORM.rs.next()) {
				CandiBean obj = new CandiBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getString(3),
						ORM.rs.getString(4), ORM.rs.getString(5));
				AllObj.cand_list.add(obj);
				AllObj.cand_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void up_table(JTable table) {
		String[] col = new String[] { "招聘部门", "招聘职位", "招聘标题", "招聘数量", "招聘日期",
				"截止日期" };
		String[][] row = new String[AllObj.recr_list.size()][col.length];
		int i = 0, j = 0;
		for (RecruBean x : AllObj.recr_list) {// 如果需要，价格日期筛选
			Vector<String> vec = new Vector<String>();
			vec.add(AllObj.depname.get(x.getDepid()));
			vec.add(AllObj.rankname.get(x.getRankid()));
			vec.add(x.getRecname());
			vec.add(x.getRecquant() + "");
			vec.add(x.getRecstartdate());
			vec.add(x.getRecstopdate());
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

	public static void up_table_1(JTable table) {
		String[] col = new String[] { "应聘部门", "应聘职位", "姓名", "联系电话" };
		String[][] row = new String[AllObj.cand_show.size()][col.length];
		int i = 0, j = 0;
		for (CandiBean x : AllObj.cand_show) {// 如果需要，价格日期筛选
			Vector<String> vec = new Vector<String>();
			vec.add(AllObj.depname.get(AllObj.recr_map.get(x.getRecid())
					.getDepid()));
			vec.add(AllObj.rankname.get(AllObj.recr_map.get(x.getRecid())
					.getRankid()));
			vec.add(x.getCanname());
			vec.add(x.getCantelphone());
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

	public static void filter(int recid) {
		AllObj.cand_show.clear();
		for (CandiBean x : AllObj.cand_list) {
			if (x.getRecid() == recid) {
				AllObj.cand_show.add(x);
			}
		}
	}

	public static void add(RecruBean obj, String[] info) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into candidates (recid, canname, cantelphone, caninfo) values (?, ?, ?, ?)");
			ORM.pst.setInt(1, obj.getRecid());
			for (int i = 0; i < info.length; i++) {
				ORM.pst.setString(i + 2, info[i]);
			}
			ORM.pst.execute();
			load();
			System.out.println("新增成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}
}
