package zenith.codes.projects.model;

import lombok.Builder;

@Builder
public record OrderItemsDto(String skuCode,Double price,int quantity) {
}
