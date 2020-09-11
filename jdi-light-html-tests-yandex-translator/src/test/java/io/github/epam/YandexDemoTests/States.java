package io.github.epam.YandexDemoTests;
import io.github.com.pages.SitePage;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.verifyUrl;
import static io.github.com.StaticSite.*;


/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    @Step
    public static void shouldBeOnHomePage() {
        moveToHomePage();
    }

    @Step
    public static void shouldBeOnSitePage() {
        shouldBeOnHomePage ();
        SitePage.open();
    }

    @Step
    public static void shouldBeOnDocPage() {
        shouldBeOnHomePage ();
        DocPage.open();
    }


    @Step
    public static void moveToHomePage()
    {
        if (!verifyUrl("https://translate.yandex.ru/") )
            homePage.open();
    }

}
