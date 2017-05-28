package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = (DbDataProvider) new TaskDataProvider();
    private DbDataProvider nameDataProvider = (DbDataProvider) new NameDataProvider();

    DbMock dbMock = new DbMock();
    private class TaskDataProvider implements DbDataProvider<Task> {

        @Override
        public List<Task> refreshAllData(Map criteria) {
            tasks = dbMock.getFakeTasks(criteria);
            return null;
        }

    }
    private class NameDataProvider implements DbDataProvider<String> {

        @Override
        public List<Task> refreshAllData(Map criteria) {
            names = dbMock.getFakeNames(criteria);
            return null;
        }
    }
    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {

        List<Task> refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
}
