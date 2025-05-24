import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> toDoList = new ArrayList<>();

        boolean isRunning = true;

        while (isRunning) {
            System.out.print("\nВыберите операцию:\n" +
                    "\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "5. Удалить дело по ключевому слову\n" +
                    "\n" +
                    "Ваш выбор: ");
            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    isRunning = false;

                    break;
                case "1":
                    System.out.print("Введите название задачи: ");
                    String taskToAdd = scanner.nextLine();

                    if (!toDoList.contains(taskToAdd)) {
                        boolean isSuccessful = toDoList.add(taskToAdd);

                        if (isSuccessful) {
                            System.out.println("Добавлено!");
                        }
                    } else {
                        System.out.println("Такая задача уже есть!");
                    }

                    completedList(toDoList);

                    break;
                case "2":
                    completedList(toDoList);

                    break;
                case "3":
                    System.out.print("Введите номер для удаления: ");
                    int numberToDelete =  Integer.parseInt(scanner.nextLine());

                    if (toDoList.size() >= numberToDelete && numberToDelete > 0) {
                        toDoList.remove(numberToDelete - 1);
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Задачи с таким номером не существует!");
                    }

                    completedList(toDoList);

                    break;
                case "4":
                    System.out.print("Введите задачу для удаления: ");
                    String taskToDelete = scanner.nextLine();

                    if (!toDoList.isEmpty()) {
                        Iterator<String> iterator = toDoList.iterator();

                        while (iterator.hasNext()) {
                            String s = iterator.next();

                            if (s.toLowerCase().equals(taskToDelete.toLowerCase())) {
                                iterator.remove();
                                System.out.println("Удалено!");
                            }
                        }
                    } else {
                        System.out.println("Задачи с таким названием не существует!");
                    }

                    completedList(toDoList);

                    break;
                case "5":
                    System.out.print("Введите ключевое слово: ");
                    String keyValue = scanner.nextLine();
                    List<String> listToDelete = new ArrayList<>();

                    if (!toDoList.isEmpty()) {
                        for (String s : toDoList) {
                            if (s.toLowerCase().contains(keyValue.toLowerCase())) {
                                listToDelete.add(s);
                            }
                        }

                        toDoList.removeAll(listToDelete);
                        System.out.println("Все задачи, содержащие слово \"" + keyValue + "\" удалены!");
                    } else {
                        System.out.println("Ни одна задача не содержит ключевое слово!");
                    }

                    completedList(toDoList);

                    break;
                default:
                    System.out.println("Некорректный выбор операции!");

                    break;
            }
        }
        System.out.println("\nПрограмма завершена!");
    }

    public static <T> void output(List<T> list) {
        for (T value : list) {
            int index = list.indexOf(value) + 1;

            System.out.println(index + ". " + value);
        }
    }

    public static <T> void completedList(List<T> list) {
        if (!list.isEmpty()) {
            System.out.println("\nВаш список дел:");
            output(list);
        } else {
            System.out.println("\nСписок пуст!");
        }
    }
}
