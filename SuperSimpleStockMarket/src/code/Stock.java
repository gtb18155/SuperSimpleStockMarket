package code;

import java.util.ArrayList;

public class Stock {
	
	private String symbol;
	private String type;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private ArrayList<Trade> 	trades;
	
	public Stock(String s, String t, double l, double f, double p) {
		symbol = s;
		type = t;
		lastDividend = l;
		fixedDividend = f;
		parValue = p;
		trades = new ArrayList<>();
	}
	
	public void setSymbol(String s){
		symbol = s;
	}

	public void setType(String t){
		type = t;
	}

	public void setLastDividend(double l){
		lastDividend = l;
	}

	public void setFixedDividend(double f){
		fixedDividend = f;
	}

	public void setParValue(double p){
		parValue = p;
	}
	
	public void buy(int q, double p, long t){
		trades.add(new Trade("buy", q, p, t));
	}
	
	public void sell(int q, double p, long t){
		trades.add(new Trade("sell", q, p, t));
	}
	
	public void removeTrade(Trade t){
		trades.remove(t);
	}	

	public String getSymbol(){
		return symbol;
	}

	public String getType(){
		return type;
	}

	public double getLastDividend(){
		return lastDividend;
	}

	public double getFixedDividend(){
		return fixedDividend;
	}

	public double getParValue(){
		return parValue;
	}

	public ArrayList<Trade> getTrades() {
		return trades;
	}
	
	public double getDividendYield(double price) {
		if (type == "Common") {
			return lastDividend/price;
		} else {
			return fixedDividend*parValue/price;
		}
	}
	
	public double getPriceDividendRatio(double price){
		return price/lastDividend;
	}
	
	public double getVolumeWeightedStockPrice(long time){
		if (trades.size() == 0) { // no trades
			System.out.println("There have been no trades of " + symbol + ".");
			return 1; 
		}
		double n = 0;
		double d = 0;
		for (Trade trade : trades) {
			if (time - trade.getTime() <= 15*60*1000) {
				n = n + trade.getPrice()*trade.getQuantity();
				d = d + trade.getQuantity();
			}
		}
		if (d == 0) {
			System.out.println("There have been no trades of " + symbol + " in the last 15 minutes.");
			return 1;
		}
		return n/d; 
	}
	
	public void printDetails() {
		if (type == "Common") {
			System.out.println("\n" + symbol + ", " + type + ", last dividend " + lastDividend + ", par value " + parValue);
		} else {
			System.out.print("\n" + symbol + ", " + type + ", last dividend " + lastDividend);
			System.out.println(", fixed dividend " + fixedDividend + ", par value " + parValue);
		}
	}
}
