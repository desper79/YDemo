package io.github.epam.YandexDemoTests;

import io.github.com.StaticSite;
import io.github.com.pages.HomePage;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Console;

import static com.epam.jdi.light.settings.WebSettings.logger;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

import static io.github.com.pages.HomePage.*;
import static io.github.com.pages.SitePage.*;
import static io.github.com.pages.SitePage.srcLangButton;
import static io.github.epam.YandexDemoTests.States.shouldBeOnSitePage;
import static org.testng.Assert.assertEquals;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class YandexDemoSiteTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeOnSitePage();
    }

    String text = "Big Red Button-Input";

    @Test
    public void testSite_1() {

        testSiteCommon (By.cssSelector("[data-value='Mail']"), "Почта", By.cssSelector("[data-ylk*='Coronavirus']"), "Coronavirus", "https://www.yahoo.com/");

    }

    public void testSiteCommon (By targetPathBy, String targetValue, By sourcePathBy, String sourceValue, String site) {

        //ждем отображения элемента поиска
        urlInput.waitFor(60).displayed();
        //ввод адреса
        urlInput.sendKeys(site);
        //поиск
        submitUrl.click();

        //ждём обработки = 100%
        progress.waitFor(10).displayed();

        //Костыль 1 - получение информации по элементу 1 из фрейма результата
        WebDriver myDriver = getDriver();
        myDriver.switchTo().frame("targetFrame");
        WebElement element = myDriver.findElement(targetPathBy);
        String text = element.getText();

        assertEquals(text, targetValue);

        //Костыль 2 - получение информации по элементу 2 из фрейма исходника
        srcLangButtonSite.click();
        myDriver.switchTo().frame("sourceFrame");
        WebElement element1 = myDriver.findElement(sourcePathBy);
        String text1 = element1.getText();

        assertEquals(text1, sourceValue);
    }

}
