package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

public interface AddressBookService {
    AddressBook createEntry(AddressBookDTO dto);
    AddressBook getEntryById(Long id);
}


