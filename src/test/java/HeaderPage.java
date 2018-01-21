import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderPage {
    private static WebDriver browser;
    private int defaultExplicitWaitInSeconds = 10;
    public static int defaultImplicitWaitInSeconds = 10;

    //-- Logo
    private By jiraLogo = By.id("logo");
    //-- Dashboards section
    private By dashboardLocator = By.id("home_link");
    private By viewSystemDashboardLocator = By.id("dash_lnk_system_lnk");
    private By manageDashboardsLocator = By.id("manage_dash_link_lnk");
    //-- Projects section
    private By projectsLocator = By.id("browse_link");
    private By currentProjectLocator = By.id("admin_main_proj_link_lnk");
    private By recentProject1Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[1]");
    private By recentProject2Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[2]");
    private By recentProject3Locator = By.xpath("(//*[contains(@id,'proj_lnk_')][@class='aui-icon-container'])[3]");
    private By softwareLocator = By.id("project_type_software_lnk");
    private By businessLocator = By.id("project_type_business_lnk");
    private By viewAllProjectsLocator = By.id("project_view_all_link_lnk");
    //-- Issues section
    private By issuesLocator = By.id("find_link");
    private By currentSearchLocator = By.id("jira.top.navigation.bar:issues_drop_current_lnk");
    private By searchForIssuesLocator = By.id("issues_new_search_link_lnk");
    private By recentIissue1Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[1]");
    private By recentIissue2Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[2]");
    private By recentIissue3Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[3]");
    private By recentIissue4Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[4]");
    private By recentIissue5Locator = By.xpath("(//*[contains(@id,'issue_lnk_')][contains(@class,'issue-link')])[5]");
    private By importIssuesFromCSVLocator = By.id("bulk_create_dd_link_lnk");
    private By filterMyOpenIssuesLocator = By.id("filter_lnk_my_lnk");
    private By filterReportedByMeLocator = By.id("filter_lnk_reported_lnk");
    private By manageFiltersLocator = By.id("issues_manage_filters_link_lnk");
    //-- Boards section
    private By boardsLocator = By.id("greenhopper_menu");
    private By recentBoard1Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[1]");
    private By recentBoard2Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[2]");
    private By recentBoard3Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[3]");
    private By recentBoard4Locator = By.xpath("(//*/a[contains(@id,'rapidb_lnk_')])[4]");
    private By viewAllBoardsLocator = By.id("ghx-manageviews-mlink_lnk");
    //-- Tests section
    private By testsLocator = By.id("zephyr_je.topnav.tests");
    private By searchTestsLocator = By.id("zephyr-je.topnav.tests.test.search_lnk");
    private By createATestLocator = By.id("zephyr-je.topnav.tests.create_lnk");
    private By planTestCycleLocator = By.id("zephyr-je.topnav.tests.plan.cycle_lnk");
    private By searchTestExecutionsLocator = By.id("zephyr-je.topnav.tests.execution.search_lnk");
    private By manageExecutionFiltersLocator = By.id("manage_zql_filters_link_lnk");
    private By executeTestsLocator = By.id("zephyr-je.topnav.tests.plan.execute_lnk");
    private By testSummaryLocator = By.id("zephyr-je.topnav.tests.test.plan.summary_lnk");
    private By testMetricsLocator = By.id("zephyr-je.topnav.tests.test.plan.metrics_lnk");
    private By traceabilityLocator = By.id("zephyr-je.topnav.tests.test.plan.traceability_lnk");
    private By welcomeLocator = By.id("zfj_welcome_lnk");
    private By zephyrHelpLocator = By.id("com.thed.zephyr.je:zephyr-je.topnav.tests.help_lnk");
    private By zephyrSupportLocator = By.id("support_link_lnk");
    private By aboutZephyrLocator = By.id("add-about_lnk");
    //-- Create button
    private By createLocator = By.id("create_link");
    //-- Search field
    private By searchFieldLocator = By.id("quickSearchInput");
    //-- Improve Jira section
    private By helpUsButtonLocator = By.id("jira-header-feedback-link");
    //-- Help section
    private By jiraInfoLocator = By.id("help_menu");
    private By jiraSoftwareHelpLocator = By.id("gh_view_help");
    private By jiraCoreHelpLocator = By.id("view_core_help");
    private By keyboardShortcutsLocator = By.id("keyshortscuthelp");
    private By aboutLocator = By.id("view_about");
    private By creditsLocator = By.id("view_credits");
    //-- User section
    private By userOptionsLocator = By.id("user-options");
    private By viewProfileLocator = By.id("view_profile");
    private By atlassianMarketplaceLocator = By.id("upm-requests-link");
    private By setHomeDashboardLocator = By.id("set_my_jira_home_default");
    private By setHomeBoardsLocator = By.id("greenhopper-my-jira-home-set");
    private By setHomeIssuesLocator = By.id("set_my_jira_home_issuenav");
    private By logOutLocator = By.id("log_out");

    @BeforeMethod
    public static void OpenPage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Temskii\\Desktop\\test\\BasicAutoTest\\bin\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("http://jira.hillel.it:8080");
    }

    @AfterMethod
    public static void CloseBrowser() {
//        browser.close();
    }

    @Test
    public void checkMethods() {
        LogIn("abobokha", "4159692125");
//        jiraLogo();
//        dashbourd();
//        jiraLogo();
//        dashbourdViewSystemDashboard();
//        dashbourdManageDashboards();
//        projects();
//        jiraLogo();
//        projectsCurrentProject();
//        projectsCurrent1Project();
//        projectsCurrent2Project();
//        projectsCurrent3Project();
//        projectsSoftware();
//        projectsBusiness();
//        projectsViewAllProjects();
//        issues();
//        jiraLogo();
//        issuesCurentSearch();
//        issuesSearchForIssues();
//        issuesRecentIissue1();
//        issuesRecentIissue2();
//        issuesRecentIissue3();
//        issuesRecentIissue4();
//        issuesRecentIissue5(); // not found
//        issuesImportIssuesFromCSV();
//        issuesFilterMyOpenIssues();
//        issuesFilterReportedByMe();
//        issuesManageFilters();
//        boards();
//        jiraLogo();
//        boardsRecentBoard1();
//        boardsRecentBoard2();
//        boardsRecentBoard3();
//        boardsRecentBoard4(); // not found
//        boardsViewAllBoards();
//        tests();
//        jiraLogo();
//        testsSearchTests();
//        testsCreateATest();
//        testsPlanTestCycle();
//        testsSearchTestExecutions();
//        testsManageExecutionFilters();
//        testsExecuteTests();
//        testsTestSummary();
//        testsTestMetrics();
//        testsTraceability();
//        testsWelcome(); // open in new tab
//        testsZephyrHelp(); // open in new tab
//        testsZephyrSupport(); // open in new tab
//        createButton(); //open dialog window
//       helpUsButton();
//        jiraLogo();
//        jiraInfo();
//        jiraLogo();
//        jiraInfoJiraSoftwareHelp();// open in new tab
//        jiraInfoJiraCoreHelp();// open in new tab
//       jiraInfoKeyboardShortcuts(); //open dialog window
//        jiraInfoAbout();
//        jiraInfoCredits();// open Jira game
//        userOptions();
//        jiraLogo();
//        userOptionsViewProfile();
//        userOptionsAtlassianMarketplace();
//        userOptionsSetHomeDashboard();
//        userOptionssetHomeBoards();
//        userOptionsSetHomeIssues();
//        userOptionslogOut();
        search("Fatal error");




    }

    private static void LogIn(String userName, String password) {

        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys(userName);
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys(password);
        browser.findElement(By.cssSelector("input[name='login']")).click();
    }

    protected void waitToBePresentAndClick(By locator) {
//        logger.info("WAIT ELEMENT TO BE PRESENT AND CLICK: " + locator);
        WebElement element = null;

        try {
            element = (new WebDriverWait(browser, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = (new WebDriverWait(browser, defaultExplicitWaitInSeconds)).
                    until(ExpectedConditions.presenceOfElementLocated(locator));
            element.click();
        }

    }


    public HeaderPage jiraLogo(){
        waitToBePresentAndClick(jiraLogo);
        return this;
    }
    //_________________________________________________________________Logo
    public HeaderPage dashbourd(){
        waitToBePresentAndClick(dashboardLocator);
        return this;
    }

    public HeaderPage dashbourdViewSystemDashboard(){
        waitToBePresentAndClick(dashboardLocator);
        waitToBePresentAndClick(viewSystemDashboardLocator);
        return this;
    }

    public HeaderPage dashbourdManageDashboards(){
        waitToBePresentAndClick(dashboardLocator);
        waitToBePresentAndClick(manageDashboardsLocator);
        return this;
    }
    //____________________________________________________________________Dashboard section
    public HeaderPage projects(){
        waitToBePresentAndClick(projectsLocator);
        return this;
    }

    public HeaderPage projectsCurrentProject(){
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(currentProjectLocator);
        return this;
    }

    public HeaderPage projectsCurrent1Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject1Locator);
        return this;
    }

    public HeaderPage projectsCurrent2Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject2Locator);
        return this;
    }

    public HeaderPage projectsCurrent3Project() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(recentProject3Locator);
        return this;
    }

    public HeaderPage projectsSoftware() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(softwareLocator);
        return this;
    }

    public HeaderPage projectsBusiness() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(businessLocator);
        return this;
    }

    public HeaderPage projectsViewAllProjects() {
        waitToBePresentAndClick(projectsLocator);
        waitToBePresentAndClick(viewAllProjectsLocator);
        return this;
    }
    //____________________________________________________________Progect section
    public HeaderPage issues() {
        waitToBePresentAndClick(issuesLocator);
        return this;
    }

    public HeaderPage issuesCurentSearch() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(currentSearchLocator);
        return this;
    }

    public HeaderPage issuesSearchForIssues() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(searchForIssuesLocator);
        return this;
    }

    public HeaderPage issuesRecentIissue1() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue1Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue2() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue2Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue3() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue3Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue4() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue4Locator);
        return this;
    }

    public HeaderPage issuesRecentIissue5() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(recentIissue5Locator);
        return this;
    }

    public HeaderPage issuesImportIssuesFromCSV() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(importIssuesFromCSVLocator);
        return this;
    }

    public HeaderPage issuesFilterMyOpenIssues() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(filterMyOpenIssuesLocator);
        return this;
    }

    public HeaderPage issuesFilterReportedByMe() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(filterReportedByMeLocator);
        return this;
    }

    public HeaderPage issuesManageFilters() {
        waitToBePresentAndClick(issuesLocator);
        waitToBePresentAndClick(manageFiltersLocator);
        return this;
    }
    //____________________________________________________________Issues section
    public HeaderPage boards() {
        waitToBePresentAndClick(boardsLocator);
        return this;
    }

    public HeaderPage boardsRecentBoard1() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard1Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard2() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard2Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard3() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard3Locator);
        return this;
    }

    public HeaderPage boardsRecentBoard4() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(recentBoard4Locator);
        return this;
    }

    public HeaderPage boardsViewAllBoards() {
        waitToBePresentAndClick(boardsLocator);
        waitToBePresentAndClick(viewAllBoardsLocator);
        return this;
    }
//____________________________________________________________Boards section

    public HeaderPage tests() {
        waitToBePresentAndClick(testsLocator);
        return this;
    }

    public HeaderPage testsSearchTests() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(searchTestsLocator);
        return this;
    }

    public HeaderPage testsCreateATest() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(createATestLocator);
        return this;
    }

    public HeaderPage testsPlanTestCycle() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(planTestCycleLocator);
        return this;
    }

    public HeaderPage testsSearchTestExecutions() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(searchTestExecutionsLocator);
        return this;
    }


    public HeaderPage testsManageExecutionFilters() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(manageExecutionFiltersLocator);
        return this;
    }


    public HeaderPage testsExecuteTests() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(executeTestsLocator);
        return this;
    }

    public HeaderPage testsTestSummary() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(testSummaryLocator);
        return this;
    }

    public HeaderPage testsTestMetrics() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(testMetricsLocator);
        return this;
    }

    public HeaderPage testsTraceability() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(traceabilityLocator);
        return this;
    }

    public HeaderPage testsWelcome() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(welcomeLocator);
        return this;
    }

    public HeaderPage testsZephyrHelp() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(zephyrHelpLocator);
        return this;
    }

    public HeaderPage testsZephyrSupport() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(zephyrSupportLocator);
        return this;
    }

    public HeaderPage testsAboutZephyr() {
        waitToBePresentAndClick(testsLocator);
        waitToBePresentAndClick(aboutZephyrLocator);
        return this;
    }
    //____________________________________________________________Tests section
    public HeaderPage createButton() {
        waitToBePresentAndClick(createLocator);
        return this;
    }
//____________________________________________________________Create button

    public HeaderPage search(String searchWord) {
        WebElement element = browser.findElement(searchFieldLocator);
        element.sendKeys(searchWord);
        element.submit();
        return this;
    }
//__________________________________________________________Search field

    public HeaderPage helpUsButton() {
        waitToBePresentAndClick(helpUsButtonLocator);
        return this;
    }

    //____________________________________________________________Improve Jira section
    public HeaderPage jiraInfo() {
        waitToBePresentAndClick(jiraInfoLocator);
        return this;
    }

    public HeaderPage jiraInfoJiraSoftwareHelp() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(jiraSoftwareHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoJiraCoreHelp() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(jiraCoreHelpLocator);
        return this;
    }

    public HeaderPage jiraInfoKeyboardShortcuts() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(keyboardShortcutsLocator);
        return this;
    }

    public HeaderPage jiraInfoAbout() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(aboutLocator);
        return this;
    }


    public HeaderPage jiraInfoCredits() {
        waitToBePresentAndClick(jiraInfoLocator);
        waitToBePresentAndClick(creditsLocator);
        return this;
    }
//____________________________________________________________Help section

    public HeaderPage userOptions() {
        waitToBePresentAndClick(userOptionsLocator);
        return this;
    }

    public HeaderPage userOptionsViewProfile() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(viewProfileLocator);
        return this;
    }

    public HeaderPage userOptionsAtlassianMarketplace() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(atlassianMarketplaceLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeDashboard() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeDashboardLocator);
        return this;
    }

    public HeaderPage userOptionssetHomeBoards() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeBoardsLocator);
        return this;
    }

    public HeaderPage userOptionsSetHomeIssues() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(setHomeIssuesLocator);
        return this;
    }

    public HeaderPage userOptionslogOut() {
        waitToBePresentAndClick(userOptionsLocator);
        waitToBePresentAndClick(logOutLocator);
        return this;
    }
//____________________________________________________________User section
}

