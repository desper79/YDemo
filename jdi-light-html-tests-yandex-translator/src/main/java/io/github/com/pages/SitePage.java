package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Frame;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SitePage extends HomePage {
    @Css("#urlInput") public static TextField urlInput;
    @Css(".button[data-action='submitUrl']") public static Button submitUrl;


    @Css("#srcLangButton") public static Link srcLangButtonSite;

    @Css("#dstLangButton") public static Button dstLangButton;

    @XPath("//*[@id = 'progress' and text() = '100%']") public static Label progress;


    @Frame("#sourceFrame") public static SitePageSourceFrame sourceFrame;

    @Frame("#targetFrame") public static SitePageTargetFrame targetFrame;



}