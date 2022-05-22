package org.loose.fis.sre.model;

import java.util.Objects;

public class OrderBook {
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

        if (!Objects.equals(customerName, order.customerName)) return false;
        if (!Objects.equals(orderedBook, order.orderedBook)) return false;
        if (!Objects.equals(status, order.status)) return false;
        if (!Objects.equals(total, order.total)) return false;
        return Objects.equals(time, order.time);
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