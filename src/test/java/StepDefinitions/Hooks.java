package StepDefinitions;


import org.junit.After;
import org.junit.Before;

public class Hooks {
    @Before
    public void beforeScenario(){

        //We can use this to initialize any variables of set any parameters at the start of scenario
        //Since this was a single test we have initialized things in the step def file itself
        System.out.println("//////////////////////////START OF SCENARIO//////////////////////////");

    }

    @After
    public void afterScenario() {

        //This step will be performed at the end of every scenario
        System.out.println("///////////////////////////End OF SCENARIO///////////////////////////");

    }

}
