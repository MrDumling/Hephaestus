package compiler.parser.statements.statement_patterns

import compiler.tokens.patterns.TokenPattern
import utils.patterns.feeding.lists.ListAcceptor

interface StatementPattern : TokenPattern {
    val tokenPattern: ListAcceptor<T>
}