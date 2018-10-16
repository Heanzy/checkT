package checkT;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JTable;

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
	private int numOfDataPreGroup;
	private int numOfTimePoint;
	public CheckT() {
		// TODO 自动生成的构造函数存根
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
	public void setTimeAndData(JTable table) throws Exception{
		int start [] = FindTableDataStart(table);
		for(int i = start[0];i < start[0] + numOfTimePoint;i++){
			for(int j = start[1]+1;j < start[1] + numOfDataPreGroup;j++)
				Double sum =0d;
			
		}
			
	}
	public int [] FindTableDataStart(JTable table)throws Exception {
		int [] start =new int[2];
		int column = table.getColumnCount();
		int row = table.getRowCount();
		int N = 0;
		boolean isFound = false;
		for(int i = 0;i<row&&!isFound;i++)
			for(int j = 0;j<column&&!isFound;j++){
				if(table.getValueAt(i, j)!=""){
					start[0]=i;
					start[1]=j;
					isFound = true;
				}
			}
		System.out.println("起始坐标是："+start[0]+start[1]);	
		if(!isFound)
			throw new Exception();
		
		return start;
	    }
	public boolean isPass(){
		return false;
	}
	public void setNumOfGroup(int numOfGroup) {
		this.numOfGroup = numOfGroup;
	}
	public int getNumOfGroup() {
		return numOfGroup;
	}
}
