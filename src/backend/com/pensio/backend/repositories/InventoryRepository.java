package com.pensio.backend.repositories;

import com.google.inject.Singleton;
import com.pensio.backend.model.IModelFactory;
import com.pensio.backend.model.Inventory;

@Singleton
public class InventoryRepository {

	private IModelFactory modelFactory;
	public Inventory load(String productId)
	{
		// We dont need to implement this, write the rest of the code as if this has been implemented
		
		//return null;
		Inventory inv = modelFactory.getInventory();
		inv.setInventory(Integer.valueOf(productId));
		return inv;
	}

	public void save(Inventory inventory) throws Exception {
		// We dont need to implement this, write the rest of the code as if this
		// has been implemented
	}

	public void update(Inventory inventory) throws Exception {
		// We dont need to implement this, write the rest of the code as if this
		// has been implemented
	}
}
