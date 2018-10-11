package com.example.springbootquartz.job;

import com.example.springbootquartz.aop.MethodDesc;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/10/11 10:50
 * description:
 */
@Component
public class TestJob implements Job {


    @Override
    @MethodDesc(desc = "我的测试")
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TestJob.execute");
    }

}
