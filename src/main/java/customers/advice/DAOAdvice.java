package customers.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
@Aspect
@Configuration
public class DAOAdvice {
    
    @Around("execution(* customers.CustomerDAO.*(..))")
    public Object daoMethodDuration(ProceedingJoinPoint call) throws Throwable{

        StopWatch sw = new StopWatch();
        String methodName = call.getSignature().getName();
        sw.start(methodName);
        Object returnValue = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Method: "+methodName+" Time taken: "+totaltime+"ms");

        return returnValue;

    }
}
