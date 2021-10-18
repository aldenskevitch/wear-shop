package com.solvd.tacoursesolvd.homework.task7;

import com.solvd.tacoursesolvd.homework.task7.shop.Sellable;
import com.solvd.tacoursesolvd.homework.task7.shop.Workable;
import com.solvd.tacoursesolvd.homework.task7.shop.catalog.TryableOn;

public class ShopServiceImpl implements ShopService {

    @Override
    public void startWork(Workable workable) {
        workable.startWork();
    }

    @Override
    public void finishWork(Workable workable) {
        workable.finishWork();
    }

    @Override
    public void goToCashier(Sellable sellable) {
        sellable.printCheck();
    }

    @Override
    public void tryOnWear(TryableOn tryableOn) {
        tryableOn.tryOn();
    }

    @Override
    public void getConsultation(Consultantable consultantable) {
        consultantable.advise();
    }
}