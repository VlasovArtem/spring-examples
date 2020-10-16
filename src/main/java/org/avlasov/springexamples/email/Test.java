package org.avlasov.springexamples.email;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.util.Properties;

/**
 * Created By artemvlasov on 04/09/2018
 **/
public class Test {

    public static void main(String[] args) throws MessagingException, IOException {
        Session session = Session.getDefaultInstance(new Properties());
        Store store = session.getStore("imaps");
        store.connect("imap.googlemail.com", 993, "avlasov@determine.com", "apbwypjnxmywzzld");
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        Message[] search = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        System.out.println("test");
//        Element emailBody = parse.createElement("div").addClass("email-body");
//        parse.body().removeAttr("style");
//        Elements div = parse.select("body > div");
//        // Last Div is div with replays
//        for (int i = 0; i < div.size() - 1; i++) {
//            Element mainBodyPart = div.get(i);
//            mainBodyPart.replaceWith(emailBody);
//            emailBody.appendChild(mainBodyPart);
//        }
//        Element emailReplaysInitElement = createEmailReplaysInitElement(parse);
//        Element replaysBody = div.last().addClass("thread").addClass("hide");
//        replaysBody.replaceWith(emailReplaysInitElement);
//        emailReplaysInitElement.appendChild(replaysBody);
//        System.out.println(parse.toString());
    }

    public static Element createEmailReplaysInitElement(Document document) {
        return document.createElement("div")
                .addClass("email-replays")
                .appendChild(createShowHideButtonDiv(document));
    }

    private static Node createShowHideButtonDiv(Document document) {
        return document.createElement("div").addClass("button-wrapper")
                .appendChild(document.createElement("div").addClass("show-hide-thread-button")
                        .appendChild(document.createElement("img").attr("src", "/pix/icons/show_hide_button.png"))
                        .appendChild(document.createElement("span").addClass("tooltiptext").text("Show Thread")));
    }


}
