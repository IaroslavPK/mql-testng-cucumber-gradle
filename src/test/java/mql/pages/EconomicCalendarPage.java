package mql.pages;

import com.codeborne.selenide.SelenideElement;
import mql.pages.web_components.EventTableRecord;
import mql.pages.web_components.MultiSelectWC;
import mql.pages.web_components.SelectWC;
import mql.pages.web_components.TableWC;
import lombok.Getter;
import org.openqa.selenium.By;
import utils.CheckElementUtils;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class EconomicCalendarPage extends Page {

    private final SelenideElement title = $(withText("Economic calendar, Forex news"));
    private final SelenideElement eventTableRoot = $(".ec-table");

    private final SelectWC timeFilter = new SelectWC(By.id("economicCalendarFilterDate"));
    private final MultiSelectWC importanceFilter = new MultiSelectWC(By.id("economicCalendarFilterImportance"));
    private final MultiSelectWC currencyFilter = new MultiSelectWC(By.id("economicCalendarFilterCurrency"));
    private final TableWC<EventTableRecord> eventsTable = new TableWC(By.className("ec-table__item"), EventTableRecord.class);

    @Override
    public boolean checkPageLoaded() {
        errorMessage += CheckElementUtils.isDisplayed(title);
        errorMessage += CheckElementUtils.isDisplayed(eventTableRoot);
        return errorMessage.equals("");
    }
}
