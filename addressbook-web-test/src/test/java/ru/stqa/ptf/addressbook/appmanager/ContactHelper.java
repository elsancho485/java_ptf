package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void initContactModification(int editId) { clickLinkByHref("edit.php?id=", editId); }

    public void submitContactModification() { click(By.name("update")); }

    public void selectContact(int index) { driver.findElements(By.name("selected[]")).get(index).click(); }

    public void initDeletionContact() { click(By.xpath("/html/body/div[1]/div[4]/form[2]/div[2]/input")); }

    public void deleteSelectedContact() { driver.switchTo().alert().accept(); }

    public void isThereAContact(ContactData contact) {
            int n = driver.findElements(By.name("selected[]")).size();
            if (n == 0) {
                create(contact);
            }
        }


    public void create(ContactData contact) {
            gotoAddNewPage();
            fillContactForm(contact);
            submitContact();
            contactCache = null;
            gotoHomePage();
        }

    public void modify(ContactData contact) {
            gotoAddNewPage();

    }

//Штука, благодаря которой мы ищем все href по странице и выбираем нужную по position
    public void clickLinkByHref(String href, int position) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
        int j = 0;
        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                j++;
            }
            if(anchor.getAttribute("href").contains(href)
                    && j == position) {
                anchor.click();
                break;
            }
        }
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.cssSelector("#maintable [name=entry]"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.cssSelector("input")).getAttribute("value"));
            List<WebElement> tds = element.findElements(By.cssSelector("td"));
            String lastname = tds.get(1).getText();
            String firstname = tds.get(2).getText();
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return new Contacts(contactCache);
    }



}



