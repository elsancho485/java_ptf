package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class CreationContactTest extends TestBase {


    @Test(enabled = false)
    public void testCreationContact() {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoAddNewPage();
        ContactData contact = new ContactData( "durnek", null, "govnina");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContact();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size() , before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (t1, t2) -> Integer.compare(t1.getId(), t2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
