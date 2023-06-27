package se.ff.bsc;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class WhenComesTheTrain
{
    int port=8111;

    WhenComesTheTrain() {
        System.out.println("Default port "+port);
    }

    WhenComesTheTrain(int port) {
        this.port=port;
        System.out.println("Custom port "+port);
    }

    public static void main( String[] args ) {
        Integer timeToArrive = new WhenComesTheTrain().checkArrivalTime("hermanStr","U8");
        System.out.println("timeToArrive="+timeToArrive);
    }

    public Integer checkArrivalTime(String station, String number) {
        try {
            String url=String.format("Http://localhost:%d/train/%s/%s", port, station, number);
            System.out.println("using url: "+url);
            HttpResponse r = Request.Get(url).execute().returnResponse();
            String json = EntityUtils.toString(r.getEntity());
            System.out.println("json="+json);
            JSONObject jsonObject = new JSONObject(json);
            String arrivalTime = jsonObject.get("arrivalTime").toString();
            return new Integer(arrivalTime);

        }
        catch (Exception e) {
            System.out.println("Unable to get arrivalTime, e="+e);
            return null;
        }
    }
}
