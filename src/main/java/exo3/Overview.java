package exo3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Overview {
	
    private <T> Set<T> getUniqueValues(Function<TradeData, T> mapper) {
		TradeDataReader reader = new TradeDataReader("/home/ndz/becode/java/Java/week_2/resources/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv");
		List<TradeData> dataList = reader.readCSV();
    	
        if (dataList == null || dataList.isEmpty()) {
            System.out.println("No data found.");
            return new HashSet<>(); // Return empty set to avoid null checks later
        }

        return dataList.stream()
                .map(mapper)
                .collect(Collectors.toSet());
    }
    
    public Set<Integer> getYears() {
        return getUniqueValues(TradeData::getYear);
    }
    
    public Set<String> getCountries() {
        return getUniqueValues(TradeData::getCountry);
    }
    
    public Set<String> getCommodities() {
        return getUniqueValues(TradeData::getCommodity);
    }
    
    public Set<String> getTransports() {
        return getUniqueValues(TradeData::getTransportMode);
    }
    
    public Set<String> getMeasures() {
        return getUniqueValues(TradeData::getMeasure);
    }
    
    public void getOverview() {
    	System.out.println("Years : " +getYears());
    	System.out.println("Countries : " +getCountries());
    	System.out.println("Commodities : " +getCommodities());
    	System.out.println("Transports : " +getTransports());
    	System.out.println("Measures : " +getMeasures());
    }
}
