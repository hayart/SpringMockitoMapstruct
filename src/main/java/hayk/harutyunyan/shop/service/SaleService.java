package hayk.harutyunyan.shop.service;

import hayk.harutyunyan.shop.bean.SaleDto;

import java.util.List;

public interface SaleService {

    List<SaleDto> getAll();

    SaleDto getById(Long id);

    SaleDto create(SaleDto request);

    SaleDto update(Long id, SaleDto request);

    SaleDto partialUpdate(Long id, SaleDto request);

    void delete(Long id);
}
