package exo3;

import java.time.LocalDate;
import java.time.Month;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class TradeData {

    @CsvBindByName(column = "direction")
    private String direction;

    @CsvBindByName(column = "year")
    private int year;

    @CsvBindByName(column = "date")
    @CsvDate("dd/MM/yyyy")
    private LocalDate date;

    @CsvBindByName(column = "weekday")
    private String weekday;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "commodity")
    private String commodity;

    @CsvBindByName(column = "transport_mode")
    private String transportMode;

    @CsvBindByName(column = "measure")
    private String measure;

    @CsvBindByName(column = "value")
    private long value;

    @CsvBindByName(column = "cumulative")
    private long cumulative;

    // Getters and setters

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getYear() {
        return year;
    }
    
    public Month getMonth() {
    	return this.date.getMonth();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getCumulative() {
        return cumulative;
    }

    public void setCumulative(long cumulative) {
        this.cumulative = cumulative;
    }

    @Override
    public String toString() {
        return "TradeData{" +
                "direction='" + direction + '\'' +
                ", year=" + year +
                ", date=" + date +
                ", weekday='" + weekday + '\'' +
                ", country='" + country + '\'' +
                ", commodity='" + commodity + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", measure='" + measure + '\'' +
                ", value=" + value +
                ", cumulative=" + cumulative +
                '}';
    }
}
