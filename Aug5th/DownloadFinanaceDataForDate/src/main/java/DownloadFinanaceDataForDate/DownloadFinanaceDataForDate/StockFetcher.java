package DownloadFinanaceDataForDate.DownloadFinanaceDataForDate;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockFetcher {  
	
	/*
	* Returns a Stock Object that contains info about a specified stock.
	* @param 	symbol the company's stock symbol
	* @return 	a stock object containing info about the company's stock
	* @see Stock
	*/
	static List<Stock> getStock(String symbol) throws ParseException {  
		String sym = symbol.toUpperCase();
		 double open=0.0;
		 double close=0.0;
		 double high=0.0;
		 double low=0.0;
		 int volume=0;
		 double adjClose=0.0;
		 Date date=new Date();
		try { 
			//http://ichart.finance.yahoo.com/table.csv?s=AAPL&d=9&e=12&f=2013&g=d&a=8&b=7&c=1984&ignore=.csv
			/*String quotes=''h ttp://ichart.finance.yahoo.com/table.csv?s="+StockSymbol+"&d="+Final date Month +"&e="+Final date day+"&f="+Final date Year +"&g=d&a="+Start date Month +"&b="+Start date day+"&c="+Start date Year+"&ignore=.csv";*/
			
			// Retrieve CSV File
			URL yahoo = new URL("http://ichart.finance.yahoo.com/table.csv?s="+ symbol + "&d=7&e=27&f=2016&g=d&a=6&b=24&c=2016&ignore=.csv");
			URLConnection connection = yahoo.openConnection(); 
			InputStreamReader is = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(is);  
			
			
			// Parse CSV Into Array
			List<Stock> stock=new ArrayList<Stock>();
			 br.readLine();
			 String line=null;
		while((line=br.readLine())!=null)
		{
			//Only split on commas that aren't in quotes
			String[] stockinfo = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			System.out.println("line:"+line);
			// Handle Our Data
			StockHelper sh = new StockHelper();
			System.out.println("date:"+stockinfo[0]);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			date = formatter.parse(stockinfo[0]);
			//date=new Date("12-12-1988");
			open = sh.handleDouble(stockinfo[1]);
			high = sh.handleDouble(stockinfo[2]);
			low = sh.handleDouble(stockinfo[3]);
			close = sh.handleDouble(stockinfo[4]);
			volume = sh.handleInt(stockinfo[5]);
			adjClose = sh.handleDouble(stockinfo[6]);
			stock.add(new Stock(open, close, high,low,volume,adjClose,date));
			
		}	
		return stock;

		} catch (IOException e) {
			Logger log = Logger.getLogger(StockFetcher.class.getName()); 
			log.log(Level.SEVERE, e.toString(), e);
			return null;
		}
		
		
		
		
	}

	
}

