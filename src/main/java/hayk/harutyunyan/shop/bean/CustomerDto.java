package hayk.harutyunyan.shop.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private long id;
    private String fullName;
}
