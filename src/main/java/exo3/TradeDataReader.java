package exo3;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class TradeDataReader {
	private String filePath;
	
    public TradeDataReader(String filePath) {
        this.filePath = filePath;
    }
	
	
    public List<TradeData> readCSV() {
        try (FileReader reader = new FileReader(this.filePath)) {
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
}
