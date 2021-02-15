package com.chj.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ：chj
 * @date ：Created in 2021/2/15 16:38
 * @params : Aspect 切面
 */
@Aspect
@Component
public class LogAspect {

    /**
     *  slf4j日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    /**
     * Pointcut 切入点
     * 匹配com.chj包下面所有的方法
     */
    @Pointcut("execution(public * com.chj.*.*(..))")
    public void webLog(){}

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around(value = "webLog()")
    public Object arround(ProceedingJoinPoint pjp){
        try {
            logger.info("1.Around:方法环绕开始......");
            Object o = pjp.proceed();
            logger.info("3.Around:方法环绕结束，结果是："+o);
            return o;
        }catch (Throwable e){
            logger.error(pjp.getSignature()+"出现异常："+e);
            return "异常";
        }
    }

    /**
     * 方法执行前
     * @param joinPoint
     */
    @Before(value = "webLog()")
    public void before(JoinPoint joinPoint){
        logger.info("2.Before:方法执行开始");
        //接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert  attributes != null;
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        logger.info("URL(路径)："+request.getRequestURL().toString());
        logger.info("HTTP_METHOD(请求头):"+request.getMethod());
        logger.info("IP(ip)："+request.getRemoteAddr());
        logger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ARGE(参数)："+ Arrays.toString(joinPoint.getArgs()));
    }


    /**
     * 方法执行结束，不管是抛出或者正常退出都会执行
     * @param joinPoint
     */
    @After(value = "webLog()")
    public void after(JoinPoint joinPoint){
        logger.info("4.After:方法最后执行....");
    }

    /**
     * 方法执行结束，增强处理
     * @param ret
     */
    @AfterReturning(returning = "ret" ,pointcut = "webLog()")
    public void doAfterReturnning(Object ret){
        //处理完请求，返回内容
        logger.info("5.AfterReturning:方法的返回值："+ret);
    }

    /**
     * 后置异常通知
     * @param joinPoint
     */
    @AfterThrowing(value = "webLog()")
    public void throwss(JoinPoint joinPoint){
        logger.info("AfterThrowing:方法异常时执行.....");
    }
}































