package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase {

    @Test (enabled = false)
    public void testContactPhone() {
        app.goTo().homePage();
//        ContactData contact = app.contact().all().iterator().next();
//        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }

}
