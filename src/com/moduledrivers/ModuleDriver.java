package com.moduledrivers;

import java.util.HashMap;
import java.util.Map;

//import com.Application.GMA;
//import com.Application.GMA4_Appium;
//import com.Application.GMA5_Appium;
//import com.Application.POS;
//import com.Application.Promotion_KVS;
//import com.Application.Promotion_NGK;
import com.Application.i18n;
//import com.ApplicationLevelComponent.Appium;
import com.ApplicationLevelComponent.DemoWebdriver;
import com.ApplicationLevelComponent.EggPlant;
import com.ApplicationLevelComponent.RemoteWebDriver;
import com.GenericComponents.GenericComponents;
import com.Logutils.HtmlResult;
import com.TestCaseRunner.TestCaseRunner;

public class ModuleDriver extends TestCaseRunner
{
	public static Map<String,Object> ModuleDrivers= new HashMap<String,Object>();

	public Map<String, Object> getModuleDrivers()
	{
		return ModuleDrivers;
	}

	public static void setModuleDrivers(String DriverclassName,Object DriverObject)
	{
		ModuleDrivers.put(DriverclassName, DriverObject);
	}

	public static void setModuleDrivers()
	{
		try {
			/*
			 * ModuleDrivers.put("HTML",new HtmlResult()); ModuleDrivers.put("Eggplant", new
			 * EggPlant()); ModuleDrivers.put("DemoWebdriver", new DemoWebdriver());
			 * ModuleDrivers.put("RemoteWebDriver", new RemoteWebDriver());
			 * ModuleDrivers.put("GenericComponents", new GenericComponents());
			 * ModuleDrivers.put("Pos", new POS()); ModuleDrivers.put("Promotion_NGK", new
			 * Promotion_NGK()); ModuleDrivers.put("Promotion_KVS", new Promotion_KVS());
			 * ModuleDrivers.put("GMA", new GMA()); ModuleDrivers.put("Appium", new
			 * Appium());
			 */
			ModuleDrivers.put("i18n", new i18n());
			//ModuleDrivers.put("GMA4_Appium", new GMA4_Appium());

		} catch (Exception e) {
			FrameWorkLogger.info("FrameWork", e.getMessage());
		}
	}
}
