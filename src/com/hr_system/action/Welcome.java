package com.hr_system.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Welcome implements Runnable {
	JLabel label;

	public Welcome(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  hh时mm分ss秒");
		while (true) {
			label.setText("当前时间：" + sdf.format(new Date().getTime()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
