package step_definitions;

import cucumber.api.java8.En;
import org.junit.Assert;
import test_code.EmailTestHelper;

public class MyStepdefs implements En {
    private EmailTestHelper testHelper = new EmailTestHelper();

    public MyStepdefs() {
        Given("^A User sends an \"([^\"]*)\" message$", (String message) -> {
            testHelper.addEmail(message);
        });

        When("^The message is converted by the Adapter$", () -> {
            try {
                testHelper.sendMessages();
            } catch (Exception exc) {
                Assert.fail("Error occurred");
            }
        });

        Then("^The Message server should contain the \"([^\"]*)\" message in the queue$", (String expectedMessage) -> {
            Assert.assertEquals(expectedMessage, testHelper.getLastMessagesInQueue());
        });
    }
}
