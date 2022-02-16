package com.Application;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ApplicationLevelComponent.EggPlant;
import com.Logutils.HtmlResult;
import com.TestCaseRunner.TestCaseRunner;
//import com.UIDriver.EggUIDriver;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;

public class DataProvider{

	
	public static String getValueFromExcel(String Key)
	{
		List<Map<String,String>> ExcelMap=TestCaseRunner.ConfigurationMap;
		String Value="";
		boolean Found=false;
		for(Map map:ExcelMap)   // Reading from Excel Map on behalf of Key and Value pair
		{
			String MapKey=(String)map.get("Key");
			if(MapKey.equalsIgnoreCase(Key.trim()))
			{
				Value=(String)map.get("Value");

				if(! ( (Value==null) || (Value.equals("")) ) )
				{
					return Value;
				}
				else
				{
					Found=false;
				}
			}
		}

		if(Found==false)
		{
			//log error
			return null;
		}
		else
		{
			return Value;
		}

	}
	//Reading excel data
		public static String getExcelProductCombination(String fileName,String PropertyName) throws FileNotFoundException, IOException, JXLException
		{
			try
			{
				String strValue = "";
				String Propertyfilepath ="";
				String ExcelfileName ="";
				String strProperty=PropertyName.trim();
				String file=fileName.trim();
				ExcelfileName = file + ".xls";
				Properties prop = new Properties();

				String filepath= System.getProperty("user.dir") + "\\FrameWork\\LookUp\\OR\\";

				if (file.equalsIgnoreCase("POSCombinationData"))
				{
					Propertyfilepath= filepath + ExcelfileName ;
					strValue = readExcelFile(Propertyfilepath, strProperty);
					return strValue;
				}
				else if (file.equalsIgnoreCase("NGKCombinationData"))
				{
					Propertyfilepath= filepath + ExcelfileName ;
					strValue = readExcelFile(Propertyfilepath, strProperty);
					return strValue;
				}
				else if (file.equalsIgnoreCase("NGKCLearChoiceData"))
				{
					Propertyfilepath= filepath + ExcelfileName ;
					strValue = readExcelFile(Propertyfilepath, strProperty);
					return strValue;
				}
				else
				{
					strProperty=null;
				}
			}
			catch (JXLException e)
			{
				System.out.println(e.getMessage());
				return null;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
			return null;
		}


		public static String readExcelFile(String FilePath,String PropertyName ) throws JXLException, IOException
		{
			FileInputStream fs = new FileInputStream(FilePath);
			String FlagValue="Y";
			String CellFlagValue ="Y";
			Workbook wb = Workbook.getWorkbook(fs);

			// TO get the access to the sheet
			Sheet sh = wb.getSheet(PropertyName);

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();

			String SingleSProductString ="";
			String OtherProductString ="";

			for (int row = 1; row < totalNoOfRows; row++) {
				boolean RowFlagValue = false;
				SingleSProductString ="";
				for (int col = 1; col < totalNoOfCols; col++) {
					//System.out.print(sh.getCell(col, row).getContents() );
					CellFlagValue = sh.getCell(0, row).getContents().trim();
					if (FlagValue.equalsIgnoreCase(CellFlagValue))
					{
						RowFlagValue = true;
						String SingleSProductString1 = sh.getCell(col, row).getContents();
						SingleSProductString += SingleSProductString1 + "|" ;
						//System.out.println(SingleSProductString);
					}
				}
				if (RowFlagValue)
				{
					OtherProductString += SingleSProductString +",";
					OtherProductString =  OtherProductString.replace("|,", ",");
				}
			}
			String FinalString="";

			OtherProductString=OtherProductString.substring(0, OtherProductString.length()-1);
			System.out.println("Final string : = " +  OtherProductString);
			FinalString = OtherProductString.trim();
			//System.out.println("Final string : = " +  FinalString);
			return FinalString;
		}
	
	


}

	
	