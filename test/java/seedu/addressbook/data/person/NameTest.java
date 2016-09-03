package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name johnKSmith;
    
    @Before
    public void setup() throws IllegalValueException {
        johnKSmith = new Name("John K Smith");
    }

    @Test
    public void isSimilar_nullInput_returnFalse() {
        assertFalse(johnKSmith.isSimilar(null));
    }

}
