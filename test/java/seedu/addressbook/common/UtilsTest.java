package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull_zeroInput_returnsFalse() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void isAnyNull_SingleNonNullInput_returnsFalse() {
        assertFalse(Utils.isAnyNull("Hi"));
    }
    
    @Test
    public void isAnyNull_nonNullListInput_returnsFalse() {
        assertFalse(Utils.isAnyNull("Hello", "World", "!"));
    }
    
    @Test
    public void isAnyNull_nullInListInput_returnsTrue() {
        assertTrue(Utils.isAnyNull("Hello", null, "!"));
    }

    @Test
    public void elementsAreUnique_nullInput_returnsTrue() {
        assertTrue(Utils.elementsAreUnique(null));
    }

    @Test
    public void elementsAreUnique_emptyInput_returnsTrue() {
        List<String> input = new ArrayList<String>();
        assertTrue(Utils.elementsAreUnique(input));
    }
    
    @Test
    public void elementsAreUnique_uniqueInput_returnsTrue() {
        List<String> inputs = new ArrayList<String>();
        inputs.add("hello");
        inputs.add("world");
        
        assertTrue(Utils.elementsAreUnique(inputs));
    }
    
    @Test
    public void elementsAreUnique_duplicateInput_returnsFalse() {
        List<String> inputs = new ArrayList<String>();
        inputs.add("the");
        inputs.add("man");
        inputs.add("stole");
        inputs.add("the");
        inputs.add("bread");
        
        assertFalse(Utils.elementsAreUnique(inputs));
    }
}
