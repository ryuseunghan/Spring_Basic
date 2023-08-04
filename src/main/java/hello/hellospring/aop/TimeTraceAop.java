package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeTraceAop {

    //실행하는 패키지명, 패키지의 클래스 파라미터 등
    @Around(("execution(* hello.hellospring..*(..))"))
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Start: "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("End: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
