package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initDeletionContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
