package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

public class StorageStub extends Storage {

	public StorageStub() throws InvalidStorageFilePathException {
		super();
	}
	
	public StorageStub(String filePath) throws InvalidStorageFilePathException {
		super(filePath);
	}
	
	@Override
	public void save(AddressBook addressBook) throws StorageOperationException {
		
	}
	
}
