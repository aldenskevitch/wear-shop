package homework.task2and3.shop.catalog.parameters;

import homework.task2and3.Buyer;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Size: " + Arrays.toString(size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size1 = (Size) o;
        return Arrays.equals(size, size1.size);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(size);
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }
}