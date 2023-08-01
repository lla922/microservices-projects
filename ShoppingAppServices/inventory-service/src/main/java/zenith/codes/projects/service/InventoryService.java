package zenith.codes.projects.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zenith.codes.projects.repository.InventoryRepository;

@Service
public record InventoryService(InventoryRepository inventoryRepository) {


    public boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
