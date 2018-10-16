package checkT;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
/** 
* ExcelAdapter ʵ�� JTables �еĸ���ճ��
* �����幦�ܡ� ���������õļ��������ݸ�ʽ 
* �� Excel ���õļ������ʽ���ݡ����ṩ�� 
* ֧�ֵ� JTables �� Excel ��Ļ������� 
*/
public class ExcelAdapter implements ActionListener
{
private String rowstring,value;
private Clipboard system;
private StringSelection stsel;
private JTable jTable1 ;
/** 
* Excel �������� JTable ���ɣ�
* ��ʵ���� JTable �ϵĸ���ճ�� 
* ���ܣ����䵱�������������
*/
public ExcelAdapter(JTable myJTable)
{
jTable1 = myJTable;
KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
// ȷ�����ư����û����Զ�������޸�
// ��ʵ������������ϵĸ��ƹ��ܡ�
KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
// ȷ��ճ�������û����Զ�������޸�
// ��ʵ������������ϵĸ��ƹ��ܡ�
jTable1.registerKeyboardAction(this,"Copy",copy,JComponent.WHEN_FOCUSED);
jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);
system = Toolkit.getDefaultToolkit().getSystemClipboard();
}
/**
* ������������ͼ��Ĺ�����������
*/
public JTable getJTable() {return jTable1;}
public void setJTable(JTable jTable1) {this.jTable1=jTable1;}
/**
* �����Ǽ�����ʵ�ֵİ����ϼ������ַ�����
* �˴������������ƺ�ճ�� ActionCommands��
* ���������ڵ�Ԫ���ѡ����ѡ����Ч��
* ���Ҵ˺��ƶ����޷�ִ�С�
* ճ���ķ����ǽ�ѡ�����ݵ����Ͻ���
* JTable �ĵ�ǰѡ�����ݵĵ�һ��Ԫ�ض��롣
*/
public void actionPerformed(ActionEvent e)
{
if (e.getActionCommand().compareTo("Copy")==0)
{
StringBuffer sbf=new StringBuffer();
// �����ȷ�����ǽ�ѡ���˵�Ԫ���
// ���ڿ�
int numcols=jTable1.getSelectedColumnCount();
int numrows=jTable1.getSelectedRowCount();
int[] rowsselected=jTable1.getSelectedRows();
int[] colsselected=jTable1.getSelectedColumns();
if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
numrows==rowsselected.length) &&
(numcols-1==colsselected[colsselected.length-1]-colsselected[0] &&
numcols==colsselected.length)))
{
JOptionPane.showMessageDialog(null, "Invalid Copy Selection",
"Invalid Copy Selection",
JOptionPane.ERROR_MESSAGE);
return;
}
for (int i=0;i<numrows;i++)
{
for (int j=0;j<numcols;j++)
{
sbf.append(jTable1.getValueAt(rowsselected[i],colsselected[j]));
if (j<numcols-1) sbf.append(" ");
}
sbf.append(" ");
}
stsel = new StringSelection(sbf.toString());
system = Toolkit.getDefaultToolkit().getSystemClipboard();
system.setContents(stsel,stsel);
}
if (e.getActionCommand().compareTo("Paste")==0)
{
System.out.println("Trying to Paste");
int startRow=(jTable1.getSelectedRows())[0];
int startCol=(jTable1.getSelectedColumns())[0];
try
{
String trstring= (String)(system.getContents(this).
getTransferData(DataFlavor.stringFlavor));
System.out.println("String is:"+trstring);
StringTokenizer st1=new StringTokenizer(trstring,"\n");
System.out.println(st1.toString());
for(int i=0;st1.hasMoreTokens();i++)
{
rowstring=st1.nextToken();
System.out.println(rowstring);
StringTokenizer st2=new StringTokenizer(rowstring,"\t");
for(int j=0;st2.hasMoreTokens();j++)
{
value=(String)st2.nextToken();
if (startRow+i< jTable1.getRowCount() &&
startCol+j< jTable1.getColumnCount())
jTable1.setValueAt(value,startRow+i,startCol+j);
System.out.println("Putting "+ value+"atrow="+startRow+i+"column="+startCol+j);
}
}
}
catch(Exception ex){ex.printStackTrace();}
}
}
}
