package QO_App;
import java.io.IOException;
import java.util.*;
import java.lang.Object;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchPlayers {
	public List<Double> salaries;
	private  double x;
	private  double mean = 0; 
	private  Double[] sortedSal;

	public static void main(String[] args)
	{

	}
	public void getPlayers()
	{
		salaries =  new ArrayList<Double>();
		try
		{
			Document doc = Jsoup.connect("https://questionnaire-148920.appspot.com/swe/").userAgent("mozilla/17.0").get();
			Elements temp = doc.select("td.player-salary"); //Referenced this link for many of my jsoup methods https://aboullaite.me/jsoup-html-parser-tutorial-examples/


			Locale locale = Locale.US;
			for(Element list:temp)
			{
				String s  = list.getElementsByTag("td").first().text();
				try
				{
					x = Double.parseDouble(s.replaceAll("[^\\d.]", ""));
					salaries.add(x);
				}
				catch(NumberFormatException e)
				{
					x =0;
				}
			}		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		sortedSal = salaries.toArray(new Double[salaries.size()]);
		Arrays.sort(sortedSal, Collections.reverseOrder());
	}
	public double getQO()
	{
		
		for(int j = 0; j<125; j++)
		{
			mean += sortedSal[j]; 
		}
		mean = mean/125; 
		return mean;
	}
	public double getMax()
	{
		double max = 0;
		for(int j = 0; j<125; j++)
		{
			if(sortedSal[j]>max)
				max = sortedSal[j];
		}
		return max;
	}
	public double getMin()
	{
		double min= Double.MAX_VALUE;
		for(int j = 0; j<125; j++)
		{
			if(sortedSal[j]<min && sortedSal[j] !=0)
				min = sortedSal[j];
		}
		return min;
	}

}