package com.samsungconek.controller;

import com.samsungconek.utils.CustomResponse;
import com.samsungconek.model.entity.Order;
import com.samsungconek.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController extends AbstractController {
    @Autowired
    private IOrderService orderService;

    // as admin . find all orders of every customers
    @GetMapping
    public ResponseEntity<?> findAll() {
//        add principal check for admin role
        return getResponseEntity(orderService.findAll());
    }

    // as admin . find all orders of 1 customers
//    @GetMapping("/customer/{id}")
//    public ResponseEntity<?> findAllOrderByCustomerName(@PathVariable Long id) {
////        add principal to check for admin role
//        Iterable<Order> orders = orderService.findAllByCustomerId(id);
//        ResponseHandler responseHandler = new ResponseHandler("SUCCESS", 200, orders);
//        return new ResponseEntity<>(responseHandler, HttpStatus.OK);
//    }

//    as user . create new order
//    @PostMapping
//    public ResponseEntity<?> createOrder(@ModelAttribute ProductDto productDto) {
////        viết đ.k check xem role đã có chưa để gọi phương thức save
//        Order newOrder = new Order();
////        dùng principal để lấy ra thông tin user
//        newOrder.setCustomerId();
//
//    }

//    as admin. find an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return getResponseEntity(orderService.findById(id));
    }
}
