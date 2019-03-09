package code;

import java.util.ArrayList;

public class StockBroker {
	
	private ArrayList<Stock> stocks;

	public StockBroker(){
		stocks = new ArrayList<>();
	}	
	
	public int addStock(String s, String t, double l, double f, double p) {
		if (t != "Common" && t != "Preferred") {
			System.out.println("Invalid stock type. Must be Common or Preferred.");
			return -1;
		}
		if (l < 0) {
			System.out.println("Invalid last dividend value. Must be greater than zero.");
			return -2;
		}
		if (f < 0) {
			System.out.println("Invalid fixed dividend value. Must be greater than zero.");
			return -3;
		}
		if (p < 0) {
			System.out.println("Invalid par value. Must be greater than zero.");
			return -4;
		}
		for (Stock ss : stocks) {
			if (s == ss.getSymbol()) {
				System.out.println("Stock symbol " + s + " already used.");
				return -5;
			}
		}
		stocks.add(new Stock(s, t, l, f, p));
		return 0;
	}
	
	public void buy(String s, int q, double p, long t) {
		getStock(s).buy(q, p, t);
	}
	
	public void sell(String s, int q, double p, long t) {
		getStock(s).sell(q, p, t);
	}
	
	public void removeStock(String symbol) {
		for (Stock stock : stocks) {
			if (symbol == stock.getSymbol()) {
				stocks.remove(stock);
				return;
			}
		}
	}

	public Stock getStock(String symbol) {
		for (Stock stock : stocks) {
			if (symbol == stock.getSymbol()) {
				return stock;
			}
		}
		return null;
	}
	
	public double getDividendYield(String symbol, double price){
		return getStock(symbol).getDividendYield(price);
	}

	public double getPriceDividendRatio(String symbol, double price){
		return getStock(symbol).getPriceDividendRatio(price);
	}

	public double getVolumeWeightedStockPrice(String symbol, long time){
		return getStock(symbol).getVolumeWeightedStockPrice(time);
	}

	public double getGBCEAllShareIndex(){
		double product = 1;
		double number = stocks.size();
		for (Stock stock : stocks) {
			product = product*stock.getParValue();
		}
		return Math.pow(product, 1/number);
	}

}
