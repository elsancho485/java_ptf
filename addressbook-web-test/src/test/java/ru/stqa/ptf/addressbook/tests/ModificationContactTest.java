package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ModificationContactTest extends TestBase {

    @Test
    public void testModificationContact() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Sashok", "krasavchik", "bazaryu"));
        app.getContactHelper().submitGroupMidification();
        app.getNavigationHelper().gotoHomePage();
    }
}
