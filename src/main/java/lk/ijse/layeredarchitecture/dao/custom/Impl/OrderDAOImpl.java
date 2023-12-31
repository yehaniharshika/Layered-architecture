package lk.ijse.layeredarchitecture.dao.custom.Impl;

import lk.ijse.layeredarchitecture.dao.SQLUtil;
import lk.ijse.layeredarchitecture.dao.custom.OrderDAO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.Order;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

 /*   @Override
    public String generateNewId(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }*/


    //exit Orders
    @Override
    public  boolean exit(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?"
                ,orderId);
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);

        boolean isExist = stm.executeQuery().next();
        return isExist;*/
        return resultSet.next();
    }

    @Override
    public String generateNewId(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1))
                : "OID-001";

    }

    @Override
    public Order search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    /*public boolean save(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        *//*Connection connection = DBConnection.getDbConnection().getConnection();
        connection.setAutoCommit(false);
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);
        return stm.executeUpdate() > 0;*//*

        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId, orderDate, customerId);
       *//* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, dto.getOrderId());
        System.out.println("date: "+dto.getOrderDate());
        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
        stm.setString(3, dto.getCustomerId());
        return stm.executeUpdate()>0;*//*
        *//*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm;

        connection.setAutoCommit(false);
        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);

        if (stm.executeUpdate() != 1) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
        boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetails(orderId,orderDetails);

        if (!isOrderDetailSaved) {
            connection.rollback();
            connection.setAutoCommit(true);
            return true;
        }

        return false;*//*
    }*/

    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",entity.getOrderId(),entity.getOrderDate(),entity.getCustomerId());
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
