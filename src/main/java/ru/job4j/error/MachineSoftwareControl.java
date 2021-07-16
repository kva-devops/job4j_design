package ru.job4j.error;

public interface MachineSoftwareControl {
    void verticalSaw();
    void horizontalSaw();
    void sideSaw();
    void drillHole();
}

// Станок ЧПУ. Если у нас есть станок, который ипользуется только для
// распила материала и не можеть сверлить, то метод drillHole() придется
// глушить
