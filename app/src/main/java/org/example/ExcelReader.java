package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelReader {
	private String content;
	private String path;
	
	public ExcelReader(String p) {
		this.path = p;
		this.content = "";
	}
	// add a file name method that removes all of path but the file name
	
	public String getFileContent() throws IOException, InvalidFormatException {
		try (InputStream input = new FileInputStream(path)){
			Workbook wb = WorkbookFactory.create(input);
			Sheet sheet = wb.getSheetAt(0);
			
			for (Row row : sheet) {
				for (Cell cell : row) {
					content += " " + cell.toString();
				}
			}
		}
		return "Content of the file: "  + content;
	}
	
	
}
