package compiler.parser.statements.statement_impl.flow_control

import compiler.parser.statements.Statement
import compiler.parser.statements.statement_patterns.flow_control.LabelPattern
import compiler.tokens.TokenValue

class LabelStatement(heldValue: List<TokenValue>) : Statement(LabelPattern, heldValue) {

}