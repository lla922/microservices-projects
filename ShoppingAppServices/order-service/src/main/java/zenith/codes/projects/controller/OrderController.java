package zenith.codes.projects.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zenith.codes.projects.model.OrderDto;
import zenith.codes.projects.service.OrderService;

@Tag(name = "Order APIs - v1", description = "Order APIs")
@RestController
@RequestMapping("/orders")
public record OrderController(OrderService orderService) {

    @Operation(
            summary = "place an order",
            description = "using orderDto , place a new order and save it to db."
    )
    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return " order is placed .";
    }

    @Operation(
            summary = "get order content by id",
            description = "get the order content from db using id."
    )
    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

}
