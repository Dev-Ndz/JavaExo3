package exo3;

import java.util.List;
import java.util.LongSummaryStatistics;

public class TradeDataStatistics {
	List<TradeData> dataList;
	
	public TradeDataStatistics() {
    	TradeDataReader reader = new TradeDataReader("/home/ndz/becode/java/Java/week_3/assets/covid_and_trade.csv");
    	dataList = reader.readCSV();
	}
	
    private LongSummaryStatistics getStatistics(int year, Integer month, Options options) {
   
    	LongSummaryStatistics statistics = null;
		
    	if (dataList == null) {
    		System.out.println("No data found.");
    	} else {
    		statistics = dataList.stream()
    			.filter(data -> data.getDate().getYear() == year 
                	&& (month == null || data.getDate().getMonthValue() == month)
                	&& (data.getCountry().equals(options.country))
                	&& (data.getCommodity().equals(options.commodity))
                	&& (data.getTransportMode().equals(options.transportMode))
                	&& (data.getMeasure().equals(options.measure))
                	)
                .mapToLong(TradeData::getValue)
                .summaryStatistics();
        }
    	return statistics;
    }

    public double getMonthlyAverage(int year, int month, Options options) {
    	return getStatistics(year, month, options).getAverage();
    }
    
/*    public long getYearlyTotal(int year, Options options) {
    	return getStatistics(year, null, options).getSum();
    }
    
    public double getYearlyAverage(int year, Options options) {
    	return getStatistics(year, null, options).getAverage();
    }

	public long getMonthlyTotal(int year, int month, Options options) {
    	return getStatistics(year, month, options).getSum();
    }*/
    
}
