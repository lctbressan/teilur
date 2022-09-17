package com.braziltest.Pages;
import com.braziltest.Steps.Hook.BaseStep;
import com.braziltest.Steps.Hook.Hook;
import com.braziltest.Utils.Instrumentation;
import com.braziltest.Utils.Config;
import com.braziltest.interfaces.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

import static com.braziltest.Utils.Config.PATHEVIDENCELINUX;
import static com.braziltest.Utils.Config.PATHEVIDENCEWIN;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseStep {

    public static int x = 0;

    public static void thatTheUserIsOnTheHomeScreen(String arg0) throws Exception {
        DriverFactory.getDriver(arg0);
    }

    public static void SendCredentials(String arg0, String arg1) throws IOException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='username']", arg0, "Type User");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='password']", arg1, "Type Pass");
        Instrumentation.clickWeb(Webdriver, Config.xpath, "//*[contains(text(),' Login')]", "Confirm");
    }
    public static void checkCheckBoxes(String arg0) {
        Instrumentation.checkBox(Webdriver,arg0);
    }

    public static void contextMenu(WebDriver driver) {
        Instrumentation.clickRightMenu(Webdriver);
    }

    public static void selectDoropdown(WebDriver driver, String arg0) {
        Instrumentation.selectDropDown(Webdriver,arg0);
    }

    public static void testRefresh(WebDriver driver,int arg0) throws IOException, InterruptedException {

        for(int i=1;i<arg0;i++){
            String[] arrOfStr=null;
            String[] arrOfStr2=null;
            String Res1 = Instrumentation.getPageStatus(Webdriver);
            arrOfStr = Res1.split(";");
            driver.navigate().refresh();
            String Res2 = Instrumentation.getPageStatus(Webdriver);
            arrOfStr2 = Res2.split(";");
            if(!arrOfStr.equals(arrOfStr2)){
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(true);
            };
        }
    }
    public static void ClicksOnREmoveButton(WebDriver driver,String arg0) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='checkbox-example']/button","Click remove Button");

    }

    public static void validateResult(String type,String arg0) throws Exception {
        File f = null;
        if(type.equals("LOGIN")) {
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.xpath, arg0);
            if (Ret3.contains(arg0)) {
                Assert.assertEquals("VALIDATION", arg0, Ret3);
            } else {
                Assert.assertTrue(false);
            }
        }
        if(type.equals("DC")) {
            String Ret3 = Instrumentation.getVariantTextOnScreen(Webdriver, Config.id, arg0);
            if (Ret3.contains(arg0)) {
                Assert.assertEquals("VALIDATION", arg0, Ret3);
            } else {
                Assert.assertTrue(false);
            }
        }
        if(type.equals("CKBX")) {
                Instrumentation.checkBoxVal(Webdriver,arg0);
        }
        if(type.equals("CON")){
                Instrumentation.validContext(Webdriver);
        }
        if(type.equals("FILE")){
            Thread.sleep(3000);
           if(System.getProperty("os.name").contains("Windows")) {
               f = new File("C:\\Users\\braziltest\\Downloads\\"+arg0);
            }
            if(System.getProperty("os.name").contains("Linux")){
                f = new File("/home/bressan/downloads"+arg0);
            }
            if(f.exists() && !f.isDirectory()) {
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(true);
            }
        }

    }

    public static void sendCredencialsAnd(String arg0, String arg1) throws IOException, InterruptedException {
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='user']", arg0, "Type User");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//input[@name='pass']", arg1, "Type Pass");
        Instrumentation.clickWeb(Webdriver, Config.xpath, "//input[@name='commit']", "Confirm");
    }




    public static void switchIframe(WebDriver driver ) throws IOException {
        Webdriver.switchTo().frame("mce_0_ifr");
        Instrumentation.clear(Webdriver,"tinymce");
        Instrumentation.sendKeysWeb(Webdriver, Config.xpath, "//*[@id='tinymce']","SOME TEXT", "");

    }

    public static void sendLoginandPass(String arg0, String arg1) throws IOException, InterruptedException {
        Thread.sleep(1000);
        Webdriver.switchTo().parentFrame();
        Webdriver.switchTo().frame("basefrm");
        //Webdriver.switchTo().frame("passWarning");
        //Webdriver.switchTo().frame(0);
        //Webdriver.switchTo().frame(Webdriver.findElement(By.id("basefrm")));
        WebElement el = Webdriver.findElement(By.id("Loginuser"));
        el.click();
        Webdriver.findElement(By.id("Loginuser")).sendKeys(arg0);
        Thread.sleep(2000);
        WebElement el1 = Webdriver.findElement(By.id("LoginPassword"));
        el1.click();
        Webdriver.findElement(By.id("LoginPassword")).sendKeys(arg1);
        Instrumentation.clickWeb(Webdriver, Config.xpath, "/html/body/div/div/div[1]/form/div/table/tbody/tr[6]/td/input[2]", "");
        //Instrumentation.sendKeysWeb(Webdriver,Config.xpath,"/html/body/div/div/div[1]/form/div/table/tbody/tr[2]/td[2]/input",arg0,"");
        //Instrumentation.sendKeysWeb(Webdriver,Config.id,"Loginuser",arg0,"");
        //Instrumentation.sendKeysWeb(Webdriver,Config.id,"LoginPassword",arg1,"");
        //Instrumentation.clickWeb(Webdriver,Config.xpath,"//*[contains(text(),'LOGIN')]","");
        //Instrumentation.clickOnElementNotInteractWithContainsText(Webdriver,Config.className,"","setupWifiTable","");

    }


    public static void ClicksOnAddButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='checkbox-example']/button","Click Add ");
    }

    public static void ClicksOnEnableButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver,Config.xpath,"//*[@id='input-example']/button","Click Enable");
    }

    public static void ClicksOnDisableButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[@id='input-example']/button", "Click Disable");
    }

    public static void ClicksTheStartButton(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[@id='start']/button", "Click Start");
    }

    public static void ClickFileDownload(WebDriver driver) throws IOException {
        Instrumentation.clickWeb(driver, Config.xpath, "//*[contains(text(),'some-file.txt')]", "Click some-file.txt");
    }

    public static void UploadFile(WebDriver driver,String arg0) throws IOException {
        Instrumentation.uploadfile(driver,arg0);
    }

    public static void testScrollPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }
}