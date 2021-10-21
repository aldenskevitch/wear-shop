package com.solvd.tacoursesolvd.wearshopproject;

import com.solvd.tacoursesolvd.wearshopproject.shop.Sellable;
import com.solvd.tacoursesolvd.wearshopproject.shop.Workable;
import com.solvd.tacoursesolvd.wearshopproject.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);

}