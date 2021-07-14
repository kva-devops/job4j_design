package ru.job4j.error;

class Transport {
    double engineVol;

    public Transport(double engineVol) {
        this.engineVol = engineVol;
    }

    public int transportTax(double engineVol) {
        if (engineVol < 1.0) {
            return 1000;
        } else if (engineVol >= 1.0 && engineVol < 2.0) {
            return 3000;
        } else {
            return 5000;
        }
    }

    public static void main(String[] args) {
        Transport auto = new AutoElectron(1.2);
        System.out.println(auto.transportTax(auto.engineVol));
    }
}

class AutoElectron extends Transport {

    public AutoElectron(double engineVol) {
        super(engineVol);
    }

    public int transportTax(double engineVol) {
        if (engineVol < 1.0) {
            return 500;
        } else {
            return 1000;
        }
    }
}

// нарушение состоит в усилении предусловия. В классе Transport есть метод для расчета транспортного
// налога, однако в классе AutoElectron (электроавтомобили) просходит изменение данного метода.
