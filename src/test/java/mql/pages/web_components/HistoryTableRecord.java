package mql.pages.web_components;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import mql.pages.web_components.annotations.TableColumn;
import mql.pages.web_components.interfaces.TableRecord;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Slf4j
public class HistoryTableRecord extends TableRecord {

    private final SelenideElement root;
    @TableColumn("Date (GMT)") private final SelenideElement date;
    @TableColumn("Reference") private final SelenideElement reference;
    @TableColumn("Actual") private final SelenideElement actual;
    @TableColumn("Forecast") private final SelenideElement forecast;
    @TableColumn("Previous") private final SelenideElement previous;

    public HistoryTableRecord(SelenideElement rowElement) {
        root = rowElement;
        date = root.$(".event-table-history__date");
        reference = root.$(".event-table-history__period");
        actual = root.$(".event-table-history__actual");
        forecast = root.$(".event-table-history__forecast");
        previous = root.$(".event-table-history__previous");
    }

    @Override
    public String getId() {
        return date.text();
    }

    @Override
    public void select() {}

    @Override
    public Object[] getRecordData() {
        return new Object[] {date.text(), reference.text(), actual.text(), forecast.text(), previous.text()};
    }

    public LocalDateTime getDateTime() {
        long instantTime = Long.parseLong(Objects.requireNonNull(date.getAttribute("data-date")));
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(instantTime), ZoneId.systemDefault());
    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(date.text());
        values.add(reference.text());
        values.add(actual.text());
        values.add(forecast.text());
        values.add(previous.text());
        return values;
    }

    @Override
    public void dump() {}
}
