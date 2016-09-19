package com.hr_system.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.InfoBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class InfoA {

	public static void load() {
		try {
			ORM.con();
			ORM.pst = ORM.con.prepareStatement("select * from info");
			ORM.rs = ORM.pst.executeQuery();
			AllObj.info_list.clear();
			AllObj.info_show.clear();
			while (ORM.rs.next()) {
				InfoBean obj = new InfoBean(ORM.rs.getInt(1), ORM.rs.getInt(2),
						ORM.rs.getString(3), ORM.rs.getString(4),
						ORM.rs.getString(5));
				AllObj.info_list.add(obj);
				AllObj.info_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void up_table(JTable table) {
		String[] col = new String[] { "公告主题", "发布人", "发布时间" };
		String[][] row = new String[AllObj.info_show.size()][col.length];
		int i = 0, j = 0;
		for (InfoBean x : AllObj.info_show) {
			Vector<String> vec = new Vector<String>();
			vec.add(x.getInfotitle());
			vec.add(AllObj.user_map.get(x.getUid()).getUname());
			vec.add(x.getInfodate());
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

	public static void filter(String infotitle, String uname) {
		AllObj.info_show.clear();
		for (InfoBean x : AllObj.info_list) {
			if ((infotitle.equals("") || infotitle.equals(x.getInfotitle()))
					&& (uname.equals("") || uname.equals(AllObj.user_map.get(
							x.getUid()).getUname()))) {
				AllObj.info_show.add(x);
			}
		}
	}

	public static void delete(InfoBean obj) {
		// delete obj
		AllObj.info_list.remove(obj);
		AllObj.info_show.remove(obj);
		// delete db
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("delete from info where infoid=?");
			ORM.pst.setInt(1, obj.getInfoid());
			ORM.pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		System.out.println("删除成功");
	}

	public static void update(InfoBean obj, String infocontent) {
		// update obj
		obj.setInfocontent(infocontent);
		// update db
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update info set infocontent=? where infoid=?");
			ORM.pst.setString(1, infocontent);
			ORM.pst.setInt(2, obj.getInfoid());
			ORM.pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		System.out.println("修改成功");
	}

	public static void add(int uid, String infotitle, String infocontent) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into info (uid, infotitle, infocontent, infodate) values (?, ?, ?, ?)");
			ORM.pst.setInt(1, uid);
			ORM.pst.setString(2, infotitle);
			ORM.pst.setString(3, infocontent);
			ORM.pst.setString(4, sdf.format(new Date()));
			ORM.pst.execute();
			load();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}
}
