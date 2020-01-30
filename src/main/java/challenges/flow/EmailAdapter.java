package challenges.flow;

import flow.ActionException;
import flow.AdapterException;
import flow.IAdapter;

public class EmailAdapter implements IAdapter<EmailAction> {
    @Override
    public EmailEvent adapt(EmailAction message) throws AdapterException, ActionException {
        String rawEmailMessage = message.execute();
        return new EmailEvent(rawEmailMessage);
    }
}
