package com.example.civic;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
@CrossOrigin
public class ComplaintController {

    private final ComplaintRepository repo;

    public ComplaintController(ComplaintRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Complaint add(@RequestBody Complaint c) {
        return repo.save(c);
    }

    @GetMapping
    public List<Complaint> all() {
        return repo.findAll();
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setStatus(status);
        return repo.save(c);
    }
}
