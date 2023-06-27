package de;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class WhenTrainArrivesTest {
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("TrainService", "localhost", 8112, this);

    @Pact(consumer = "ClientService")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");


        DslPart result = new PactDslJsonBody()
                .stringType("station")
                .stringType("number")
                //.integerType("arrivalTime")
                .asBody();

        return builder
                .given("Arrival of U8 Train")
                .uponReceiving("A request to get the arrival time of train")
                .path("/train/hermanStr/U8")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(result).toPact();

    }

    @Test
    @PactVerification()
    public void doTest() {
        System.setProperty("pact.rootDir","../pacts");
        new WhenComesTheTrain(provider.getPort()).checkArrivalTime("hermanStr", "U8");
    }

}

