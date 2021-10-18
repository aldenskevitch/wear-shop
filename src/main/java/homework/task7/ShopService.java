package homework.task7;

import homework.task7.shop.Sellable;
import homework.task7.shop.Workable;
import homework.task7.shop.catalog.TryableOn;

public interface ShopService {

    void startWork(Workable workable);

    void finishWork(Workable workable);

    void goToCashier(Sellable sellable);

    void tryOnWear(TryableOn TryableOn);

    void getConsultation(Consultantable consultantable);

}