package co.odin.senapi.api.accountype;

import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    public String buildSelectSql(){
        return new SQL(){{
            //TODO:
            SELECT("*");
            FROM("account_types");
        }}.toString();
    }
}
