import compiler.parser.statements.statement_patterns.assignment.DeclarationPattern
import compiler.parser.structure.common_patterns.listingStructure
import compiler.tokens.patterns.TokenPattern
import utils.patterns.ImpliedPattern

fun main() {
    println(listingStructure(ImpliedPattern(DeclarationPattern.INT_DECLARATION.assignedValue)))

    println("h0 -================================-")

//    println(
//        listingStructure<String>(DeclarationPattern.INT_DECLARATION.assignedValue).matches(toFeeder())
//    )

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