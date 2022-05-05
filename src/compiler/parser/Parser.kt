package compiler.parser

import compiler.parser.statements.StatementContainerPattern
import compiler.parser.statements.Statement
import compiler.parser.statements.StatementFactory
import compiler.tokens.TokenValue
import compiler.tokens.patterns.non_specific.StatementEndTokenPattern

typealias TokenValueList = List<TokenValue>

object Parser {
    fun parseTokenList(inputTokens: TokenValueList): StatementContainerPattern =
        StatementContainerPattern(parseStatements(inputTokens))

    private fun parseStatements(inputTokens: TokenValueList): List<Statement> =
        getUnparsedStatements(inputTokens).map { x ->
            StatementFactory.buildStatement(x)
        }

    fun getUnparsedStatements(inputTokens: TokenValueList): List<TokenValueList> {
        val output: MutableList<TokenValueList> = ArrayList()

        var currentTokenValueList: MutableList<TokenValue> = ArrayList()

        for (currentToken: TokenValue in inputTokens) {
            if (currentToken.type != StatementEndTokenPattern) {
                currentTokenValueList.add(currentToken)
                continue
            }

            if (StatementFactory.matchesStatement(currentTokenValueList)) {
                output.add(currentTokenValueList)
                currentTokenValueList = ArrayList()
            }
        }

        //allows statements at ends of programs, without a need for a ';' or a newline
        if (StatementFactory.matchesStatement(currentTokenValueList)) {
            output.add(currentTokenValueList)
        } else {
            throw RuntimeException("Could not match: $currentTokenValueList")
        }

        return output
    }
}