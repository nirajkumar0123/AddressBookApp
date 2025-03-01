package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private Long idCounter = 1L; // Simulating auto-increment ID

    @Override
    public AddressBook createEntry(AddressBookDTO dto) {
        AddressBook newEntry = new AddressBook();
        newEntry.setId(idCounter++); // Assigning unique ID
        newEntry.setName(dto.getName());
        newEntry.setAddress(dto.getAddress());
        newEntry.setPhoneNumber(dto.getPhoneNumber());
        return newEntry;
    }

    @Override
    public AddressBook getEntryById(Long id) {
        return null;
    }
}

