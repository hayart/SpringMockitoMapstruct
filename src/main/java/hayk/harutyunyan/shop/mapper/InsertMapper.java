package hayk.harutyunyan.shop.mapper;

import hayk.harutyunyan.shop.bean.InsertDto;
import hayk.harutyunyan.shop.model.Insert;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InsertMapper {

    Insert toEntity(InsertDto dto);

    InsertDto toDto(Insert entity);

    List<InsertDto> map(List<Insert> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Insert updateEntity(InsertDto dto, @MappingTarget Insert entity);
}
