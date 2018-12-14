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
        closeAddUserForm();
    }

    @Test
    public void adminCanEditUserData() {
        goToEditUserData();
        editFirstAndLastName();
        searchCreatedUserInList();
    }

    @Test
    public void adminCanArchivateUser() {
        searchUserNameInEditFormBefore();
        archivateUser();
        searchUserNameInEditFormAfter();
    }

    @Test
    public void adminCanUpgradeUser() {
        getGradeNumberBeforeUpgrade();
        upgradeUser();
        getGradeNumberAfterUpgrade();
        checkingUpgradeUser();
    }
}