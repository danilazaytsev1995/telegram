package danila_zaytsev.telegram.Service;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;
import static danila_zaytsev.telegram.Service.Members.members;

public class MembersCommand extends ServiceCommand {

    public MembersCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName, members.get(0));

    }
}
