package demo;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Link;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class AppTest {

	@Test public void testExample() throws IOException, MailosaurException {
	    // Available in the API tab of a server
	    String apiKey = "YOUR-API-KEY";
	    String serverId = "SERVICE-ID";
	    String serverDomain = "SERVER-DOMAIN";

	    MailosaurClient mailosaur = new MailosaurClient(apiKey);

	    MessageSearchParams params = new MessageSearchParams();
	    params.withServer(serverId);

	    SearchCriteria criteria = new SearchCriteria();
	    criteria.withSentTo("anything@" + serverDomain);

	    Message message = mailosaur.messages().get(params, criteria);
	    
	    System.out.println("Subject: " + message.subject());
	    System.out.println("From: " + message.from().get(0).email());
	    
	    // body
	     System.out.println("Body (text): " + message.text().body());
	     
	     //Links
	     System.out.println("Total links: " + message.html().links().size());
	     Link firstLink = message.html().links().get(0);
	     System.out.println("First link URL: " + firstLink.text());
	     
	     //Attachements
	     System.out.println("Total attachments: " + message.attachments().size());
	     	     

	    assertNotNull(message);
	    assertEquals("Mailosour Email Testing", message.subject());
	  }
	}

