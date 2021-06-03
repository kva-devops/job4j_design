package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> baseAnswerBot = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(baseAnswerBot::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        String buffStr;
        boolean turnOnBot = true;
            try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
                while (scan.hasNextLine()) {
                    buffStr = scan.nextLine();
                    pw.write(buffStr);
                    pw.println();
                    if (buffStr.equals(OUT)) {
                        scan.close();
                        break;
                    }
                    if (buffStr.equals(STOP)) {
                        turnOnBot = false;
                    }
                    if (buffStr.equals(CONTINUE) && !turnOnBot) {
                        turnOnBot = true;
                    }
                    if (turnOnBot) {
                        buffStr = botSays(baseAnswerBot);
                        pw.write(buffStr);
                        pw.println();
                        System.out.println(buffStr);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private String botSays(List<String> data) {
        return data.get((int) (Math.random() * data.size()));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "chatWithBot.log",
                "answersBot.txt");
        cc.run();
    }
}
