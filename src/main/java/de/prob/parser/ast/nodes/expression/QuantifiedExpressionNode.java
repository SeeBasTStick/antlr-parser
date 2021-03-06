package de.prob.parser.ast.nodes.expression;

import de.prob.parser.ast.SourceCodePosition;
import de.prob.parser.ast.nodes.DeclarationNode;
import de.prob.parser.ast.nodes.predicate.PredicateNode;

import java.util.List;

//TODO: Reason for extending SetComprehensionNode?
public class QuantifiedExpressionNode extends SetComprehensionNode {

	public enum QuantifiedExpressionOperator {
		QUANTIFIED_UNION, QUANTIFIED_INTER, SIGMA, PI
	}

	private QuantifiedExpressionOperator operator;
	private ExprNode expressionNode;

	public ExprNode getExpressionNode() {
		return expressionNode;
	}

	public void setExpr(ExprNode expr) {
		this.expressionNode = expr;
	}

	public QuantifiedExpressionNode(SourceCodePosition sourceCodePosition, QuantifiedExpressionOperator operator,
			List<DeclarationNode> declarationList, PredicateNode predNode, ExprNode expressionNode) {
		super(sourceCodePosition, declarationList, predNode);
		this.expressionNode = expressionNode;
		this.operator = operator;
		this.expressionNode.setParent(this);
	}

	public QuantifiedExpressionOperator getOperator() {
		return operator;
	}

}
