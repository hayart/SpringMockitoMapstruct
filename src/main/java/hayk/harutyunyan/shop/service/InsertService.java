package hayk.harutyunyan.shop.service;

import hayk.harutyunyan.shop.bean.InsertDto;

import java.util.List;

public interface InsertService {

    List<InsertDto> getAll();

    InsertDto getById(Long id);

    InsertDto create(InsertDto request);

    InsertDto update(Long id, InsertDto request);

    InsertDto partialUpdate(Long id, InsertDto request);

    void delete(Long id);
}
