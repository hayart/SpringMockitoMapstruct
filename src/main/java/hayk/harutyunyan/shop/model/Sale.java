package hayk.harutyunyan.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Sale {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookId", nullable = false)
    private long bookId;

    @Column(name = "customerId", nullable = false)
    private long customerId;

    @Column(name = "count", nullable = false)
    private long count;

    @Column(name = "saleDate", nullable = false)
    private Date saleDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sale sale = (Sale) o;
            return bookId == sale.bookId && customerId == sale.customerId && count == sale.count && Objects.equals(id, sale.id) && Objects.equals(saleDate, sale.saleDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, bookId, customerId, count, saleDate);
        }
}
