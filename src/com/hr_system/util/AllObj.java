package com.hr_system.util;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.hr_system.bean.CandiBean;
import com.hr_system.bean.ContractBean;
import com.hr_system.bean.EmployeeBean;
import com.hr_system.bean.InfoBean;
import com.hr_system.bean.RecruBean;
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
	public static HashMap<Integer, TrainingPlanBean> trin_map = new HashMap<Integer, TrainingPlanBean>();
	public static HashMap<Integer, String> appname = new HashMap<Integer, String>();
	public static ArrayList<TrainingApplyBean> tria_list = new ArrayList<TrainingApplyBean>();
	public static HashMap<TrainingPlanBean, Integer> triapp = new HashMap<TrainingPlanBean, Integer>();// ��ѵ�ƻ���Ӧ����״̬
	public static HashMap<Integer, Integer> trp_in = new HashMap<Integer, Integer>(); // �Ѵ��ڵ���ѵ�ƻ������¼��״̬
	// salary part
	public static HashMap<Integer, EmployeeBean> user_map = new HashMap<Integer, EmployeeBean>();
	public static ArrayList<SalaryBean> sala_list = new ArrayList<SalaryBean>();
	public static ArrayList<SalaryBean> sala_show = new ArrayList<SalaryBean>();
	public static EmployeeBean user_selected;
	// recruitment
	public static ArrayList<RecruBean> recr_list = new ArrayList<RecruBean>();
	public static ArrayList<RecruBean> recr_show = new ArrayList<RecruBean>();
	public static HashMap<Integer, RecruBean> recr_map = new HashMap<Integer, RecruBean>();
	public static ArrayList<CandiBean> cand_list = new ArrayList<CandiBean>();
	public static ArrayList<CandiBean> cand_show = new ArrayList<CandiBean>();
	// info
	public static ArrayList<InfoBean> info_list = new ArrayList<InfoBean>();
	public static ArrayList<InfoBean> info_show = new ArrayList<InfoBean>();
	// trainingcheck
	public static ArrayList<TrainingApplyBean> tria_tc_list = new ArrayList<TrainingApplyBean>();
	public static ArrayList<TrainingApplyBean> tria_tc_show = new ArrayList<TrainingApplyBean>();

}
