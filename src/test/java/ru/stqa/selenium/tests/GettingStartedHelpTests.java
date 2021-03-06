package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.*;


public class GettingStartedHelpTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    UpperMenuHelper upperMenuPage;
    HelpSectionPageHelper helpSectionPage;
    GettingStartedGuideHelper gettingStartedGuidePage;

    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        upperMenuPage = PageFactory.initElements(driver, UpperMenuHelper.class);
        helpSectionPage = PageFactory.initElements(driver,HelpSectionPageHelper.class);
        gettingStartedGuidePage = PageFactory.initElements(driver,GettingStartedGuideHelper.class);

        loginPage.openLoginPage()
                 .loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        upperMenuPage.openMenuPage()
                     .waitUntilPageIsLoaded()
                     .openHelpMenu();
        helpSectionPage.waitUntilPageIsLoaded();
    }

    @Test
    public void gettingStartedGuideHelpOpening()  {
        log4j.startTestCase("gettingStartedGuideHelpOpening");
        log4j.info("Choosing getting started guide menu");
        helpSectionPage.chooseGettingStartedGuideMenu();
        log4j.info("Switching to new window and waiting page loading");
        gettingStartedGuidePage.switchToNewWindowAndWaitPageLoading();
        Assert.assertEquals(gettingStartedGuidePage.getTitle(),"Getting Started with Trello",
                "Actual title is not equal to expected title");
        log4j.endTestCase();
    }
}
