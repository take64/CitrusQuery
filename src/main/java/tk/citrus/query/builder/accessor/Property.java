package tk.citrus.query.builder.accessor;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import tk.citrus.query.builder.annotation.PROPERTY;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * プロパティ
 */
public class Property
{
    /**
     * フィールドのリストを取得
     *
     * @return フィールドのリスト
     */
    public List<String> propertyKeys()
    {
        // フィールドの取得
        Field[] fields = this.getClass().getDeclaredFields();

        // 返却用のリスト
        List<String> results = new ArrayList<>();

        // 走査
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(PROPERTY.class) == false)
            {
                // プロパティではない
                return;
            }
            // フィールド名を取得して追加
            results.add(field.getName());
        });

        // 返却
        return results;
    }
}
