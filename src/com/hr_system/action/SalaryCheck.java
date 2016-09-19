package com.hr_system.action;

import java.sql.SQLException;

import com.hr_system.bean.SalaryBean;
import com.hr_system.util.ORM;

public class SalaryCheck {

	public static void update(SalaryBean obj, int i) {
		// update obj
		obj.setAppid(i);
		// update db
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update salary set appid=? where salid=?");
			ORM.pst.setInt(1, i);
			ORM.pst.setInt(2, obj.getSalid());
			ORM.pst.execute();
			System.out.println("ÐÞ¸Ä³É¹¦");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

	}

}
