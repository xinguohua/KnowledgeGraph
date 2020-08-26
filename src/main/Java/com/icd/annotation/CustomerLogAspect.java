package com.icd.annotation;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切点类
 * 
 * @author 李耀华
 * @since 2020年7月8日 注意：mvc配置文件中，要将包com.jd.annotation扫描，否则aop不能生效
 */
@Aspect
@Component
public class CustomerLogAspect
{
	// 定义Controller层切点
	@Pointcut("@annotation(com.icd.annotation.SystemControllerLog)")
	public void CustomerLoginAspect()
	{
		// 切点方法不需要写任何方法内容
	}
	
	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@Before("CustomerLoginAspect()")
	public void doBefore(JoinPoint joinPoint) {
         System.out.println("程序执行之前进行的操作");
	}
	
	
	/**
	 * 执行完成后通知
	 * 
	 * @param joinPoint 切点
	 *             
	 * @throws Exception 
	 */
	@AfterReturning("CustomerLoginAspect()")
	public void doAfterReturning(JoinPoint joinPoint) throws Exception {
		String logDescript=getControllerMethodDescription(joinPoint);		
		System.out.println(logDescript);
	}
	
	
	/**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();   
        //System.out.println(targetName);
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog.class).description();    
                     break;    
                }    
            }    
        }    
        return description;    
    }  
}
