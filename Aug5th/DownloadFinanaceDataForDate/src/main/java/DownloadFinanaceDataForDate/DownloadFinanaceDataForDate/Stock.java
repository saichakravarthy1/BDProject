package DownloadFinanaceDataForDate.DownloadFinanaceDataForDate;

import java.util.Date;

public class Stock { 
	
	private double open;
	private double close;
	private double high;
	private double low;
	private int volume;
	private double adjClose;
	private Date date;
	
	public Stock(double open,double close,double high,double low,int volume, double adjClose,Date date) {	
		this.open = open; 
		this.close = close;	
		this.volume = volume; 
		this.high = high; 
		this.low = low; 
		this.adjClose = adjClose; 
		this.date=date;
		
	} 
	
	public double getOpenPrice(){
		return this.open;
	}
	public Date getDate(){
		return this.date;
	}
	public double getClosePrice(){
		return this.close;
	}
	
	
	
	public double getHigh() { 
		return this.high;		
	} 
	
	public double getLow() { 		
		return this.low;		
	} 
	
	public int getVolume() {    
		return this.volume;     
	} 
 
	public double getAdjClose() {    
		return this.adjClose;     
	} 
  
}
