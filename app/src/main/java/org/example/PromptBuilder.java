package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class PromptBuilder {
	private static final Logger LOGGER = LogManager.getLogger(PromptBuilder.class);
	private String prompt;
	private boolean purpose;
	private boolean format;
	
	public PromptBuilder() {
		this.prompt = "";
		this.purpose = false;
		this.format = false;
	}
	
	//Returns prompt
	public String getPrompt() {
		if (!purpose) {
			LOGGER.warn("Task is not set");
		}
		if (!format) {
			LOGGER.warn("Format is not set");
		}
		return prompt;
	}
	/* Adds the task to the prompt
	 */
	public void task(String p) throws InvalidFormatException {
		if (p.equals("")) {
			LOGGER.warn(p,"Blank string");
			throw new InvalidFormatException("Argument is empty");
		}
		this.prompt += "Task {" + p + "}";
		this.purpose = true;
	}
	/* Adds format to prompt
	 */
	public void format(String f) throws InvalidFormatException {
		if (f.equals("")) {
			LOGGER.warn(f,"Blank string");
			throw new InvalidFormatException("Argument is empty");
		}
		this.prompt += "Output format {" + f + "} \n";
		this.format = true;
	}
	
	
}