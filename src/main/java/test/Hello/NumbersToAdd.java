package test.Hello;

import java.util.ArrayList;
import java.util.Scanner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NumbersToAdd {
	
	ArrayList<Integer> listofinputs = new ArrayList<Integer>();
	int noofinputs = 0;
	
	@Given("^Ask the user to provide how many number they wants us to add$")
	public void ask_the_user_to_provide_how_many_number_they_wants_us_to_add() throws Throwable {
		System.out.println("How many number would you like to add");
		
		Scanner sc = new Scanner (System.in);
		noofinputs = sc.nextInt();
	}

	@When("^I take those numbers input from user$")
	public void i_take_those_numbers_input_from_user() throws Throwable {
		
		for ( int i=0; i<noofinputs; i++) {
			
						System.out.println("Enter the number to add");
						
						Scanner sc1 = new Scanner (System.in);
						listofinputs.add(sc1.nextInt());
							
		}
	}

	@Then("^I should add the numbers and display the result$")
	public void i_should_add_the_numbers_and_display_the_result() throws Throwable {
		//System.out.println(listofinputs);
		int sum = 0;
		int i=0;
		for (i=0; i<noofinputs-1; i++) {
			sum = sum+listofinputs.get(i);
		
			System.out.print(listofinputs.get(i) +"+");
		}
		sum=sum+listofinputs.get(i);
		System.out.println(listofinputs.get(i)+"="+sum);
		}
		
		
		
	}
// 1+2=3
// take input from excel file





