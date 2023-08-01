package zenith.codes.projects.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zenith.codes.projects.service.InventoryService;

@Tag(name = "Inventory APIs - v1", description = "Inventory APIs")
@RestController
@RequestMapping("/inventory")
public record InventoryController(InventoryService inventoryService) {


    @Operation(
            summary = "This method is used to see whether a product exists in the inventory or not.",
            description = "using the skuCode , verify what is in inventory / stock."
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode){
       return inventoryService.isInStock(skuCode);
    }
}
