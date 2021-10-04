package homework.task2.shop.catalog.parameters;

import homework.task2.Buyer;

public class Size {

    private int[] size = new int[3];

    public Size(Buyer buyer) {
        for (int i = 0; i < size.length; i++) {
            switch (i) {
                case 0:
                    size[i] = buyer.getHeight();
                    break;
                case 1:
                    size[i] = buyer.getChest();
                    break;
                case 2:
                    size[i] = buyer.getWaist();
                    break;
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
