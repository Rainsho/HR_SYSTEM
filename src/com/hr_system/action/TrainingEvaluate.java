package com.hr_system.action;

import java.sql.SQLException;

import com.hr_system.bean.TrainingEvaluateBean;
import com.hr_system.bean.TrainingPlanBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class TrainingEvaluate {

	public static TrainingEvaluateBean load(TrainingPlanBean obj, int i) {
		try {
			ORM.con();
			if (i == 1) {
				ORM.pst = ORM.con
						.prepareStatement("select * from trainingevaluate where uid=? and trpid=?");
			} else {
				ORM.pst = ORM.con
						.prepareStatement("select * from trainingfeedback where uid=? and trpid=?");
			}
			ORM.pst.setInt(1, AllObj.user.getUid());
			ORM.pst.setInt(2, obj.getTrpid());
			ORM.rs = ORM.pst.executeQuery();
			if (ORM.rs.next()) {
				TrainingEvaluateBean obj_tre = new TrainingEvaluateBean(
						ORM.rs.getInt(1), ORM.rs.getInt(2), ORM.rs.getInt(3),
						ORM.rs.getString(4));
				return obj_tre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		return null;
	}

	public static void update(TrainingEvaluateBean obj_tre, int i) {
		try {
			ORM.con();
			if (i == 1) {
				ORM.pst = ORM.con
						.prepareStatement("update trainingevaluate set tretext=? where treid=?");
			} else {
				ORM.pst = ORM.con
						.prepareStatement("update trainingfeedback set trftext=? where trfid=?");
			}
			ORM.pst.setString(1, obj_tre.getTretext());
			ORM.pst.setInt(2, obj_tre.getTreid());
			ORM.pst.execute();
			System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void add(TrainingEvaluateBean obj_tre, int i) {
		try {
			ORM.con();
			if (i == 1) {
				ORM.pst = ORM.con
						.prepareStatement("insert into trainingevaluate (uid, trpid, tretext) values (?, ?, ?)");
			} else {
				ORM.pst = ORM.con
						.prepareStatement("insert into trainingfeedback (uid, trpid, trftext) values (?, ?, ?)");
			}
			ORM.pst.setInt(1, obj_tre.getUid());
			ORM.pst.setInt(2, obj_tre.getTrpid());
			ORM.pst.setString(3, obj_tre.getTretext());
			ORM.pst.execute();
			if (i == 1) {
				ORM.pst = ORM.con
						.prepareStatement("select treid from trainingevaluate where uid=? and trpid=?");
			} else {
				ORM.pst = ORM.con
						.prepareStatement("select trfid from trainingfeedback where uid=? and trpid=?");
			}
			ORM.pst.setInt(1, obj_tre.getUid());
			ORM.pst.setInt(2, obj_tre.getTrpid());
			ORM.rs = ORM.pst.executeQuery();
			ORM.rs.next();
			obj_tre.setTreid(ORM.rs.getInt(1));
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}
}
