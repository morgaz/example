package org.example.example;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.transport.NullPayload;
 
  
public class HolaMundoTestCase extends FunctionalTestCase { 
private static String MESSAGE = "Hola Mundo";
 
 
@Override
    protected String getConfigFile()
    {
        return "example.xml";
    }
 
 
@Test
    public void clientTestCase() throws Exception
    {
        MuleClient client = muleContext.getClient(); 
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("http.method", "GET");
        MuleMessage result = client.send("http://localhost:8082", "", props); 
        assertNotNull(result);
        assertFalse(result.getPayload() instanceof NullPayload); 
        assertEquals(MESSAGE, result.getPayloadAsString());
    }
}