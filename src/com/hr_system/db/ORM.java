package com.hr_system.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ORM {

	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=";

	private String USER;
	private String PSWD;
	private String DB;

	Connection con;
	Statement sta;
	ResultSet rs;
	ResultSetMetaData rsmd;

	public static void main(String[] args) {
		/*
		 * ORM o1 = new ORM("sa", "root", "test101"); for (ArrayList<String> x :
		 * o1.dql("select * from tb_Prod where id > 5")) {
		 * System.out.println(x); } System.out.println(""); ORM o2 = new
		 * ORM("sa", "root", "HUAWEI"); for (ArrayList<String> x :
		 * o2.dql("select top 20 * from employee")) { System.out.println(x); }
		 * System.out.println("");
		 * o2.dml("update employee set salary = salary+1 where employeeid = 1");
		 */
	}

	public ORM(String u, String p, String db) {
		this.USER = u;
		this.PSWD = p;
		this.DB = db;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ArrayList<String>> dql(String sql) {
		try {
			con = DriverManager.getConnection(URL + DB, USER, PSWD);
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
			rsmd = rs.getMetaData();
			int c = rsmd.getColumnCount();
			ArrayList<ArrayList<String>> arr1 = new ArrayList<ArrayList<String>>();
			while (rs.next()) {
				ArrayList<String> arr2 = new ArrayList<String>();
				for (int i = 0; i < c; i++) {
					arr2.add(rs.getString(i + 1));
				}
				arr1.add(arr2);
			}
			return arr1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sta != null)
					sta.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public void dml(String sql) {
		try {
			con = DriverManager.getConnection(URL + DB, USER, PSWD);
			sta = con.createStatement();
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sta != null)
					sta.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<ArrayList<String>> dql(String sql, int a) { // ¼Ó±íÍ·
		try {
			con = DriverManager.getConnection(URL + DB, USER, PSWD);
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
			rsmd = rs.getMetaData();
			int c = rsmd.getColumnCount();
			ArrayList<ArrayList<String>> arr1 = new ArrayList<ArrayList<String>>();
			ArrayList<String> arr2 = new ArrayList<String>();
			for (int i = 0; i < c; i++) {
				arr2.add(rsmd.getColumnName(i + 1));
			}
			arr1.add(arr2);
			while (rs.next()) {
				arr2 = new ArrayList<String>();
				for (int i = 0; i < c; i++) {
					arr2.add(rs.getString(i + 1));
				}
				arr1.add(arr2);
			}
			return arr1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sta != null)
					sta.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public String[][] AL2A(ArrayList<ArrayList<String>> al) {
		int r = al.size();
		int c = al.get(0).size();
		String[][] a = new String[r][c];
		for (int i = 0; i < r; i++) {
			a[i] = al.get(i).toArray(a[i]);
		}
		return a;
	}

}