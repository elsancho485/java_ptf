package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;


import java.util.List;

public class ContactDeletionTest extends TestBase {


    @Test(enabled = false)
    public void testContactDeletion() {
        app.goTo().gotoHomePage();
        app.getContactHelper().isThereAContact(new ContactData("privet", "snezhok", "zhenyok"));
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initDeletionContact();
        app.getContactHelper().deleteSelectedContact();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
