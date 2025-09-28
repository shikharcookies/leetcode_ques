import java.util.*;

class TaskManager {

    private static class Task {
        int priority;
        int taskID;

        Task(int priority, int taskID) {
            this.priority = priority;
            this.taskID = taskID;
        }
    }

    private PriorityQueue<Task> maxHeap;
    private Map<Integer,Integer> taskPriorityMap;
    private Map<Integer,Integer> taskOwnerMap;

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>(
            (a,b) -> {
                if(a.priority != b.priority) {
                    return b.priority - a.priority;
                }
                return b.taskID - a.taskID;
            }
        );
        taskPriorityMap = new HashMap<>();
        taskOwnerMap = new HashMap<>();
        for(List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        maxHeap.offer(new Task(priority, taskId));
        taskPriorityMap.put(taskId, priority);
        taskOwnerMap.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        maxHeap.offer(new Task(newPriority, taskId));
        taskPriorityMap.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        taskPriorityMap.put(taskId, -1);
    }
    
    public int execTop() {
        while(!maxHeap.isEmpty()) {
            Task top = maxHeap.poll();
            int currPriority = taskPriorityMap.getOrDefault(top.taskID, -1);

            if(top.priority == currPriority) {
                taskPriorityMap.put(top.taskID, -1);
                return taskOwnerMap.get(top.taskID);
            }
        }
        return -1;
    }
}


/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */