package util;

import java.sql.Date;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util
{	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static NumberFormat nf1 = NumberFormat.getInstance(new Locale("pt","BR"));
	private static NumberFormat nf2 = NumberFormat.getInstance(new Locale("pt","BR"));

	static
	{	nf2.setMaximumFractionDigits (2);	   // O default é 3.
		nf2.setMinimumFractionDigits (2);
		nf2.setGroupingUsed(false);
	}

	public static Date strToDate(String umaData)
	{	String dia = umaData.substring(0,2);
		String mes = umaData.substring(3,5);
		String ano = umaData.substring(6,10);

		return Date.valueOf(ano + "-" + mes + "-" + dia);
	}

	public static String dateToStr(Date umaData)
	{	return sdf.format(umaData);
	}

	public static double strToDouble(String valorMonetario)
		throws ParseException
	{	if (valorMonetario == null || "".equals(valorMonetario))
			return 0;
		else   
		{	return nf1.parse(valorMonetario).doubleValue();
		}		
	}

	public static String doubleToStr(double valorMonetario)
		throws ParseException
	{	return nf2.format(valorMonetario);	
	}
}