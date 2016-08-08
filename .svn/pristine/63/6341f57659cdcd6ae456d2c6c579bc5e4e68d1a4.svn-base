package com.pensio.backend.guice.module;

import com.google.inject.AbstractModule;
import com.pensio.backend.controllers.BackendController;
import com.pensio.backend.ioc.BackendContainer;
import com.pensio.backend.model.IModelFactory;
import com.pensio.backend.repositories.InventoryRepository;
import com.pensio.backend.repositories.ShopOrderRepository;
import com.pensio.backend.services.MerchantApiService;
import com.pensio.util.HttpUtil;
import com.pensio.util.XpathUtil;

/**
 * Created by ugi on 3/6/2016.
 */
public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(HttpUtil.class);
        bind(XpathUtil.class);
        bind(BackendController.class);
        bind(MerchantApiService.class);
        bind(InventoryRepository.class);
        bind(ShopOrderRepository.class);
        bind(IModelFactory.class).to(BackendContainer.class);


    }
}
