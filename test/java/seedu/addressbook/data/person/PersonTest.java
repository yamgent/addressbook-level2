package seedu.addressbook.data.person;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.UniqueTagList;

public class PersonTest {

    @Test
    public void getSequenceNumber_outcomeInstructions_sameAsWhatInstructionsSaid()
            throws IllegalValueException, PersonNotFoundException {
        
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

        addressBook.removePerson(ben);

        Person daisy = new Person(new Name("Daisy"), new Phone("444", false), new Email("d@d.com", false),
                new Address("Blk D", false), new UniqueTagList());
        addressBook.addPerson(daisy);
        assertEquals(4, daisy.getSequenceNumber());
    }

}
