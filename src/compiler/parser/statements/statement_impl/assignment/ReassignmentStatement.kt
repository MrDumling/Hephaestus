package compiler.parser.statements.statement_impl.assignment

import compiler.parser.statements.statement_patterns.assignment.ReassignmentPattern
import compiler.tokens.TokenValue

class ReassignmentStatement(heldValue: List<TokenValue>) : GenericDeclarationStatement(ReassignmentPattern, heldValue)