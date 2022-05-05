package compiler.tokens.patterns.values

import compiler.tokens.patterns.TokenPattern

enum class ImmutableValues(override val matchedPattern: Regex) : TokenPattern {
    BOOLEAN_VALUE(Regex("true|false")),
    CHARACTER_VALUE(Regex("'(([^\\\\'])|(\\\\[ntrv\\\\'\"?]))'")),
    DOUBLE_VALUE(Regex("[+-]?[0-9]*?\\.[0-9]+")),
    INT_VALUE(Regex("(0b[10_]+)|(0o[0-8_]+)|(0x[0-9A-Fa-f_]+)|((\\d|_)+)")),
    STRING_VALUE(Regex("\".*?[^\\\\](\\\\\\\\)*\""));
}