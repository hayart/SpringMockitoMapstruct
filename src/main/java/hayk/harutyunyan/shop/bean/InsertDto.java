package hayk.harutyunyan.shop.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class InsertDto {
    private long id;
    private long bookId;
    private long count;
    private Date insertDate;
}
