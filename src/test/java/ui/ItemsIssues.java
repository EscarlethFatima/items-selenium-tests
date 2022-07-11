package ui;

import entities.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.StrangerList;
import utils.StringHelper;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ItemsIssues extends BaseTests{

    private StrangerList itemsPage;
    private Item itemBug1, itemBug2, itemBug3;

    @Before
    public void setUp()  {
        itemsPage = new StrangerList(driver, webActions);
        itemBug1 = new Item("ITEM BUG1: Stranger Things","strangerThings.png");
        itemBug2 = new Item(StringHelper.generateRandomString(250),"strangerThings.png");
        itemBug3 = new Item(StringHelper.generateRandomString(250),"strangerThings.png");
    }

    @Test
    public  void editItemImage() {
        itemsPage.createItem(itemBug1);

        String image = "bug.png";
        itemsPage.clickEditItem(itemBug1.getName());
        itemsPage.setItemImage(image);
        itemsPage.clickConfirmUpdateItem();
        assertTrue("Edit Item Image was not updated",itemsPage.getImageSrc(itemBug1.getName()).contains(image));
    }

    @Test
    public  void editButtonIsDisplayedAfterCreatingItemDescriptionWithLongText() {
        itemsPage.createItem(itemBug2);
        assertTrue("Edit button is not displayed", itemsPage.editItemButtonIsDisplayed(itemBug2.getName()));
    }

    @Test
    public  void deleteButtonIsDisplayedAfterCreatingItemDescriptionWithLongText() {
        itemsPage.createItem(itemBug3);
        assertTrue("Delete button is not displayed", itemsPage.deleteItemButtonIsDisplayed(itemBug3.getName()));
    }
}
