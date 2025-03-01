package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookServiceImpl implements AddressBookService {

    private List<AddressBook> addressBookList = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public AddressBook createEntry(AddressBookDTO dto) {
        log.info("Creating new address book entry: {}", dto);
        AddressBook newEntry = new AddressBook();
        newEntry.setId(idCounter++);
        newEntry.setName(dto.getName());
        newEntry.setAddress(dto.getAddress());
        newEntry.setPhoneNumber(dto.getPhoneNumber());

        addressBookList.add(newEntry);
        log.info("Entry created successfully with ID: {}", newEntry.getId());
        return newEntry;
    }

    @Override
    public AddressBook getEntryById(Long id) {
        log.info("Searching for entry with ID: {}", id);
        AddressBook entry = addressBookList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (entry != null) {
            log.info("Entry found: {}", entry);
        } else {
            log.warn("Entry with ID {} not found", id);
        }
        return entry;
    }

    @Override
    public List<AddressBook> getAllEntries() {
        log.info("Fetching all address book entries");
        log.info("Total entries found: {}", addressBookList.size());
        return addressBookList;
    }

    @Override
    public AddressBook updateEntry(Long id, AddressBookDTO dto) {
        log.info("Updating entry with ID: {}", id);
        for (AddressBook entry : addressBookList) {
            if (entry.getId().equals(id)) {
                entry.setName(dto.getName());
                entry.setAddress(dto.getAddress());
                entry.setPhoneNumber(dto.getPhoneNumber());
                log.info("Entry with ID {} updated successfully", id);
                return entry;
            }
        }
        log.warn("Entry with ID {} not found for update", id);
        return null;
    }

    @Override
    public boolean deleteEntry(Long id) {
        log.info("Deleting entry with ID: {}", id);
        boolean isDeleted = addressBookList.removeIf(entry -> entry.getId().equals(id));
        if (isDeleted) {
            log.info("Entry with ID {} deleted successfully", id);
        } else {
            log.warn("Entry with ID {} not found for deletion", id);
        }
        return isDeleted;
    }
}
