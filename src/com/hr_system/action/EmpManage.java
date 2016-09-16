package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class EmpManage {

	public static void load() {
		// 初始化可选下拉框，后期丢到welcome模块里面
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			ORM.rs = ORM.sta.executeQuery("select * from department");
			while (ORM.rs.next()) {
				AllObj.depname.put(ORM.rs.getInt(1), ORM.rs.getString(2));
			}
			ORM.rs = ORM.sta.executeQuery("select * from rank");
			while (ORM.rs.next()) {
				AllObj.rankname.put(ORM.rs.getInt(1), ORM.rs.getString(2));
			}
			ORM.rs = ORM.sta.executeQuery("select * from permission");
			while (ORM.rs.next()) {
				AllObj.pername.put(ORM.rs.getInt(1), ORM.rs.getString(2));
			}
			ORM.rs = ORM.sta.executeQuery("select * from employee");
			AllObj.user_list.clear();
			AllObj.user_show.clear();
			while (ORM.rs.next()) {
				EmployeeBean obj = new EmployeeBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3), ORM.rs.getInt(4),
						ORM.rs.getString(5), ORM.rs.getString(6),
						ORM.rs.getString(7), ORM.rs.getString(8));
				AllObj.user_list.add(obj);
				AllObj.user_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static Vector<String> E2V(EmployeeBean emp) {
		// 把emp对象转换成vec对象，方便table加行
		Vector<String> vec = new Vector<String>();
		vec.add(emp.getUid() + "");
		vec.add(emp.getUname());
		vec.add(emp.getUpassword());
		vec.add(AllObj.depname.get(emp.getDepid()));
		vec.add(AllObj.rankname.get(emp.getRankid()));
		vec.add(emp.getUgender());
		vec.add(emp.getUtelphone());
		return vec;
	}

	public static void filter(String nm, String tel, String dep, String rank) {
		AllObj.page = 0;
		AllObj.user_show.clear();
		for (EmployeeBean x : AllObj.user_list) {
			if ((nm.equals("") || nm.equals(x.getUname()))
					&& (tel.equals("") || tel.equals(x.getUtelphone()))
					&& (dep.equals("") || dep.equals(AllObj.depname.get(x
							.getDepid())))
					&& (rank.equals("") || rank.equals(AllObj.rankname.get(x
							.getRankid())))) {
				AllObj.user_show.add(x);
			}
		}
	}

	public static void up_table(JTable table, int s, int t) {
		String[] col = new String[] { "ID", "姓名", "密码", "部门", "职务", "性别", "电话" };
		String[][] row = new String[t - s + 1][col.length];
		for (int i = 0; i < t - s + 1; i++) {
			row[i] = E2V(AllObj.user_show.get(s + i)).toArray(row[i]);
		}
		table.setModel(new DefaultTableModel(row, col));
	}

	public static void up_label(JLabel lblxnm) {
		if (AllObj.user_show.size() == 0) {
			lblxnm.setText("没有符合要求的记录");
		} else {
			lblxnm.setText(String.format("共%s条记录，当前显示第%s至第%s条",
					AllObj.user_show.size(), 10 * AllObj.page + 1,
					Math.min(10 * AllObj.page + 10, AllObj.user_show.size())));
		}
	}
}
