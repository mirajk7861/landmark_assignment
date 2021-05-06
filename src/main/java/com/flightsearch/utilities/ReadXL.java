package com.flightsearch.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadXL  extends Config
{
	static FileInputStream fis;
	static Workbook wb;
	static FileOutputStream fos;
	
		
	
	/*
	 * method to get the column number based on the column header value
	 * input parameter XL path, sheet name and column header value
	 */
public static int getCol(String path,String sheet,String search)
       {
              String cellValue;
              int col=-1;
              int noOfCol=XLCol(path,sheet,0);
              try{
                     fis = new FileInputStream(path);
                     wb = WorkbookFactory.create(fis);
                     for(int i=0;i<=0;i++)
                     {
                           for(int j=0;j<noOfCol;j++)
                           {
                                  try{
                                         cellValue=wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
                                         if(cellValue.equals(search))
                                         {
                                                col=j;
                                                break;
                                         }else
                                         {
                                                continue;
                                         }
                                  }
                                  catch(Exception e)
                                  {
                                         continue;
                                  }
                           }
                     }
              }catch(Exception e)
              {
                     return -1;
              }
              return col;
       }


public static int getRow(String path,String sheet,String search)
       {
              String cellValue;
              int row=-1;
              int noOfrows=XLRow(path,sheet);
              try
              {
                     fis = new FileInputStream(path);
                     wb = WorkbookFactory.create(fis);

                     for(int i=1;i<=noOfrows;i++)
                     {
                           try{
                                  cellValue=wb.getSheet(sheet).getRow(i).getCell(0).getStringCellValue();
                                  if(cellValue.equals(search))
                                  {
                                         row=i;
                                         break;
                                  }else
                                  {
                                         continue;
                                  }
                           }catch(Exception e)
                           {
                                  //  add log statement here
                           }
                     }
              }catch(Exception e){
                     //  add log statement here
              }

              return row;
       }

	
	
	
	
	
	
	
	/*
	 *  To get the XL cell value
	 *  Input parameters, XL path, sheet name, row and column number
	 */
	public static String XLCellValue(String path,String sheet,int row,int cell)
	{
		
		String cellValue;
		//RichTextString cellValue1;
		try
		{
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
			cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			fis.close();
			// cellValue1=wb.getSheet(sheet).getRow(row).getCell(cell).getRichStringCellValue();
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
		//	LogStatus.LogAction("Reading From Excel", e.getMessage(), ":Warn");
			return cellValue=" ";
			
		}
		return cellValue;
	}
	
	/*
	 *  To get the XL cell value
	 *  Input parameters, XL path, sheet name, row number and column header
	 */
	public static String XLCellValue(String path,String sheet,int row,String colName)
	{
		
		String cellValue;
		int cell=getCol(path,sheet,colName);
		//RichTextString cellValue1;
		try
		{
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
			 cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			// cellValue1=wb.getSheet(sheet).getRow(row).getCell(cell).getRichStringCellValue();
			 fis.close();
		}
		catch(Exception e)
		{
			return cellValue=" ";
			
		}
		return cellValue;
	}
	
	/*
	 *  To get the XL cell value
	 *  Input parameters, XL path, sheet name, row header and column header
	 */
	public static String XLCellValue(String path,String sheet,String rowName,String colName)
	{
		
		String cellValue;
		int cell=getCol(path,sheet,colName);
		int row=getRow(path,sheet,rowName);
		//RichTextString cellValue1;
		try
		{
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
			 cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			// cellValue1=wb.getSheet(sheet).getRow(row).getCell(cell).getRichStringCellValue();
			 fis.close();
		}
		catch(Exception e)
		{
		//	LogStatus.LogAction("Reading From Excel", e.getMessage(), ":Warn");
			return cellValue=" ";
			
		}
		return cellValue;
	}
	
	/*
	 * To write value to the specified cell
	 * input parameter: XL path,sheet name,text,row and col values
	 */
	public static void	writeCell(String path,String sheet,String txt,int row,int col) //throws InvalidFormatException, IOException
	{
		try{
				fis = new FileInputStream(path);
				wb = WorkbookFactory.create(fis);
				Row r = wb.getSheet(sheet).getRow(row);
				r.createCell(col).setCellValue(txt);
				FileOutputStream fout= new FileOutputStream(path);
				wb.write(fout);
				fout.close();
				fis.close();
		}catch(Exception e)
		{
			//System.out.println();
			e.printStackTrace(System.out);
		//	LogStatus.LogAction("Write to Excel", e.getMessage(), ":Warn");
		}
	}
	
	/*
	 *  To get the integer XL cell value
	 *  Input parameters, XL path, sheet name, row and column number
	 */
	public static double XLCellNumericValue(String path,String sheet,int row,int cell)
	{
		
		double cellValue;
		try
		{
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);
			cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			fis.close();
		}
		catch(Exception e)
		{
			//LogStatus.LogAction("Reading From Excel", e.getMessage(), ":Warn");
			return cellValue=-1;
			
		}
		return cellValue;
	}
	/*
	 *  To get the XL row number
	 *  Input parameters, XL path and  sheet name
	 */
	public static int XLRow(String path,String sheet)
	{
			int xlRow;
			try{
					fis = new FileInputStream(path);
					wb = WorkbookFactory.create(fis);
					xlRow=wb.getSheet(sheet).getLastRowNum();
					fis.close();
				}catch(Exception e)
				{
				//	LogStatus.LogAction("Reading From Excel", e.getMessage(), ":Warn");
					return -1;
				}
		return xlRow;
	}
	
	public static int XLCol(String path,String sheet,int row)
	{
			int xlCol;
			try{
					fis = new FileInputStream(path);
					wb = WorkbookFactory.create(fis);
					xlCol=wb.getSheet(sheet).getRow(row).getLastCellNum();
					fis.close();
				}catch(Exception e)
				{
					//LogStatus.LogAction("Reading From Excel", e.getMessage(), ":Warn");
					return -1;
				}
		return xlCol;
	}
		
	public static int getHours(String a)
	{
		int hours = Integer.parseInt(a);
		return hours/100;
	}
	public  static int getMinutes(String a)
	{
		int hours = Integer.parseInt(a);
		return hours%100;
	}
	
	public static String getStatus(String change,String old)
	{
		if(getHours(change)==getHours(old))
		{
			if(getMinutes(change)>getMinutes(old))
			{
				//System.out.println("deleayed in minutes");
				return "delayed";
			}
			else
			{
				//System.out.println("early in minutes");
				return "early";
			}
			
		}else
		{
		
		if(getHours(change)*60+getMinutes(change)>getHours(old)*60+getMinutes(old))
		{
			
			//System.out.println("Delayed");
			return "delayed";
			
		}else
		{
			//System.out.println("early");
			return "early";
			
		}
		}
	}
	public static int getNoOfSheets(String path)
    {
         int sheetcount=-1;
         try
         {
             fis = new FileInputStream(path);
             wb = WorkbookFactory.create(fis);
             sheetcount=wb.getNumberOfSheets();
             fis.close();
         }catch(Exception e)
         {
             //log status
             System.out.println(e.getMessage());
             return -1;
         }
         return sheetcount;
    }
    public static String[] getSheetNames(String path)
    {
         int sheetcount;
         try
         {
             fis = new FileInputStream(path);
             wb = WorkbookFactory.create(fis);
             sheetcount=wb.getNumberOfSheets();
             String[] sheets= new String[sheetcount];
             for(int i=0;i<sheetcount;i++)
                  sheets[i]=wb.getSheetName(i);
             fis.close();
             return sheets;
         }catch(Exception e)
         {
             //log status
             System.out.println(e.getMessage());
             return null;
         }
         
    }


		public static ArrayList<String> xlToArrayList(String path,String sheet,int row)
	    {
	           ArrayList<String> rowValues=new ArrayList<String>();
	           try
	           {        	   
	        	      int col=ReadXL.XLCol(path, sheet, row);
	                  for(int i=0;i<col;i++)
	                  {  
	                		  if(wb.getSheet(sheet).getRow(row).getCell(i)==null){               			  
	                			  rowValues.add(null);               			  
	                		  }else{                       
	                			  rowValues.add(wb.getSheet(sheet).getRow(row).getCell(i).getStringCellValue().toString());
	                		  }      	   
	                  }	 
	           }catch(Exception e)
	           {
	         	  System.out.print("Execption in Method ::xlToArrayList");
	           }         
	           return rowValues;
	   
	}
	
}
