package DownloadFinanaceDataForDate.DownloadFinanaceDataForDate;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DownloadFinanaceDataForDate.DownloadFinanaceDataForDate.Stock;
import DownloadFinanaceDataForDate.DownloadFinanaceDataForDate.StockFetcher;

public class StockHelp { 
	
	
	public static void main(String[] args) throws ParseException, IOException { 
		
		List<Stock> facebook=new ArrayList<Stock>();
		facebook = StockFetcher.getStock("AAPL");
		BufferedWriter bf=new BufferedWriter(new FileWriter("Stocks.txt"));
		int j=8;
		for(int i=0;i<facebook.size()-1;i++)
		{
			String line="";
			String tweet_line="";
			line+=facebook.get(i).getDate()+":";
			line+=facebook.get(i).getOpenPrice()+":";
			line+=facebook.get(i).getHigh()+":";
			line+=facebook.get(i).getLow()+":";
			line+=facebook.get(i).getClosePrice()+":";
			line+=facebook.get(i).getVolume()+":";
			line+=facebook.get(i).getAdjClose()+"\n";
			System.out.println("date:"+facebook.get(i).getDate());
			double diff=facebook.get(i).getClosePrice()-facebook.get(i).getOpenPrice();
			int res=0;
			if(diff>=0.0)
			{
				res=1;
			}
			System.out.println("date:"+facebook.get(i).getDate()+"-res:"+res);
			
			
			BufferedReader b1=new BufferedReader(new FileReader("./tweets"+j+"_aapl.txt"));
			while((tweet_line=b1.readLine())!=null)
			{
				if(tweet_line.isEmpty() || tweet_line.trim().equals("") || tweet_line.trim().equals("\n"))
					continue;
				//System.out.println(tweet_line);
				//if(tweet_line.equals("\n"))
					//continue;
			    bf.write(tweet_line+"^"+res);
			    bf.write("\n");
			}
			j--;
            b1.close();
          
			
			
		}
        bf.close();


		
	} 

}
