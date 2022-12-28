package hayk.harutyunyan.shop.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private long id;
    private String title;
    private long price;
}
