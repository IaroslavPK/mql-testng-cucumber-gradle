package mql.pages;

import com.codeborne.selenide.SelenideElement;
import mql.pages.web_components.EventHistoryTable;
import mql.pages.web_components.HistoryTableRecord;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class EventDetailsPage extends Page {

    private final SelenideElement countryLink = $(withText("Country:")).ancestor("div").$("a");
    private final SelenideElement eventImportance = $(".event-table__importance");
    private final SelenideElement historyTab = $(byAttribute("data-content", "history"));
    private final EventHistoryTable historyTable = new EventHistoryTable(By
            .className("event-table-history__item"), HistoryTableRecord.class);

    @Override
    public boolean checkPageLoaded() {
        return true;
    }
}
