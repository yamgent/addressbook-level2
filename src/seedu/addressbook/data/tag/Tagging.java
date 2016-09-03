package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * A class that allow us to record whether a tag for a particular person was
 * added or deleted for the current session.
 * 
 * @author Tan Wang Leng
 */
public class Tagging {
    public enum ActionTaken {
        ADD, REMOVE,
    }

    private static final String ACTION_SYMBOL_ADD = "+";
    private static final String ACTION_SYMBOL_REMOVE = "-";

    private final Person person;
    private final Tag tag;
    private final ActionTaken actionTaken;

    public Tagging(Person person, Tag tag, ActionTaken actionTaken) {
        this.person = person;
        this.tag = tag;
        this.actionTaken = actionTaken;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public ActionTaken getActionTaken() {
        return actionTaken;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        switch (actionTaken) {
        case ADD:
            builder.append(ACTION_SYMBOL_ADD);
            break;

        case REMOVE:
            builder.append(ACTION_SYMBOL_REMOVE);
            break;

        default:
            builder.append(actionTaken);
            break;
        }
        builder.append(" ");

        builder.append(person.getName());
        builder.append(" ");

        builder.append(tag);

        return builder.toString();
    }
}
