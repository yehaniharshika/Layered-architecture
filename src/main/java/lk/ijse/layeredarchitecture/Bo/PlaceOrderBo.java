package lk.ijse.layeredarchitecture.Bo;

import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.dto.OrderDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo  extends SuperBO{
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    Item findItem(String code);
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;
    String generateNextOrderId(String orderId) throws SQLException, ClassNotFoundException;

    //exit Orders
    //boolean exitOrders(String orderId) throws SQLException, ClassNotFoundException;
    boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;

    List<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

}
