package com.careerit.sfb.scope;

/*class TaskManager{

    private static TaskManager obj = null;

    private TaskManager(){
    }

    public static TaskManager getInstance(){
        if(obj == null){
            synchronized (TaskManager.class) {
                if (obj == null) {
                    obj = new TaskManager();
                }
            }
        }
        return obj;
    }
}*/
enum TaskManager {
    INSTANCE;
    public void showTasks(){
        System.out.println("Will show list of all active tasks");
    }
}
public class SingletonDesignPattern {

    public static void main(String[] args) {

        TaskManager taskManager1 = TaskManager.INSTANCE;
        TaskManager taskManager2 = TaskManager.INSTANCE;
        TaskManager taskManager3 = TaskManager.INSTANCE;

        taskManager1.showTasks();
        taskManager2.showTasks();
        taskManager3.showTasks();

    }
}
