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
				AllObj.recr_map.put(obj.getRecid(), obj);
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

	public static void filter(String depname, String rankname) {
		AllObj.recr_show.clear();
		for (RecruBean x : AllObj.recr_list) {
			if ((depname.equals("全部") || depname.equals(AllObj.depname.get(x
					.getDepid())))
					&& (rankname.equals("全部") || rankname
							.equals(AllObj.rankname.get(x.getRankid())))) {
				AllObj.recr_show.add(x);
			}
		}
	}

	public static void update(RecruBean obj, Object[] info) {
		// update obj
		int i = 0;
		obj.setDepid((Integer) info[i++]);
		obj.setRankid((Integer) info[i++]);
		obj.setRecname(info[i++].toString());
		obj.setRecquant(Integer.parseInt(info[i++].toString()));
		obj.setRecstartdate(info[i++].toString());
		obj.setRecstopdate(info[i++].toString());
		obj.setRecinfo(info[i++].toString());
		if (obj.getRecstopdate().equals("")) {
			obj.setRecstopdate(null);
		}
		if (obj.getRecinfo().equals("")) {
			obj.setRecinfo(null);
		}
		// update db
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update recruitmentinfo set depid=?, rankid=?, recname=?, recquant=?, recstartdate=?, recstopdate=?, recinfo=? where recid=?");
			for (i = 0; i < info.length - 2; i++) {// 最后两个可能为null，手动配置
				ORM.pst.setString(i + 1, info[i].toString());
			}
			if (obj.getRecstopdate() == null) {
				ORM.pst.setString(6, null);
			} else {
				ORM.pst.setString(6, info[5].toString());
			}
			if (obj.getRecinfo() == null) {
				ORM.pst.setString(7, null);
			} else {
				ORM.pst.setString(7, info[6].toString());
			}
			ORM.pst.setInt(8, obj.getRecid());
			ORM.pst.execute();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void add(Object[] info) {
		// update db
		int i = 0;
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into recruitmentinfo (depid, rankid, recname, recquant, recstartdate, recstopdate, recinfo) values (?, ?, ?, ?, ?, ?, ?)");
			for (i = 0; i < info.length - 2; i++) {// 最后两个可能为null，手动配置
				ORM.pst.setString(i + 1, info[i].toString());
			}
			if (info[5].toString().equals("")) {
				ORM.pst.setString(6, null);
			} else {
				ORM.pst.setString(6, info[5].toString());
			}
			if (info[6].toString().equals("")) {
				ORM.pst.setString(7, null);
			} else {
				ORM.pst.setString(7, info[6].toString());
			}
			ORM.pst.execute();
			// update obj
			load();
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}
}
