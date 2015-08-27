/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iloveyouboss;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
    
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;
    
    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got Bonuses?");
        criteria = new Criteria();
    }
    
    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
        
        boolean matches = profile.matches(criteria);
        
        Assert.assertFalse(matches);
    }
    
    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
        
        boolean matches = profile.matches(criteria);
        
        Assert.assertTrue(matches);
    }
}