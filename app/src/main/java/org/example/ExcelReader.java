package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelReader {
	private String content;
	private String path;
	private static final Logger LOGGER = LogManager.getLogger("ExcelReader.class");
	
	public ExcelReader(String p) {
		this.path = p;
		this.content = "";
	}
	// add a file name method that removes all of path but the file name
	
	public String getFileContent() throws InvalidFormatException {
		try (InputStream input = new FileInputStream(path)){
			LOGGER.info("File Parsing Begins");
			Workbook wb = WorkbookFactory.create(input);
			
			int count = 0;
			while (count < wb.getNumberOfSheets()) {
			
				Sheet sheet = wb.getSheetAt(count);
			
				content += "Worksheet" + count + 1 + "{";
				for (Row row : sheet) {
					for (Cell cell : row) {
						content += " " + cell.toString();
				
					}
			}
			content += "} ";
			count++;
			} if (count == 0) {
				LOGGER.error("File is empty",wb);
				return content;
			}
			} catch (IOException e) {
			LOGGER.error("Could not read the data file.",e);
		}
		
		return "Content of the file: "  + content;
	}
	
	
}
