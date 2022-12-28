package hayk.harutyunyan.shop.mapper;

import hayk.harutyunyan.shop.bean.BookDto;
import hayk.harutyunyan.shop.model.Book;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);

    List<BookDto> map(List<Book> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book updateEntity(BookDto dto, @MappingTarget Book entity);
}
