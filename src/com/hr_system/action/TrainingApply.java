package com.hr_system.action;

import java.sql.SQLException;

import com.hr_system.bean.TrainingApplyBean;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class TrainingApply {

	public static void load() {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("select * from trainingapply where uid=?");
			ORM.pst.setInt(1, AllObj.user.getUid());
			ORM.rs = ORM.pst.executeQuery();
			AllObj.tria_list.clear();
			while (ORM.rs.next()) {
				TrainingApplyBean obj = new TrainingApplyBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3), ORM.rs.getInt(4));
				AllObj.tria_list.add(obj);
				AllObj.trp_in.put(ORM.rs.getInt(3), ORM.rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		for (TrainingPlanBean x : AllObj.trin_show) {
			if (AllObj.trp_in.keySet().contains(x.getTrpid())) {
				AllObj.triapp.put(x, AllObj.trp_in.get(x.getTrpid())); // 已存在的apply记录及状态
			} else {
				AllObj.triapp.put(x, 4); // 不存在的默认为未申请
			}
		}
	}

	public static void filter(String depname, String trpname, String appname) {
		AllObj.trin_show.clear();
		for (TrainingPlanBean x : AllObj.trin_list) {
			if ((depname.equals("全部") || depname.equals(x.getDepname()))
					&& (trpname.equals("") || trpname.equals(x.getTrpname()))
					&& (appname.equals("全部") || appname.equals(AllObj.appname
							.get(AllObj.triapp.get(x))))) {
				AllObj.trin_show.add(x);
			}
		}
	}

	public static void update(TrainingPlanBean obj, int i) {
		int traid = 0;
		// 更新tria_list
		for (TrainingApplyBean x : AllObj.tria_list) {
			if (x.getTrpid() == obj.getTrpid()) {
				x.setAppid(i);
				traid = x.getTraid();
				break;
			}
		}
		// 更新triapp
		AllObj.triapp.put(obj, i);
		// 更新数据库
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update trainingapply set appid=? where traid=?");
			ORM.pst.setInt(1, i);
			ORM.pst.setInt(2, traid);
			ORM.pst.execute();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void add(TrainingPlanBean obj) {
		int traid = 0;
		// 更新数据库
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into trainingapply (uid, trpid, appid) values (?, ?, ?)");
			ORM.pst.setInt(1, AllObj.user.getUid());
			ORM.pst.setInt(2, obj.getTrpid());
			ORM.pst.setInt(3, 1);
			ORM.pst.execute();
			ORM.pst = ORM.con
					.prepareStatement("select traid from trainingapply where uid=? and trpid=? and appid=?");
			ORM.pst.setInt(1, AllObj.user.getUid());
			ORM.pst.setInt(2, obj.getTrpid());
			ORM.pst.setInt(3, 1);
			ORM.rs = ORM.pst.executeQuery();
			ORM.rs.next();
			traid = ORM.rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		// 更新triapp
		AllObj.triapp.put(obj, 1);
		// 加入trp_in
		AllObj.trp_in.put(obj.getTrpid(), 1);
		// 加入tria_list
		TrainingApplyBean temp = new TrainingApplyBean(traid,
				AllObj.user.getUid(), obj.getTrpid(), 1);
		AllObj.tria_list.add(temp);
		System.out.println("申请成功");
	}

}
