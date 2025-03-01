package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

import java.util.List;

public interface AddressBookService {
    AddressBook createEntry(AddressBookDTO dto);
    AddressBook getEntryById(Long id);
    List<AddressBook> getAllEntries();
    AddressBook updateEntry(Long id, AddressBookDTO dto);
    boolean deleteEntry(Long id);
}


