package com.pbweb.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Name: ExcelUtil
 * Description: This is the utility class to fetch the data from the excel sheet
 * Developed By: Prashanti Mantrala
 * Approved By : 
 * Data Created/Modified: 11/25/2023
 */

public class ExcelUtil {
	
    XSSFWorkbook excel;
	
	/*
	 * this is the constructor which will be called when ever an object of this class is created
	 */
	public ExcelUtil(String excelPath) 
	{
		try
		{
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			excel = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the excel sheet! please check "+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	/*
	 * this method is used to get the active rows from the excel
	 */
	public int getRowCount(int sheetNum)
	{
		return excel.getSheetAt(sheetNum).getLastRowNum()+1;
	}
	
	public int getRowCount(String sheetName)
	{
		return excel.getSheet(sheetName).getLastRowNum()+1;
	}
	
	/*
	 * this method is used to get the cell data
	 */
	public String getCellData(int sheetNum, int row, int cell)
	{
		return excel.getSheetAt(sheetNum).getRow(row).getCell(cell).toString();
	}
	
	public String getCellData(String sheetName, int row, int cell)
	{
		return excel.getSheet(sheetName).getRow(row).getCell(cell).toString();
	}


}