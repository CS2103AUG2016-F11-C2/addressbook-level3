package seedu.addressbook.data.person;

public interface ReadWritePerson extends ReadOnlyPerson {
    void editPhone(Phone newPhone);
}