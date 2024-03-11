/**
 * Copyright (c) 2016 Kiel University and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.elk.alg.graphviz.dot.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.elk.alg.graphviz.dot.dot.Attribute;
import org.eclipse.elk.alg.graphviz.dot.dot.AttributeStatement;
import org.eclipse.elk.alg.graphviz.dot.dot.DotPackage;
import org.eclipse.elk.alg.graphviz.dot.dot.EdgeStatement;
import org.eclipse.elk.alg.graphviz.dot.dot.EdgeTarget;
import org.eclipse.elk.alg.graphviz.dot.dot.Graph;
import org.eclipse.elk.alg.graphviz.dot.dot.GraphvizModel;
import org.eclipse.elk.alg.graphviz.dot.dot.Node;
import org.eclipse.elk.alg.graphviz.dot.dot.NodeStatement;
import org.eclipse.elk.alg.graphviz.dot.dot.Port;
import org.eclipse.elk.alg.graphviz.dot.dot.Statement;
import org.eclipse.elk.alg.graphviz.dot.dot.Subgraph;
import org.eclipse.elk.alg.graphviz.dot.services.GraphvizDotGrammarAccess;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GraphvizDotFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private GraphvizDotGrammarAccess _graphvizDotGrammarAccess;

  protected void _format(final GraphvizModel graphvizModel, @Extension final IFormattableDocument document) {
    IHiddenRegion region = this.textRegionExtensions.previousHiddenRegion(graphvizModel);
    while ((region != null)) {
      {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.autowrap();
        };
        document.set(region, _function);
        region = region.getNextHiddenRegion();
      }
    }
    EList<Graph> _graphs = graphvizModel.getGraphs();
    for (final Graph graph : _graphs) {
      {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Graph>append(graph, _function);
        document.<Graph>format(graph);
      }
    }
  }

  protected void _format(final Graph graph, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(graph).feature(DotPackage.Literals.GRAPH__TYPE), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(document.prepend(this.textRegionExtensions.regionFor(graph).keyword("{"), _function_1), _function_2), 
      this.textRegionExtensions.regionFor(graph).keyword("}"), _function_3);
    EList<Statement> _statements = graph.getStatements();
    for (final Statement statement : _statements) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Statement>append(statement, _function_4);
        document.<Statement>format(statement);
      }
    }
  }

  protected void _format(final Attribute attribute, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(attribute).keyword(";"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(attribute).keyword("="), _function_1);
  }

  protected void _format(final NodeStatement nodeStatement, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(nodeStatement).keyword(";"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(nodeStatement).keyword("["), _function_1), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(nodeStatement).keyword("]"), _function_3);
    final Consumer<ISemanticRegion> _function_4 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(document.prepend(it, _function_5), _function_6);
    };
    this.textRegionExtensions.regionFor(nodeStatement).keywords(",").forEach(_function_4);
    Node _node = nodeStatement.getNode();
    if (_node!=null) {
      document.<Node>format(_node);
    }
    EList<Attribute> _attributes = nodeStatement.getAttributes();
    for (final Attribute attribute : _attributes) {
      document.<Attribute>format(attribute);
    }
  }

  protected void _format(final Node node, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(node).keyword(":"), _function);
    Port _port = node.getPort();
    if (_port!=null) {
      document.<Port>format(_port);
    }
  }

  protected void _format(final EdgeStatement edgeStatement, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(edgeStatement).keyword(";"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(edgeStatement).keyword("["), _function_1), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(edgeStatement).keyword("]"), _function_3);
    final Consumer<ISemanticRegion> _function_4 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(document.prepend(it, _function_5), _function_6);
    };
    this.textRegionExtensions.regionFor(edgeStatement).keywords(",").forEach(_function_4);
    Node _sourceNode = edgeStatement.getSourceNode();
    if (_sourceNode!=null) {
      document.<Node>format(_sourceNode);
    }
    EList<EdgeTarget> _edgeTargets = edgeStatement.getEdgeTargets();
    for (final EdgeTarget target : _edgeTargets) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        document.<EdgeTarget>prepend(target, _function_5);
        document.<EdgeTarget>format(target);
      }
    }
    EList<Attribute> _attributes = edgeStatement.getAttributes();
    for (final Attribute attribute : _attributes) {
      document.<Attribute>format(attribute);
    }
  }

  protected void _format(final EdgeTarget edgeTarget, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(edgeTarget).feature(DotPackage.Literals.EDGE_TARGET__OPERATOR), _function);
    Subgraph _targetSubgraph = edgeTarget.getTargetSubgraph();
    if (_targetSubgraph!=null) {
      document.<Subgraph>format(_targetSubgraph);
    }
    Node _targetnode = edgeTarget.getTargetnode();
    if (_targetnode!=null) {
      document.<Node>format(_targetnode);
    }
  }

  protected void _format(final AttributeStatement attributeStatement, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(attributeStatement).keyword(";"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(attributeStatement).keyword("["), _function_1), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(attributeStatement).keyword("]"), _function_3);
    final Consumer<ISemanticRegion> _function_4 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_6 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(document.prepend(it, _function_5), _function_6);
    };
    this.textRegionExtensions.regionFor(attributeStatement).keywords(",").forEach(_function_4);
    EList<Attribute> _attributes = attributeStatement.getAttributes();
    for (final Attribute attribute : _attributes) {
      document.<Attribute>format(attribute);
    }
  }

  protected void _format(final Subgraph subgraph, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(subgraph).keyword(";"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(subgraph).keyword(this._graphvizDotGrammarAccess.getSubgraphAccess().getSubgraphKeyword_1_0()), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(document.prepend(this.textRegionExtensions.regionFor(subgraph).keyword("{"), _function_2), _function_3), 
      this.textRegionExtensions.regionFor(subgraph).keyword("}"), _function_4);
    EList<Statement> _statements = subgraph.getStatements();
    for (final Statement statement : _statements) {
      {
        final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Statement>append(statement, _function_5);
        document.<Statement>format(statement);
      }
    }
  }

  protected void _format(final Port port, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(port).keyword(":"), _function);
  }

  public void format(final Object attribute, final IFormattableDocument document) {
    if (attribute instanceof XtextResource) {
      _format((XtextResource)attribute, document);
      return;
    } else if (attribute instanceof Attribute) {
      _format((Attribute)attribute, document);
      return;
    } else if (attribute instanceof AttributeStatement) {
      _format((AttributeStatement)attribute, document);
      return;
    } else if (attribute instanceof EdgeStatement) {
      _format((EdgeStatement)attribute, document);
      return;
    } else if (attribute instanceof NodeStatement) {
      _format((NodeStatement)attribute, document);
      return;
    } else if (attribute instanceof Subgraph) {
      _format((Subgraph)attribute, document);
      return;
    } else if (attribute instanceof EdgeTarget) {
      _format((EdgeTarget)attribute, document);
      return;
    } else if (attribute instanceof Graph) {
      _format((Graph)attribute, document);
      return;
    } else if (attribute instanceof GraphvizModel) {
      _format((GraphvizModel)attribute, document);
      return;
    } else if (attribute instanceof Node) {
      _format((Node)attribute, document);
      return;
    } else if (attribute instanceof Port) {
      _format((Port)attribute, document);
      return;
    } else if (attribute instanceof EObject) {
      _format((EObject)attribute, document);
      return;
    } else if (attribute == null) {
      _format((Void)null, document);
      return;
    } else if (attribute != null) {
      _format(attribute, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attribute, document).toString());
    }
  }
}
