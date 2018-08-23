package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class CreationContactTest extends TestBase {


    @Test
    public void testCreationContact() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactHelper().fillContactForm(new ContactData("kakashka", "govnina", "durnek"));
        app.getContactHelper().submitContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
