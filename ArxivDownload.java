package com.scv.selenium_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;

public class ArxivDownload {
    public static void main(String[] args) throws InterruptedException {
        File downloadsDir = new File("/Users/scv/Downloads");

        // Set Preferences for FirefoxProfile.
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadsDir.getAbsolutePath());
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);

        System.setProperty("webdriver.gecko.driver","/Users/scv/Desktop/work/Learnings/Selenium/Drivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://arxiv.org/");
        System.out.println(driver.getTitle());
        //Thread.sleep(1000);
        driver.findElement(By.id("new-cs")).click();
        //Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[contains(.,'New submissions')]")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//dl[1]//dt[1]//span[1]//a[1]")).click();
        //Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='abs-button download-pdf']")).click();
        //Thread.sleep(500);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //Thread.sleep(100);
        System.out.println("Reached EOF");
        driver.quit();
    }

}
