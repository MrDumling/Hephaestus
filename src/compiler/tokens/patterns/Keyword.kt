package compiler.tokens.patterns

enum class Keyword(keywordString: String) : TokenPattern {
    BOOLEAN_KEYWORD("boolean"),
    BYTE_KEYWORD("byte"),
    CHAR_KEYWORD("char"),
    DOUBLE_KEYWORD("double"),
    FLOAT_KEYWORD("float"),
    INT_KEYWORD("int"),
    LONG_KEYWORD("long"),
    SHORT_KEYWORD("short"),
    STRING_KEYWORD("string"),

    GOTO_KEYWORD("goto");

    init {
        if (!keywordString.matches(Regex("[a-zA-Z_][a-zA-Z_0-9]*"))) {
            throw Exception("Keyword does not match defined patterns")
        }
    }

    override val matchedPattern = Regex(keywordString)

}