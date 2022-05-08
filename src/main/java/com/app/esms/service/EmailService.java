package com.app.esms.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;


@Service
public class EmailService {

    @Value("${SENDGRID_API}")
    public String SENDGRID_API;

    public boolean sendEmail(String toEmail, String name, String subject, String password) throws IOException {
        Mail mail = new Mail();

        Email fromEmail = new Email();
        fromEmail.setName("ESMS Admin");
        fromEmail.setEmail("noreply@esms.com");
        mail.setFrom(fromEmail);
        Personalization personalization = new Personalization();
        Email to = new Email();
        to.setName(name);
        to.setEmail(toEmail);
        personalization.addTo(to);

        personalization.setSubject(subject);

        mail.addPersonalization(personalization);

        Content content = new Content();
        content.setType("text/html");
        content.setValue("<html>" +
                "<body>" +
                "Hi " +name+" <br>"+
                "<p>Here is your password for ESMS : <b>"+password+"<b></p><br><br>" +
                "Thanks,<br><br>" +
                "ESMS Team"+
                "</body>" +
                "</html>");
        mail.addContent(content);
        int status = send(mail, SENDGRID_API);
        return status == 202 ? true: false;
    }

    private static int send(final Mail mail, String API_KEY) throws IOException {
        final SendGrid sg = new SendGrid(API_KEY);
        sg.addRequestHeader("X-Mock", "true");

        final Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        final Response response = sg.api(request);
        return response.getStatusCode();
    }
}
