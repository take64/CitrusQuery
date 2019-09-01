package tk.citrus.query;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 接続クライアント
 */
public class Client
{
    /**
     * singleton
     */
    public static Client singleton;

    /**
     * DSN
     */
    private DSN dsn;

    /**
     * 接続
     */
    private Connection connection;



    /**
     * constructor.
     */
    public Client()
    {
        super();
    }



    /**
     * constructor.
     *
     * @param dsn
     */
    public Client(DSN dsn)
    {
        this.setDsn(dsn);
    }



    /**
     * singleton.
     *
     * @return singleton instance
     */
    public static Client getInstance()
    {
        if (singleton == null)
        {
            singleton = new Client();
        }
        return singleton;
    }



    /**
     * 接続のオープン
     */
    public void open() throws SQLException, QueryException
    {
        if (this.getDsn() == null)
        {
            throw new QueryException("DSN情報がありません");
        }

        Connection connection;
        try
        {
            // 接続を取得
            connection = DriverManager.getConnection(this.getDsn().toString());
        }
        catch (SQLException e)
        {
            throw e;
        }
        this.setConnection(connection);
    }



    /**
     * クローズ
     */
    public void close() throws SQLException
    {
        // 接続がある場合にクローズする
        if (this.getConnection() != null)
        {
            this.getConnection().close();
        }
    }



    public DSN getDsn()
    {
        return dsn;
    }



    public void setDsn(DSN dsn)
    {
        this.dsn = dsn;
    }



    public Connection getConnection()
    {
        return connection;
    }



    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
}
