package com.obmachevsky;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task tasks = new Task();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.println("5. Удалить дела по ключевому слову");
            System.out.print("Ваш выбор: ");

            int operation = 0;
            try {
                operation = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение операции!");
                System.out.println();
                continue;
            }

            System.out.println();
            switch (operation) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.print("Введите название задачи: ");
                    String newTask = scanner.nextLine();
                    if (tasks.add(newTask)) {
                        System.out.println("Добавлено!");
                        tasks.showAllTasks();
                    } else {
                        System.out.println("Данная задача уже присутствует в списке!");
                    }
                }
                case 2 -> tasks.showAllTasks();
                case 3 -> {
                    System.out.print("Введите номер для удаления: ");
                    int id = 0;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Введите корректное значение номера задачи!");
                        System.out.println();
                        continue;
                    }
                    System.out.println();
                    if (tasks.removeByID(id)) {
                        System.out.println("Удалено!");
                        tasks.showAllTasks();
                    } else {
                        System.out.println("Введен неверный номер или ваш список дел пуст!");
                    }
                }
                case 4 -> {
                    System.out.print("Введите задачу для удаления: ");
                    String task = scanner.nextLine();
                    System.out.println();
                    if (tasks.removeByTask(task)) {
                        System.out.println("Удалено!");
                        tasks.showAllTasks();
                    } else {
                        System.out.println("Введен неверная задача или ваш список дел пуст!");
                    }
                }
                case 5 -> {
                    System.out.print("Введите ключевое слово: ");
                    String task = scanner.nextLine();
                    if (tasks.removeByPartValue(task)) {
                        tasks.showAllTasks();
                        System.out.println("Список дел подвергся изменению. Удалены позиции согласно заданного ключевого слова!");
                    } else {
                        System.out.println("Список дел не подвергся изменению. Ключевое слово отсутствует в списке дел!");
                    }
                }
                default -> {
                    System.out.println("Введите корректный номер операции!");
                }
            }
        }
    }
}
