package tech.majaliwa.content_calendar.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.majaliwa.content_calendar.model.Content;
import tech.majaliwa.content_calendar.repository.ContentCollectionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/content") // path to this controller
@CrossOrigin
public class ContentController {

    private final ContentCollectionRepository repository;

    // if there's only one public constructor, @AutoWired is implicit
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") // handle GET requests
    // make a request and find all the pieces of content in the system
    public List<Content> findAll() {
        return repository.findAll();
    }

    // Create Read Update Delete - filter | paging and sorting etc

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsByID(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}
