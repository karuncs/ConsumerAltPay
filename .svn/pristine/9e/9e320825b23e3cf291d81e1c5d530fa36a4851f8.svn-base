package com.pensio.backend.controllers;

import com.google.inject.Inject;
import com.pensio.backend.model.ShopOrder;
import com.pensio.backend.repositories.ShopOrderRepository;
import com.pensio.backend.services.InventoryService;
import com.pensio.backend.services.MerchantApiService;

public class BackendController {

    private final ShopOrderRepository shopOrderRepository;
    private final MerchantApiService merchantApiService;
    private final InventoryService inventoryService;

    @Inject
    public BackendController(ShopOrderRepository shopOrderRepository, MerchantApiService merchantApiService, InventoryService inventoryService) {
        this.shopOrderRepository = shopOrderRepository;
        this.merchantApiService = merchantApiService;
        this.inventoryService = inventoryService;
    }

    public void capturePayment(String shopOrderId) {
        ShopOrder order = shopOrderRepository.loadShopOrder(shopOrderId);

        //Check if order is not null
        order.capture(inventoryService, merchantApiService, order);

        shopOrderRepository.saveShopOrder(order);

        // TODO: Save the model after capturing
    }

    public void releasePayment(String shopOrderId) {
        //ShopOrder order = null; // TODO: load the shop order
        ShopOrder order = shopOrderRepository.loadShopOrder(shopOrderId);
        order.release(merchantApiService, order);
        shopOrderRepository.saveShopOrder(order);
        // TODO: Save the model after releasing
    }

}
