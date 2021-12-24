package danila_zaytsev.telegram.Service;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

import static danila_zaytsev.telegram.Service.Members.members;

public class RegCommand extends ServiceCommand {

    public RegCommand (String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        /*формируем имя пользователя - поскольку userName может быть не заполнено,
        для этого случая используем имя и фамилию пользователя*/
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());
        members.add(user.getUserName());
        //обращаемся к методу суперкласса для отправки пользователю ответа
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "*ШТОШ...* Теперь ты участник игры *\"Пиздаболия\"*");
    }
}
