package com.luv2code.Appdao;

import com.luv2code.Appdao.TrafficService.TrafficService;
import com.luv2code.Appdao.dao.Account;
import com.luv2code.Appdao.dao.AppDAO;
import com.luv2code.Appdao.dao.MemberDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AppdaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppdaoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appdao , MemberDAO memberDAO, TrafficService trafficService) {
        return runner -> {
            //demoTheAfterReturningAdvice(appdao);
            //demoTheAfterThrowingAdvice(appdao);
            //demoTheAfterAdvice(appdao);
            //demoaroundAdvice(trafficService);
            demoaroundAdviceHandlingException(trafficService);

        };
    }

    private void demoaroundAdviceHandlingException(TrafficService trafficService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling the fortune method .... ");
        boolean flag = false ;
        String data = trafficService.getfortune(flag);
        System.out.println("The data is : "+ data);
        System.out.println("Finish.");
    }

    private void demoaroundAdvice(TrafficService trafficService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling the fortune method .... ");
        String data = trafficService.getfortune();
        System.out.println("The data is : "+ data);
        System.out.println("Finish.");
    }

    private void demoTheAfterAdvice(AppDAO appdao) {
        List<Account> list = null ;
        try {
            boolean flag = false ;
            list = appdao.findAccounts(flag);
        }
        catch (Exception exc){
            System.out.println("The Exception in main is : "+exc);
        }
        System.out.println("\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(list);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AppDAO appdao) {
        List<Account> list = null ;
        try {
            boolean flag = true ;
            list = appdao.findAccounts(flag);
        }
        catch (Exception exc){
            System.out.println("The Exception in main is : "+exc);
        }
        System.out.println("\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(list);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AppDAO appdao) {
        List<Account> list = appdao.findAccounts();

        System.out.println("\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(list);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AppDAO appdao , MemberDAO memberDAO) {
        Account account = new Account("Mohamed","Intermediate");
        appdao.addAccount(account , true);

        appdao.setName("Mohamed");
        appdao.setServiceCode("luv2code");
        String name = appdao.getName();
        String ServiceCode = appdao.getServiceCode();

        memberDAO.addMembership();
        memberDAO.addMemberShip();
        appdao.goSleep();
    }


}
