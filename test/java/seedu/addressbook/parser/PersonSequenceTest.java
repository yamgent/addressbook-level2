package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;

public class PersonSequenceTest {

    /**
     * Follows everything stated in LO-ClassLevel. (hence the name of the
     * method)
     * 
     * @throws IllegalValueException
     */
    @Test
    public void testLoClassLevel() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();

        Person adam = new Person(new Name("Adam"), new Phone("111", false), new Email("a@a.com", false),
                new Address("Blk A", false), new UniqueTagList());
        addressBook.addPerson(adam);
        assertEquals(1, adam.getSequenceNumber());
        
        Person ben = new Person(new Name("Ben"), new Phone("222", false), new Email("b@b.com", false),
                new Address("Blk B", false), new UniqueTagList());
        addressBook.addPerson(ben);
        assertEquals(2, ben.getSequenceNumber());
                
        Person charlie = new Person(new Name("Charlie"), new Phone("333", false), new Email("c@c.com", false),
                new Address("Blk C", false), new UniqueTagList());
        addressBook.addPerson(charlie);
        assertEquals(3, charlie.getSequenceNumber());
    }

}
