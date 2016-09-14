package com.hr_system.action;

import java.sql.SQLException;

import com.hr_system.bean.EmployeeBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class EmpRegist {

	public static boolean ck(EmployeeBean obj) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("select * from employee where uname=?");
			ORM.pst.setString(1, obj.getUname());
			ORM.rs = ORM.pst.executeQuery();
			return ORM.rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
		return false;
	}

	public static void add(EmployeeBean obj) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into employee (depid, rankid, perid, uname, upassword, ugender, utelphone) values (?, ?, ?, ?, ?, ?, ?)");
			// uid自增，不能插入，省略列名，在mysql环境下会报错
			ORM.pst.setInt(1, obj.getDepid());
			ORM.pst.setInt(2, obj.getRankid());
			ORM.pst.setInt(3, obj.getPerid());
			ORM.pst.setString(4, obj.getUname());
			ORM.pst.setString(5, obj.getUpassword());
			ORM.pst.setString(6, obj.getUgender());
			ORM.pst.setString(7, obj.getUtelphone());
			ORM.pst.execute();
			// 更新数据库返回的uid
			ORM.pst = ORM.con
					.prepareStatement("select uid from employee where uname=?");
			ORM.pst.setString(1, obj.getUname());
			ORM.rs = ORM.pst.executeQuery();
			ORM.rs.next();
			obj.setUid(ORM.rs.getInt(1));
			// 加入总员工数组
			AllObj.user_list.add(obj);
			System.out.println("注册成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

	}

}
