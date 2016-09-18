package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.EmployeeBean;
import com.hr_system.bean.SalaryBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Salary {

	public static void load() {
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			// 加载申请状态
			ORM.rs = ORM.sta.executeQuery("select * from applystate");
			while (ORM.rs.next()) {
				AllObj.appname.put(ORM.rs.getInt(1), ORM.rs.getString(2));
			}
			// load salary bean list
			ORM.rs = ORM.sta.executeQuery("select * from salary");
			while (ORM.rs.next()) {
				SalaryBean obj = new SalaryBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3), ORM.rs.getInt(4),
						ORM.rs.getInt(5), ORM.rs.getInt(6), ORM.rs.getInt(7),
						ORM.rs.getInt(8), ORM.rs.getInt(9), ORM.rs.getInt(10),
						ORM.rs.getString(11).substring(0, 7));
				AllObj.sala_list.add(obj);
				AllObj.sala_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		// load user_map
		if (AllObj.user_list.size() == 0) {
			EmpManage.load();
		}
		for (EmployeeBean x : AllObj.user_list) {
			AllObj.user_map.put(x.getUid(), x);
		}

	}

	public static void up_table(JTable table) {
		String[] col = new String[] { "记录编号", "员工部门", "员工姓名", "薪酬状态", "基本工资",
				"住房公积金", "基本养老", "健康保险", "失业保险", "报销款", "绩效奖", "月份" };
		String[][] row = new String[AllObj.sala_show.size()][col.length];
		for (int i = 0; i < row.length; i++) {
			Vector<String> vec = new Vector<String>();
			vec.add(AllObj.sala_show.get(i).getSalid() + "");
			vec.add(AllObj.depname.get(AllObj.user_map.get(
					AllObj.sala_show.get(i).getUid()).getDepid()));
			vec.add(AllObj.user_map.get(AllObj.sala_show.get(i).getUid())
					.getUname());
			vec.add(AllObj.appname.get(AllObj.sala_show.get(i).getAppid()));
			vec.add(AllObj.sala_show.get(i).getSalbasic() + "");
			vec.add(AllObj.sala_show.get(i).getSalhouse() + "");
			vec.add(AllObj.sala_show.get(i).getSalold() + "");
			vec.add(AllObj.sala_show.get(i).getSalhealth() + "");
			vec.add(AllObj.sala_show.get(i).getSalemp() + "");
			vec.add(AllObj.sala_show.get(i).getSalrefund() + "");
			vec.add(AllObj.sala_show.get(i).getSalperformance() + "");
			vec.add(AllObj.sala_show.get(i).getSaldate() + "");
			row[i] = vec.toArray(row[i]);
		}
		table.setModel(new DefaultTableModel(row, col) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col < 4) {
					return false;
				} else {
					return true;
				}
			}
		});
	}

	public static void filter(String appname, String depname, String uname,
			String saldate) {
		AllObj.sala_show.clear();
		for (SalaryBean x : AllObj.sala_list) {
			if ((appname.equals("全部") || appname.equals(AllObj.appname.get(x
					.getAppid())))
					&& (depname.equals("全部") || depname.equals(AllObj.depname
							.get(AllObj.user_map.get(x.getUid()).getDepid())))
					&& (uname.equals("") || uname.equals(AllObj.user_map.get(
							x.getUid()).getUname()))
					&& (saldate.equals("") || saldate.equals(x.getSaldate()))) {
				AllObj.sala_show.add(x);
			}
		}
	}

	public static void update(SalaryBean obj, int[] int2up, String saldate) {
		// update obj
		int i = 0;
		obj.setSalbasic(int2up[i++]);
		obj.setSalhouse(int2up[i++]);
		obj.setSalold(int2up[i++]);
		obj.setSalhealth(int2up[i++]);
		obj.setSalemp(int2up[i++]);
		obj.setSalrefund(int2up[i++]);
		obj.setSalperformance(int2up[i++]);
		obj.setSaldate(saldate);
		obj.setAppid(5);// 修改后，强行把appid设置为5
		// update db
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update salary set salbasic=?, salhouse=?, salold=?, salhealth=?, salemp=?, salrefund=?, salperformance=?, saldate=? where salid=?");
			for (int j = 0; j < int2up.length; j++) {
				ORM.pst.setInt(j + 1, int2up[j]);
			}
			ORM.pst.setString(8, saldate + "-01");
			ORM.pst.setInt(9, obj.getSalid());
			ORM.pst.execute();
			ORM.pst = ORM.con
					.prepareStatement("update salary set appid=5 where salid=?");
			ORM.pst.setInt(1, obj.getSalid());
			ORM.pst.execute();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void add(EmployeeBean obj, int[] int_sala, String saldate) {
		try {
			// add db
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into salary (uid, appid, salbasic, salhouse, salold, salhealth, salemp, salrefund, salperformance, saldate) values (?, 5, ?, ?, ?, ?, ?, ?, ?, ?)");
			ORM.pst.setInt(1, obj.getUid());
			for (int j = 0; j < int_sala.length; j++) {
				ORM.pst.setInt(j + 2, int_sala[j]);
			}
			ORM.pst.setString(9, saldate + "-01");
			ORM.pst.execute();
			// add obj
			int i = 0;
			SalaryBean temp = new SalaryBean();
			temp.setSalbasic(int_sala[i++]);
			temp.setSalhouse(int_sala[i++]);
			temp.setSalold(int_sala[i++]);
			temp.setSalhealth(int_sala[i++]);
			temp.setSalemp(int_sala[i++]);
			temp.setSalrefund(int_sala[i++]);
			temp.setSalperformance(int_sala[i++]);
			temp.setSaldate(saldate);
			temp.setAppid(5);// 修改后，强行把appid设置为5
			temp.setUid(obj.getUid());
			ORM.pst = ORM.con
					.prepareStatement("select salid from salary where uid=? and saldate=?");
			ORM.pst.setInt(1, obj.getUid());
			ORM.pst.setString(2, saldate + "-01");
			ORM.rs = ORM.pst.executeQuery();
			ORM.rs.next();
			temp.setSalid(ORM.rs.getInt(1));
			AllObj.sala_list.add(temp);
			AllObj.sala_show.add(temp);
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
