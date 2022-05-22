package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.OrderBook;
import javafx.collections.ObservableList;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OrderBookService {

    private static ObjectRepository<OrderBook> orderRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders-BookShop.db").toFile())
                .openOrCreate("test_order", "test_order");

        orderRepository = database.getRepository(OrderBook.class);
    }

    public static void addOrder(String customerName, String orderedBook, String status, String total, String time) {
        orderRepository.insert(new OrderBook(customerName, orderedBook, status, total, time));
    }

    @NotNull
    public static ObservableList<OrderBook> getOrders() {
        ObservableList<OrderBook> orders = FXCollections.observableArrayList();
        for (OrderBook order : orderRepository.find()) {
            orders.add(new OrderBook(order.getCustomerName(), order.getOrderedBook(), order.getStatus(), order.getTotal(), order.getTime()));
        }
        return orders;
    }

    @NotNull
    public static ObservableList<OrderBook> getOrdersCustomer(String username) {
        ObservableList<OrderBook> orders = FXCollections.observableArrayList();
        for (OrderBook order : orderRepository.find()) {
            if (Objects.equals(username, order.getCustomerName())) {
                orders.add(new OrderBook(order.getCustomerName(), order.getOrderedBook(), order.getStatus(), order.getTotal(), order.getTime()));
            }
        }
        return orders;
    }

    public static void editStatus(String customerName, String status, String time) {
        for (OrderBook order : orderRepository.find()) {
            if (Objects.equals(customerName, order.getCustomerName())) {
                order.setStatus(status);
                order.setTime(time);
                orderRepository.update(order);
            }
        }
    }

    public static void deleteOrder(String customerName) {
        for (OrderBook order : orderRepository.find()) {
            if (Objects.equals(customerName, order.getCustomerName())) {
                orderRepository.remove(order);
            }
            else {
                System.out.println("Couldn't find any order by " + customerName);
            }
        }
    }

}
