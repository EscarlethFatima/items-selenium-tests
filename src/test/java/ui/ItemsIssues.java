package ui;

import entities.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.StrangerList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ItemsIssues extends BaseTests{

    private StrangerList itemsPage;
    private Item itemBug1, itemBug2, itemBug3;

    @Before
    public void setUp()  {
        itemsPage = new StrangerList(driver, webActions);
        itemBug1 = new Item("ITEM BUG1: Stranger Things","strangerThings.png");
        itemBug2 = new Item("ITEM BUG2: Stranger Things","strangerThings.png");
        itemBug3 = new Item("ITEM BUG3: Stranger Things","strangerThings.png");
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
    public  void createItemButtonShouldNotBeEnabledWhenNotAllTheRequiredFieldsHaveBeenSet() {
        itemsPage.setItemDescription(itemBug2.getName());
        assertFalse("Create Item is enabled", itemsPage.createItemIsEnabled());
    }

    @Test
    public  void deleteWarningModalIsProperlySpelled() {
        itemsPage.createItem(itemBug3);
        itemsPage.clickDelete(itemBug3.getName());
        assertEquals("Delete Warning Modal is not properly spelled",
                "Are you sure you want to delete this item?", itemsPage.getDeleteModalHeaderText());
    }
}
