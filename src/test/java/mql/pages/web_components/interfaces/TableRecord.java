package mql.pages.web_components.interfaces;

import mql.pages.web_components.annotations.TableColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class TableRecord implements WebComponent {
    Logger log = LoggerFactory.getLogger(TableRecord.class);

    public abstract String getId();

    public abstract void select();

    public abstract Object[] getRecordData();

    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(TableColumn.class)) {
                TableColumn tableColumn = field.getAnnotation(TableColumn.class);
                field.setAccessible(true);
                columns.add(tableColumn.value());
                log.debug("table records");
                log.debug(tableColumn.value());
            }
        }
        return columns;
    }

}
