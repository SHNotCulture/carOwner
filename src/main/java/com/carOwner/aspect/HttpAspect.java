package com.carOwner.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class HttpAspect {
    private  static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    private String logMsg;
    @Pointcut("execution(public * com.carOwner.controller.*.*(..))")
    private  void mainAction(){
    }
    @Before("mainAction()")
    public void dobefore(JoinPoint joinPoint)throws ClassNotFoundException {
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
    }

    @After("mainAction()")
    public void doAfter(JoinPoint joinPoint) throws ClassNotFoundException {
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        //String method=request.getMethod().toString();
        String ip=request.getRemoteAddr().toString();
        String class_method=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName().toString();
        String args=joinPoint.getArgs().toString();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        //url
        logger.info("url={}",url);
        //method

        //logger.info("method={}",method);
        //ip
        logger.info("ip={}",ip);
        //类方法
        logger.info("class_method={}",class_method);
        //参数
        logger.info("args={}",args);

        logger.info("访问结束");
    }

    @AfterReturning(returning = "object",pointcut = "mainAction()")
    public void doAfterReturn(Object object){
        //返回数据
        logger.info("response={}",object.toString());
    }
}
