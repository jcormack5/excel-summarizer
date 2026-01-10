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
		if (purpose && format) return prompt; // needs more specific error handling for no format or purpose
		else return "";
	}
	/* Will prompt user for what they want to extract from file
	 * Insights, key trends, patterns, anomalies, short summary
	 */
	public void getPurpose() {
		this.prompt += " ";
	}
	/* Prompts user for output format
	 * Bullet points, ordered list, json, paragraph
	 */
	public void getFormat() {
		this.prompt += " ";
	}
	
	
}