package staj.models;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    private static File currentFile = null;
    private static StringBuilder content = new StringBuilder();
    private static boolean isModified = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Добре дошъл в FileManager. Въведи 'help' за списък с команди.");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            String cmd = tokens[0];

            switch (cmd.toLowerCase()) {
                case "open":
                    if (tokens.length < 2) {
                        System.out.println("Моля, въведи име на файл: open <filename>");
                    } else {
                        openFile(tokens[1]);
                    }
                    break;

                case "close":
                    closeFile();
                    break;

                case "save":
                    saveFile();
                    break;

                case "saveas":
                    if (tokens.length < 2) {
                        System.out.println("Моля, въведи име на файл: saveas <newFilename>");
                    } else {
                        saveAs(tokens[1]);
                    }
                    break;

                case "help":
                    printHelp();
                    break;

                case "exit":
                    if (isModified) {
                        System.out.println("Има незаписани промени. Запази файла преди изход (save/saveas).");
                    } else {
                        System.out.println("Излизане...");
                        scanner.close();
                        return;
                    }
                    break;

                default:
                    System.out.println("Невалидна команда. Въведи 'help' за помощ.");
            }
        }
    }

    private static void openFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            content.setLength(0); // clear content
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            currentFile = new File(filename);
            isModified = false;
            System.out.println("Файлът е отворен успешно.");
            System.out.println("Съдържание:\n" + content);
        } catch (IOException e) {
            System.out.println("Грешка при отваряне на файл: " + e.getMessage());
        }
    }

    private static void closeFile() {
        if (currentFile == null) {
            System.out.println("Няма отворен файл.");
        } else {
            currentFile = null;
            content.setLength(0);
            isModified = false;
            System.out.println("Файлът е затворен.");
        }
    }

    private static void saveFile() {
        if (currentFile == null) {
            System.out.println("Няма отворен файл. Използвай 'saveas' за да запазиш като нов.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
            writer.write(content.toString());
            isModified = false;
            System.out.println("Файлът е записан успешно.");
        } catch (IOException e) {
            System.out.println("Грешка при запис: " + e.getMessage());
        }
    }

    private static void saveAs(String newFilename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFilename))) {
            writer.write(content.toString());
            currentFile = new File(newFilename);
            isModified = false;
            System.out.println("Файлът е записан като: " + newFilename);
        } catch (IOException e) {
            System.out.println("Грешка при запис: " + e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("Достъпни команди:");
        System.out.println(" open <filename>   - Отваря файл");
        System.out.println(" close             - Затваря текущия файл");
        System.out.println(" save              - Записва текущия файл");
        System.out.println(" saveas <filename> - Записва под друго име");
        System.out.println(" help              - Показва това меню");
        System.out.println(" exit              - Изход от програмата");
    }
}