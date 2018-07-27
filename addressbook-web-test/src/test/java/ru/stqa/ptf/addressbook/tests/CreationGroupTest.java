package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

public class CreationGroupTest extends TestBase {

  @Test
  public void testCreationGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("yest1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
