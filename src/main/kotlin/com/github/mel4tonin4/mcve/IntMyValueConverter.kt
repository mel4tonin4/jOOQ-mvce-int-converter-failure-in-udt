package com.github.mel4tonin4.mcve

import org.jooq.Converter

class IntMyValueConverter : Converter<Int, MyValue> {
    override fun from(databaseObject: Int?): MyValue? =
        databaseObject?.let { MyValue(it) }

    override fun to(obj: MyValue?): Int? =
        obj?.value

    override fun fromType(): Class<Int> =
        Int::class.java

    override fun toType(): Class<MyValue> =
        MyValue::class.java
}