package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public static Label mainTitle;
	@Css(".main-txt") public static Text jdiText;
	@UI("['JDI Github']") public static Link githubLink;

	@Css("#fakeArea") public static TextField fakeArea;
	@Css("#textarea") public static TextField textarea;

	@Css("#translation .translation-word") public static Label translation;

	@Css("[data-complaint-type='fullTextTranslation']") public static Label fullTextTranslation;


	@Css("[data-action='swapDirection']") public static Button swapDirection;

	@Css("#srcLangButton") public static Label srcLangButton;
	@XPath("//*[@id='srcLangButton' and text() ='Английский']") public static Label isEnglish;
	@XPath("//*[@id='srcLangButton' and text() ='Русский']") public static Label isRussian;

	@Css("#examples") public static Label examples;
	@Css("#logo") public static Label logo;


}