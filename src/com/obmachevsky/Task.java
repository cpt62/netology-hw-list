package com.obmachevsky;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task {
    private List<String> taskList;

    public Task() {
        taskList = new ArrayList<>();
    }

    public void add(String task) {
        taskList.add(task);
    }

    public void showAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Список дел пуст!");
            return;
        }
        System.out.println("Ваш список дел: ");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("%d. %s", i + 1, taskList.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public boolean removeByID(int num) {
        num = num - 1;
        if (num > taskList.size()) {

            return false;
        }
        taskList.remove(num);
        return true;
    }

    public boolean removeByTask(String task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
            return true;
        } else {
            System.out.println("Такого дела не существует");
            return false;
        }
    }

    public boolean removeByPartValue(String part) {
        part = part.toLowerCase();
        Iterator<String> iterator = taskList.iterator();
        boolean wasModified = false;
        while (iterator.hasNext()) {
            String checkString = iterator.next().toLowerCase();
            if (checkString.contains(part)) {
                iterator.remove();
                System.out.println("Удалено из списка дел " + checkString);
                wasModified = true;
            }
        }
        return wasModified;
    }
}
