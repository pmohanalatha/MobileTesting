package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class ExtentTestReportGenerator {
	public static ExtentReports extent;

	public static ExtentReports ExtentTestReportGenerator() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\TestReport.html");
		reporter.config().setReportName("Test Automation Results");
		reporter.config().setDocumentTitle("Extent Test Report");
		reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Name", "Automation Tester");
		return extent;
	}

}
