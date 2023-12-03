import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder jdaBuilder = JDABuilder.createDefault("MTE4MDY1MzIwNTQxMjEzOTExOQ.Gi0NbO.iNTfiIoSAwNgmEX31yF6eRKCR8faNYILpodecE")
                .setActivity(Activity.listening("to ur mom"))
                .addEventListeners(new DiscordBot());
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
//        super.onMessageReceived(event);
        if (!event.getAuthor().isBot()) {
            String messageSent = event.getMessage().getContentRaw();
            if(messageSent.contains("www.instagram.com")){
                String str = new StringBuilder(messageSent).insert(12, "dd").toString();
                event.getChannel().sendMessage(str).queue();
                event.getChannel().sendMessage("Credit: <@" + event.getAuthor().getId() + ">").queue();
                event.getMessage().delete().queue();
            }
        }
    }
}
