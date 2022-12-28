package hayk.harutyunyan.shop.service.impl;

import hayk.harutyunyan.shop.bean.SaleDto;
import hayk.harutyunyan.shop.mapper.SaleMapper;
import hayk.harutyunyan.shop.model.Sale;
import hayk.harutyunyan.shop.repository.SaleRepository;
import hayk.harutyunyan.shop.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper;

    @Override
    public List<SaleDto> getAll() {
        return saleMapper.map(saleRepository.findAll());
    }

    @Override
    public SaleDto getById(Long id) {
        return saleMapper.toDto(saleRepository.findById(id).get());
    }

    @Override
    public SaleDto create(SaleDto dto) {
        saleRepository.save(saleMapper.toEntity(dto));
        return dto;
    }

    @Override
    public SaleDto update(Long id, SaleDto dto) {
       Sale entity = saleRepository.findById(id).get();
       saleMapper.updateEntity(dto, entity);
       saleRepository.save(entity);
       return saleMapper.toDto(entity);
    }

    @Override
    public SaleDto partialUpdate(Long id, SaleDto dto) {
        Sale entity = saleRepository.findById(id).get();
        saleMapper.updateEntity(dto, entity);
        saleRepository.save(entity);
        return saleMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        Sale entity = saleRepository.findById(id).get();
        saleRepository.delete(entity);
    }
}
