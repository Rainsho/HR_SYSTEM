package com.hr_system.util;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.hr_system.bean.ContractBean;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.bean.SalaryBean;
import com.hr_system.bean.TrainingApplyBean;
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
	public static HashMap<Integer, String> appname = new HashMap<Integer, String>();
	public static ArrayList<TrainingApplyBean> tria_list = new ArrayList<TrainingApplyBean>();
	public static HashMap<TrainingPlanBean, Integer> triapp = new HashMap<TrainingPlanBean, Integer>();// 培训计划对应申请状态
	public static HashMap<Integer, Integer> trp_in = new HashMap<Integer, Integer>(); // 已存在的培训计划申请记录及状态
	// salary part
	public static HashMap<Integer, EmployeeBean> user_map = new HashMap<Integer, EmployeeBean>();
	public static ArrayList<SalaryBean> sala_list = new ArrayList<SalaryBean>();
	public static ArrayList<SalaryBean> sala_show = new ArrayList<SalaryBean>();
	public static EmployeeBean user_selected;

}
