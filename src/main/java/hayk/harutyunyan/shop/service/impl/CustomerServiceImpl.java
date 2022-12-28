package hayk.harutyunyan.shop.service.impl;

import hayk.harutyunyan.shop.bean.CustomerDto;
import hayk.harutyunyan.shop.mapper.CustomerMapper;
import hayk.harutyunyan.shop.model.Customer;
import hayk.harutyunyan.shop.repository.CustomerRepository;
import hayk.harutyunyan.shop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return customerMapper.map(customerRepository.findAll());
    }

    @Override
    public CustomerDto getById(Long id) {
        return customerMapper.toDto(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDto create(CustomerDto dto) {
        customerRepository.save(customerMapper.toEntity(dto));
        return dto;
    }

    @Override
    public CustomerDto update(Long id, CustomerDto dto) {
       Customer entity = customerRepository.findById(id).get();
       customerMapper.updateEntity(dto, entity);
       customerRepository.save(entity);
       return customerMapper.toDto(entity);
    }

    @Override
    public CustomerDto partialUpdate(Long id, CustomerDto dto) {
        Customer entity = customerRepository.findById(id).get();
        customerMapper.updateEntity(dto, entity);
        customerRepository.save(entity);
        return customerMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        Customer entity = customerRepository.findById(id).get();
        customerRepository.delete(entity);
    }
}
