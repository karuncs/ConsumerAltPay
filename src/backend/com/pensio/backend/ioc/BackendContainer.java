package com.pensio.backend.ioc;

import com.google.inject.Inject;
import com.pensio.backend.controllers.BackendController;
import com.pensio.backend.model.IModelFactory;
import com.pensio.backend.model.Inventory;
import com.pensio.backend.model.OrderLine;
import com.pensio.backend.model.Product;
import com.pensio.backend.model.ShopOrder;
import com.pensio.backend.repositories.ShopOrderRepository;
import com.pensio.backend.services.InventoryService;
import com.pensio.backend.services.MerchantApiService;

public class BackendContainer implements IModelFactory {
	private static ShopOrderRepository shopOrderRepository = null;
	private final MerchantApiService merchantApiService;
	private final InventoryService inventoryService;

	@Inject
	public BackendContainer(MerchantApiService merchantApiService, InventoryService inventoryService) {
		this.merchantApiService = merchantApiService;
		this.inventoryService = inventoryService;
	}

	public BackendController getBackendController()
	{
		return new BackendController(getShopOrderRepository(), merchantApiService, inventoryService);
	}

	// TODO: should be a singleton
	public synchronized ShopOrderRepository getShopOrderRepository()
	{
		if(shopOrderRepository==null){
			shopOrderRepository = new ShopOrderRepository(this);
			return shopOrderRepository;
		}
		else return shopOrderRepository;

	}
	
	@Override
	public ShopOrder getShopOrder() 
	{
		// TODO: initialize a new ShopOrder with it's dependencies
		return new ShopOrder();
	}

	@Override
	public Inventory getInventory() 
	{
		// TODO: initialize a new Inventory with it's dependencies
		return new Inventory();
	}

	@Override
	public OrderLine getOrderLine() 
	{
		// TODO: initialize a new OrderLine with it's dependencies
		return new OrderLine();
	}

	@Override
	public Product getProduct() 
	{
		// TODO: initialize a new Product with it's dependencies
		return new Product();
	}

}
