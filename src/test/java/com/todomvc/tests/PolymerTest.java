package com.todomvc.tests;

import com.todomvc.pages.PolymerPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PolymerTest extends TestBase{

    PolymerPage polymerPage=new PolymerPage();

    @Test
    public void test(){
    polymerPage.getTab("JavaScript").click();
    polymerPage.getLink("Polymer").click();
    String toDoItemOne="My first to do item";
    String toDOItemTwo="My second to do item";
    polymerPage.inputBox.sendKeys(toDoItemOne+ Keys.ENTER);
    polymerPage.inputBox.sendKeys(toDOItemTwo+Keys.ENTER);
    Assert.assertTrue(polymerPage.createdItem(toDoItemOne).isDisplayed(),"Verify my first TODO item is not created");
    Assert.assertTrue(polymerPage.createdItem(toDOItemTwo).isDisplayed(),"Verify my second TODO item is not created");

        WebElement btnForChanging= polymerPage.createdItem(toDOItemTwo);
        actions.doubleClick(btnForChanging).perform();

        for (int i = 0; i < toDOItemTwo.length(); i++) {
            polymerPage.editBox.sendKeys(Keys.BACK_SPACE);
        }

        String changedItem="I have changed second item";
        polymerPage.editBox.sendKeys(changedItem);

        Assert.assertTrue(polymerPage.createdItem(changedItem).isDisplayed(),"Mysecond TODO is not changed");

    }
}
