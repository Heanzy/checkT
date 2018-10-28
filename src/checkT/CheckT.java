package checkT;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

public class CheckT {
	private double b0;
	private double b1;
	private double averageX;
	private double averageY;
    //private ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> dataBase = new ArrayList<ArrayList<Double>>();
    public Map<Integer,Double> timeAndData = new HashMap<>();
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
			sumDown += (e.getKey()-averageX)*(e.getKey()-averageX);
		sB1 = S/Math.sqrt(sumDown);
	}
	public void setS(){
		double sumup = 0d;
		double sumdown = n-2;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet())
			sumup += (e.getValue()-b0-b1*e.getKey())*(e.getValue()-b0-b1*e.getKey());
		System.out.println("方差:"+sumup/sumdown);
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
//	public ArrayList<ArrayList<Double>> getData() {
//		return data;
//	}
	public ArrayList<ArrayList<Double>> getDatabase() {
		return dataBase;
	}
	public void setAverageX() {
		double sum = 0d;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet()){
			sum += e.getKey();
		}
		averageX = sum/numOfTimePoint;
	}
	public void setAverageY() {
		double sum = 0d;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet()){
			sum += e.getValue();
		}
		averageY = sum/numOfTimePoint;
	}
	public void setB0() {
		b0 = averageY - b1*averageX;
	}
	public void setB1() {
		double sumup = 0d;
		double sumdown = 0d;
		for(Map.Entry<Integer, Double> e:timeAndData.entrySet()){
			sumup += (e.getKey()-averageX)*(e.getValue()-averageY);
			sumdown += (e.getKey()-averageX)*(e.getKey()-averageX);
		}
		System.out.println("B1的分子"+sumup);
		System.out.println("B1的分母"+sumdown);
		b1=sumup/sumdown;
	}
//	public void setData(ArrayList<ArrayList<Double>> data) {
//		this.data = data;
//	}
	public void setDatabase(ArrayList<ArrayList<Double>> database) {
		this.dataBase = database;
	}
	

	public void setTimeAndData(JTable table) {
		int start [] = FindTableDataStart(table);
		System.out.println(numOfTimePoint);
		System.out.println(numOfDataPreGroup);
		for(int i = start[0];i < start[0] + numOfTimePoint;i++){
			double sum=0d;
			for(int j = start[1]+1;j < start[1] + 1 + numOfDataPreGroup;j++){
				sum = sum+Double.parseDouble((String) table.getValueAt(i, j));
			}
			System.out.println("每一行的和为:"+sum);
			System.out.println("现在行数:"+i);
			System.out.println("现在遍历到的值为:"+table.getValueAt(i, start[1]));
			timeAndData.put(Integer.parseInt((String)table.getValueAt(i, start[1])), sum/numOfDataPreGroup);
		}
		System.out.println(timeAndData);
	}
	public int [] FindTableDataStart(JTable table) {
		int [] start =new int[2];
		int column = table.getColumnCount();
		int row = table.getRowCount();
		int N = 0;
		boolean isFound = false;
		for(int i = 0;i<row&&!isFound;i++)
			for(int j = 0;j<column&&!isFound;j++){
				if(table.getValueAt(i, j)!=null){
					start[0]=i;
					start[1]=j;
					isFound = true;
				}
			}
		System.out.println("起始坐标是："+start[0]+start[1]);	
//		if(!isFound)
//			throw new Exception();
		
		return start;
	    }
	public boolean isPass(){
		return false;
	}

	public void setNumOfDataPreGroup(int numOfDataPreGroup) {
		this.numOfDataPreGroup = numOfDataPreGroup;
	}
	public void setNumOfTimePoint(int numOfTimePoint) {
		this.numOfTimePoint = numOfTimePoint;
	}
	public int getNumOfDataPreGroup() {
		return numOfDataPreGroup;
	}
	public ArrayList<ArrayList<Double>> getDataBase() {
		return dataBase;
	}
	public int getNumOfTimePoint() {
		return numOfTimePoint;
	}
	public double getS() {
		return S;
	}
	public double getsB1() {
		return sB1;
	}
	public Map<Integer, Double> getTimeAndData() {
		return timeAndData;
	}
	public int getN() {
		return n;
	}
	public void setDataBase(ArrayList<ArrayList<Double>> dataBase) {
		this.dataBase = dataBase;
	}
	public void setN(int n) {
		this.n = n;
	}
	 public int setNODPGFromTable(JTable table,int [] start) {
	    	int column = table.getColumnCount();
	    	int row = table.getRowCount();
	    	int N = 0;
	    	for(int i = start[1];i<column;i++)
	    		if(table.getValueAt(start[0], i)!=null)
	    			N++;
	    	return N-1;		
	    }
	    public int setNOTPFromTable(JTable table,int [] start) {
	    	int row = table.getRowCount();
	    	int M = 0;
	    	for(int i = start[0];i<row;i++)
	    		if(table.getValueAt(i, start[1])!=null)
	    			M++;
	    	return M;	
	    }
	    public Map<Integer, Double> dataTest(){
	    	Map<Integer, Double> map = new HashMap<>();
	    	map.put(0, 87.60);
	    	map.put(1, 87.46);
	    	map.put(3, 87.58);
	    	map.put(6, 87.74);
	    	return map;
	    }
}
