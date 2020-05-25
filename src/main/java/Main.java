import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import model.CustomMappingStrategy;
import model.CustomerCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<CustomerCSV> customersCSV = new ArrayList<CustomerCSV>();
        customersCSV.add(new CustomerCSV("Test", "Sailor", 21));
        customersCSV.add(new CustomerCSV("SuperName", "Maudi", 24));
        customersCSV.add(new CustomerCSV("Nannaa", "Slim", 23));
        customersCSV.add(new CustomerCSV("UAU", "Smith", 61));

        FileWriter writer = new FileWriter("./myFile.csv");

        CustomMappingStrategy<CustomerCSV> strat = new CustomMappingStrategy<CustomerCSV>();
        strat.setType(CustomerCSV.class);
        String[] headers = new String[] {"Beautiful Name", "Terrible Surname", "Age"};
        strat.setHeader(headers);

        StatefulBeanToCsv<CustomerCSV> beanToCsv =
                new StatefulBeanToCsvBuilder<CustomerCSV>(writer)
                        .withMappingStrategy(strat)
                        .build();
        beanToCsv.write(customersCSV);
        writer.close();
    }
}
