package hayk.harutyunyan.shop.mapper;

import hayk.harutyunyan.shop.bean.CustomerDto;
import hayk.harutyunyan.shop.model.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);

    List<CustomerDto> map(List<Customer> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}
