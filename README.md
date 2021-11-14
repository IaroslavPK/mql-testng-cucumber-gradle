# mql-testng-cucumber-test
###Example of browser test on stack [ java+testng+cucumber ]

Contains 1 test for "Economic calendar, Forex news page" https://www.mql5.com/en/economic-calendar

Used "Selenide" framework for GUI tests.

###Required tools
- Java 8
- Gradle 7
- Google Chrome browser

###Hints
- Cucumber 'feature' files in "src/test/java/resources/com/features"
- Cucumber glue in "mql.steps_definitions"
- In 'CustomDriverProvider' class assigns Googlebot User-Agent for ChromeDriver
- WebDriver initialization in ExampleTest `beforeAll()`

###How to run
#### Via console
- Execute command `gradle clean test` in project root folder
- Observe the execution in Chrome, review console logs: cucumber logs in base testng log
```sh
    Given Open page "https://www.mql5.com/en/economic-calendar" # mql.steps.EventCalendarDefinition.openPage(java.lang.String)
    Then Filter by period "Current month"                       # mql.steps.EventCalendarDefinition.filterByPeriod(java.lang.String)
    Then Filter by importance "Medium"                          # mql.steps.EventCalendarDefinition.filterByImportance(java.lang.String)
    Then Filter by currency "CHF - Swiss frank"                 # mql.steps.EventCalendarDefinition.filterByCurrency(java.lang.String)
    Then Open first "CHF" currency event from filtered result   # mql.steps.EventCalendarDefinition.openFirstActionFromFilteredResult(java.lang.String)
    And Verify action priority is "Medium"                      # mql.steps.EventCalendarDefinition.verifyActionPriorityIs(java.lang.String)
    And Verify country is "Switzerland"                         # mql.steps.EventCalendarDefinition.verifyCountryIs(java.lang.String)

```
- Watch logs in step ("Log history for the last 1 year") and review History table CHF records for the last year.
```sh
    ___________________________________________________
    | Date (GMT)| Reference| Actual| Forecast| Previous|
    |==================================================|
    | 1 Nov 2021| Oct 2021 | 65.4  | 68.4    | 68.1    |
    | 1 Oct 2021| Sep 2021 | 68.1  | 70.5    | 67.7    |
    | 1 Sep 2021| Aug 2021 | 67.7  | 72.5    | 71.1    |
    | 2 Aug 2021| Jul 2021 | 71.1  | 68.1    | 66.7    |
    | 1 Jul 2021| Jun 2021 | 66.7  | 70.6    | 69.9    |
    | 1 Jun 2021| May 2021 | 69.9  | 68.0    | 69.5    |
    | 3 May 2021| Apr 2021 | 69.5  | 63.9    | 66.3    |
    | 1 Apr 2021| Mar 2021 | 66.3  | 60.4    | 61.3    |
    | 1 Mar 2021| Feb 2021 | 61.3  | 58.7    | 59.4    |
    | 1 Feb 2021| Jan 2021 | 59.4  | 56.6    | 57.3    |
    | 4 Jan 2021| Dec 2020 | 58.0  | 53.7    | 55.2    |
    | 1 Dec 2020| Nov 2020 | 55.2  | 52.6    | 52.3    |
    | 2 Nov 2020| Oct 2020 | 52.3  | 52.4    | 53.1    |
```

###Logs
Test log file located in "build/test.log"</br>
In log you can also find History table CHF records for the last year in slightly different format
```sh
+-----------+-----------+-----------+-----------+----------+
|Date (GMT) |Reference  |     Actual|   Forecast|  Previous|
+-----------+-----------+-----------+-----------+----------+
|1 Nov 2021 |Oct 2021   |       65.4|       68.4|      68.1|
|1 Oct 2021 |Sep 2021   |       68.1|       70.5|      67.7|
|1 Sep 2021 |Aug 2021   |       67.7|       72.5|      71.1|
|2 Aug 2021 |Jul 2021   |       71.1|       68.1|      66.7|
|1 Jul 2021 |Jun 2021   |       66.7|       70.6|      69.9|
|1 Jun 2021 |May 2021   |       69.9|       68.0|      69.5|
|3 May 2021 |Apr 2021   |       69.5|       63.9|      66.3|
|1 Apr 2021 |Mar 2021   |       66.3|       60.4|      61.3|
|1 Mar 2021 |Feb 2021   |       61.3|       58.7|      59.4|
|1 Feb 2021 |Jan 2021   |       59.4|       56.6|      57.3|
|4 Jan 2021 |Dec 2020   |       58.0|       53.7|      55.2|
|1 Dec 2020 |Nov 2020   |       55.2|       52.6|      52.3|
|2 Nov 2020 |Oct 2020   |       52.3|       52.4|      53.1|
+-----------+-----------+-----------+-----------+----------+
```

<br><br>
### How to build report

#### Allure report
- Execute console command to build Allure report `gradle allureReport` in project root directory
- Check site built in "build/reports/allure-report/allureReport"
- Open "build/reports/allure-report/allureReport/index.html" in chrome
- Review Allure report with cucumber steps
- !! If allure shows blank report, this may happen on some PC because of path, execute `gradle allureServe` and report open at once.

In allure report you can also see History table CHF records for the last year in slightly different format.
<br>
To fine it extend the last step ("Log history for the last 1 year")
<br>
and extend "history for the last 1 year" attachement. Here is the same table as in log.

#### In ./img you can find screens of repots and hints of file location.
