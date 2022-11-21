package br.com.fiap.fintech.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Function {

	
	public static String DoubleToCurrency(Double value, Locale local) {
		
		NumberFormat coin = NumberFormat.getCurrencyInstance(local);
		return coin.format(value);		
	}
	
	
	public static String DateToMonthInFull(Date date, Locale local) {
		
		SimpleDateFormat df_monthfull = new SimpleDateFormat("MMMMM", local);				
		String monthinfull = df_monthfull.format(date);
			   monthinfull = monthinfull.substring(0,1).toUpperCase()+monthinfull.substring(1);
		
		return monthinfull;
	}
	
	
}
