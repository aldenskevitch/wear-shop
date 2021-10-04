package homework.task2.shop.catalog.parameters;

import homework.task2.Buyer;

public class Size {

    private int[] size = new int[3];

    public Size(Buyer buyer) {
        for (int i = 0; i < size.length; i++) {
            if (i == 0) {
                size[i] = buyer.getHeight();
            } else if (i == 1) {
                size[i] = buyer.getChest();
            } else {
                size[i] = buyer.getWaist();
            }
        }
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }
}
