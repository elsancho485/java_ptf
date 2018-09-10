package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ModificationContactTest extends TestBase {

    @Test(enabled = false)
    public void testModificationContact() {
        app.goTo().gotoHomePage();
        app.getContactHelper().isThereAContact(new ContactData("Brat", "Bratan", "Bratishka"));
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size());
        ContactData contact = new ContactData("Sashok", "krasavchik", "bazaryu");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (f1, f2) -> Integer.compare(f1.getId(), f2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
