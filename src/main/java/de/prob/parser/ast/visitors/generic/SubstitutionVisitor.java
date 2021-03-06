package de.prob.parser.ast.visitors.generic;

import de.prob.parser.ast.nodes.substitution.AnySubstitutionNode;
import de.prob.parser.ast.nodes.substitution.AssignSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.BecomesElementOfSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.BecomesSuchThatSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.ChoiceSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.ConditionSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.IfOrSelectSubstitutionsNode;
import de.prob.parser.ast.nodes.substitution.LetSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.ListSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.OperationCallSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.SkipSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.SubstitutionNode;
import de.prob.parser.ast.nodes.substitution.VarSubstitutionNode;
import de.prob.parser.ast.nodes.substitution.WhileSubstitutionNode;

public interface SubstitutionVisitor {

	default void visitSubstitutionNode(SubstitutionNode node) {
		if (node instanceof ListSubstitutionNode) {
			visitListSubstitutionNode((ListSubstitutionNode) node);
		} else if (node instanceof AnySubstitutionNode) {
			visitAnySubstitution((AnySubstitutionNode) node);
		} else if (node instanceof LetSubstitutionNode) {
			visitLetSubstitution((LetSubstitutionNode) node);
		} else if (node instanceof BecomesSuchThatSubstitutionNode) {
			visitBecomesSuchThatSubstitutionNode((BecomesSuchThatSubstitutionNode) node);
		} else if (node instanceof BecomesElementOfSubstitutionNode) {
			visitBecomesElementOfSubstitutionNode((BecomesElementOfSubstitutionNode) node);
		} else if (node instanceof ConditionSubstitutionNode) {
			visitConditionSubstitutionNode((ConditionSubstitutionNode) node);
		} else if (node instanceof IfOrSelectSubstitutionsNode) {
			visitIfOrSelectSubstitutionsNode((IfOrSelectSubstitutionsNode) node);
		} else if (node instanceof SkipSubstitutionNode) {
			visitSkipSubstitutionNode((SkipSubstitutionNode) node);
		} else if (node instanceof AssignSubstitutionNode) {
			visitAssignSubstitutionNode((AssignSubstitutionNode) node);
		} else if (node instanceof OperationCallSubstitutionNode) {
			visitSubstitutionIdentifierCallNode((OperationCallSubstitutionNode) node);
		} else if (node instanceof WhileSubstitutionNode) {
			visitWhileSubstitutionNode((WhileSubstitutionNode) node);
		} else if (node instanceof VarSubstitutionNode) {
			visitVarSubstitutionNode((VarSubstitutionNode) node);
		} else if (node instanceof ChoiceSubstitutionNode) {
			visitChoiceSubstitutionNode((ChoiceSubstitutionNode) node);
		} else {
			throw new AssertionError(node.getClass());
		}

	}

	void visitVarSubstitutionNode(VarSubstitutionNode node);

	void visitWhileSubstitutionNode(WhileSubstitutionNode node);

	void visitSubstitutionIdentifierCallNode(OperationCallSubstitutionNode node);

	void visitIfOrSelectSubstitutionsNode(IfOrSelectSubstitutionsNode node);

	void visitListSubstitutionNode(ListSubstitutionNode node);

	void visitAssignSubstitutionNode(AssignSubstitutionNode node);

	void visitSkipSubstitutionNode(SkipSubstitutionNode node);

	void visitConditionSubstitutionNode(ConditionSubstitutionNode node);

	void visitAnySubstitution(AnySubstitutionNode node);

	void visitLetSubstitution(LetSubstitutionNode node);

	void visitBecomesElementOfSubstitutionNode(BecomesElementOfSubstitutionNode node);

	void visitBecomesSuchThatSubstitutionNode(BecomesSuchThatSubstitutionNode node);

	void visitChoiceSubstitutionNode(ChoiceSubstitutionNode node);
}
