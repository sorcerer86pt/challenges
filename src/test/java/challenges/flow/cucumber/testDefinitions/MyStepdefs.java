package challenges.flow.cucumber.testDefinitions;

import challenges.flow.EmailAdapter;
import challenges.flow.EmailApp;
import challenges.flow.UserAgent;
import cucumber.api.java8.En;
import flow.Engine;
import flow.IAdapter;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class MyStepdefs implements En {
    private UserAgent agent;
    private EmailApp app = new EmailApp();
    private Engine engine;

    public MyStepdefs() {
        Given("^A User sends an \"([^\"]*)\" message$", (String message) -> {
            this.agent = new UserAgent(message);
        });
        When("^The message is converted by the Adapter$", () -> {
            Map<String, IAdapter> adapters = new HashMap<String, IAdapter>();
            adapters.put("EMAIL", new EmailAdapter());

            this.engine = new Engine(agent, adapters, app);
            try {
                this.engine.run();
            } catch (Exception exc) {
                System.err.println("Exception found: " + exc.getLocalizedMessage());
                Assert.fail("Error occurred");
            }
        });
        Then("^The Message server should contain the \"([^\"]*)\" message in the queue$", (String expectedMessage) -> {
            Assert.assertEquals(expectedMessage, app.popMessage());
        });
    }
}
