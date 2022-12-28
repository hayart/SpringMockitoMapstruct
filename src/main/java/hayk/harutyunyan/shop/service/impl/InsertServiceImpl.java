package hayk.harutyunyan.shop.service.impl;

import hayk.harutyunyan.shop.bean.InsertDto;
import hayk.harutyunyan.shop.mapper.InsertMapper;
import hayk.harutyunyan.shop.model.Insert;
import hayk.harutyunyan.shop.repository.InsertRepository;
import hayk.harutyunyan.shop.service.InsertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InsertServiceImpl implements InsertService {

    private final InsertRepository insertRepository;

    private final InsertMapper insertMapper;

    @Override
    public List<InsertDto> getAll() {
        return insertMapper.map(insertRepository.findAll());
    }

    @Override
    public InsertDto getById(Long id) {
        return insertMapper.toDto(insertRepository.findById(id).get());
    }

    @Override
    public InsertDto create(InsertDto dto) {
        insertRepository.save(insertMapper.toEntity(dto));
        return dto;
    }

    @Override
    public InsertDto update(Long id, InsertDto dto) {
       Insert entity = insertRepository.findById(id).get();
       insertMapper.updateEntity(dto, entity);
       insertRepository.save(entity);
       return insertMapper.toDto(entity);
    }

    @Override
    public InsertDto partialUpdate(Long id, InsertDto dto) {
        Insert entity = insertRepository.findById(id).get();
        insertMapper.updateEntity(dto, entity);
        insertRepository.save(entity);
        return insertMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        Insert entity = insertRepository.findById(id).get();
        insertRepository.delete(entity);
    }
}
