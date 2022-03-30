package compiler.parser.statements

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.tokens.TokenValue
import utils.patterns.ValueContainer

abstract class Statement(heldPattern: StatementPattern, val heldValue: List<TokenValue>) : ValueContainer<StatementPattern, List<TokenValue>>(heldPattern, heldValue) {
    external fun run()
}