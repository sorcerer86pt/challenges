package challenges.flow;

import com.google.common.base.Strings;
import flow.EventException;
import flow.IEvent;

/**
 * Class that specifies an Email Event
 */
public class EmailEvent implements IEvent<String> {

    private String emailMessage;

    public EmailEvent(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    @Override
    public String trigger() throws EventException {
        if (Strings.isNullOrEmpty(this.emailMessage)) {
            throw new EventException();
        }
        return "MSG:" + this.emailMessage;
    }
}
