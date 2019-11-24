package home.models;

import com.fasterxml.jackson.databind.DeserializationFeature;
import home.controllers.OperatorOrderController;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Request : Check and get Orders from API
 *
 * sample post request to API (for testing only) :
 * https://ooad-api.herokuapp.com/postOrder?orderNumber=123&customerName=some Customer&address=address&item=some item
 */


public class Request extends Thread {

    private static URL getUrl;

    static {
        try {
            getUrl = new URL("https://ooad-api.herokuapp.com/getOrder");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    ;
    private static HttpsURLConnection request;
    private static OperatorOrderController ooc;

    public Request(OperatorOrderController oc) {
        this.ooc = oc;
    }

    /**
     * make a GET request to api
     * */
    public void run() {
        // open connection
        while (true) {
            try {
                this.request = (HttpsURLConnection) this.getUrl.openConnection();
                request.setRequestMethod("GET");

                int status = request.getResponseCode();

                if(status == 200) {
                    //System.out.println("[Sucess] Response Affirmative !");
                    //System.out.println(request.getContent().toString());

                    BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // print result
                   // System.out.println(response.toString());
                    //System.out.println("Parsing");
                    this.parseRequest(response.toString());

                   // System.out.println("Fine till here");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] something went wrong in thread ;");
                System.out.println(e);
                //break;
            }
        }
    }

    private void parseRequest(String req) throws IOException {
        //System.out.println("[NOTE] Parsing request");
        if(req.equals("No Order")) {
            return;
        }
        System.out.println(req);
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, false);
        om.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        om.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        om.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
        Order o = om.readValue(req, Order.class);
        System.out.println("[SUCCESS] Order object created with id :  "+o.getOrderNumber());
        System.out.println("[NOTE] Sending order to OOC ...");
        if(this.ooc.addOrderToTable(o)) {
            System.out.println("[SUCCESS] Sent Order to controller ...");
            return;
        }
        System.out.println("[ERROR] Failed adding order ...");
        return;

    }
}
