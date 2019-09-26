
package oop;
import java.lang.Math.*;
public class Stock {
    
    private String underlyingAsset;
    private String symbol;
    private double[] prices;
    private double startPrice;
    private double endPrice;
    private static int StockCount =0;

    public Stock(String underlyingAsset, String symbol, double[] prices, double startPrice, double endPrice) {
        this.underlyingAsset = underlyingAsset;
        this.symbol = symbol;
        this.prices = prices;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        StockCount++;
    }

    public String getUnderlyingAsset() {
        return underlyingAsset;
    }

    public void setUnderlyingAsset(String underlyingAsset) {
        this.underlyingAsset = underlyingAsset;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }

    public static int getStockCount() {
        return StockCount;
    }
    
    public void displayPrice(){
        for(int i=0; i < this.prices.length; i++){
            System.out.print(this.prices[i]);
        }
    }
    
    public double Sum(){
        double sum =0;
        for(int i=0; i < this.prices.length; i++){
            sum += this.prices[i];
            
        }
        return sum;
    }
    public double Average(){
        return this.Sum() / this.prices.length;
        
    }
    public double Varience(){
        double avg = this.Average();
        double minus =0;
        for(int i =0; i < this.prices.length; i++){
            minus = ((this.prices[i] - avg) * 2) / this.prices.length;
        }
        return minus;
    }
    
    public double Sigma(){
        return Math.sqrt(this.Varience());
    }
    public double Range(){
        return Math.abs(this.prices[0] - this.prices[this.prices.length-1]);
    }
    public double Heigh(){
        double heigh =0;
        for(int i=0; this.prices.length > i; i++){
            if(this.prices[i] > heigh){
                heigh = this.prices[i];
            }
        }
        return heigh;
    }
    public double Low(){
        double low =0;
        for(int i=0; this.prices.length > i; i++){
            if(this.prices[i] < low){
                low = this.prices[i];
            }
        }
        return low;
    }
    
    public static void displayStockInfo(Stock s){
        System.out.println(s.Average());
        System.out.println(s.Heigh());
        System.out.println(s.Low());
        System.out.println(s.Range());
    }
    public static String compareStockPerfomnce(Stock s1, Stock s2){
        if(s1.Range() > s2.Range()){
            return s1.getSymbol();
        }else{
            return s2.getSymbol();
        }
    }
    public static void main(String[] args) {
        double[] prices = {43.05, 43.10, 44.05,44.25, 44.50, 46.25};
        Stock s1 = new Stock("Intel Coporation", "INTL", prices, prices[0], prices[prices.length-1]);
        displayStockInfo(s1);
    }
    
}
