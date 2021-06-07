package ru.job4j.serialization;

import org.json.JSONObject;

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

    public int getSerialNum() {
        return serialNum;
    }

    public String getModel() {
        return model;
    }

    public boolean isMilitary() {
        return military;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public DriverOfRobot getDriver() {
        return driver;
    }

    public static void main(String[] args) {
        String[] wList = new String[] {
                "pistol", "rifle", "rocket"};
        DriverOfRobot rDriver = new DriverOfRobot(
                "Alex J Merphy", "sergeant", 2131
        );
        Robot firstRobot = new Robot(
                111111, "Robocop", true, wList, rDriver);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serial", firstRobot.getSerialNum());
        jsonObject.put("model", firstRobot.getModel());
        jsonObject.put("military", firstRobot.isMilitary());
        jsonObject.put("weapons", firstRobot.getWeapons());
        jsonObject.put("driver", firstRobot.getDriver());
        System.out.println(jsonObject);
        System.out.println(new JSONObject(firstRobot));
    }
}
