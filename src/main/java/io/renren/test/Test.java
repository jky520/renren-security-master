package io.renren.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");//小写的mm表示的是分钟  
		String dstr="2017-6";  
		Date date=sdf.parse(dstr);  
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);  
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		
		int startDate = 0;
		int endDate = 0;
		if(startDate == 0 && endDate == 0) {
			startDate = 1;
			endDate = lastDay;
		}
		if(endDate > lastDay) endDate = lastDay;
		SimpleDateFormat sdf1 = null;
		Calendar cal1=Calendar.getInstance();
		String cDate = null;
		String[] zcTime = {"08时50分-11时50分","14时10分-18时00分"}; // 正常时间
		String[] zcTimen = {"08时50分-11时50分","14时10分-18时00分","18时50分-20时50分"}; // 正常时间(包括晚上)
		String[] ecTime = {"08时50分-11时50分","14时10分-17时00分"}; // 周二时间
		String[] ecTimen = {"08时50分-11时50分","14时10分-17时00分","18时50分-20时50分"}; // 周二时间(包括晚上)
		String[] weekDays  = {"日","一","二","三","四","五","六"};
		int[] classCounts = {3,4,2};
		
		String dt = "";
		String week = "";
		String ks = "";
		String classroom = "J1703";
		String adress = "软件开发一部";
		String content = "java基础";
		String teacher = "姜坤银";
		int classCount = 0;
		boolean isWeek = true;
		boolean isNight = true;
		for(int i = startDate; i<=endDate;i++) {
			sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			cDate = dstr+"-"+i;
			date = sdf1.parse(cDate); 
			cal1.setTime(date);
			int w = cal1.get(Calendar.DAY_OF_WEEK) - 1;
			String wk = weekDays[w];
			System.out.println("================================================================================================");
			dt = (String) (i < 10 ? "0"+i : i+"");
			week = wk;
			if("二".equals(wk)) {
				int n = 0;
				if(isNight) {
					for(int t=0; t<ecTimen.length;t++) {
						ks = ecTimen[t];
						if(t>1) n=t;
						classCount = classCounts[n];
						System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
					}
				} else {
					for(int t=0; t<ecTime.length;t++) {
						ks = ecTime[t];
						classCount = classCounts[n];
						System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
					}
				}
				
			} else {
				if(isNight) {
					for(int t=0; t<ecTimen.length;t++) {
						ks = zcTimen[t];
						classCount = classCounts[t];
						if(isWeek) {
							System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
						} else {
							if(!("六".equals(wk) || "日".equals(wk))) {
								System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
							}
						}
					}
				} else {
					for(int t=0; t<ecTime.length;t++) {
						ks = zcTime[t];
						classCount = classCounts[t];
						if(isWeek) {
							System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
						} else {
							if(!("六".equals(wk) || "日".equals(wk))) {
								System.out.println(dt+"\t"+week+"\t"+ks+"\t"+classroom+"\t"+adress+"\t"+content+"\t"+teacher+"\t"+classCount+"\t");
							}
						}
					}
				}
			}
		}
	}
}
