package com.github.mel4tonin4.mcve

import org.jooq.Converter
import java.util.*

class UuidMyIdConverter : Converter<UUID, MyId> {
    override fun from(databaseObject: UUID?): MyId? =
        databaseObject?.let { MyId(it) }

    override fun to(obj: MyId?): UUID? =
        obj?.value

    override fun fromType(): Class<UUID> =
        UUID::class.java

    override fun toType(): Class<MyId> =
        MyId::class.java
}
