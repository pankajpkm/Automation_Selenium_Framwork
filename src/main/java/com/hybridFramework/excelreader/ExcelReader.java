package com.hybridFramework.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	@SuppressWarnings("deprecation")
	public String[][] readExcelData(String fileLocation, String sheetName){
		
		try{
			String dataSets[][]=null;
			FileInputStream file = new FileInputStream(new File(fileLocation));
			
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			int totalColumn = sheet.getRow(0).getLastCellNum();
			dataSets = new String[totalRow-1][totalColumn];
			
			Iterator<Row> rowItr= sheet.iterator();
			int i=0;
			int j=0;
			while(rowItr.hasNext()){
				Row row= rowItr.next();
				if(i++ !=0){
					int rowNo=j;
					j++;
					Iterator<Cell> cellItr= row.iterator();
					int colNo=0;
					while(cellItr.hasNext()){
						Cell cell=cellItr.next();
						
						switch(cell.getCellType()){
						case Cell.CELL_TYPE_STRING:
						 dataSets[rowNo][colNo++]=cell.getStringCellValue();
						 System.out.println(cell.getStringCellValue());
						 	break;
						case Cell.CELL_TYPE_NUMERIC:
							 dataSets[rowNo][colNo++]=cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
						case Cell.CELL_TYPE_FORMULA:
							 dataSets[rowNo][colNo++]=cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
						case Cell.CELL_TYPE_BOOLEAN:
							 dataSets[rowNo][colNo++]=cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
							 default:
								 
						}
					}
					System.out.println("");
				}
			}
			workbook.close();
			file.close();
			return dataSets;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}
