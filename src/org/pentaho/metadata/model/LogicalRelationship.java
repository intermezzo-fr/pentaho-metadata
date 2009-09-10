/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2009 Pentaho Corporation..  All rights reserved.
 */
package org.pentaho.metadata.model;

import org.pentaho.metadata.model.concept.Concept;
import org.pentaho.metadata.model.concept.types.RelationshipType;

/**
 * Logical relationships define the relationship between two
 * business tables through columns or an open formula expression.
 * 
 * TODO: This class needs additional work before it can support 
 * the capabilities in the original metadata model
 * 
 * @author Will Gorman (wgorman@pentaho.com)
 *
 */
public class LogicalRelationship extends Concept {

  private static final long serialVersionUID = -2673951365033614344L;
  
  public static final String COMPLEX = "complex"; //$NON-NLS-1$
  public static final String COMPLEX_JOIN = "complex_join"; //$NON-NLS-1$
  public static final String RELATIONSHIP_TYPE = "relationship_type"; //$NON-NLS-1$
  public static final String JOIN_ORDER_KEY = "join_order_key"; //$NON-NLS-1$
  
  private LogicalTable fromTable, toTable;
  private LogicalColumn fromColumn, toColumn;
  
  public LogicalRelationship() {
    super();
    setComplex(false);
    setRelationshipType(RelationshipType.UNDEFINED);
  }
  
  public Boolean isComplex() {
    return (Boolean)getProperty(COMPLEX);
  }
  
  public void setComplex(Boolean complex) {
    setProperty(COMPLEX, complex);
  }
  
  public String getComplexJoin() {
    return (String)getProperty(COMPLEX_JOIN);
  }
  
  public void setComplexJoin(String complexJoin) {
    setProperty(COMPLEX_JOIN, complexJoin);
  }
  
  public RelationshipType getRelationshipType() {
    return (RelationshipType)getProperty(RELATIONSHIP_TYPE);
  }
  
  public void setRelationshipType(RelationshipType relationshipType) {
    setProperty(RELATIONSHIP_TYPE, relationshipType);
  }
  
  public String getJoinOrderKey() {
    return (String)getProperty(JOIN_ORDER_KEY);
  }
  
  public void setJoinOrderKey(String joinOrderKey) {
    setProperty(JOIN_ORDER_KEY, joinOrderKey);
  }
  
  public LogicalTable getFromTable() {
    return fromTable;
  }

  public void setFromTable(LogicalTable fromTable) {
    this.fromTable = fromTable;
  }

  public LogicalTable getToTable() {
    return toTable;
  }

  public void setToTable(LogicalTable toTable) {
    this.toTable = toTable;
  }

  public LogicalColumn getFromColumn() {
    return fromColumn;
  }

  public void setFromColumn(LogicalColumn fromColumn) {
    this.fromColumn = fromColumn;
  }

  public LogicalColumn getToColumn() {
    return toColumn;
  }

  public void setToColumn(LogicalColumn toColumn) {
    this.toColumn = toColumn;
  }
  
  public boolean isUsingTable(LogicalTable table) {
    if (table==null) {
      return false;
    }
    return table.getId().equals(toTable.getId()) || table.getId().equals(fromTable.getId());
  }

}
