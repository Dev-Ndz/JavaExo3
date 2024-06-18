package exo3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);
	    Command command = new Command();
	    String input;
	    System.out.println("Welcome to Trade Data Analyzator");
	    
	    System.out.println("What data do you need ?");
	    input = scanner.nextLine();
	    switch(input) {
	    case "monthly_total":
	    	scanner.close();
	    	break;
	    case "monthly_average":
	    	command.monthlyAverage();
	    	scanner.close();
	    	break;
	    case "yearly_total":
	    	scanner.close();
	    	break;
	    case "yearly_average":
	    	scanner.close();
	    	break;
	    case "quit":
	    	System.out.println("Bisous...");
	    	scanner.close();
	    	break;
    	default:
    		
    		break;
	    }
//	    if(input.equals("coucou"));
//	    System.out.println("coucou");
//	    String anotherInput = scanner.nextLine();
//	    System.out.println(anotherInput);
//	    scanner.close();
//		Options dollars = new Options();
//		Options tonnes = new Options();
//		tonnes.setMeasure("Tonnes");
//		
//		
//
//		System.out.println(TradeDataStatistics.getYearlyTotal(2021, dollars));
//		System.out.println(TradeDataStatistics.getYearlyTotal(2021, tonnes));
//		
//		
//		Overview overv = new Overview();
//		overv.getOverview();
		
	}

}
