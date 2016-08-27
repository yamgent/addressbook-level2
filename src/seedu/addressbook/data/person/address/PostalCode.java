package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the postal code of a Person's address.
 * 
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {
    public static final String EXAMPLE = "451234";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Address's postal code should only contain numbers";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "\\d+";

    private final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                        && this.value.equals(((PostalCode) other).value)); // state
                                                                           // check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }    
}
