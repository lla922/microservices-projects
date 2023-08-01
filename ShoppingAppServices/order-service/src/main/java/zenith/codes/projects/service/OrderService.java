package zenith.codes.projects.service;

import org.springframework.stereotype.Service;
import zenith.codes.projects.model.Order;
import zenith.codes.projects.model.OrderDto;
import zenith.codes.projects.model.OrderItems;
import zenith.codes.projects.model.OrderItemsDto;
import zenith.codes.projects.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public record OrderService(OrderRepository orderRepository) {

    public void placeOrder(OrderDto orderDto){ //dto yu alip orjinal bir ordera cevir
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItemsList = orderDto.orderItemsDto().stream()
                .map(orderItemsDto -> toOrderItems(orderItemsDto))
                .collect(Collectors.toList());

        order.setOrderItemsList(orderItemsList);
        orderRepository.save(order);
    }

    public OrderDto getOrder(int id){
        Optional<Order> order = orderRepository.findById(id);

        List<OrderItemsDto> orderItemsDtos = order.get().getOrderItemsList().stream()
                .map(orderItems -> toOrderItemsDto(orderItems))
                .collect(Collectors.toList());

        OrderDto orderDto = OrderDto.builder()
                .orderItemsDto(orderItemsDtos)
                .build();

        return orderDto;
    }


    private OrderItems toOrderItems(OrderItemsDto orderItemsDto) {

        OrderItems orderItems = OrderItems.builder()
                .price(orderItemsDto.price())
                .skuCode(orderItemsDto.skuCode())
                .quantity(orderItemsDto.quantity())
                .build();
        return orderItems;
    }

    private OrderItemsDto toOrderItemsDto(OrderItems orderItems){
        OrderItemsDto orderItemsDto = OrderItemsDto.builder()
                .skuCode(orderItems.getSkuCode())
                .price(orderItems.getPrice())
                .quantity(orderItems.getQuantity())
                .build();
        return orderItemsDto;
    }
}
