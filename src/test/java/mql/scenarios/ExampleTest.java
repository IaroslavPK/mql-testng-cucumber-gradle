package mql.scenarios;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.slf4j.Slf4j;
import mql.common.BaseTest;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.CustomDriverProvider;

@CucumberOptions(
        glue = {"mql"},
        plugin = {
                "pretty",
                "summary",
                //"html:build/cucumber-reports/cucumber-pretty",
                "json:build/cucumber-reports/CucumberTestReport.json",
                "rerun:build/cucumber-reports/rerun.txt"
        },
        features = {"src/test/resources/com/features"}
)
@Slf4j
public class ExampleTest extends BaseTest {

    @BeforeSuite
    void beforeAll() {
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 30000;
        Configuration.browser = CustomDriverProvider.class.getName();
        log.info("Goodbye World");
        log.debug("Goodbye World");
    }

    @SuppressWarnings({"groupsTestNG"})
    @Test(
            groups = "cucumber",
            dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper)  {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @AfterSuite
    public void tearDownClass() {
        WebDriverRunner.closeWebDriver();
        super.tearDownClass();
    }
}
