package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void groupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddNewPage() { click(By.linkText("add new")); }

  public void gotoHomePage() { click(By.linkText("home")); }

}
