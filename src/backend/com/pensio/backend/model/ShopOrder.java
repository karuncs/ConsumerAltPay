package com.pensio.backend.model;

import com.pensio.backend.exceptions.MerchantApiServiceException;
import com.pensio.backend.services.InventoryService;
import com.pensio.backend.services.MerchantApiService;

import java.util.List;


public class ShopOrder {
    String id;
    String paymentId;
    List<OrderLine> orderLines;

    public String getId() {
        return id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void capture(final InventoryService inventoryService, final MerchantApiService merchantApiService, final ShopOrder shopOrder) {
        final List<OrderLine> orderLines = shopOrder.getOrderLines();
        for (OrderLine orderLine : orderLines) {
            inventoryService.checkInventory(orderLine.getProduct(), orderLine.getQuantity());
            try {
                merchantApiService.capturePayment(shopOrder);
                /*if(captureResponse!=null && captureResponse.wasSuccessful()){
                    inventoryService.takeFromInventory(product,quantity);
				}*/
                inventoryService.takeFromInventory(orderLine.getProduct(), orderLine.getQuantity());
            } catch (MerchantApiServiceException e) {
                e.printStackTrace();
            }
        }


        // TODO: use the InventoryService to check inventory before capturing
        // TODO: Use the MerchantApiService to capture the payment.
        // TODO: use the InventoryService to take from inventory after capturing
    }

    // Release is a synonym for canceling a payment
    public void release(MerchantApiService merchantApiService, ShopOrder shopOrder) {
        // TODO: Use the MerchantApiService to release the payment.
        try {
            merchantApiService.releasePayment(shopOrder);
        } catch (MerchantApiServiceException e) {
            e.printStackTrace();
        }

    }
}
