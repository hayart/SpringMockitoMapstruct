package hayk.harutyunyan.shop.service.impl;

import hayk.harutyunyan.shop.bean.BookDto;
import hayk.harutyunyan.shop.exeption.ResourceNotFound;
import hayk.harutyunyan.shop.mapper.BookMapper;
import hayk.harutyunyan.shop.model.Book;
import hayk.harutyunyan.shop.repository.BookRepository;
import hayk.harutyunyan.shop.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        return bookMapper.map(bookRepository.findAll());
    }

    @Override
    public BookDto getById(Long id) {
        Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Book with given Id not found."));
        return bookMapper.toDto(entity);
    }

    @Override
    public BookDto create(BookDto dto) {
        bookRepository.save(bookMapper.toEntity(dto));
        return dto;
    }

    @Override
    public BookDto update(Long id, BookDto dto) {
       Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Book with given Id not found."));
       bookMapper.updateEntity(dto, entity);
       bookRepository.save(entity);
       return bookMapper.toDto(entity);
    }

    @Override
    public BookDto partialUpdate(Long id, BookDto dto) {
        Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Book with given Id not found."));
        bookMapper.updateEntity(dto, entity);
        bookRepository.save(entity);
        return bookMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Book with given Id not found."));
        bookRepository.delete(entity);
    }
}
