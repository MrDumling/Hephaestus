import compiler.parser.statements.statement_patterns.assignment.DeclarationPattern
import compiler.parser.structure.common_patterns.ListingStructure
import compiler.tokens.patterns.TokenPattern
import utils.patterns.ImpliedPattern

fun main() {
    println(ListingStructure<TokenPattern>(ImpliedPattern(DeclarationPattern.INT_DECLARATION.assignedValue)).
        values.
        iterator().forEach { println(it) }
    )

    println("h0 -================================-")

    println(
        ListingStructure<String>(DeclarationPattern.INT_DECLARATION.assignedValue).matches(toFeeder())
    )

    println("reached end")


//    val bufferedReader: BufferedReader = File("src/program.txt").bufferedReader()
//    val inputProgram = bufferedReader.use { it.readText() }
//
//    println("input program:")
//    println(inputProgram)
//
//    val tokens = Tokenizer(inputProgram).tokenize()
//    for (x in Parser.parseTokenList(tokens).heldStatements) {
//        println(x)
//    }
}