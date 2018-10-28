package checkT;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class DrawMath {
 
	public static void drawG(double b1,double b0) {
 
		XYSeries series = new XYSeries("xySeries");
		for (int x = 0; x < 12; x++) {
			double y = b1*x+b0;
			series.add(x, y);
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"y = "+b1+"*x"+b0, // chart title
				"ʱ��", // x axis label
				"����ֵ", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL,
				false, // include legend
				false, // tooltips
				false // urls
				);
 
		ChartFrame frame = new ChartFrame("����t������ȶ��Լ���", chart);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
 
}
