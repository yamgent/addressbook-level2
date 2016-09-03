package seedu.addressbook.data.person;

/**
 * Represents a contact field for a Person.
 * Guarantees: immutable.
 * 
 * @author Tan Wang Leng
 */
public class Contact {

    private final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.getValue().equals(((Contact) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getValue() {
        return value;
    }
}