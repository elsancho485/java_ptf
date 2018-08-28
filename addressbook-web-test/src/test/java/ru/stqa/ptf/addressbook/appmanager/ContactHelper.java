package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
    }

    public void gotoHomePage() { click(By.linkText("home")); }

    public void gotoAddNewPage() { click(By.linkText("add new")); }

    public void submitContact() { click (By.name("submit"));}

    public void initContactModification() { click (By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[7]/td[8]/a/img")); }

    public void submitGroupModification() { click(By.name("update")); }

    public void selectContact(int index) { driver.findElements(By.name("selected[]")).get(index).click(); }

    public void initDeletionContact() { click(By.xpath("/html/body/div[1]/div[4]/form[2]/div[2]/input")); }

    public void deleteSelectedContact() { driver.switchTo().alert().accept(); }


    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = driver.findElements(By.cssSelector("#maintable [name=entry]"));
        for (WebElement row : rows) {
            int id = Integer.parseInt(row.findElement(By.cssSelector("input")).getAttribute("value"));
            List<WebElement> tds = row.findElements(By.cssSelector("td"));
            String firstname = tds.get(2).getText();
            String lastname = tds.get(1).getText();
            ContactData contact = new ContactData(id, firstname, null, lastname);
            contacts.add(contact);
        }
        return contacts;
    }

    public void isThereAContact(ContactData contact) {
            int n = driver.findElements(By.name("selected[]")).size();
            if (n == 0) {
                createContact(contact);
            }
        }

        public void createContact(ContactData contact) {
            gotoAddNewPage();
            fillContactForm(contact);
            submitContact();
            gotoHomePage();
        }
    }



