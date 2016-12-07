package common.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

/**
* 项目名:SpringBootDemo
* 创建人:贺小五
* 创建时间:16/12/4 下午7:05
* 类名:AspectDemo
* 类描述:
*/
//申明是个切面
@Aspect
//申明是个spring管理的bean
@Component
@Order(1)
public class AspectDemo {


  private Logger log = Logger.getLogger(getClass());

  private Gson gson = new Gson();

  //申明一个切点 里面是 execution表达式
  @Pointcut("execution(public * com.tzm.controller.*.*(..))")
  private void controllerAspect(){}


  //请求method前打印内容
  @Before(value = "controllerAspect()")
  public void methodBefore(JoinPoint joinPoint){
     ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
     HttpServletRequest request = requestAttributes.getRequest();

     //打印请求内容
     log.info("===============请求内容===============");
     log.info("请求地址:"+request.getRequestURL().toString());
     log.info("请求方式:"+request.getMethod());
     log.info("请求类方法:"+joinPoint.getSignature());
     log.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
     log.info("===============请求内容===============");
  }


  //在方法执行完结后打印返回内容
  @AfterReturning(returning = "o",pointcut = "controllerAspect()")
  public void methodAfterReturing(Object o ){
     log.info("--------------返回内容----------------");
     log.info("Response内容:"+gson.toJson(o));
     log.info("--------------返回内容----------------");
  }
}