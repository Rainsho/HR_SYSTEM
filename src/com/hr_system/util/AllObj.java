package com.hr_system.util;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.hr_system.bean.ContractBean;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.bean.TrainingPlanBean;

public class AllObj {
	public static EmployeeBean user;
	public static HashMap<Integer, String> depname = new HashMap<Integer, String>();
	public static HashMap<Integer, String> rankname = new HashMap<Integer, String>();
	public static HashMap<Integer, String> pername = new HashMap<Integer, String>();
	public static ArrayList<EmployeeBean> user_list = new ArrayList<EmployeeBean>();
	public static ArrayList<EmployeeBean> user_show = new ArrayList<EmployeeBean>();
	public static int page = 0;
	public static JTable jtb;
	public static JLabel jlb;
	public static ArrayList<ContractBean> cont_list = new ArrayList<ContractBean>();
	public static ArrayList<ContractBean> cont_show = new ArrayList<ContractBean>();
	public static ArrayList<TrainingPlanBean> trin_list = new ArrayList<TrainingPlanBean>();
	public static ArrayList<TrainingPlanBean> trin_show = new ArrayList<TrainingPlanBean>();

}
