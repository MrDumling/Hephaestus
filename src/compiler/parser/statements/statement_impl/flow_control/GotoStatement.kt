package compiler.parser.statements.statement_impl.flow_control

import compiler.parser.statements.Statement
import compiler.parser.statements.statement_patterns.flow_control.GotoPattern
import compiler.tokens.TokenValue

class GotoStatement(heldValue: List<TokenValue>) : Statement(GotoPattern, heldValue)