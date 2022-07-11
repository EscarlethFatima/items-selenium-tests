package ui;

import entities.Item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.StrangerList;
import utils.StringHelper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ItemsList extends BaseTests {
    private StrangerList itemsPage;
    private Item item, itemToBeUpdated, itemToBeDeleted;


    @Before
    public void setUp()  {
        itemsPage = new StrangerList(driver, webActions);
        item = new Item("ITEM 1: Stranger Things is so cool","strangerThings.png");
        itemToBeUpdated = new Item("ITEM 2: Once is amazing","strangerThings.png");
        itemToBeDeleted = new Item("ITEM 3: Mike is tall enough","strangerThings.png");
    }

    @Test
    public  void createItem(){
        itemsPage.createItem(item);
        String message = "Item was not created".concat(item.getName());
        assertTrue(message,itemsPage.itemIsDisplayed(item.getName()));

    }

    @Test
    public  void editItem() {
        String updateItemText = "ISTRANGER THINGS";
        String message = "Item was not updated ".concat(updateItemText);
        itemsPage.createItem(itemToBeUpdated);

        itemsPage.clickEditItem(itemToBeUpdated.getName());
        itemsPage.setItemDescription(updateItemText);
        itemsPage.clickConfirmUpdateItem();
        assertTrue(message,itemsPage.itemIsDisplayed(updateItemText));
    }

    @Test
    public  void deleteItem() {
        itemsPage.createItem(itemToBeDeleted);
        String message = "Item was not removed ".concat(itemToBeDeleted.getName());
        itemsPage.deleteItem(itemToBeDeleted.getName());
        assertFalse(message, itemsPage.itemIsDisplayed(itemToBeDeleted.getName()));
    }

    @Test
    public  void checkMaxLongItemDescription() {
        String maxLongItem = StringHelper.generateRandomString(301);
        itemsPage.setItemDescription(maxLongItem);
        assertFalse("Create item button should not be enabled when sending long item description",
                itemsPage.createItemIsEnabled());
    }

    @Test
    public  void checkASpecificItemExists(){
        String itemDescription = "Creators: Matt Duffer, Ross Duffer";
        String message = "Specific Item does not exist ".concat(itemDescription);
        assertTrue(message,itemsPage.itemIsDisplayed(itemDescription));
    }
}
