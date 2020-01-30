package challenges.flow;

import flow.IAction;
import flow.IAgent;

import java.util.LinkedList;
import java.util.List;

public class UserAgent implements IAgent {

    private String[] messages;

    public UserAgent(String... messages) {
        this.messages = messages;
    }


    @Override
    public List<IAction> act() {
        List<IAction> actions = new LinkedList<IAction>();
        for (String message : this.messages) {
            actions.add(new EmailAction(message));
        }
        return actions;
    }
}
