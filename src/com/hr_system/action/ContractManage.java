package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.ContractBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class ContractManage {

	public static void load() {
		try {
			ORM.con();
			ORM.sta = ORM.con.createStatement();
			ORM.rs = ORM.sta
					.executeQuery("select a.*, b.uname, c.depname from contract as a, employee as b, department as c where a.uid=b.uid and b.depid=c.depid");
			while (ORM.rs.next()) {
				ContractBean obj = new ContractBean(ORM.rs.getInt(1),
						ORM.rs.getString(8), ORM.rs.getString(9),
						ORM.rs.getString(3), ORM.rs.getString(4).substring(0,
								10), ORM.rs.getInt(5), ORM.rs.getString(6),
						ORM.rs.getString(7), ORM.rs.getInt(2));
				AllObj.cont_list.add(obj);
				AllObj.cont_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static Vector<String> C2V(ContractBean obj) {
		// 对象转集合
		Vector<String> vec = new Vector<String>();
		vec.add(obj.getConid() + "");
		vec.add(obj.getUname());
		vec.add(obj.getDepname());
		vec.add(obj.getConname());
		vec.add(obj.getCondate());
		vec.add(obj.getConyear() + "");
		vec.add(obj.getContype());
		vec.add(obj.getConinfo());
		vec.add("双击编辑");
		vec.add("双击删除");
		return vec;
	}

	public static void up_table(JTable table, int s, int t) {
		String[] col = new String[] { "合同编号", "合同持有人", "持有人部门", "合同名称", "签约时间",
				"合同年限", "合同性质", "合同内容", "编辑", "删除" };
		String[][] row = new String[t - s + 1][col.length];
		for (int i = 0; i < t - s + 1; i++) {
			row[i] = C2V(AllObj.cont_show.get(s + i)).toArray(row[i]);
		}
		table.setModel(new DefaultTableModel(row, col) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column < 3 || column > 7) {
					return false;
				} else {
					return true;
				}
			}
		});
	}

	public static void up_label(JLabel lblxnm) {
		if (AllObj.cont_show.size() == 0) {
			lblxnm.setText("没有符合要求的记录");
		} else {
			lblxnm.setText(String.format("共%s条记录，当前显示第%s至第%s条",
					AllObj.cont_show.size(), 10 * AllObj.page + 1,
					Math.min(10 * AllObj.page + 10, AllObj.cont_show.size())));
		}
	}

	public static void filter(String conname, String contype) {
		AllObj.page = 0;
		AllObj.cont_show.clear();
		for (ContractBean x : AllObj.cont_list) {
			if ((conname.equals("") || conname.equals(x.getConname()))
					&& (contype.equals("") || contype.equals(x.getContype()))) {
				AllObj.cont_show.add(x);
			}
		}
	}

	public static void update(ContractBean obj, String conname, String condate,
			int conyear, String contype, String coninfo) {
		// 更新obj
		obj.setConname(conname);
		obj.setCondate(condate);
		obj.setConyear(conyear);
		obj.setContype(contype);
		obj.setConinfo(coninfo);
		// 更新数据库
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update contract set conname=?, condate=?, conyear=?, contype=?, coninfo=? where conid=?");
			ORM.pst.setString(1, conname);
			ORM.pst.setString(2, condate);
			ORM.pst.setInt(3, conyear);
			ORM.pst.setString(4, contype);
			ORM.pst.setString(5, coninfo);
			ORM.pst.setInt(6, obj.getConid());
			ORM.pst.execute();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void delete(ContractBean obj) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("delete from contract where conid=?");
			ORM.pst.setInt(1, obj.getConid());
			ORM.pst.execute();
			AllObj.cont_list.remove(obj);
			AllObj.cont_show.remove(obj);
			System.out.println("删除成功！");
			// 检查是否会导致删除后page不足
			if (AllObj.page != 0) {
				AllObj.page -= AllObj.page > Math
						.ceil(AllObj.cont_show.size() / 10.0) - 1 ? 1 : 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void add(ContractBean obj) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into contract (uid, conname, condate, conyear, contype, coninfo) values (?, ?, ?, ?, ?, ?)");
			ORM.pst.setInt(1, obj.getUid());
			ORM.pst.setString(2, obj.getConname());
			ORM.pst.setString(3, obj.getCondate());
			ORM.pst.setInt(4, obj.getConyear());
			ORM.pst.setString(5, obj.getContype());
			ORM.pst.setString(6, obj.getConinfo());
			ORM.pst.execute();
			// 更新数据库返回的uid
			ORM.pst = ORM.con
					.prepareStatement("select conid from contract where uid=? and conname=? and condate=? and conyear=? and contype=? and coninfo=?");
			ORM.pst.setInt(1, obj.getUid());
			ORM.pst.setString(2, obj.getConname());
			ORM.pst.setString(3, obj.getCondate());
			ORM.pst.setInt(4, obj.getConyear());
			ORM.pst.setString(5, obj.getContype());
			ORM.pst.setString(6, obj.getConinfo());
			ORM.rs = ORM.pst.executeQuery();
			ORM.rs.next();
			obj.setConid(ORM.rs.getInt(1));
			// 加入总员工数组
			AllObj.cont_list.add(obj);
			AllObj.cont_show.add(obj);
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

}
