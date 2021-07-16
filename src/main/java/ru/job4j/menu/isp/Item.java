package ru.job4j.menu.isp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Item implements PrintingItem, ActionItem {
    String name;
    List<Item> child;
    int deepLevel;

    public Item(String name, List<Item> child, int deepLevel) {
        this.name = name;
        this.child = child;
        this.deepLevel = deepLevel;
    }

    @Override
    public void printItem() {
        System.out.println(lineBeforeItem(this) + " " + this.getName());
        if (this.child.size() != 0) {
            for (Item elem : this.child) {
                elem.printItem();
            }
        }
    }

    @Override
    public String lineBeforeItem(Item item) {
        String separatorLiner;
        if (item.deepLevel != 0) {
            separatorLiner = StringUtils.repeat("----", item.deepLevel);
        } else {
            separatorLiner = "-";
        }
        return separatorLiner;
    }

    @Override
    public void actionItem() {

    }

    @Override
    public void userInput() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{"
               + "name='" + name + '\''
               + ", child=" + child
               + '}';
    }

    public static void main(String[] args) {
        Item main = new Item("Menu", new ArrayList<>(
                List.of(new Item("first", new ArrayList<>(
                        List.of(
                                new Item("third", new ArrayList<>(), 2),
                                new Item("fourth", new ArrayList<>(), 2)
                        )
                        ), 1),
                        new Item("second", new ArrayList<>(), 1)
        )), 0);
        main.printItem();
        main.userInput();
        main.actionItem();

    }
}
