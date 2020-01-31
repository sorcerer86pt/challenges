package test_code;

import challenges.flow.EmailAdapter;
import challenges.flow.EmailApp;
import challenges.flow.UserAgent;
import flow.Engine;
import flow.IAdapter;

import java.util.HashMap;
import java.util.Map;


/**
 * Helper class for cucumber test to help test Email app.
 */
public class EmailTestHelper {
    private UserAgent agent;
    private EmailApp app;
    private Engine engine;

    /**
     * Creates and setup all necessary class instances
     */
    public EmailTestHelper() {
        this.agent = new UserAgent();
        this.app = new EmailApp();
        Map<String, IAdapter> adapters = new HashMap<>();
        adapters.put("EMAIL", new EmailAdapter());
        this.engine = new Engine(agent, adapters, app);

    }

    /**
     * Add an email to the list of emails
     *
     * @param emailMessage the email message
     */
    public void addEmail(String emailMessage) {
        this.agent.addMessage(emailMessage);
    }

    /**
     * Send all emails
     *
     * @throws Exception If something unexpected occurred
     */
    public void sendMessages() throws Exception {
        try {
            this.engine.run();
        } catch (Exception exc) {
            System.err.println("Exception found: " + exc.getMessage());
            throw exc;
        }
    }

    /**
     * Get last messages in queue.
     *
     * @return Last message in Queue
     */
    public String getLastMessagesInQueue() {
        return this.app.popMessage();
    }
}
