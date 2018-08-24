package ru.stqa.ptf.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class CreationGroupTest extends TestBase {

  @Test
  public void testCreationGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("yest1", "test2", "test3");
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for (GroupData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    before.add(group);
    group.setId(max);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
