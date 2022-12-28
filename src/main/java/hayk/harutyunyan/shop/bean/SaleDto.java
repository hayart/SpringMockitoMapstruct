package hayk.harutyunyan.shop.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SaleDto {
    private long id;
    private long bookId;
    private long customerId;
    private long count;
    private Date saleDate;
}
