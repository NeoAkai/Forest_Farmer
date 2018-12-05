package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCreator {

    private boolean getDebugMsg = true;

    public SQLCreator(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql.webhosting24.1blu.de/db85565x2810214?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "s85565_2810214", "kkgbeste");
            Statement stmt = con.createStatement();


        }catch(Exception e){
            if(getDebugMsg) e.printStackTrace();
        }
    }
}
