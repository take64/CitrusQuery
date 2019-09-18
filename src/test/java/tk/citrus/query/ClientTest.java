package tk.citrus.query;

/**
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import org.junit.jupiter.api.Test;
import tk.citrus.pulse.Environment;
import tk.citrus.pulse.file.FileAccessor;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

class ClientTest
{
    @Test
    public void 接続_インメモリSQLite_正常にオープンとクローズができる()
    {
        Client client = new Client(DSN.sqliteDSN(":memory:"));

        // オープン・クローズ
        this.openAndClose(client);
    }



    @Test
    public void 接続_ファイルSQLite_正常にオープンとクローズができる()
    {
        // ファイル生成
        String sqlite = Environment.currentDirectory() + "/test.sqlite";
        FileAccessor.createFileIfNotExists(sqlite);

        // 接続
        Client client = Client.getInstance();
        client.setDsn(DSN.sqliteDSN(sqlite));

        // オープン・クローズ
        this.openAndClose(client);

        // ファイル削除
        FileAccessor.deleteFileIfExists(sqlite);
    }



    /**
     * クライアントでの接続オープンとクローズ
     *
     * @param client
     */
    private void openAndClose(Client client)
    {
        try
        {
            client.open();
            client.close();
        }
        catch (SQLException | QueryException e)
        {
            fail(e.getMessage());
        }
    }
}
