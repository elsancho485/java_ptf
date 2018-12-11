package ru.wombat.admin.tests.Tests;

import org.testng.annotations.Test;

public class AddUserTest extends TestBase {

    @Test
    public void adminCanAddNewUser() {
        goToAddUserForm();
        fillAddUserForm();
        submitUserCreation();
        searchCreatedUserInList();
    }

    @Test
    public void emptyFieldsErrorDisplaying() {
        goToAddUserForm();
        submitUserCreation();
        searchForEmptyFieldsError();
        closeAddUserForm();
    }

    @Test
    public void errorAboutExistingEmail() {
        goToAddUserForm();
        fillAddUserFormWithExistingEmail();
        submitUserCreation();
        searchForExistingEmailError();
    }
}