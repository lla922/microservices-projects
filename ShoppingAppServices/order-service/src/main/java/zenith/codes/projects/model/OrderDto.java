package zenith.codes.projects.model;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderDto(List<OrderItemsDto> orderItemsDto) { //order post ederken yani place ederken sadece order itemlerimin olmasi yeterli
}
