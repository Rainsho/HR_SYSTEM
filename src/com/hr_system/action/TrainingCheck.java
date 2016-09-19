package com.hr_system.action;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hr_system.bean.TrainingApplyBean;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class TrainingCheck {

	public static void up_table(JTable table) {
		String[] col = new String[] { "培训部门", "培训对象", "培训主题", "培训负责人", "培训地址",
				"培训时间", "培训月时", "申请人", "申请人部门", "申请状态" };
		String[][] row = new String[AllObj.tria_tc_show.size()][col.length];
		int i = 0, j = 0;
		TrainingPlanBean obj;
		for (TrainingApplyBean x : AllObj.tria_tc_show) {
			obj = AllObj.trin_map.get(x.getTrpid());
			Vector<String> vec = new Vector<String>();
			vec.add(AllObj.depname.get(obj.getDepid()));
			vec.add(obj.getTrppeople());
			vec.add(obj.getTrpname());
			vec.add(obj.getTrpadmin());
			vec.add(obj.getTrpplace());
			vec.add(obj.getTrpdate());
			vec.add(obj.getTrpmonth() + "");
			vec.add(AllObj.user_map.get(x.getUid()).getUname());
			vec.add(AllObj.depname.get(AllObj.user_map.get(x.getUid())
					.getDepid()));
			vec.add(AllObj.appname.get(x.getAppid()));
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

	public static void load() {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("select * from trainingapply where appid != 4");
			ORM.rs = ORM.pst.executeQuery();
			AllObj.tria_tc_list.clear();
			AllObj.tria_tc_show.clear();
			while (ORM.rs.next()) {
				TrainingApplyBean obj = new TrainingApplyBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3), ORM.rs.getInt(4));
				AllObj.tria_tc_list.add(obj);
				AllObj.tria_tc_show.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void filter(String depname, String appname, String trpname,
			String uname) {
		AllObj.tria_tc_show.clear();
		TrainingPlanBean obj;
		for (TrainingApplyBean x : AllObj.tria_tc_list) {
			obj = AllObj.trin_map.get(x.getTrpid());
			if ((depname.equals("全部") || depname.equals(AllObj.depname.get(obj
					.getDepid())))
					&& (appname.equals("全部") || appname.equals(AllObj.appname
							.get(x.getAppid())))
					&& (trpname.equals("") || trpname.equals(obj.getTrpname()))
					&& (uname.equals("") || uname.equals(AllObj.user_map.get(
							x.getUid()).getUname()))) {
				AllObj.tria_tc_show.add(x);
			}
		}
	}

	public static void update(TrainingApplyBean obj, int i) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update trainingapply set appid=? where traid=?");
			ORM.pst.setInt(1, i);
			ORM.pst.setInt(2, obj.getTraid());
			ORM.pst.execute();
			System.out.println("审批成功");
			load();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
