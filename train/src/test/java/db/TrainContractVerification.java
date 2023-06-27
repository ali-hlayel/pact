package db;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("TrainService")
@PactFolder("../pacts")

public class TrainContractVerification {
    @State("Arrival of U8 Train")
    public void hammerSmith() {
        System.out.println("Result" );
    }


    @TestTarget
    public final Target target = new HttpTarget(8111);
}
