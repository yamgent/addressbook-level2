package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    private static final String JOHN_K_SMITH = "John K Smith";  
    private Name nameJohnKSmith;
    
    @Before
    public void setup() throws IllegalValueException {
        nameJohnKSmith = new Name(JOHN_K_SMITH);
    }

    @Test
    public void isSimilar_nullInput_returnFalse() {
        assertFalse(nameJohnKSmith.isSimilar(null));
    }

    @Test
    public void isSimilar_exactSameName_returnTrue() throws IllegalValueException {
        Name otherName = new Name(JOHN_K_SMITH);        
        assertTrue(nameJohnKSmith.isSimilar(otherName));
    }
}
