package exo3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TradeDataStatisticsTest {
    private List<TradeData> mockData;
    private Options options;
	
	@BeforeEach
    public void setUp() {
        options = new Options();
        options.country = "CountryA";
        options.commodity = "CommodityA";
        options.transportMode = "ModeA";
        options.measure = "MeasureA";

        mockData = Arrays.asList(
                createTradeData("Export", 2021, LocalDate.of(2021, 1, 1), "Monday", "CountryA", "CommodityA", "ModeA", "MeasureA", 100, 1000),
                createTradeData("Export", 2021, LocalDate.of(2021, 1, 15), "Friday", "CountryA", "CommodityA", "ModeA", "MeasureA", 200, 1150),
                createTradeData("Export", 2021, LocalDate.of(2021, 2, 1), "Monday", "CountryA", "CommodityA", "ModeA", "MeasureA", 200, 1350),
                createTradeData("Export", 2021, LocalDate.of(2021, 1, 1), "Monday", "CountryA", "CommodityA", "ModeA", "MeasureA", 300, 1650)
            );
        }

        private TradeData createTradeData(String direction, int year, LocalDate date, String weekday, String country, String commodity, String transportMode, String measure, long value, long cumulative) {
            TradeData tradeData = new TradeData();
            tradeData.setDirection(direction);
            tradeData.setYear(year);
            tradeData.setDate(date);
            tradeData.setWeekday(weekday);
            tradeData.setCountry(country);
            tradeData.setCommodity(commodity);
            tradeData.setTransportMode(transportMode);
            tradeData.setMeasure(measure);
            tradeData.setValue(value);
            tradeData.setCumulative(cumulative);
            return tradeData;
        }

	@Test
    public void testGetMonthlyAverage() {
		TradeDataStatistics stats = new TradeDataStatistics();
		stats.dataList = mockData;

		
        double average = stats.getMonthlyAverage(2021, 1, options);
        assertEquals(200.0d, average, 0.01);
        
    }

}
