package ru.innerzone.tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    @Test
    public void userCanLogin() {
        Configuration.browser = "chrome";
        open("http://sports.innerzone.local/#/login");
        $(By.id("inputEmail")).setValue("smladmin");
        $(By.id("inputPassword")).setValue("smladmin").pressEnter();
        $$(By.cssSelector("/html/body/app-root/app-dashboard/div/app-navbar/div/span/app-current-entity/modal/div/div/div/div[2]/modal-content/div[1]/label"));
    }
}
