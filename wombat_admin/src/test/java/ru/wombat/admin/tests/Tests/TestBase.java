package ru.wombat.admin.tests.Tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import ru.wombat.admin.tests.DataAndHelpers.UserData;

import static com.codeborne.selenide.Selenide.*;

public class TestBase extends UserData {

    @BeforeSuite
    public void login() { //Логинка
        Configuration.browser = "chrome";
        String login = "grades_admin@smedialink.com";
        String password = "iac5jiB8Y";
        open("http://0.0.0.0:3000/login");
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Все метрики в одной системе!'])[1]/following::button[1]")).click();
        switchTo().window(1);
        sleep(5000);
        try {
            $(By.id("passp-field-login")).setValue(login).pressEnter();
            $(By.id("passp-field-passwd")).setValue(password).pressEnter();
        } catch (Throwable e) {
            $(By.name("login")).setValue(login);
            $(By.name("passwd")).setValue(password).pressEnter();
        }
        $(By.id("nb-2")).click();
        switchTo().window(0);
        sleep(1000);
        $(By.id("menu__users")).click();
        sleep(500);
    }

    public void goToAddUserForm() { //Переход к форме создания сотрудника
        $(By.className("button__src-shared-AddButton-__3G-")).click();
    }

    public void searchCreatedUserInList() { //Ищем имя и фамилиюсозданного юзера в первой строке списка
        $(By.className("name__src-users-components-UsersListItem-__1eu")).shouldHave(Condition.text(firstname.toUpperCase() + " " + lastname.toUpperCase()));
        sleep(1000);
    }

    public void searchForEmptyFieldsError() { // Поиск ошбибки о пустом поле
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='обязательно'])[1]/following::div[2]"));
        sleep(1000);
    }

    public void searchForExistingEmailError() { // Поиск ошибки о том, что email занят
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='обязательно для заполнения'])[1]/following::div[16]"));
        sleep(1000);
    }

    public void closeAddUserForm() {
        $(By.className("closeButton__src-users-components-NewUserForm-__Isr")).click();
        sleep(1000);
    }
}
