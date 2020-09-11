package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DocPage extends HomePage {
    public static FileInput fileInput;
    @Css("[data-type='trSpan']") public static Label result;
    @Css("input#docInput") public static Text docInput;
}