package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Robot {
    final private int serialNum;
    final private String model;
    final private boolean military;
    final private String[] weapons;
    final private DriverOfRobot driver;

    public Robot(int serialNum, String model,
                 boolean military, String[] weapons,
                 DriverOfRobot driver) {
                    this.serialNum = serialNum;
                    this.model = model;
                    this.military = military;
                    this.weapons = weapons;
                    this.driver = driver;
    }

    @Override
    public String toString() {
        return "Robot{"
                + "serialNum=" + serialNum
                + ", model='" + model + '\''
                + ", military=" + military
                + ", weapons=" + Arrays.toString(weapons)
                + ", driver=" + driver
                + '}';
    }

    public static void main(String[] args) {
        String[] wList = new String[] {
                "pistol", "rifle", "rocket"};
        DriverOfRobot rDriver = new DriverOfRobot(
                "Alex J Merphy", "sergeant", 2131
        );
        Robot firstRobot = new Robot(
                111111, "Robocop", true, wList, rDriver);
        System.out.println("Init object: " + firstRobot);
        final Gson gson = new GsonBuilder().create();
        String objectRobotInJson = gson.toJson(firstRobot);
        System.out.println("Object in JSON format: " + objectRobotInJson);
        Robot recoverFromJson = gson.fromJson(
                objectRobotInJson, Robot.class
        );
        System.out.println("JSON to object recover: " + recoverFromJson);

    }
}
