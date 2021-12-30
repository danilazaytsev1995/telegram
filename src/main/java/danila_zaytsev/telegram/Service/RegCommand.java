package danila_zaytsev.telegram.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class RegCommand extends ServiceCommand {
    JdbcTemplate jdbcTemplate;

    public RegCommand (String identifier, String description, JdbcTemplate jdbcTemplate) {
        super(identifier, description);
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());

        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM members_table WHERE" +
                    " telegram_id = ? and chat_id = ?", Integer.class, user.getId(), chat.getId());

        if (count == 0) {
            jdbcTemplate.update("INSERT INTO members_table (telegram_id, user_name, first_name, last_name," +
                            "talker_of_the_day, talker_of_the_month, talker_of_the_year, chat_id) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?);", user.getId(), user.getUserName(),
                    user.getFirstName(), user.getLastName(), 0, 0, 0, chat.getId());

            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                    "*ШТОШ...* Теперь ты участник игры *\"Болтовня\"*");
        } else {
            sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                    "*ЭЙ*, ты ведь уже в игре");
        }
    }

}
