package com.pensio.backend.services;

import com.google.inject.Inject;
import com.pensio.backend.model.Inventory;
import com.pensio.backend.model.Product;
import com.pensio.backend.repositories.InventoryRepository;

public class InventoryService {
    private InventoryRepository repository;

    @Inject
    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public boolean checkInventory(Product product, int quantity) {
        // TODO: implement check inventory, as you see fit
        Inventory inventory = repository.load(product.getId());
        return doInventory(product, quantity, inventory);
    }

    public boolean takeFromInventory(Product product, int quantity) {
        // TODO: implement take from inventory, as you see fit
        Inventory inventory = repository.load(product.getId());
        return doInventory(product, quantity, inventory);
    }

    private boolean doInventory(Product product, int quantity, Inventory inventory) {
        if (inventory != null) {
            inventory.setInventory(quantity);
            try {
                repository.update(inventory);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            Inventory created = new Inventory();
            created.setProduct(product);
            created.setInventory(quantity);
            try {
                repository.save(created);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
