package checkT;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;

public class CheckT {
	private double b0;
	private double b1;
	private double averageX;
	private double averageY;
    private ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> dataBase = new ArrayList<ArrayList<Double>>();
    private Map<Integer,Double> timeAndData;
    //private ArrayList<Double> averagex = new ArrayList<>();
    //private ArrayList<Double> timeList = new ArrayList<>();
	private double S;
	private int n;
	private double sB1;
	public CheckT() {
		// TODO 自动生成的构造函数存根
	}
	public ArrayList<Double> getAveragex() {
		return averagex;
	}
	public void setsB1(){
		double sumUp = S;
		double sumDown = 0d;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet())
			sumDown += (e.getValue()-averageX)*(e.getValue()-averageX);
		sB1 = S/Math.sqrt(sumDown);
	}
	public void setS(){
		double sumup = 0d;
		double sumdown = n-2;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet())
			sumup += (e.getKey()-b0-b1*e.getValue())*(e.getKey()-b0-b1*e.getValue());
		S = Math.sqrt(sumup/sumdown);
	}
	public double getAverageX() {
		return averageX;
	}
	public double getAverageY() {
		return averageY;
	}
	public double getB0() {
		return b0;
	}
	public double getB1() {
		return b1;
	}
	public ArrayList<ArrayList<Double>> getData() {
		return data;
	}
	public ArrayList<ArrayList<Double>> getDatabase() {
		return dataBase;
	}
	public void setAverageX(double averageX) {
		this.averageX = averageX;
	}
	public void setAverageY(double averageY) {
		this.averageY = averageY;
	}
	public void setB0() {
		b0 = averageY - b1*averageX;
	}
	public void setB1() {
		double sumup = 0d;
		double sumdown = 0d;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet()){
			sumup += (e.getValue()-averageX)*(e.getKey()-averageY);
			sumdown += (e.getValue()-averageX)*(e.getKey()-averageX);
		}
		b1=sumup/sumdown;
	}
	public void setData(ArrayList<ArrayList<Double>> data) {
		this.data = data;
	}
	public void setDatabase(ArrayList<ArrayList<Double>> database) {
		this.dataBase = database;
	}
	
	public void setAverage() {
        for(ArrayList<Double> E:data){
            Double sum = 0d;
            for(Double e:E){
                sum += e;
            }
            averagex.add((double)(sum/E.size()));
        }
    }
	public boolean isPass(){
		return false;
	}
}
