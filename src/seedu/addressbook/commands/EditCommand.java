package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

/**
 * Adds a person to the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Edits a person's phone number (by index) in the address book. "
            + "\n\t"
            + "Parameters: INDEX p/NEW_NUMBER\n\t"
            + "Example: " + COMMAND_WORD
            + " 1 p/999";

    public static final String MESSAGE_SUCCESS = "%1$s edited.";
    
    private final Phone newPhone;

    /**
     * Convenience constructor using raw values.
     * @throws IllegalValueException 
     */
    public EditCommand(int targetVisibleIndex, String newPhone, boolean isPhonePrivate) throws IllegalValueException {
    	super(targetVisibleIndex);
    	this.newPhone = new Phone(newPhone, isPhonePrivate);
    }
    
    @Override
    public CommandResult execute() {
        try {
            final Person target = getEditablePerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            target.editPhone(newPhone);
            return new CommandResult(String.format(MESSAGE_SUCCESS, target.getName()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }
}