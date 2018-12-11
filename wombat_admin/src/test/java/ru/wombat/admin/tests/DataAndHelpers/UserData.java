package ru.wombat.admin.tests.DataAndHelpers;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UserData { //Данные пользователя
    public String email = "wccdejceicdw";
    public String firstname = "dccdejndi";
    public String lastname = "meh";
    public String phone = "89182386052";
    public String telegram = "omaewa";
    public String worksSince = "03.02.1990";
    public String birthdate = "11.04.2010";

    public void fillAddUserForm() { //Заполнение данных юзера
        $(By.name("rrf.user.userpic")).uploadFile(new File("src/test/resources/stqa.png"));
        $(By.name("rrf.user.firstName")).setValue(firstname);
        $(By.name("rrf.user.lastName")).setValue(lastname);
        $(By.name("rrf.user.email")).setValue(email);
        $(By.name("rrf.user.phone")).setValue(phone);
        $(By.name("rrf.user.telegram")).setValue(telegram);
        $(By.name("rrf.user.worksSince")).setValue(worksSince);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.name("rrf.user.birthDate")).setValue(birthdate);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::input[1]")).pressEnter();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::input[1]")).setValue("G1").pressEnter();
    }

    public void submitUserCreation() { // Завершение добавления сотрудника(Клик по кнопке "Создать и выслать инвайт"
        $(By.className("button__src-users-components-NewUserForm-__z9_")).pressEnter();
    }

    public void fillAddUserFormWithExistingEmail() { // Заполнение формы создания юзера с существующим email
        $(By.name("rrf.user.firstName")).setValue(firstname);
        $(By.name("rrf.user.lastName")).setValue(lastname);
        $(By.name("rrf.user.email")).setValue("atkachenko");
        $(By.name("rrf.user.phone")).setValue(phone);
        $(By.name("rrf.user.telegram")).setValue(telegram);
        $(By.name("rrf.user.worksSince")).setValue(worksSince);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.name("rrf.user.birthDate")).setValue(birthdate);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::input[1]")).pressEnter();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::input[1]")).setValue("G1").pressEnter();
    }
}
