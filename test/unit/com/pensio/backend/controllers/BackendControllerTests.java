package com.pensio.backend.controllers;

import com.pensio.backend.model.OrderLine;
import com.pensio.backend.model.Product;
import com.pensio.backend.model.ShopOrder;
import com.pensio.backend.repositories.ShopOrderRepository;
import com.pensio.backend.services.InventoryService;
import com.pensio.backend.services.MerchantApiService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BackendControllerTests {

    private static final String ORDER_ID = "Some order id";
    @Mock MerchantApiService merchantApiService;
    @Mock InventoryService inventoryService;
    @Mock private ShopOrderRepository shopOrderRepository;
    @Mock private ShopOrder shopOrder;
    // The object to be tested
    private BackendController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(shopOrderRepository.loadShopOrder(ORDER_ID)).thenReturn(shopOrder);

        controller = new BackendController(shopOrderRepository, merchantApiService, inventoryService);
    }

    @Test
    public void captureReservationGetsTheOrderFromTheRepository() {
        controller.capturePayment(ORDER_ID);

        verify(shopOrderRepository).loadShopOrder(ORDER_ID);
    }

    @Test
    public void captureReservationMustInvokeCaptureOnTheOrder() {
        Mockito.doNothing().when(shopOrder).capture(inventoryService,merchantApiService,shopOrder);
        Mockito.doNothing().when(shopOrderRepository).saveShopOrder(shopOrder);
        controller.capturePayment(ORDER_ID);
        verify(shopOrder).capture(inventoryService, merchantApiService,shopOrder);
        verify(shopOrderRepository).saveShopOrder(shopOrder);
    }
}
