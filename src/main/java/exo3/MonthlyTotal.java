package exo3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class MonthlyTotal {
	
    private static List<TradeData> readCSV() {
        try (FileReader reader = new FileReader("/home/ndz/becode/java/exo2.2/effects-of-covid-19-on-trade-at-21-July-2021-provisional.csv")) {
            CsvToBean<TradeData> csvToBean = new CsvToBeanBuilder<TradeData>(reader)
                    .withType(TradeData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static long getMonthlyTotal(int year, int month) {
    	
    	long monthlyTotal = 0;
    	List<TradeData> dataList = readCSV();
    	
    	if (dataList == null) {
    		System.out.println("No data found.");
    	} else {
            monthlyTotal = dataList.stream()
                    .filter(data -> data.getDate().getYear() == year 
                            && data.getDate().getMonthValue() == month)
                    .mapToLong(TradeData::getValue)
                    .sum();
        }

    	return monthlyTotal;
    }
    
}
