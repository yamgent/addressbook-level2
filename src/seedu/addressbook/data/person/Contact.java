package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a contact field for a Person. Guarantees: immutable; is valid as
 * declared in {@link #isValid(String)}
 * 
 * @author Tan Wang Leng
 */
public class Contact {

    private final String value;
    private boolean isPrivate;

    /**
     * Constructor for Contact class, with validation checking.
     * 
     * @param value of the contact
     * @param isPrivate contact
     * @param constraintsMessage to show when validation fails
     * @throws IllegalValueException if validation fails
     */
    public Contact(String value, boolean isPrivate, final String constraintsMessage)
            throws IllegalValueException {
        this.value = value;
        this.isPrivate = isPrivate;

        if (!isValid(value)) {
            throw new IllegalValueException(constraintsMessage);
        }
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                        && this.getValue().equals(((Contact) other).getValue())); // state
                                                                                  // check
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
     * By default: we assume anything is valid, so if subclasses have any
     * requirements they MUST override this class.
     * 
     * @param test string for validation
     * @return validity
     */
    public boolean isValid(String test) {
        return true;
    }
}