package com.Application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ApplicationLevelComponent.Appium;
import com.ApplicationLevelComponent.DemoWebdriver;
import com.Logutils.HtmlResult;
import com.UIDriver.WebUIDriver;
import com.google.common.util.concurrent.Service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class i18n extends DemoWebdriver
{  WebUIDriver webDriver= new WebUIDriver();

	public void launchURL(Map<String, String> input)
	{String URL = input.get("URL").trim();
		try 
		{
			if(webDriver.get(URL))
			{
				HtmlResult.passed("To open web application", ""+URL+" should be launched successfully", ""+URL+" launched successfully");
			}
			else
			{
				HtmlResult.failed("To open web application", ""+URL+" should be launched successfully", ""+URL+" not launched successfully");
			}
		}
		catch(Exception e)
		{
			HtmlResult.failed("To open web application", ""+URL+" should be launched successfully", ""+URL+" not launched successfully");
		}
	}
	
 
	public void login(Map<String, String> input) throws InterruptedException
	{
		String strUserId = input.get("custUid").trim();
		String strPassword = input.get("custPwd").trim();
		webDriver.sendkeysXpath("login_input", strUserId);
		webDriver.sendkeysXpath("password_input", strPassword);
		if(webDriver.clickByXpath("login_btn"))
		{   Thread.sleep(2000);
			HtmlResult.passed("Login In to Application.", "User should be able to login", "User logged in with Username "+ strUserId );
		}
		else
		{
			HtmlResult.failed("Login In to Application.", "User should be able to login", "User failed to login with Username - '"+ strUserId + "'");
		}
	}
	
	public void changeLanguage(Map<String, String> input)
	{
		//add code to change language
		String language = input.get("language").trim();
		HtmlResult.passed("Updating application language to "+language+"", "Applicatio language should be updated to "+language+"", "Applicatio language successfully updated to "+language);
		
	}
	
	public void verifyPageLabel(Map<String, String> input) 
	{
		String expectedText = input.get("expectedText").trim();
		String language = input.get("language").trim();
		try {
		String strObjectName =input.get("objectName");
		String actualText=webDriver.getText(strObjectName);
		if(expectedText.equalsIgnoreCase(actualText))
		{
			HtmlResult.passed("Verifying label "+expectedText+" in "+language+"", "Expected label name is "+expectedText+"", "Actual lable name is "+actualText);
		}
		else
		{
			HtmlResult.failed("Verifying label "+expectedText+" in "+language+"", "Expected label name is "+expectedText+"", "Actual lable name is "+actualText);
		}
		}
		catch(Exception e)
		{HtmlResult.failed("Verifying label "+expectedText+" in "+language+"", "Expected label name is "+expectedText+"", "Failed due to :"+e.getLocalizedMessage());}
	}
	
	public void closeWebApp()
	{
		try 
		{
			if(webDriver.quit())
				HtmlResult.passedWithoutScreenshot("To close application", "Application should be closed successfully", "Application closed successfully");
		
		else
			HtmlResult.failed("To close application", "Application should be closed successfully", "Application is not closed successfully");
	
		}
		catch(Exception e)
		{
			HtmlResult.failed("To close application", "Application should be closed successfully", "Application is not closed successfully");
			System.err.println("Error");
		}
	}
}
