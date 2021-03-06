package ru.wombat.admin.tests.DataAndHelpers;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UserData { //Данные пользователя


    private String firstName, lastName;

    public String email() { //Генерация email для создания юзера
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.lastName();
    }

    public String firstname() { //Генерация имени для создания юзера
        if(firstName == null) {
            Fairy fairy = Fairy.create();
            Person person = fairy.person();
            firstName = person.firstName();
        }
        return firstName;
    }

    public String generateFirstname() { // Генерация имени для редактирования юзера
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        firstName = person.firstName();
        return firstName;
    }

    public String lastname() { //Генерация фамилии для создания юзера
        if(lastName == null) {
            Fairy fairy = Fairy.create();
            Person person = fairy.person();
            lastName = person.lastName();
        }
        return lastName;
    }

    public String generateLastname() { // Генерация фамилии для редактирования юзера
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        lastName = person.lastName();
        return lastName;
    }

    public String phone() { //Генерация номера телефона
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.telephoneNumber();
    }

    public String telegram() { // Генерация юзернейма в телеграме
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.lastName();
    }

    public String getFirstNameInEditForm() { //Подтягиваем имя из формы редактирования
        String firstNameInEditForm = $(By.name("rrf.profile.firstName")).getValue();
        return firstNameInEditForm;
    }

    public String getLastNameInEditForm() { //Подтягиваем фамилию из формы редактирования
        String lastNameInEditForm = $(By.name("rrf.profile.lastName")).getValue();
        return lastNameInEditForm;
    }

    public String getGradeNumberBeforeUpgrade() { //Подтягиваем грейд из первой ячейки до повышения
        String gradeIndex = $(By.cssSelector("div[class^='grade__src-users-components-UsersListItem-__etq']")).getText();
        return gradeIndex.valueOf(gradeIndex.split("G")[1]);
    }

    public Integer getNextGrade() { //Определяем следующий грейд
        int nextGrade = (Integer.valueOf(getGradeNumberBeforeUpgrade()) + 2);
        return nextGrade;
    }

    public String getGradeNumberAfterUpgrade() { //Подтягиваем грейд из первой ячейки после повышения
        String gradeIndex = $(By.cssSelector("div[class^='grade__src-users-components-UsersListItem-__etq']")).getText();
        return gradeIndex.valueOf(gradeIndex.split("G")[1]);
    }

    public String worksSince = "11.04.2010"; // Работает с
    public String birthdate = "11.07.1998"; // Дата рождения

    public void fillAddUserForm() { //Заполнение данных юзера
        $(By.name("rrf.user.userpic")).uploadFile(new File("src/test/resources/stqa.png"));
        $(By.name("rrf.user.firstName")).setValue(firstname());
        $(By.name("rrf.user.lastName")).setValue(lastname());
        $(By.name("rrf.user.email")).setValue(email() + Math.random() );
        $(By.name("rrf.user.phone")).setValue(phone());
        $(By.name("rrf.user.telegram")).setValue(telegram());
        $(By.name("rrf.user.worksSince")).setValue(worksSince);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.name("rrf.user.birthDate")).setValue(birthdate);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::input[1]")).setValue("Dev Team").pressEnter();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::input[1]")).setValue("G4").pressEnter();
    }

    public void submitUserCreation() { // Завершение добавления сотрудника(Клик по кнопке "Создать и выслать инвайт"
        $(By.className("button__src-users-components-NewUserForm-__z9_")).pressEnter();
    }

    public void fillAddUserFormWithExistingEmail() { // Заполнение формы создания юзера с существующим email
        $(By.name("rrf.user.userpic")).uploadFile(new File("src/test/resources/stqa.png"));
        $(By.name("rrf.user.firstName")).setValue(firstname());
        $(By.name("rrf.user.lastName")).setValue(lastname());
        $(By.name("rrf.user.email")).setValue("atkachenko");
        $(By.name("rrf.user.phone")).setValue(phone());
        $(By.name("rrf.user.telegram")).setValue(telegram());
        $(By.className("caption__src-shared-forms-__2hP")).click();
        $(By.name("rrf.user.worksSince")).setValue(worksSince);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.name("rrf.user.birthDate")).setValue(birthdate);
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[7]/following::label[1]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[8]/following::input[1]")).setValue("Dev Team").pressEnter();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::span[3]")).click();
        $(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[9]/following::input[1]")).setValue("G4").pressEnter();
    }

    public void editFirstAndLastName() { //Редактирование имени и фамилии пользователя
        $(By.name("rrf.profile.firstName")).clear();
        $(By.name("rrf.profile.firstName")).setValue(generateFirstname());
        $(By.name("rrf.profile.email")).click();
        $(By.className("success__src-shared-forms-__2lg")).waitUntil(text("сохранено"), 20000);
        $(By.name("rrf.profile.lastName")).clear();
        $(By.name("rrf.profile.lastName")).setValue(generateLastname());
        $(By.name("rrf.profile.email")).click();
        $(By.className("success__src-shared-forms-__2lg")).waitUntil(text("сохранено"), 20000);
        $(By.className("closeButton__src-users-components-ReEditUserForm-__20P")).click();
    }
}
