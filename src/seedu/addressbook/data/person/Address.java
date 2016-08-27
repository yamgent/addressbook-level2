package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

/**
 * Represents a Person's address in the address book.
 *
 * Guarantees: immutable; is valid as declared in
 * {@link #isValidAddress(String)}
 */
public class Address {

    public static final String ADDRESS_SEPARATOR = ",";
    public static final String ADDRESS_SEPARATOR_WITH_SPACE = ADDRESS_SEPARATOR + " ";
    public static final int ADDRESS_PARTS_BLOCK = 0;
    public static final int ADDRESS_PARTS_STREET = 1;
    public static final int ADDRESS_PARTS_UNIT = 2;
    public static final int ADDRESS_PARTS_POSTAL_CODE = 3;

    public static final String EXAMPLE = getHumanReadableAddress(Block.EXAMPLE, Street.EXAMPLE, Unit.EXAMPLE,
            PostalCode.EXAMPLE);

    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address should consist of 4 parts: BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] parts = splitAddressIntoParts(address);

        this.block = new Block(parts[ADDRESS_PARTS_BLOCK].trim());
        this.street = new Street(parts[ADDRESS_PARTS_STREET].trim());
        this.unit = new Unit(parts[ADDRESS_PARTS_UNIT].trim());
        this.postalCode = new PostalCode(parts[ADDRESS_PARTS_POSTAL_CODE].trim());
    }

    /**
     * Splits an address into its different components that can be accessed with
     * indices using ADDRESS_PARTS_*.
     * 
     * @param fullAddress to derive the parts from.
     * @return an array of Strings, with the block, street, unit and postal
     *         code.
     */
    private String[] splitAddressIntoParts(String fullAddress) {
        return fullAddress.split(ADDRESS_SEPARATOR);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return getHumanReadableAddress(block.toString(), street.toString(), unit.toString(),
                postalCode.toString());
    }

    /**
     * Combines all the components into one string that is
     * readable by human (e.g "123, some street, #45-456, 324234")
     * 
     * @param block number of the address
     * @param street name of the address
     * @param unit number of the address
     * @param postalCode of the address
     * @return a string with all the components combined
     */
    private static String getHumanReadableAddress(String block, String street, String unit,
            String postalCode) {
        return block + ADDRESS_SEPARATOR_WITH_SPACE + street + ADDRESS_SEPARATOR_WITH_SPACE + unit
                + ADDRESS_SEPARATOR_WITH_SPACE + postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.block.equals(((Address) other).block) // state
                                                                      // check
                        && this.street.equals(((Address) other).street)
                        && this.unit.equals(((Address) other).unit)
                        && this.postalCode.equals(((Address) other).postalCode));
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}