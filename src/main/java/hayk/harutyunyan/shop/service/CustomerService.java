package hayk.harutyunyan.shop.service;

import hayk.harutyunyan.shop.bean.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAll();

    CustomerDto getById(Long id);

    CustomerDto create(CustomerDto request);

    CustomerDto update(Long id, CustomerDto request);

    CustomerDto partialUpdate(Long id, CustomerDto request);

    void delete(Long id);
}
