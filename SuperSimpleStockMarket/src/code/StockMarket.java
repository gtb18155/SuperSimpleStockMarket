package code;

import java.util.Date;

public class StockMarket {

	public static void main(String[] args) {
		
		// create broker
		StockBroker broker = new StockBroker();
		
		// inform broker of stocks
		broker.addStock("TEA","Common",		0,    0,	100);
		broker.addStock("POP","Common",		8,    0,	100);
		broker.addStock("ALE","Common",		23,   0,	 60);
		broker.addStock("GIN","Preferred",	8, 0.02,	100);
		broker.addStock("JOE","Common",		13,   0,	250);
		
		// buy and sell some stocks, retrospectively (stock, quantity, price, time-stamp)
		long now = (new Date()).getTime();
		broker.buy( "TEA", 10, 120, now - 20*60*1000);
		broker.buy( "TEA", 20, 110, now - 15*60*1000);
		broker.buy( "TEA", 10, 100, now - 10*60*1000);
		broker.sell("TEA", 10,  90, now -  5*60*1000);
		broker.buy( "POP", 10, 120, now - 20*60*1000);
		broker.buy( "POP", 20, 110, now - 15*60*1000);
		broker.buy( "POP", 10, 100, now - 10*60*1000);
		broker.sell("POP", 30,  90, now -  5*60*1000);
		broker.buy( "ALE", 10,  80, now - 20*60*1000);
		broker.buy( "ALE", 20,  70, now - 15*60*1000);
		broker.buy( "ALE", 10,  60, now - 10*60*1000);
		broker.sell("ALE", 10,  50, now -  5*60*1000);
		broker.buy( "GIN", 10, 120, now - 20*60*1000);
		broker.buy( "GIN", 20, 110, now - 15*60*1000);
		broker.buy( "GIN", 10, 100, now - 10*60*1000);
		broker.sell("GIN", 30,  90, now -  5*60*1000);
		broker.buy( "JOE", 10, 270, now - 20*60*1000);
		broker.buy( "JOE", 20, 260, now - 15*60*1000);
		broker.buy( "JOE", 10, 250, now - 10*60*1000);
		broker.sell("JOE", 10, 240, now -  5*60*1000);		
		
		// Print out TEA figures
		broker.getStock("TEA").printDetails();
		System.out.println("    Dividend yield for a price of  90: " + broker.getDividendYield("TEA",  90));
		System.out.println("    Dividend yield for a price of 100: " + broker.getDividendYield("TEA", 100));
		System.out.println("    Dividend yield for a price of 110: " + broker.getDividendYield("TEA", 110));
		System.out.println("         P/E ratio for a price of  90: " + broker.getPriceDividendRatio("TEA",  90));
		System.out.println("         P/E ratio for a price of 100: " + broker.getPriceDividendRatio("TEA", 100));
		System.out.println("         P/E ratio for a price of 110: " + broker.getPriceDividendRatio("TEA", 110));
		System.out.println("          Volume weighted stock price: " + broker.getVolumeWeightedStockPrice("TEA", now));
		
		// Print out POP figures
		broker.getStock("POP").printDetails();
		System.out.println("    Dividend yield for a price of  90: " + broker.getDividendYield("POP",  90));
		System.out.println("    Dividend yield for a price of 100: " + broker.getDividendYield("POP", 100));
		System.out.println("    Dividend yield for a price of 110: " + broker.getDividendYield("POP", 110));
		System.out.println("         P/E ratio for a price of  90: " + broker.getPriceDividendRatio("POP",  90));
		System.out.println("         P/E ratio for a price of 100: " + broker.getPriceDividendRatio("POP", 100));
		System.out.println("         P/E ratio for a price of 110: " + broker.getPriceDividendRatio("POP", 110));
		System.out.println("          Volume weighted stock price: " + broker.getVolumeWeightedStockPrice("POP", now));
	
		// Print out ALE figures
		broker.getStock("ALE").printDetails();
		System.out.println("    Dividend yield for a price of 50: " + broker.getDividendYield("ALE", 50));
		System.out.println("    Dividend yield for a price of 60: " + broker.getDividendYield("ALE", 60));
		System.out.println("    Dividend yield for a price of 70: " + broker.getDividendYield("ALE", 70));
		System.out.println("         P/E ratio for a price of 50: " + broker.getPriceDividendRatio("ALE", 50));
		System.out.println("         P/E ratio for a price of 60: " + broker.getPriceDividendRatio("ALE", 60));
		System.out.println("         P/E ratio for a price of 70: " + broker.getPriceDividendRatio("ALE", 70));
		System.out.println("          Volume weighted stock price: " + broker.getVolumeWeightedStockPrice("ALE", now));	

		// Print out GIN figures
		broker.getStock("GIN").printDetails();
		System.out.println("    Dividend yield for a price of  90: " + broker.getDividendYield("GIN",  90));
		System.out.println("    Dividend yield for a price of 100: " + broker.getDividendYield("GIN", 100));
		System.out.println("    Dividend yield for a price of 110: " + broker.getDividendYield("GIN", 110));
		System.out.println("         P/E ratio for a price of  90: " + broker.getPriceDividendRatio("GIN",  90));
		System.out.println("         P/E ratio for a price of 100: " + broker.getPriceDividendRatio("GIN", 100));
		System.out.println("         P/E ratio for a price of 110: " + broker.getPriceDividendRatio("GIN", 110));
		System.out.println("          Volume weighted stock price: " + broker.getVolumeWeightedStockPrice("GIN", now));
	
		// Print out JOE figures
		broker.getStock("JOE").printDetails();
		System.out.println("    Dividend yield for a price of 240: " + broker.getDividendYield("JOE", 240));
		System.out.println("    Dividend yield for a price of 250: " + broker.getDividendYield("JOE", 250));
		System.out.println("    Dividend yield for a price of 260: " + broker.getDividendYield("JOE", 260));
		System.out.println("         P/E ratio for a price of 240: " + broker.getPriceDividendRatio("JOE", 240));
		System.out.println("         P/E ratio for a price of 250: " + broker.getPriceDividendRatio("JOE", 250));
		System.out.println("         P/E ratio for a price of 260: " + broker.getPriceDividendRatio("JOE", 260));
		System.out.println("          Volume weighted stock price: " + broker.getVolumeWeightedStockPrice("JOE", now));
	
		// Print out the GBCE All Share Index
		System.out.println("\nGBCE All Share Index: " + broker.getGBCEAllShareIndex());
		
	}

}
