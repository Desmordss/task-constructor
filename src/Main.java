public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Создаем задачи
        System.out.println("Создание и тестирование задач:");
        Task task1 = new Task("Задача 1", "Мы всей семьёй переедем в другой город!");
        manager.createTask(task1);
        Task task2 = new Task("Задача 2", "Сделать план переезда");
        manager.createTask(task2);

        // Создаем эпик с подзадачами
        System.out.println("\nСоздание эпика с подзадачами:");
        Epic epic1 = new Epic("Эпик 1", "Детальный план переезда");
        manager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Подзадача 1", "Собрать коробки", epic1.getId());
        manager.createSubtask(subtask1);
        Subtask subtask2 = new Subtask("Подзадача 2", "Упаковать кошку", epic1.getId());
        manager.createSubtask(subtask2);

        // Создаем эпик с одной подзадачей
        System.out.println("\nСоздание эпика с одной подзадачей:");
        Epic epic2 = new Epic("Эпик 2", "Тут должна была быть задача переезда!");
        manager.createEpic(epic2);
        Subtask subtask3 = new Subtask("Подзадача 3", "Сказать слова прощания", epic2.getId());
        manager.createSubtask(subtask3);

        // Печатаем списки задач
        System.out.println("\nСписок всех задач:");
        System.out.println("Задачи: " + manager.getAllTasks());
        System.out.println("Эпики: " + manager.getAllEpics());
        System.out.println("Подзадачи: " + manager.getAllSubtasks());

        // Обновляем статусы
        System.out.println("\nОбновление статусов:");
        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateSubtask(subtask1);
        manager.updateSubtask(subtask2);

        System.out.println("Статус эпика 1: " + epic1.getStatus());

        // Удаляем задачу и эпик
        System.out.println("\nУдаление задачи и эпика:");
        manager.deleteTaskById(task1.getId());
        manager.updateTask(task1);

        manager.deleteEpicById(epic2.getId());
        manager.updateEpic(epic2);

        System.out.println("\nИтоговый список задач:");
        System.out.println("Задачи: " + manager.getAllTasks());
        System.out.println("Эпики: " + manager.getAllEpics());
        System.out.println("Подзадачи: " + manager.getAllSubtasks());
        // Всё готово к переезду! =)
    }
}