package hayk.harutyunyan.shop.service;

import hayk.harutyunyan.shop.bean.BookDto;
import hayk.harutyunyan.shop.exeption.ResourceNotFound;

import java.util.List;
import java.util.function.Supplier;

public interface BookService {

    List<BookDto> getAll();

    BookDto getById(Long id);

    BookDto create(BookDto request);

    BookDto update(Long id, BookDto request);

    BookDto partialUpdate(Long id, BookDto request);

    void delete(Long id);

    default Supplier<ResourceNotFound> ResourceNotFound(String message) {
        return () -> new ResourceNotFound(message);
    }
}
