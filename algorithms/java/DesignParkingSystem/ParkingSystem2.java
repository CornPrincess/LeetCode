package DesignParkingSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoutianbin
 * @date 2021/3/19 10:48 AM
 */
public class ParkingSystem2 {
    // HashMap
    Map<Integer, Integer> map = new HashMap<>();

    public ParkingSystem2(int big, int medium, int small) {
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        int cnt = map.get(carType);
        if (cnt == 0) {
            return false;
        } else {
            cnt--;
            map.put(carType, cnt);
            return true;
        }
    }

    public boolean addCar0(int carType) {
        if (map.get(carType) > 0) {
            map.put(carType, map.get(carType) -1);
            return true;
        }
        return false;
    }
}
