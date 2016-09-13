package com.hr_system.action;

import java.sql.SQLException;

import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Login {

	public static EmployeeBean login(String uname, String upassword, int perid) {
		ORM.con();
		try {
			ORM.pst = ORM.con
					.prepareStatement("select * from employee where uname=? and upassword=? and perid=?");
			ORM.pst.setString(1, uname);
			ORM.pst.setString(2, upassword);
			ORM.pst.setInt(3, perid);
			ORM.rs = ORM.pst.executeQuery();
			if (ORM.rs.next()) {
				EmployeeBean user = new EmployeeBean(ORM.rs.getInt(1),
						ORM.rs.getInt(2), ORM.rs.getInt(3), ORM.rs.getInt(4),
						ORM.rs.getString(5), ORM.rs.getString(6),
						ORM.rs.getString(7), ORM.rs.getString(8));
				AllObj.user = user;
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

		return null;
	}

}
