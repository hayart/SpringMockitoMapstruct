package hayk.harutyunyan.shop.mapper;

import hayk.harutyunyan.shop.bean.SaleDto;
import hayk.harutyunyan.shop.model.Sale;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaleMapper {

    Sale toEntity(SaleDto dto);

    SaleDto toDto(Sale entity);

    List<SaleDto> map(List<Sale> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sale updateEntity(SaleDto dto, @MappingTarget Sale entity);
}
