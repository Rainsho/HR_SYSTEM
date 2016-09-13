package com.hr_system.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.hr_system.bean.EmployeeBean;

public class AllObj {
	public static EmployeeBean user;
	public static HashMap<Integer, String> depname = new HashMap<Integer, String>();
	public static HashMap<Integer, String> rankname = new HashMap<Integer, String>();
	public static HashMap<Integer, String> pername = new HashMap<Integer, String>();
	public static ArrayList<EmployeeBean> user_list = new ArrayList<EmployeeBean>();
	public static ArrayList<EmployeeBean> user_show = new ArrayList<EmployeeBean>();
	public static int page = 0;

}
