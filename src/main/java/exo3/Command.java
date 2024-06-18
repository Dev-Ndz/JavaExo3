package exo3;

import java.util.Scanner;

public class Command {
	
    private final Scanner scanner;
    private TradeDataStatistics stats;
    
    public Command() {
        scanner = new Scanner(System.in);
	    this.stats = new TradeDataStatistics();
    }

	public Options promptOptions() {
		Options options = new Options();

		System.out.println("Specify country (default All) : " );
		String country = scanner.nextLine();
		if (!country.isEmpty()) {
			options.setCountry(country);
		}

		System.out.println("Specify commodity (default All) : " );
		String commodity = scanner.nextLine();
		if (!commodity.isEmpty()) {
			options.setCommodity(commodity); // Correct method call
		}

		System.out.println("Specify transport_mode (default All) : " );
		String transport = scanner.nextLine();
		if (!transport.isEmpty()) {
			options.setTransportMode(transport); // Correct method call
		}

		System.out.println("Specify measure (default All) : " );
		String measure = scanner.nextLine();
		if (!measure.isEmpty()) {
			options.setMeasure(measure); // Correct method call
		}

		return options;
	}
	
	public int selectYear() {
		int year;
		System.out.println("Select Year - type a number between 2015 and 2021 : " );
		year = scanner.nextInt();
		while(year<2015 || year>2021) {
			System.out.println("Wrong input - Please type a number between 2015 and 2021 : " );
			year = scanner.nextInt();
		}
		scanner.nextLine();
		return year;
	}
	public int selectMonth() {
		int month;
		System.out.println("Select Month - type a number between 1 and 12 : " );
		month = scanner.nextInt();
		while(month < 1 || month > 12) {
			System.out.println("Wrong input - Please type a number between 1 and 12 : " );
			month = scanner.nextInt();
		}
		scanner.nextLine();
		return month;
	}
	
	public void monthlyAverage() {
		int year = selectYear();
		int month = selectMonth();
		Options options = promptOptions();
		System.out.println(this.stats.getMonthlyAverage(year, month, options));
	}
}
