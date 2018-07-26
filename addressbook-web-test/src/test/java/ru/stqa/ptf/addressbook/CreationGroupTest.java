package ru.stqa.ptf.addressbook;


import org.testng.annotations.*;

public class CreationGroupTest extends TestBase {

  @Test
  public void testCreationGroup() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("yest1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
