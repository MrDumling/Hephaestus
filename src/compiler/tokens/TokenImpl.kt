package compiler.tokens

import compiler.tokens.patterns.Keyword
import compiler.tokens.patterns.non_specific.IgnoredTokenPattern
import compiler.tokens.patterns.non_specific.StatementEndTokenPattern
import compiler.tokens.patterns.non_specific.ValidName
import compiler.tokens.patterns.operators.UnfixedOperatorPattern
import compiler.tokens.patterns.operators.binary_operators.BitwiseOperators
import compiler.tokens.patterns.operators.binary_operators.ComparisonOperatorPattern
import compiler.tokens.patterns.operators.binary_operators.LogicalOperatorPattern
import compiler.tokens.patterns.operators.binary_operators.MathOperatorPattern
import compiler.tokens.patterns.values.ImmutableValues

val tokenList: List<TokenPrecedenceGroup> = listOf(
    TokenPrecedenceGroup(ImmutableValues.STRING_VALUE, ImmutableValues.CHARACTER_VALUE),
    TokenPrecedenceGroup(ImmutableValues.BOOLEAN_VALUE),

    TokenPrecedenceGroup(IgnoredTokenPattern),

    TokenPrecedenceGroup(*Keyword.values()),
    TokenPrecedenceGroup(ValidName),

    TokenPrecedenceGroup(ImmutableValues.DOUBLE_VALUE),
    TokenPrecedenceGroup(ImmutableValues.INT_VALUE),

    TokenPrecedenceGroup(
        ComparisonOperatorPattern.EQUALS,
        ComparisonOperatorPattern.GREATER_THAN_OR_EQUAL,
        ComparisonOperatorPattern.LESS_THAN_OR_EQUAL
    ),

    TokenPrecedenceGroup(LogicalOperatorPattern.LOGICAL_OR, LogicalOperatorPattern.LOGICAL_AND),

    TokenPrecedenceGroup(
        UnfixedOperatorPattern.OPENING_BRACE,
        UnfixedOperatorPattern.CLOSING_BRACE,
        UnfixedOperatorPattern.OPENING_BRACKET,
        UnfixedOperatorPattern.CLOSING_BRACKET
    ),

    TokenPrecedenceGroup(BitwiseOperators.BITWISE_SHIFT_LEFT, BitwiseOperators.BITWISE_SHIFT_RIGHT),
    TokenPrecedenceGroup(*MathOperatorPattern.values()),

    TokenPrecedenceGroup(
        BitwiseOperators.BITWISE_AND,
        BitwiseOperators.BITWISE_OR,
        BitwiseOperators.BITWISE_XOR
    ),

    TokenPrecedenceGroup(
        ComparisonOperatorPattern.GREATER_THAN,
        ComparisonOperatorPattern.LESS_THAN
    ),

    TokenPrecedenceGroup(UnfixedOperatorPattern.ASSIGNMENT_OPERATOR, UnfixedOperatorPattern.COLON_OPERATOR),
    TokenPrecedenceGroup(StatementEndTokenPattern)
)