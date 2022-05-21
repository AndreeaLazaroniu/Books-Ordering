package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
import org.loose.fis.sre.model.Book;
//import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.model.Order;
import javafx.collections.ObservableList;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OrderService {

    private static ObjectRepository<Order> orderRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders-BookShop.db").toFile())
                .openOrCreate("test_order", "test_order");

        orderRepository = database.getRepository(Order.class);
    }

    public static void addOrder(String customerName, Book[] books, String status, String total, String time) {
        orderRepository.insert(new Order(customerName, books, status, total, time));
    }

    //@NotNull
    public static ObservableList<Order> getOrders() {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        for (Order order : orderRepository.find()) {
            orders.add(new Order(order.getCustomerName(), order.getBooks(), order.getStatus(), order.getTotal(), order.getTime()));
        }
        return orders;
    }

    public static void editStatus(String customerName, String status) {
        for (Order order : orderRepository.find()) {
            if (Objects.equals(customerName, order.getCustomerName()))
                order.setStatus(status);
                orderRepository.update(order);
        }
    }

}
