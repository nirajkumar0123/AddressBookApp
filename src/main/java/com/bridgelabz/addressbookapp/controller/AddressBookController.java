package com.bridgelabz.addressbookapp.controller;

import lombok.extern.slf4j.Slf4j;
import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Create new entry
    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@RequestBody AddressBookDTO dto) {
        log.info("Received request to create new entry: {}", dto);
        AddressBook newEntry = addressBookService.createEntry(dto);
        log.info("Successfully created entry with ID: {}", newEntry.getId());
        return ResponseEntity.ok(newEntry);
    }

    // Get all entries
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        log.info("Fetching all address book entries");
        List<AddressBook> entries = addressBookService.getAllEntries();
        log.info("Total entries found: {}", entries.size());
        return ResponseEntity.ok(entries);
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        log.info("Fetching entry with ID: {}", id);
        AddressBook entry = addressBookService.getEntryById(id);
        if (entry != null) {
            log.info("Entry found: {}", entry);
            return ResponseEntity.ok(entry);
        } else {
            log.warn("Entry with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Update entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        log.info("Received request to update entry with ID: {}", id);
        AddressBook updatedEntry = addressBookService.updateEntry(id, dto);
        if (updatedEntry != null) {
            log.info("Successfully updated entry with ID: {}", id);
            return ResponseEntity.ok(updatedEntry);
        } else {
            log.warn("Entry with ID {} not found for update", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Delete entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        log.info("Received request to delete entry with ID: {}", id);
        boolean isDeleted = addressBookService.deleteEntry(id);
        if (isDeleted) {
            log.info("Entry with ID {} deleted successfully", id);
            return ResponseEntity.ok("Entry deleted successfully!");
        } else {
            log.warn("Entry with ID {} not found for deletion", id);
            return ResponseEntity.notFound().build();
        }
    }
}
