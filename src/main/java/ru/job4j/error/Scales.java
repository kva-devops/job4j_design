package ru.job4j.error;

import java.util.ArrayList;
import java.util.List;

public class Scales {
    List<Double> weightMemoryList;

    public Scales(List<Double> weightMemoryList) {
        this.weightMemoryList = weightMemoryList;
    }

    public double measuredWeight(SomeObject obj) {
        double result = obj.getWeight();
        if (result < 0.001 && result > 100.0) {
            throw new IllegalArgumentException("Too match weight!");
        } else {
            weightMemoryList.add(result);
            return result;
        }
    }

    public static void main(String[] args) {
        SomeObject obj1 = new SomeObject(50.0);
        SomeObject obj2 = new SomeObject(150.0);
        Scales scales1 = new ElectronicScales(new ArrayList<>());
        System.out.println(scales1.measuredWeight(obj1));
        System.out.println(scales1.measuredWeight(obj2));
    }
}

class SomeObject {
    double weight;

    public SomeObject(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class ElectronicScales extends Scales {

    public ElectronicScales(List<Double> weightMemoryList) {
        super(weightMemoryList);
    }

    @Override
    public double measuredWeight(SomeObject obj) {
        double result = obj.getWeight();
        weightMemoryList.add(result);
        return result;
    }
}
// проблема в ослаблении постусловия, а именно в отсутствии проверки на максимально допустимый вес,
// который можно измерить любыми весами (например этого не позволяет прочность стола, на котором
// располагаются весы)