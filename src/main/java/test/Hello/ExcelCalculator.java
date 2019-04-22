package test.Hello;

import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelCalculator {

	 public static void main( String[] args) throws Exception
	    {
	    	FileInputStream ab=new FileInputStream("C:\\Users\\Reddy\\Documents\\Numbers.xlsx");
	    	Workbook work=new XSSFWorkbook(ab);
	    	Sheet sheet=work.getSheetAt(0);
	    	
	    	Iterator<Row> rowIterator=sheet.iterator();
	    	rowIterator.next();
	    	while(rowIterator.hasNext()) {
	    		Row r=rowIterator.next();
	    		int a=(int)r.getCell(0).getNumericCellValue();
	    		int x=(int)r.getCell(1).getNumericCellValue();
	    		int y = (int)r.getCell(2).getNumericCellValue();
	    		Calculator object = new Calculator (x, y);
	    		
	    		System.out.println("This result is for Roll No" +a);
				
	    		object.add();
	    		object.substract();
	    		object.multiplication();	    	
	    		
	    		System.out.println("__________________________");
	    		     
	    	}
	    	ab.close();
	    	    	
			
		
	}
	 

}

