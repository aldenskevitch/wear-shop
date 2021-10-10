package homework.task2and3;

import homework.task2and3.shop.Sellable;
import homework.task2and3.shop.Workable;
import homework.task2and3.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);
}