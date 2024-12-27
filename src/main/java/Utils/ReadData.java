package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ReadData(String path) {
		this.path=path;
	}
	
	
	public int getRowCount(String SheetNo) throws IOException {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		ws= wb.getSheet(SheetNo);
		int rowNo= ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowNo;

	}

	public int getColumnCount(String Sheetno, int rowno) throws IOException {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		ws= wb.getSheet(Sheetno);
		row = ws.getRow(rowno);
		int columnNo = row.getLastCellNum();
		wb.close();
		fis.close();
		return columnNo;


	}

	public String getCellData(String Sheetno,int rowno,int columnno) throws IOException {
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		ws= wb.getSheet(Sheetno);
		row = ws.getRow(rowno);
		cell = row.getCell(columnno);
		String cellData = null;
		try {
			DataFormatter format=new DataFormatter();
			cellData=format.formatCellValue(cell);
			System.out.println(cellData);
			}
			catch(Exception e)
			{
			System.out.println("no value");
			System.out.println(e.getMessage());
			}
		wb.close();
		fis.close();
		return cellData;

		

	}
	
}
