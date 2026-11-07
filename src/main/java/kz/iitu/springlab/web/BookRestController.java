
package kz.iitu.springlab.web;

import kz.iitu.springlab.catalog.Book;
import kz.iitu.springlab.catalog.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService service;

    public BookRestController(BookService service) {
        this.service = service;
    }

    // 1. GET - получить список книг
    @GetMapping
    public List<Book> getAll(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer limit
    ) {
        List<Book> books = service.findAll(author);

        if (limit != null && limit >= 0) {
            return books.stream()
                    .limit(limit)
                    .toList();
        }

        return books;
    }

    // 2. GET - получить книгу по ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. POST - добавить новую книгу
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book created = service.create(book);

        return ResponseEntity
                .created(URI.create("/api/books/" + created.id()))
                .body(created);
    }

    // 4. PUT - обновить книгу
    @PutMapping("/{id}")
    public ResponseEntity<Book> replace(
            @PathVariable long id,
            @RequestBody Book book
    ) {
        return service.replace(id, book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. DELETE - удалить книгу
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // Variant 1 - поиск по части названия без учёта регистра
    @GetMapping("/search")
    public List<Book> searchByTitle(@RequestParam String q) {
        String query = q.toLowerCase(Locale.ROOT);

        return service.findAll(null).stream()
                .filter(book -> book.title()
                        .toLowerCase(Locale.ROOT)
                        .contains(query))
                .toList();
    }
}
