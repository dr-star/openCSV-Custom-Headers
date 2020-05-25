package model;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private String[] header;
    private static final String[] HEADER = new String[]{"name", "surname", "age"};

    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
        super.generateHeader(bean);
        return header;
    }


}
