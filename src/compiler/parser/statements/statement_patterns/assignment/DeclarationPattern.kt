package compiler.parser.statements.statement_patterns.assignment

import compiler.parser.statements.statement_patterns.StatementPattern
import compiler.tokens.patterns.Keyword
import compiler.tokens.patterns.TokenPattern
import compiler.tokens.patterns.non_specific.*
import compiler.tokens.patterns.operators.UnfixedOperatorPattern
import compiler.tokens.patterns.values.ImmutableValues

enum class DeclarationPattern(val typeName: TokenPattern, val assignedValue: TokenPattern) :
    StatementPattern {
    FLOAT_DECLARATION(
        InterchangeableTokens(Keyword.FLOAT_KEYWORD, Keyword.DOUBLE_KEYWORD),
        InterchangeableTokens(ImmutableValues.DOUBLE_VALUE, ImmutableValues.INT_VALUE)
    ),
    INT_DECLARATION(
        InterchangeableTokens(Keyword.INT_KEYWORD, Keyword.LONG_KEYWORD, Keyword.SHORT_KEYWORD, Keyword.BYTE_KEYWORD),
        ImmutableValues.INT_VALUE
    ),
    STRING_DECLARATION(
        Keyword.STRING_KEYWORD,
        ImmutableValues.STRING_VALUE
    ),
    CHARACTER_DECLARATION(
        Keyword.CHAR_KEYWORD,
        ImmutableValues.CHARACTER_VALUE
    ),
    BOOLEAN_DECLARATION(
        Keyword.BOOLEAN_KEYWORD,
        ImmutableValues.BOOLEAN_VALUE
    );

    override val matchedPattern: Regex = GroupableTokens(
        typeName,
        ValidName,
        UnfixedOperatorPattern.ASSIGNMENT_OPERATOR,
        assignedValue
    ).matchedPattern
}