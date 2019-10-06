/**
 * Changes String to LocalDate
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
public class StringToDate {
	private String date_String;
	private LocalDate date_LocalDate;
	
        /**
         * Constructor
         */
	public StringToDate() {
		this.date_String = "";
		this.date_LocalDate = null;
	}
	
        /**
         * Constructor
         * @param date date to be converted
         */
	public StringToDate(String date) {
		this.date_String = date;
		this.date_LocalDate = change(this.date_String);
	}
	
        /**
         * Changes String to LocalDate
         * @param date date to be converted
         * @return LocalDate
         */
	public LocalDate change (String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.date_LocalDate = LocalDate.parse(date, dtf);
		return this.date_LocalDate;
	}

	/**
         * Returns changed String
	 * @return the date_LocalDate
	 */
	public LocalDate getChangedDate() {
		return date_LocalDate;
	}
	
}