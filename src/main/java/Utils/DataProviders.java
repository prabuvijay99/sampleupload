package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="leadData")
	public String[][] sendData() throws IOException {
		
		
		String path=System.getProperty("user.dir")+"//TestData//LeadData.xlsx";
		
		ReadData rd=new ReadData(path);		
		
		int rowCount = rd.getRowCount("Sheet1");
		
		int columnCount = rd.getColumnCount("Sheet1", 1);
		
		
		String[][] data=new String[rowCount][columnCount];
		for(int r=1;r<=rowCount;r++) {
			for(int c=0;c<columnCount;c++) {
				
				data[r-1][c]=rd.getCellData("Sheet1", r, c);
				
			}
		}
		
		return data;
		

	}
	

}
