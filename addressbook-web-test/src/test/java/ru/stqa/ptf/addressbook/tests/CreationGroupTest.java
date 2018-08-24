package ru.stqa.ptf.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CreationGroupTest extends TestBase {

  @Test
  public void testCreationGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
