package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
    }

    public void submitContact() { click (By.name("submit"));}

    public void initContactModification() { click (By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[7]/td[8]/a/img")); }

    public void submitGroupMidification() { click(By.name("update")); }
}


