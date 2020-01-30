package challenges.flow;

import com.google.common.base.Strings;
import flow.ActionException;
import flow.IAction;

public class EmailAction implements IAction<String> {

    private String message;

    public EmailAction(String message) {
        this.message = message;
    }

    @Override
    public String execute() throws ActionException {
        if (Strings.isNullOrEmpty(message)) {
            throw new ActionException();
        }
        return this.message;
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
