package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.crudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO  extends crudDAO<OrderDTO> {
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
   /* String generateNextOrderId(String orderId) throws SQLException, ClassNotFoundException;

    //exit Orders
    boolean exitOrders(String orderId) throws SQLException, ClassNotFoundException;


    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;*/
}