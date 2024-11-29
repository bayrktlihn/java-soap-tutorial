package io.bayrktlihn.javasoaptutorial;

import lombok.RequiredArgsConstructor;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

@RequiredArgsConstructor
public class SecurityHandler implements SOAPHandler<SOAPMessageContext> {


    private final String username;
    private final String password;

    @Override
    public Set<QName> getHeaders() {
        return Set.of();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (isOutbound) {
            SOAPMessage message = context.getMessage();
            SOAPPart soapPart = message.getSOAPPart();
            try {
                SOAPEnvelope envelope = soapPart.getEnvelope();

                SOAPHeader header = envelope.getHeader();

                if (header == null) {
                    header = envelope.addHeader();
                }

                SOAPElement security = header.addChildElement("Security", "wsse", "https://docs.oasis-open.org/wss/oasis-wss-wssecurity-secext-1.1.xsd");
                SOAPElement userToken = security.addChildElement("UsernameToken", "wsse");

                userToken.addChildElement("Username", "wsse").addTextNode(username);
                userToken.addChildElement("Password", "wsse").addTextNode(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
