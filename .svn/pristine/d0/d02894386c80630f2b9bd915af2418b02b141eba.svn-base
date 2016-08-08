package com.pensio.backend.model;

import com.pensio.backend.exceptions.MerchantApiServiceException;
import com.pensio.backend.repositories.InventoryRepository;
import com.pensio.backend.repositories.ShopOrderRepository;
import com.pensio.backend.services.CaptureResponse;
import com.pensio.backend.services.InventoryService;
import com.pensio.backend.services.MerchantApiService;
import com.pensio.backend.services.ReleaseResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopOrderTest {

    private static final String ID = "orderid";
    private static final String PAYMENTID = "paymentid";
    final ArrayList<OrderLine> orderLines = new ArrayList<>();
    @Mock MerchantApiService merchantApiService;
    @Mock InventoryService inventoryService;
    private ShopOrder order;
    @Mock private ShopOrderRepository shopOrderRepository;
    @Mock private InventoryRepository inventoryRepository;
    private Product product;
    private Inventory inventory;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        product.setId("productId");
        product.setName("product name");
        inventory = new Inventory();
        inventory.setInventory(1);
        inventory.setProduct(product);
        order = new ShopOrder();
        order.setId(ID);
        order.setPaymentId(PAYMENTID);

        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantity(1);

        orderLines.add(orderLine);
        order.setOrderLines(orderLines);
    }

    @Test
    public void executeCapture_inventoryIsChecked() {
        // TODO: Implement test


        when(inventoryRepository.load(product.getId())).thenReturn(inventory);

        when(inventoryService.checkInventory(product, 1)).thenReturn(Boolean.TRUE);

        inventoryService.checkInventory(product, 1);

        verify(inventoryService).checkInventory(product, 1);
    }

    @Test
    public void executeCapture_paymentIsCapturedThroughApiService() throws MerchantApiServiceException {

        when(inventoryRepository.load(product.getId())).thenReturn(inventory);

        when(inventoryService.checkInventory(product, 1)).thenReturn(Boolean.FALSE);

        when(merchantApiService.capturePayment(order)).thenReturn(new CaptureResponse(Boolean.FALSE));


        when(inventoryService.takeFromInventory(product, 1)).thenReturn(Boolean.FALSE);

        order.capture(inventoryService, merchantApiService, order);

        verify(inventoryService).checkInventory(product, 1);

        // TODO: Implement test

    }

    @Test
    public void executeRelease_paymentIsReleasedThroughApiService() throws MerchantApiServiceException {
        // TODO: Implement test
        when(merchantApiService.releasePayment(order)).thenReturn(new ReleaseResponse(Boolean.TRUE));

        order.release(merchantApiService, order);

        verify(merchantApiService).releasePayment(order);
    }

    // TODO: Add more tests you think is relevant
}
