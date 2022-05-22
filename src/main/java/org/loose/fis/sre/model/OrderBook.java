package org.loose.fis.sre.model;

import java.util.Objects;
import org.dizitart.no2.objects.Id;

public class OrderBook {
    @Id
    private String customerName;
    private String orderedBook;
    private String status;
    private String total;
    private String time;

    public OrderBook(String customerName, String orderedBook, String status, String total, String time) {
        this.customerName = customerName;
        this.orderedBook = orderedBook;
        this.status = status;
        this.total = total;
        this.time = time;
    }

    public OrderBook() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderedBook() {
        return orderedBook;
    }

    public void setOrderedBook(String orderedBook) {
        this.orderedBook = orderedBook;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getTotal() { return total; }

    public void setTotal(String total) { this.total = total; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time= time; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderBook order = (OrderBook) o;

        if (customerName != null ? !customerName.equals(order.customerName) : order.customerName != null) return false;
        if (orderedBook != null ? !orderedBook.equals(order.orderedBook) : order.orderedBook != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (total != null ? !total.equals(order.total) : order.total != null) return false;
        return time != null ? time.equals(order.time) : order.time == null;
    }

    @Override
    public int hashCode() {
        int result = customerName != null ? customerName.hashCode() : 0;
        result = 31 * result + (orderedBook != null ? orderedBook.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}