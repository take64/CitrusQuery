package tk.citrus.query;

/**
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

/**
 * DSNクラス
 */
public class DSN
{
    /**
     * JDBC SQLite
     */
    public static String JDBC_SQLITE = "jdbc:sqlite:";

    /**
     * データベースプロトコル
     */
    protected String protocol;

    /**
     * データベースファイルパス
     */
    protected String filepath;



    /**
     * SQLiteのDSNを生成して取得
     *
     * @param filepath
     * @return
     */
    public static DSN sqliteDSN(String filepath)
    {
        DSN dsn = new DSN();
        dsn.setProtocol(JDBC_SQLITE);
        dsn.setFilepath(filepath);
        return dsn;
    }



    /**
     * DSN文字列を生成して返却
     *
     * @return DSN文字列
     */
    public String toString()
    {
        // SQLiteの場合
        if (this.getProtocol().equals(JDBC_SQLITE) == true)
        {
            return String.format("%s%s", this.getProtocol(), this.getFilepath());
        }
        return "";
    }



    public String getProtocol()
    {
        return protocol;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
}
