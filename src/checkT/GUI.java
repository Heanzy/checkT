package checkT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private CheckT checkT;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 871, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 35, 621, 355);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		panel.add(table);
		ExcelAdapter excelAdapter = new ExcelAdapter(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(658, 73, -15, 144);
		panel.add(scrollPane);
		
		JLabel lblB = new JLabel("b1");
		lblB.setFont(new Font("宋体", Font.PLAIN, 25));
		lblB.setBounds(641, 123, 58, 30);
		panel.add(lblB);
		
		textField = new JTextField();
		textField.setBounds(759, 123, 66, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblB_1 = new JLabel("b0");
		lblB_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblB_1.setBounds(641, 187, 58, 30);
		panel.add(lblB_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(759, 187, 66, 30);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkT = new CheckT();
				
					int start[] = checkT.FindTableDataStart(table);
					checkT.setNumOfDataPreGroup(checkT.setNODPGFromTable(table, start));
					checkT.setNumOfTimePoint(checkT.setNOTPFromTable(table, start));
					System.out.println("每行有数据个数:"+checkT.getNumOfDataPreGroup());
					System.out.println("行数:"+checkT.getNumOfTimePoint());
					checkT.setN(checkT.getNumOfTimePoint());
					checkT.setTimeAndData(table);
					//checkT.timeAndData = checkT.dataTest();
					checkT.setAverageX();
					System.out.println("x的平均值:"+checkT.getAverageX());
					checkT.setAverageY();
					System.out.println("y的平均值:"+checkT.getAverageY());
					checkT.setB1();
					System.out.println("B1:"+checkT.getB1());
					checkT.setB0();
					System.out.println("B0:"+checkT.getB0());
					checkT.setS();
					System.out.println("S:"+checkT.getS());
					checkT.setsB1();
					System.out.println("SB1:"+checkT.getsB1());
					textField.setText(String.valueOf(checkT.getB1()));
					textField_1.setText(String.valueOf(checkT.getB0()));
				
					// TODO 自动生成的 catch 块
//					System.out.println(e1.getMessage());
//					JOptionPane.showMessageDialog(null, "数据为空", "提示",JOptionPane.WARNING_MESSAGE);
				
				
				
			}
		});
		btnNewButton.setBounds(714, 386, 93, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u751F\u6210\u56FE\u50CF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawMath.drawG(checkT.getB1(), checkT.getB0());
			}
		});
		button.setBounds(714, 419, 93, 23);
		panel.add(button);
	}
}
