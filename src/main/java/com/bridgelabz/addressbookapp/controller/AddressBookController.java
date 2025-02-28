package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Integer, String> sampleData = new HashMap<>();

    @GetMapping
    public ResponseEntity<Map<Integer, String>> getAllEntries() {
        return ResponseEntity.ok(sampleData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEntryById(@PathVariable int id) {
        return sampleData.containsKey(id)
                ? ResponseEntity.ok(sampleData.get(id))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> createEntry(@RequestParam int id, @RequestParam String name) {
        sampleData.put(id, name);
        return ResponseEntity.ok("Entry created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestParam String name) {
        if (sampleData.containsKey(id)) {
            sampleData.put(id, name);
            return ResponseEntity.ok("Entry updated successfully!");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        return sampleData.remove(id) != null
                ? ResponseEntity.ok("Entry deleted successfully!")
                : ResponseEntity.notFound().build();
    }
}

