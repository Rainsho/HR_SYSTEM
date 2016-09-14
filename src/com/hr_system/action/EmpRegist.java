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
			AllObj.user_show.add(obj);
			System.out.println("注册成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

	}

	public static void modify(EmployeeBean emp) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("update employee set depid=?, rankid=?, perid=?, uname=?, upassword=?, ugender=?, utelphone=? where uid=?");
			ORM.pst.setInt(1, emp.getDepid());
			ORM.pst.setInt(2, emp.getRankid());
			ORM.pst.setInt(3, emp.getPerid());
			ORM.pst.setString(4, emp.getUname());
			ORM.pst.setString(5, emp.getUpassword());
			ORM.pst.setString(6, emp.getUgender());
			ORM.pst.setString(7, emp.getUtelphone());
			ORM.pst.setInt(8, emp.getUid());
			ORM.pst.execute();
			System.out.println("修改成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

	public static void delete(EmployeeBean emp) {
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("delete from employee where uid=?");
			ORM.pst.setInt(1, emp.getUid());
			ORM.pst.execute();
			AllObj.user_list.remove(emp);
			AllObj.user_show.remove(emp);
			System.out.println("删除成功！");
			// 删除后会disable删除及修改按钮，同时需要检查是否会导致删除后page不足
			if (AllObj.page != 0) {
				AllObj.page -= AllObj.page > Math
						.ceil(AllObj.user_show.size() / 10.0) - 1 ? 1 : 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}
	}

}
