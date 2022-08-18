package com.samsungconek.service.order;

import com.samsungconek.model.entity.Order;
import com.samsungconek.repository.IOrderRepository;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        BusinessAssert.isTrue(orders.size() > 0, BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        BusinessAssert.isTrue(orderOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return orderOptional.get();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        BusinessAssert.isTrue(orderOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        orderRepository.deleteById(id);
    }
}
