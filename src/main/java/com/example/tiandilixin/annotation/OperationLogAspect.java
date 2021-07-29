package com.example.tiandilixin.annotation;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Aspect
@Component
public class OperationLogAspect {

    /**
     * OperationLog为切入点
     */
    @Pointcut("@annotation(com.example.tiandilixin.annotation.Log)")
    public void operationLog() {
    }

    /**
     * 处理完请求后执行
     */
    @AfterReturning("operationLog()")
    public void afterReturning(JoinPoint joinPoint) {
        saveOperationLog(joinPoint, null);
    }


    @AfterThrowing(value = "operationLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        saveOperationLog(joinPoint, e);
    }



    @Async
    void saveOperationLog(JoinPoint joinPoint, Exception exception) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Log logAnnotation = method.getAnnotation(Log.class);
            int operationName = 0;
            if (logAnnotation != null) {
                // 注解上的描述
                operationName = logAnnotation.value();
            }
            //获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();

            //获取请求的方法名
            String methodName = method.getName();
            String fullMethodName = className + "." + methodName + "()";
            //请求的参数
            Object[] args = joinPoint.getArgs();
            //将参数所在的数组转换成json
            String params = null;
            try {
                params = JSONObject.toJSONString(args);
            } catch (Exception e) {
            }
            String errorInfo = "";
            if (exception != null) {
                errorInfo = exception.getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
