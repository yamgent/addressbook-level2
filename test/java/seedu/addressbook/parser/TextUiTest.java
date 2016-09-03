package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.ui.TextUi;

public class TextUiTest {

    @Test
    public void textUi_printables_concatenatedCorrectly() throws IllegalValueException {
        final String phoneNumber = "123";
        final String emailAddress = "a@a.com";
        final String physicalAddress = "Blk A";
        final String concatenatedString = "Phone: " + phoneNumber + ", Email: " + emailAddress 
                + ", Address: " + physicalAddress;

        Phone phone = new Phone(phoneNumber, false);
        Email email = new Email(emailAddress, false);
        Address address = new Address(physicalAddress, false);

        assertEquals(concatenatedString, TextUi.getPrintableString(phone, email, address));
    }
}
