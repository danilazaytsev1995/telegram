package danila_zaytsev.telegram.Service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

public class MembersCommand extends ServiceCommand {
    JdbcTemplate jdbcTemplate;
    List<String> members = new ArrayList();

    public MembersCommand(String identifier, String description, JdbcTemplate jdbcTemplate) {
        super(identifier, description);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());
        try {
            members = jdbcTemplate.queryForList("SELECT user_name FROM members_table WHERE chat_id = ?",
                    String.class, chat.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        String message = String.join("\n", members);

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "Список участников:\n" + message);
    }
}
/*members = jdbcTemplate.queryForObject("SELECT user_name FROM members_table WHERE chat_id = ?",
                List.class, chat.getId());*/
