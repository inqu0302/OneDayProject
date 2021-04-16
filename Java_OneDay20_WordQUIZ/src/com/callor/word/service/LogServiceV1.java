package com.callor.word.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogServiceV1 {

	public void Log(String msg) {
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		try {
			
			String logName = "src/com/callor/word/Log.txt";
			fileWriter = new FileWriter(logName);
			out = new PrintWriter(fileWriter);
			
			Date date = new Date();
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");
			String time = sd.format(date);
			
			out.println("=".repeat(50));
			out.printf("발생일자 : %s/n", time);
			out.printf("Exception : %s\n", msg);
			out.println("=".repeat(50));
			
			out.flush();
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
