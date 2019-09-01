package tk.citrus.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

/**
 * JDBCで利用するドライバクラス
 */
public class Drivers
{
    /**
     * ドライバクラス SQLite
     */
    public static String SQLITE = "org.sqlite.JDBC";


    /**
     * ドライバクラスのロード
     *
     * @param driverClass
     */
    public static void load(String driverClass) throws ClassNotFoundException
    {
        Class.forName(driverClass);
    }
}
