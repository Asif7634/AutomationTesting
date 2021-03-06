package com.Logutils;

import com.ApplicationLevelComponent.EggPlant;
import com.TestCaseRunner.TestCaseRunner;
import com.UIDriver.AppiumUIDriver;
import com.UIDriver.EggUIDriver;
import com.UIDriver.WebUIDriver;


public class ScreenShotUtil
{

	public static void TakeScreenShot(String FilePath)
	{
		String Technology=TestCaseRunner.Technology;

		if(Technology.contains("EggPlant")||Technology.contains("Eggium"))
		{
			captureEggScreen(FilePath);
		}
		else if(Technology.contains("WebDriver"))
		{
			captureWebScreen(FilePath);
		}
		else if(Technology.contains("Appium"))
		{
			captureMobScreen(FilePath);
		}
	}

	// eggplants capture screen
	private static void captureEggScreen(String FilePath)
	{
		EggUIDriver eggUiDriver = EggPlant.eggUIDriver;
		eggUiDriver.takeScreenShot(FilePath);
	}

	//webdrivers screenshot method
	private static void captureWebScreen(String FilePath)
	{
		WebUIDriver.takeScreenShot(FilePath+".png");
	}

	//webdrivers screenshot method for appium
	private static void captureMobScreen(String FilePath)
	{
		try {

			Thread.sleep(2000);
			AppiumUIDriver.takeScreenShot(FilePath+".png");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}


}
