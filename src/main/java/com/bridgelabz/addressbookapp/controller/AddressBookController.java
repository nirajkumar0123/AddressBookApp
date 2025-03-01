package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Long, AddressBook> sampleData = new HashMap<>();
    private Long idCounter = 1L; // Simulating auto-increment ID

    // Get all entries
    @GetMapping
    public ResponseEntity<Map<Long, AddressBook>> getAllEntries() {
        return ResponseEntity.ok(sampleData);
    }

    // Get entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getEntryById(@PathVariable Long id) {
        return sampleData.containsKey(id)
                ? ResponseEntity.ok(sampleData.get(id))
                : ResponseEntity.notFound().build();
    }

    // Create new entry
    @PostMapping
    public ResponseEntity<AddressBook> createEntry(@RequestBody AddressBookDTO dto) {
        AddressBook newEntry = new AddressBook();
        newEntry.setId(idCounter++); // Assigning unique ID
        newEntry.setName(dto.getName());
        newEntry.setAddress(dto.getAddress());
        newEntry.setPhoneNumber(dto.getPhoneNumber());

        sampleData.put(newEntry.getId(), newEntry);
        return ResponseEntity.ok(newEntry);
    }

    // Update entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        if (sampleData.containsKey(id)) {
            AddressBook updatedEntry = sampleData.get(id);
            updatedEntry.setName(dto.getName());
            updatedEntry.setAddress(dto.getAddress());
            updatedEntry.setPhoneNumber(dto.getPhoneNumber());

            return ResponseEntity.ok(updatedEntry);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        return sampleData.remove(id) != null
                ? ResponseEntity.ok("Entry deleted successfully!")
                : ResponseEntity.notFound().build();
    }
}
