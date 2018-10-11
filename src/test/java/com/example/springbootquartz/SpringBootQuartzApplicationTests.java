package com.example.springbootquartz;

import com.example.springbootquartz.entity.TaskInfo;
import com.example.springbootquartz.job.TestJob;
import com.example.springbootquartz.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootQuartzApplicationTests {
    @Autowired
    private TaskService taskService;
    @Test
    public void contextLoads() {

        TaskInfo infoTestJob = new TaskInfo();
        infoTestJob.setJobName(TestJob.class.getCanonicalName());
        infoTestJob.setJobGroup("group1");
        infoTestJob.setJobDescription("预警文章定时器");
        infoTestJob.setCronExpression("0/10 * * * * ?"); //执行时间 10秒钟
        taskService.addJob(infoTestJob);
    }

}
