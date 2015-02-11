package com.javarush.test.level23.lesson04.home01;

import com.javarush.test.level22.lesson05.home01.Task;

import java.util.List;
import java.util.Map;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.refresh();
        for (Task task : solution.getTasks())
            System.out.println(task);
        for (String str : solution.getNames())
            System.out.println(str);
    }

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public List<Task> getTasks() {
        return tasks;
    }

    public List<String> getNames() {
        return names;
    }

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    private class TaskDataProvider  implements DbDataProvider<Task>{


        @Override
        public void refreshAllData(Map criteria) {

            List<Task> tempList = DbMock.getFakeTasks(criteria);
            if(tempList!=null){
                Solution.this.tasks.addAll(tempList);
            }
        }
    }

    private class NameDataProvider implements DbDataProvider<String> {


        @Override
        public void refreshAllData(Map criteria) {
            List<String> tempList = DbMock.getFakeNames(criteria);
            if(tempList!=null)
                Solution.this.names.addAll(tempList);
       }
    }



    class Task {
    }
}
