package customers.advice;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import customers.IEmailSender;
import customers.ILogger;

@Aspect
@Configuration
public class EmailAdvice {
    @Autowired
    ILogger logger;

    @After("execution(* customers.EmailSender.sendEmail(..)) && args(email,message)")
    public void sendEmailLogger(JoinPoint joinPoint, String email, String message) {
        logger.log("Email is sent: message= " + message + " , emailaddress =" + email);

        IEmailSender emailSender = (IEmailSender) joinPoint.getTarget();

        System.out.println(LocalDateTime.now()+" method="+joinPoint.getSignature().getName()+" address="+email+" message = "+message+" outgoing mail server="+emailSender.getOutgoingMailServer());
    }

}
