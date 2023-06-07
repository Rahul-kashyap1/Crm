package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

	/**
	 *  [TestMethod]
	 *  [Description("Generate random name")] 
	 */

	public static String GenerateRandomName(int length) {
		try {
			String RandomName = "Auto_" + RandomStringUtils.randomAlphabetic(length);
			return RandomName;
		} catch (Exception ex) {

		}
		return "";

	}

	/**
	 *  [TestMethod]
	 *  [Description("Generate random number")] 
	 */

	public static String GenerateRandomNumber(int length) {
		try {

			String RandomNumber = RandomStringUtils.randomNumeric(length);
			return RandomNumber;
		} catch (Exception ex) {

		}
		return "";
	}

	/**
	 *  [TestMethod]
	 *  [Description("Generate Security Number number")] 
	 */

	public static String GenerateRandomSecurityNumber() {
		try {

			String RandomSecurityNumber = RandomStringUtils.randomNumeric(3)+"-"+RandomStringUtils.randomNumeric(2)+"-"+RandomStringUtils.randomNumeric(4);
			return RandomSecurityNumber;
		} catch (Exception ex) {

		}
		return "";
	}


	/**
	 *  [TestMethod]
	 *  [Description("Generate random Item")] 
	 */

	public static String GenerateRandomItem() {
		try {

			String RandomItem ="Auto_" + RandomStringUtils.randomAlphabetic(4)+"/"+RandomStringUtils.randomNumeric(5);
			return RandomItem;
		} catch (Exception ex) {

		}
		return "";
	}

	/**
	 *  [TestMethod]
	 *  [Description("Generate dateOfBirth")] 
	 */

	public static String GenerateDOB() {

//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yysyy");

		String date = LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		System.out.println(date);

		return date;

	}

	/**
	 *  [TestMethod]
	 *  [Description("Generate directory")] 
	 */

	public String makedirectory(){
		final String destinationdirectory;
		File destinationDir = new File("C:/AutomationReport"+getTime());
		boolean successful = destinationDir.mkdir();
		if (successful) {
			// System.out.println("Image dir created successfully");
		}

		destinationdirectory = destinationDir.getAbsolutePath();
		return destinationdirectory;
	}

	/**
	 *  [TestMethod]
	 *  [Description("To get current date and time ")] 
	 */
	public static String getTime(){
		Date myDate = new Date();
		String time = (new SimpleDateFormat("ddMMMMMyyyy_hh_mm").format(myDate));
		return time;
	}

	/**
	 *  [TestMethod]
	 *  [Description("To get current date and time ")] 
	 */
	public static String getReportTime(){
		Date myDate = new Date();
		String time = (new SimpleDateFormat("dd MMMMM yyyy hh:mm a").format(myDate));
		return time;
	}

	public static String getInAndOutTime(){
		Date myDate = new Date();
		String time = (new SimpleDateFormat("M/d/YY").format(myDate));
		System.out.println(time);
		return time;
	}

	/**
	 *  [TestMethod]
	 *  [Description("To get current year ")] 
	 */
	public static int getYear(){
	Date d=new Date();  
    @SuppressWarnings("deprecation")
	int year=d.getYear();  
    int currentYear=year+1900;  
    System.out.println("Current year is : "+currentYear); 
    return currentYear;
	}
	
	
	
	/**
	 *  [TestMethod]
	 *  [Description("To get calender date ")] 
	 */
	public static String CalenderDate(){
		Date myDate = new Date();
		String date = (new SimpleDateFormat("MM/dd/YYYY").format(myDate));
		System.out.println(date);
		return date;
	}
	
	
	public static int CalenderCurrentDate() {
	     
	      LocalDate currentdate = LocalDate.now();
	     
	      int currentDay = currentdate.getDayOfMonth();
		return currentDay;
	      
	     
	     
	   }
	public static Month CalenderCurrentMonth() {
		LocalDate currentdate = LocalDate.now();  
		Month currentMonth = currentdate.getMonth();
	     
	      
		return currentMonth;
	      
	     
	     
	   }
	
	public static int CalenderCurrentYear() {
		LocalDate currentdate = LocalDate.now();  
		int currentYear = currentdate.getYear();
	     
	      
		return currentYear;
	      
	     
	     
	   }
     
     
	
}
