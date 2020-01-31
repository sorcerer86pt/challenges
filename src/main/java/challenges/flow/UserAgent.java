package challenges.flow;

import flow.IAction;
import flow.IAgent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements an Email User.
 * The two main methods that are of use are the addMessage and act
 *
 * @author fabio.rodrigues
 * @since 1.0.0
 */
public class UserAgent implements IAgent {

    private List<String> messages;

    /**
     * Default constructor
     */
    public UserAgent() {
        this.messages = new ArrayList<>();
    }

    /**
     * This type of constructor will create the {@link UserAgent} with the given messages
     *
     * @param messages an Array of message to initialize
     */
    public UserAgent(String... messages) {

        this.messages = Arrays.asList(messages);
    }

    /**
     * Add the given message to the messages to be sent
     *
     * @param message The message to be sent
     */
    public void addMessage(String message) {
        this.messages.add(message);
    }

    /**
     * Send the messages to the Email Adapter
     *
     * @return Action List of Email messages Actions. {@link EmailAction}
     */
    @Override
    public List<IAction> act() {
        List<IAction> actions = new LinkedList<IAction>();
        for (String message : this.messages) {
            actions.add(new EmailAction(message));
        }
        return actions;
    }
}
