package com.solvd.wearshopproject;

import com.solvd.wearshopproject.shop.Sellable;
import com.solvd.wearshopproject.shop.Workable;
import com.solvd.wearshopproject.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);

}