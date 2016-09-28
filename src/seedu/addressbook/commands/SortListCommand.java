package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;

import java.util.*;

public class SortListCommand extends Command {
    
    public static final String COMMAND_WORD = "sort";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all persons in the address book sorted by their name.\n\t"
            + "Example: " + COMMAND_WORD;

   
    class NameComparator implements Comparator<ReadOnlyPerson> {
        @Override
        public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2 ) {
            String personName1 = person1.getName().toString();
            String personName2 = person2.getName().toString();
            return personName1.compareToIgnoreCase(personName2);
        }
    }

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        allPersons.sort(new NameComparator());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
