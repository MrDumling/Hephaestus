package compiler.parser.statements.statement_impl.assignment

import compiler.parser.statements.Statement
import compiler.parser.statements.statement_patterns.assignment.ArrayDeclarationPattern
import compiler.parser.statements.statement_patterns.assignment.DeclarationPattern
import compiler.tokens.TokenValue

class ArrayDeclaration(heldValue: List<TokenValue>, heldType: DeclarationPattern) : Statement(ArrayDeclarationPattern(heldType), heldValue)