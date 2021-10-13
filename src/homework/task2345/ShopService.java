package homework.task2345;

import homework.task2345.shop.Sellable;
import homework.task2345.shop.Workable;
import homework.task2345.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);

}