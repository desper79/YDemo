package io.github.com;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import io.github.com.pages.*;

@JSite("https://translate.yandex.ru/")
public class StaticSite {
	@Url("") public static HomePage homePage;
	@Url("/doc") public static DocPage DocPage;
	@Url("/translate") public static SitePage SitePage;
}