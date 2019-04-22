package test.Hello;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	FileInputStream fs=new FileInputStream("C:\\Users\\Reddy\\Documents\\Book1.xlsx");
    	Workbook work=new XSSFWorkbook(fs);
    	Sheet sheet=work.getSheetAt(0);
    	
    	Iterator<Row> rowIterator=sheet.iterator();
    
    	rowIterator.next();
    	while(rowIterator.hasNext()) {
    		Row r=rowIterator.next();
    		int roll=(int)r.getCell(0).getNumericCellValue();
    		String name=r.getCell(1).getStringCellValue();
    		int Math = (int)r.getCell(2).getNumericCellValue();
    		
    		
    		 new Student8(roll,name,Math).display();
    		
    	}
    	fs.close();
    	
    	
    	
    	
       
    }
}

class Student8{  
	 int rollno;  
	 String name;  
	 int math;
	 static String college ="ITS";  
	   
	 Student8(int r,String n, int m){  
	 rollno = r;  
	 name = n; 
	 math = m;
	 }  
	void display (){System.out.println(rollno+" "+name+" "+math+" "+college);}  
}
