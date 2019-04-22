package test.Hello;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentMarks {
	int avg [] = new int [5] ;
	int rollNo [] = new int [5];	


	@Given("^the student subject mark list \"([^\"]*)\"$")
	public void the_student_subject_mark_list(String arg1) throws Throwable {
		FileInputStream marklist=new FileInputStream(arg1);
		Workbook work=new XSSFWorkbook(marklist);
		Sheet sheet=work.getSheetAt(0);

		Iterator<Row> rowIterator=sheet.iterator();
		rowIterator.next();
		int i=0;
		while(rowIterator.hasNext()) {
			Row r=rowIterator.next();
			rollNo [i]=(int)r.getCell(0).getNumericCellValue();
			String name=(String)r.getCell(1).getStringCellValue();
			int math = (int)r.getCell(2).getNumericCellValue();
			int science = (int)r.getCell(3).getNumericCellValue();
			int civics = (int)r.getCell(4).getNumericCellValue();
			avg[i] = (math+science+civics)/3;
			i++;
		}

	}


	@When("^printed the mark list where the condition is if percentage is >(\\d+)% then pass and <(\\d+)% is fail$")
	public void printed_the_mark_list_where_the_condition_is_if_percentage_is_then_pass_and_is_fail(int arg1, int arg2) throws Throwable {

		for(int i=0;i<6;i++) {


			if (avg[i]>90) {
				System.out.println(rollNo[i]+" "+ "You are passed the exam with"  +avg[i] + "%");
			}else {
				System.out.println(rollNo[i]+ " "+"Sorry ! you failed, your percentage is" +avg[i]+ "%");
			}
		}	
	}

	



}

