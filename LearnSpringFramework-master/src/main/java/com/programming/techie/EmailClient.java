package com.programming.techie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class EmailClient {
   @Autowired
   @Qualifier("advancedSpellChecker")
    private SpellChecker spellChecker;

    void sendEmail(String emailMessage) {
        spellChecker.checkSpelling(emailMessage);
        // Logic to Send Email
    }
    //below one for constructor based 
    /*
    EmailClient(SpellChecker specllchecker){
    	this.spellChecker=specllchecker;
    }*/

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
    
}
