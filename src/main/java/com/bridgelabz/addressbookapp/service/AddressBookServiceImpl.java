package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private List<AddressBook> addressBookList = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public AddressBook createEntry(AddressBookDTO dto) {
        AddressBook newEntry = new AddressBook();
        newEntry.setId(idCounter++);
        newEntry.setName(dto.getName());
        newEntry.setAddress(dto.getAddress());
        newEntry.setPhoneNumber(dto.getPhoneNumber());

        addressBookList.add(newEntry); // Storing in memory
        return newEntry;
    }

    @Override
    public AddressBook getEntryById(Long id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AddressBook> getAllEntries() {
        return addressBookList;
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBookDTO dto) {
        for (AddressBook entry : addressBookList) {
            if (entry.getId().equals(id)) {
                entry.setName(dto.getName());
                entry.setAddress(dto.getAddress());
                entry.setPhoneNumber(dto.getPhoneNumber());
                return entry;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}


