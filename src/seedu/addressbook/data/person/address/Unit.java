package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the unit number of a Person's address.
 * 
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {
    public static final String EXAMPLE = "#12-393";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Address's unit should be of format #12-34";
    public static final String UNIT_VALIDATION_REGEX = "#\\d+-\\d+";

    private final String value;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        if (!isValidUnit(unit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = unit;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                        && this.value.equals(((Unit) other).value)); // state
                                                                     // check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
