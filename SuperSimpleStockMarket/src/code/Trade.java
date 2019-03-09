package code;

public class Trade {

	private long time;
	private int quantity;
	private String type; // buy or sell
	private double price;
	
	public Trade(String tt, int q,  double p, long t) {
		time = t;
		quantity = q;
		type = tt;
		price = p;
	}
	
	public void setTime(long t) {
		time = t;
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public long getTime() {
		return time;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public Double getPrice() {
		return price;
	}
}
