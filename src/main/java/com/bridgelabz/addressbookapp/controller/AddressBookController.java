package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Create new entry
    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@RequestBody AddressBookDTO dto) {
        AddressBook newEntry = addressBookService.createEntry(dto);
        return ResponseEntity.ok(newEntry);
    }

    // Get all entries
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        AddressBook entry = addressBookService.getEntryById(id);
        return entry != null ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    // Update entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        AddressBook updatedEntry = addressBookService.updateEntry(id, dto);
        return updatedEntry != null ? ResponseEntity.ok(updatedEntry) : ResponseEntity.notFound().build();
    }

    // Delete entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        return addressBookService.deleteEntry(id)
                ? ResponseEntity.ok("Entry deleted successfully!")
                : ResponseEntity.notFound().build();
    }
}
