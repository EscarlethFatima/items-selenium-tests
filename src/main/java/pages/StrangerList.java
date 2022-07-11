package pages;

import core.driver.CommonWebActions;
import entities.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.constants.Constants.FILE_PATH_ATTACHMENT;

public class StrangerList extends Base {
    @FindBy(id = "inputImage")
    private WebElement itemImageFile;

    @FindBy(css = "label[for = 'inputText'] + textarea")
    private WebElement itemDescriptionTxt;

    @FindBy(css = ".btn.pull-right.btn-success")
    private WebElement createItemButton;

    @FindBy(css = ".btn.pull-right.btn-primary")
    private WebElement updateItemButton;

    @FindBy(css = ".btn.btn-primary")
    private WebElement confirmDeletingButton;

    private static final String ITEM = "//p[normalize-space(text())=\"%s\"]";
    private static final String EDIT_ITEM = "//p[text()='%s']/../../div/button[text()='Edit']";
    private static final String DELETE_ITEM = "//p[text()='%s']/../../div/button[text()='Delete']";

    public StrangerList(WebDriver driver, CommonWebActions webActions){

        super(driver,webActions);
    }

    public  void clickDeleteItem(String item){
        webActions.clickElement(driver.findElement(By.xpath(String.format(DELETE_ITEM, item))));
    }

    public  void clickConfirmDeleteItem(){
        webActions.clickElement(confirmDeletingButton);
    }

    public  void clickConfirmUpdateItem(){
        webActions.clickElement(updateItemButton);
    }

    public  void clickEditItem(String item){
        webActions.clickElement(By.xpath(String.format(EDIT_ITEM, item)));
    }

    public  void setItemDescription(String itemName){
        webActions.setTextElement(itemDescriptionTxt, itemName);
    }

    public  void setItemImage(String itemFile){
        webActions.setTextElement(itemImageFile, String.format(FILE_PATH_ATTACHMENT, itemFile));
    }

    public  void createItem(Item item){
        webActions.setTextElement(itemDescriptionTxt, item.getName());
        webActions.setTextElement(itemImageFile, String.format(FILE_PATH_ATTACHMENT, item.getImagePath()));
        webActions.clickElement(createItemButton);
    }

    public  void  deleteItem(String itemDescription){
        webActions.clickElement(By.xpath(String.format(DELETE_ITEM, itemDescription)));
        webActions.clickElement(confirmDeletingButton);
    }

    public  boolean itemIsDisplayed(String item){
        System.out.println(String.format(ITEM, item));
        return webActions.isWebElementDisplayed(By.xpath(String.format(ITEM, item)),3000);
    }

    public  boolean createItemIsEnabled(){
        return webActions.isWebElementEnabled(createItemButton);
    }


}
