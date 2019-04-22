package test.Hello;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NumbersToAddExcelInput {

	ArrayList<Integer> listofinputs = new ArrayList<Integer>();
	int numbersToAdd = 0;
	int positionofinput = 0;
	
	@Given("^Ask the user to provide how many numbers they wants to add$")
	public void ask_the_user_to_provide_how_many_number_they_wants_us_to_add() throws Throwable {
		System.out.println("How many number would you like to add");
		Scanner sc = new Scanner (System.in);
		numbersToAdd = sc.nextInt();
		System.out.println("From which row would you like to start adding the numbers");
		positionofinput = sc.nextInt();
		}
	
	@When("^I take those numbers input from Excel sheet \"([^\"]*)\"$")
	public void i_take_those_numbers_input_from_Excel_sheet(String arg1) throws Throwable {
		FileInputStream numberlist=new FileInputStream(arg1);
		Workbook work=new XSSFWorkbook(numberlist);
		Sheet sheet=work.getSheetAt(0);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	   Iterator<Row>rowIterator=sheet.iterator();
		rowIterator.next();
			while(rowIterator.hasNext()) {
			Row r=rowIterator.next();
			listofinputs.add((int)r.getCell(0).getNumericCellValue());
			}
	}
	@Then("^I add the numbers and display the result correctly$")
	public void i_should_add_the_numbers_and_display_the_result() throws Throwable {
		//System.out.println(listofinputs);
		int sum = 0;
		int i=0;
		int count=0;
		for (i=positionofinput; count<numbersToAdd-1; i++, count++) {
			sum = sum+listofinputs.get(i);
		
			System.out.print(listofinputs.get(i) +"+");
		}
		sum=sum+listofinputs.get(i);
		System.out.println(listofinputs.get(i)+"="+sum);
		}
		
		
		
	}

