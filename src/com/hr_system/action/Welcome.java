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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  hhʱmm��ss��");
		while (true) {
			label.setText("��ǰʱ�䣺" + sdf.format(new Date().getTime()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
