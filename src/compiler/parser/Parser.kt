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
            StatementFactory.createStatement(x)
        }

    private fun getUnparsedStatements(inputTokens: TokenValueList): List<TokenValueList> {
        val output: MutableList<TokenValueList> = ArrayList()

        var currentTokenValueList: MutableList<TokenValue> = ArrayList()

        for (currentToken: TokenValue in inputTokens) {
            if (currentToken.type == StatementEndTokenPattern) {
                if(currentTokenValueList.size == 0) continue

                output.add(currentTokenValueList)
                currentTokenValueList = ArrayList()
                continue
            }

            currentTokenValueList.add(currentToken)
        }

        return output
    }
}