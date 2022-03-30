package compiler.tokens

import compiler.tokens.patterns.TokenPattern
import utils.patterns.ValueContainer

data class TokenValue(val type: TokenPattern, val value: String) : ValueContainer<TokenPattern, String>(type, value)