class TaskManager {  
    PriorityQueue<int[]> pq; //maxHeap => [usedId, taskId, priority]
    HashMap<Integer, int[]> map; //hashMap => (key:taskId -> value:[usedId, taskId, priority])
    public TaskManager(List<List<Integer>> tasks) {
        this.pq = new PriorityQueue<>((a, b) -> (a[2] != b[2] ? b[2] - a[2] : b[1] - a[1])); //maxHeap
        this.map = new HashMap<>(); //hashMap
        
        for(List<Integer> curr : tasks) { //storing the tasks information
            int[] info = new int[]{curr.get(0), curr.get(1), curr.get(2)};
            this.map.put(curr.get(1), info);
            this.pq.add(info);
        }
    }
    
    public void add(int userId, int taskId, int priority) { //adding a new task information
        int[] curr = new int[]{userId, taskId, priority};
        pq.add(curr);
        map.put(taskId, curr);
        return;
    }
    
    public void edit(int taskId, int newPriority) { //updating a task information
        int[] curr = map.get(taskId);
        int[] updatedInfo = new int[]{curr[0], taskId, newPriority};
        map.put(taskId, updatedInfo); //lazy updation => task is only updated in the hashMap not in the maxHeap
        pq.add(updatedInfo);
        return;
    }
    
    public void rmv(int taskId) { //removing a task information
        map.remove(taskId); //lazy deletion => task is only deleted from the hashMap not from the maxHeap
        return;
    }
    
    public int execTop() { //executing the task with highest priority
        int res = -1;
        while(!pq.isEmpty()) { //lazy deletion
            int[] curr = pq.remove();
            int userId = curr[0], taskId = curr[1], priority = curr[2];
            if(map.containsKey(taskId)) {
                int info[] = map.get(taskId);
                int originalUserId = info[0], originalPriority = info[2];
                if(userId == originalUserId && priority == originalPriority) {
                    res = userId;
                    map.remove(taskId);
                    break; 
                }
            }
        }
        return res;
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
/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */