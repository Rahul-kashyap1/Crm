package ui.tests.messages;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.ExtentReportListener.GenerateReport;
import Home.Home;
import Messages.MessagePage;
import Utility.Methods;

public class QA_001_Create_New_Message extends Methods {

	@Test
	public void createMessage() {
		try {
			reportInitialize();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			click(home.messageLink);
			GenerateReport.Logger_click(reference, "Message");
			MessagePage m = new MessagePage();
			m.createNewMessage(reference, "create");
			click(home.messageLink);
			Assert.assertTrue(isElementPresentInList(m.listOfSubject, m.RandomSubject));
			GenerateReport.Logger_TestPass(reference, "<b>" + m.RandomSubject + "</b> message is created successfully");
			m.createNewMessage(reference, "update");
			click(home.messageLink);
			Assert.assertTrue(isElementPresentInList(m.listOfSubject, m.RandomSubject));
			GenerateReport.Logger_TestPass(reference, "<b>" + m.RandomSubject + "</b> message is updated successfully");
			m.createNewMessage(reference, "delete");
			Assert.assertFalse(m.result);
			GenerateReport.Logger_TestPass(reference, "<b>" + m.RandomSubject + "</b> message is deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
