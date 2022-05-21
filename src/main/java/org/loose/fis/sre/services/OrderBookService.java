package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
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

}
