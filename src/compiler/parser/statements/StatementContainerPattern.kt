package compiler.parser.statements

import java.io.Serializable

class StatementContainerPattern(val heldStatements: List<Statement>) : AbstractSyntaxTreeNodePattern<List<Statement>>,
    Serializable {
    override fun matches(checkedValue: List<Statement>): Boolean {
        TODO("Not yet implemented")
    }
}