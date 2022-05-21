package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Order {
    @Id
    private String customerName;
    private Book[] books;
    private String status;
    private String total;
    private String time;

    public Order(String customerName, Book[] books, String status, String total, String time) {
        this.customerName = customerName;
        this.books = books;
        this.status = status;
        this.total = total;
        this.time = time;
    }

    public Order() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
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

        Order order = (Order) o;

        if (customerName != null ? !customerName.equals(order.customerName) : order.customerName != null) return false;
        if (books != null ? !books.equals(order.books) : order.books != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (total != null ? !total.equals(order.total) : order.total != null) return false;
        return time != null ? time.equals(order.time) : order.time == null;
    }

    @Override
    public int hashCode() {
        int result = customerName != null ? customerName.hashCode() : 0;
        result = 31 * result + (books != null ? books.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
