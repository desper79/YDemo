package io.github.epam.YandexDemoTests;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.pages.DocPage.*;
import static io.github.com.pages.SitePage.*;
import static io.github.epam.YandexDemoTests.States.shouldBeOnDocPage;
import static io.github.epam.YandexDemoTests.States.shouldBeOnSitePage;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class YandexDemoDocTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeOnDocPage();
    }

    @Test
    public void testDoc_1()
    {
        logo.waitFor(60).displayed();

        WebDriver myDriver = getDriver();
        WebElement element = myDriver.findElement(By.cssSelector ("input#docInput"));
        element.sendKeys(mergePath(COMMON.projectPath,"/src/test/resources/1.docx"));


        try
        {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {}


        //Костыль 1 - получение информации по элементу 1 из фрейма результата
        myDriver.switchTo().frame("targetFrame");

        //Костыль 2
        try
        {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {}

        WebElement element1 = myDriver.findElement(By.cssSelector("[data-type='trSpan']"));
        String text = element1.getText();

        assertEquals(text, "Тест");
    }

    public void testSiteCommon (By targetPathBy, String targetValue, String sourcePath, String sourceValue, String site) {
        //ждем отображения страницы
        logo.waitFor(60).displayed();

        //загрузка файла
        WebDriver myDriver = getDriver();
        WebElement element = myDriver.findElement(By.cssSelector ("input#docInput"));
        element.sendKeys(mergePath(COMMON.projectPath,sourcePath));


        try
        {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {}

        // получение результата
        //Костыль 1 - получение информации по элементу 1 из фрейма результата
        myDriver.switchTo().frame("targetFrame");

        //Костыль 2
        try
        {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {}

        WebElement element1 = myDriver.findElement(By.cssSelector("[data-type='trSpan']"));
        String text = element1.getText();

        //сравнение
        assertEquals(text, targetValue);
    }

}
