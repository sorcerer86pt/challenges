package challenges.flow;

import flow.ActionException;
import flow.EventException;
import flow.IEvent;

public class EmailEvent implements IEvent<String> {

    private String emailMessage;

    public EmailEvent(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    @Override
    public String trigger() throws EventException, ActionException {
        return "MSG:" + this.emailMessage;
    }
}
