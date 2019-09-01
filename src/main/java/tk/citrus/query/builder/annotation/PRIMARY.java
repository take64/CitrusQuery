package tk.citrus.query.builder.annotation;

/*
 * @copyright   Copyright 2019, Citrus/besidesplus All Rights Reserved.
 * @author      take64 <take64@citrus.tk>
 * @license     http://www.citrus.tk/
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * カラムオブジェクトのプライマリキー指定
 */
@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
public @interface PRIMARY
{
}
