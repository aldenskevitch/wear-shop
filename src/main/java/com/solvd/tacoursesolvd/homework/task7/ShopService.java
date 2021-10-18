package com.solvd.tacoursesolvd.homework.task7;

import com.solvd.tacoursesolvd.homework.task7.shop.Sellable;
import com.solvd.tacoursesolvd.homework.task7.shop.Workable;
import com.solvd.tacoursesolvd.homework.task7.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);

}