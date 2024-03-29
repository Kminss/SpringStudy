package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aopSetting.xml");
        Exam proxy = (Exam) context.getBean("proxy");

        /*Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), new Class[]{Exam.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                Object result = method.invoke(exam, args);
                long end = System.currentTimeMillis();
                String message = (end - start) + "ms 시간이 걸렸습니다.";
                System.out.println(message);

                return result;
            }
        });*/

        //prxy를 이용한 시간 측정
        System.out.printf("total is %d \n ", proxy.total());
        //기본 total 서비스
       // System.out.printf("total is %d \n", exam.total());

    }



}
