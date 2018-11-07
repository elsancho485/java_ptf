//package ru.stqa.ptf.addressbook.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import ru.stqa.ptf.addressbook.model.ContactData;
//
//
//import java.util.List;
//
//public class ContactDeletionTest extends TestBase {
//
//
//    @Test(enabled = false)
//    public void testContactDeletion() {
//        app.goTo().gotoHomePage();
//        app.contact().isThereAContact(new ContactData("privet", "snezhok", "zhenyok"));
//        List<ContactData> before = app.contact().getContactList();
//        app.contact().selectContact(before.size() - 1);
//        app.contact().initDeletionContact();
//        app.contact().deleteSelectedContact();
//        app.goTo().gotoHomePage();
//        List<ContactData> after = app.contact().getContactList();
//        Assert.assertEquals(after.size(), before.size() - 1);
//
//        before.remove(before.size() - 1);
//        Assert.assertEquals(before, after);
//    }
//}
