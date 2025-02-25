import org.jooq.impl.DSL

import com.github.mel4tonin4.mcve.jooq.Tables.MY_TABLE
import com.github.mel4tonin4.mcve.jooq.Tables.MY_OTHER_TABLE

typealias MyTablePojo = com.github.mel4tonin4.mcve.jooq.tables.pojos.MyTable
typealias MyOtherTablePojo = com.github.mel4tonin4.mcve.jooq.tables.pojos.MyOtherTable

fun main(args: Array<String>) {
    println("Hello World!")

    val ctx = DSL.using(
        "jdbc:postgresql://localhost:5432/mcve",
        "postgres",
        "poietico"
    )

    val otherResults = ctx.selectFrom(MY_OTHER_TABLE).fetchInto(MyOtherTablePojo::class.java)

    println(otherResults.size)

    val results = ctx.selectFrom(MY_TABLE).fetchInto(MyTablePojo::class.java)

    println(results.size)
}
