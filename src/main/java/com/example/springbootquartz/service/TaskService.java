package com.example.springbootquartz.service;

import com.example.springbootquartz.entity.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/10/10 15:54
 * description:
 */
public interface TaskService {
    List<TaskInfo> list();

    void addJob(TaskInfo info);

    void edit(TaskInfo info);

    void delete(String jobName, String jobGroup);

    void pause(String jobName, String jobGroup);

    void resume(String jobName, String jobGroup);

    boolean checkExists(String jobName, String jobGroup)throws SchedulerException;
}
