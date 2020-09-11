package io.github.epam.YandexDemoTests;

import io.github.com.pages.HomePage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.HomePage.*;
import static io.github.epam.YandexDemoTests.States.shouldBeOnHomePage;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class YandexDemoTextTests implements TestsInit {

    @BeforeMethod
    public void before() {
            shouldBeOnHomePage();
    }

    @Test
    public void testRuEn_1() {
        testTextCommonRuEn("тест", "test", false);
    }

    @Test
    public void testRuEn_2() {
        testTextCommonRuEn("Это проверка автотеста", "This is an AutoTest check", false);
    }

    @Test
    public void testEnRu_1() {
        testTextCommonRuEn("test", "тест", true);
    }

    @Test
    public void testEnRu_2() {
        testTextCommonRuEn("Это проверка", "This is a test", true);
    }

    @Test
    public void getTextTest() {
        assertEquals(true,  true);
        //assertEquals(redButton.getText(), text);
    }

    public void testTextCommonRuEn(String input, String output, boolean isEnglish) {
        if (srcLangButton.text() == "Русский")
        {
            if (isEnglish) {
                swapDirection.click();
                HomePage.isEnglish.waitFor().displayed();
            }
        }

        textarea.sendKeys(input);

        //Костыль
        try
        {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {}

        //проверка
        String result = fullTextTranslation.getText();

        assertEquals(result,  output);
    }

}
