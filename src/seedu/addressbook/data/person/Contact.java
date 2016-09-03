package seedu.addressbook.data.person;

/**
 * Represents a contact field for a Person.
 * Guarantees: immutable; is valid as declared in {@link #isValid(String)}
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
    
    /**
     * Is the value given a valid one?
     * 
     * By default: we assume anything is valid,
     * so if subclasses have any requirements they
     * MUST override this class.
     * 
     * @param test string for validation
     * @return validity
     */
    public boolean isValid(String test) {
        return true;
    }
}