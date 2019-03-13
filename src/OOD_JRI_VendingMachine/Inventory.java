package OOD_JRI_VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory <T> {
    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity (T item) {
        int value = inventory.getOrDefault(item, 0);
        return value ;
    }

    public void add(T item) {
        int count = getQuantity(item);
        inventory.put(item, count + 1);
    }

    public void deduct (T item) {
        if(hasItem(item)) {
            int count = getQuantity(item);
            inventory.put(item, count - 1);
        }
    }

    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }

    public void clear() {
        inventory.clear();
    }

    public void put(T item, int quantity) {
        inventory.put(item, quantity);
    }
}
