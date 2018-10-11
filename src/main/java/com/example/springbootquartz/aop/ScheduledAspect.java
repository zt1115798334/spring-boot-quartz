package com.example.springbootquartz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/10 16:29
 * description:
 */
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
public class ScheduledAspect {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String methodName;      // 方法名
    private long startTime;         // 开始时间

    /**
     * 切入点
     */
    @Pointcut("execution( * com.example.springbootquartz.job..*.*(..))  && @annotation(methodDesc)")
    public void proxyAspect(MethodDesc methodDesc) {
    }


    @Before("proxyAspect(methodDesc)")
    public void doBefore(JoinPoint joinPoint, MethodDesc methodDesc) {
        methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        log.info("开始执行 " + methodDesc.desc() + "，方法名称为" + methodName);
        startTime = System.currentTimeMillis();
    }

    @After("proxyAspect(methodDesc)")
    public void doAfter(MethodDesc methodDesc) {
        long E_time = System.currentTimeMillis() - startTime;
        log.info("执行 " + methodName + " 耗时为：" + E_time + "ms");
    }

    @AfterThrowing(pointcut = "proxyAspect(methodDesc)", throwing = "ex")
    public void doAfterThrowing(Exception ex, MethodDesc methodDesc) {
        log.error("执行 " + methodName + " 出现异常,异常信息为:" + ex.getMessage());

    }

}
