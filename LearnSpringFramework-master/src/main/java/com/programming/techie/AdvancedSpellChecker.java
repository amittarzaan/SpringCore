package com.programming.techie;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/application.properties")
//@Scope("prototype")
//@Scope("singleton")
public class AdvancedSpellChecker implements SpellChecker,InitializingBean,DisposableBean {

    @Value("${app.database.uri}")
    private String databaseUri;


    public void checkSpelling(String emailMessage) {
        if (emailMessage != null) {
            // Determining the Language of the email Message
            // Check grammatical errors in the email Message
            // Check spellings in the email Message
        	System.out.println("message-------------->"+emailMessage);
            System.out.println("Checking Spelling using Advanced Spell Checker..");
            System.out.println("Spell Checking Completed!!");

            System.out.println("This is for tsting ");
            System.out.println("This is for dev code ");      
            System.out.println("This is for testing1 ");
            System.out.println("This is for dev ");
            System.out.println("This is for dev2 ");
            System.out.println("This is for dev3 ");
            System.out.println("This is for dev4 ");
            System.out.println("This is for testing ");
            System.out.println("This is for testing1 ");
            System.out.println("This is for testing2 ");
            System.out.println("This is for testing3 ");

            System.out.println("DB URI: " + databaseUri);
        } else {
            throw new RuntimeException("An exception occurred while checking Spelling");
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed Properties-------------------------------------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Setting Properties after Bean is initialized");
    }
 }
