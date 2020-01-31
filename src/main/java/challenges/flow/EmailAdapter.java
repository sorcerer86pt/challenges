package challenges.flow;

import flow.ActionException;
import flow.AdapterException;
import flow.IAdapter;

/**
 * Email adapter class that receives Email actions and maps them to Email events.
 */
public class EmailAdapter implements IAdapter<EmailAction> {
    @Override
    public EmailEvent adapt(EmailAction message) throws AdapterException, ActionException {
        String rawEmailMessage = message.execute();
        return new EmailEvent(rawEmailMessage);
    }
}
