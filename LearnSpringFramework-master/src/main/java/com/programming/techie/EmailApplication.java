package com.programming.techie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailApplication {
    public static void main(String[] args) {
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("beans.xml");
//        ApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
//        emailClient.sendEmail("Hey, " +
//                "This is my first email message.");
//        emailClient.sendEmail("Hey, " +
//                "This is my second email message.");
//
//        // Bean Scopes
//        AdvancedSpellChecker advancedSpellChecker = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
//        System.out.println(advancedSpellChecker);
//        AdvancedSpellChecker advancedSpellChecker1 = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
//        System.out.println(advancedSpellChecker1);
//
//        ((AnnotationConfigApplicationContext) applicationContext).registerShutdownHook();
    	//EmailClient emailClient=new EmailClient(new AdvancedSpellChecker());
    	//emailClient.sendEmail("amitlaha");
    //	EmailClient emailClient=new EmailClient(new BasicSpellChecker());
    //	emailClient.sendEmail("amitlaha");
    	//ApplicationContext applicationContex=new ClassPathXmlApplicationContext("beans.xml");
    	//EmailClient emailClient=applicationContex.getBean("emailClient",EmailClient.class);
    	ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
         EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
    	emailClient.sendEmail("Hey this is my fist email amitlaha@gmailcom");
    	emailClient.sendEmail("Hey this is my second email amitlaha@gmailcom");
    	//Note while calling a bean We need to start it with small latter
        SpellChecker advanceSpecllcheker=applicationContext.getBean("advancedSpellChecker",AdvancedSpellChecker.class);
        SpellChecker advanceSpecllcheker2=applicationContext.getBean("advancedSpellChecker",AdvancedSpellChecker.class);
        System.out.println("advanceSpecllcheker>> "+advanceSpecllcheker); 
        System.out.println("advanceSpecllcheker222>> "+advanceSpecllcheker2); 
        ((AnnotationConfigApplicationContext)applicationContext).registerShutdownHook();
     }
}
