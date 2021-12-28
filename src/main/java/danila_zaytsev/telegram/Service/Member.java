package danila_zaytsev.telegram.Service;

public class Member {
    private String telegram_id;
    private String user_name;
    private String first_name;
    private String last_name;
    private String talker_of_the_day;
    private String talker_of_the_month;
    private String talker_of_the_year;
    private String chat_id;


    public Member(String telegram_id, String user_name, String first_name, String last_name, String talker_of_the_day,
                  String talker_of_the_month, String talker_of_the_year, String chat_id) {
        this.telegram_id = telegram_id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.talker_of_the_day = talker_of_the_day;
        this.talker_of_the_month = talker_of_the_month;
        this.talker_of_the_year = talker_of_the_year;
        this.chat_id = chat_id;
    }

    public String getTelegram_id() {
        return telegram_id;
    }

    public void setTelegram_id(String telegram_id) {
        this.telegram_id = telegram_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTalker_of_the_day() {
        return talker_of_the_day;
    }

    public void setTalker_of_the_day(String talker_of_the_day) {
        this.talker_of_the_day = talker_of_the_day;
    }

    public String getTalker_of_the_month() {
        return talker_of_the_month;
    }

    public void setTalker_of_the_month(String talker_of_the_month) {
        this.talker_of_the_month = talker_of_the_month;
    }

    public String getTalker_of_the_year() {
        return talker_of_the_year;
    }

    public void setTalker_of_the_year(String talker_of_the_year) {
        this.talker_of_the_year = talker_of_the_year;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }
}
