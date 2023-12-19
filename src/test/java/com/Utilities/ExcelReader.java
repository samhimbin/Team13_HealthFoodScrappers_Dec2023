package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.streaming.SXSSFCell;
=======
>>>>>>> 2d314de73986116c7bfb27eecba74e50e2fc46fd
=======
>>>>>>> priyanka
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;


	public File jsonFile;
	
	 public ExcelReader(String path)
	{
		this.path=path;
	}

	 public File getJSONFile (String jsonPath)
	 {
		 jsonFile= new File(jsonPath);	
		 
		 return jsonFile;
	 }
	 public int getRowCount(String sheetName) throws IOException 
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			int rowcount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;		
		}

		public int getCellCount(String sheetName,int rownum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();
			workbook.close();
			fi.close();
			return cellcount;
		}
	 
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
		}
				
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		
		sheet=workbook.getSheet(sheetName);
					
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);

		fo=new FileOutputStream(path);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> priyanka
	public void createExcel(String sheetName) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName);
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
	public void createExcel(String sheetName) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		XSSFRow row = sheet.createRow(0);
		
>>>>>>> 6b2afe5126f43dbc773d90534d594719cf3bd4f2
=======
>>>>>>> priyanka
		// creating first row of Excel
		setCellData(sheetName, 0, 0, "RecipeID");
		setCellData(sheetName, 0, 1, "RecipeName");
		setCellData(sheetName, 0, 2, "Recipe Category(Breakfast/lunch/snack/dinner)");
		setCellData(sheetName, 0, 3, "Food Category(Veg/non-veg/vegan/Jain)");
		setCellData(sheetName, 0, 4, "Ingredients");
		setCellData(sheetName, 0, 5, "Preparation Time");
		setCellData(sheetName, 0, 6, "Cooking Time");
		setCellData(sheetName, 0, 7, "Preparation method");
		setCellData(sheetName, 0, 8, "Nutrient values");
		setCellData(sheetName, 0, 9, "Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
		setCellData(sheetName, 0, 10, "Recipe URL");
		setCellData(sheetName,0,11,"To Add Ingredient(Bonus Points)");
		
		}
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
		
=======
>>>>>>> 2d314de73986116c7bfb27eecba74e50e2fc46fd
>>>>>>> 6b2afe5126f43dbc773d90534d594719cf3bd4f2
=======
>>>>>>> priyanka
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> priyanka
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
<<<<<<< HEAD
>>>>>>> 2d314de73986116c7bfb27eecba74e50e2fc46fd
=======
>>>>>>> priyanka
}