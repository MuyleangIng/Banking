package co.odin.senapi.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private static final String tableName = "users";

    public String buildDeleteByIdSql(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
    public String buildInsertSql(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("name","#{u.name}");
            VALUES("gender","#{u.gender}");
            VALUES("one_signal_id","#{u.oneSignalId}");
            VALUES("student_card_id","#{u.studentCardId}");
            VALUES("is_student","#{u.isStudent}");
            VALUES("is_deleted","FALSE");
        }}.toString();
    }
    public String buildSelectById(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id = #{id}");
        }}.toString();
    }
}
