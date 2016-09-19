package com.hr_system.action;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

import com.hr_system.bean.InfoBean;
import com.hr_system.util.AllObj;
import com.hr_system.util.ORM;

public class Welcome implements Runnable {
	JLabel label;

	public Welcome(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HHʱmm��ss��");
		while (true) {
			label.setText("��ǰʱ�䣺" + sdf.format(new Date().getTime()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void att(JLabel label) {
		if (AllObj.user == null) {
			System.out.println("���ȵ�½��");
			return;
		}
		Calendar time = Calendar.getInstance();
		time.setTime(new Date());
		int hh = time.get(Calendar.HOUR_OF_DAY);
		int attmarkid;
		if (hh < 9) {
			attmarkid = 1;
		} else if (hh >= 17) {
			attmarkid = 2;
		} else {
			attmarkid = 3;
		}
		int i = 0;
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			ORM.con();
			ORM.pst = ORM.con
					.prepareStatement("insert into attendance (attmarkid, uid, atttime) values (?, ?, ?)");
			ORM.pst.setInt(1, attmarkid);
			ORM.pst.setInt(2, AllObj.user.getUid());
			ORM.pst.setTimestamp(3, new Timestamp(time.getTimeInMillis())); // ʹ��setDate�ᶪʧʱ������
			ORM.pst.execute();
			ORM.pst = ORM.con
					.prepareStatement("select * from attendance where uid=? and YEAR(atttime)=? and MONTH(atttime)=? and DAY(atttime)=?");
			ORM.pst.setInt(1, AllObj.user.getUid());
			ORM.pst.setInt(2, time.get(Calendar.YEAR));
			ORM.pst.setInt(3, time.get(Calendar.MONTH) + 1);
			ORM.pst.setInt(4, time.get(Calendar.DAY_OF_MONTH));
			ORM.rs = ORM.pst.executeQuery();
			while (ORM.rs.next()) {
				str += sdf.format(ORM.rs.getTimestamp(4)) + "  ";
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ORM.close();
		}

		System.out.println("�򿨳ɹ���");
		label.setText("���칲��" + i + "�Σ��ֱ�Ϊ��" + str);
	}

	public static String show_info() {
		int infoid = 3;// Ҫ��ʾ�Ĺ��棬db�����ֶΣ���ʱ�ֶ�����
		if (AllObj.info_list.size() == 0) {
			InfoA.load();
		}
		InfoBean obj = null;
		for (InfoBean x : AllObj.info_list) {
			if (x.getInfoid() == infoid) {
				obj = x;
				break;
			}
		}
		if (obj == null) {
			return "û�������ö�����";
		}
		String str = "������⣺" + obj.getInfotitle() + "\n����ʱ�䣺"
				+ obj.getInfodate() + "\n�������ģ�\n" + obj.getInfocontent();
		return str;
	}
}
