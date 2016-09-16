package com.hr_system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tools {
	public static String checkdate(String x) {
		// ��ʽyyyy-MM-dd
		if (!x.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			System.out.println("���ڸ�ʽ���Ϸ�");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(sdf.parse(x));
		} catch (ParseException e) {
			System.out.println("���ڸ�ʽ���Ϸ�");
		}
		return null;
	}

}
