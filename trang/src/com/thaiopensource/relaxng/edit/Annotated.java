package com.thaiopensource.relaxng.edit;

import com.thaiopensource.relaxng.parse.Context;

import java.util.List;
import java.util.Vector;
import java.util.Iterator;

public abstract class Annotated extends SourceObject {
  private final List leadingComments = new Vector();
  private final List attributeAnnotations = new Vector();
  private final List childElementAnnotations = new Vector();
  private final List followingElementAnnotations = new Vector();
  private Context context;

  public List getLeadingComments() {
    return leadingComments;
  }

  public List getAttributeAnnotations() {
    return attributeAnnotations;
  }

  public List getChildElementAnnotations() {
    return childElementAnnotations;
  }

  public List getFollowingElementAnnotations() {
    return followingElementAnnotations;
  }

  public boolean mayContainText() {
    return false;
  }

  public Context getContext() {
    return context;
  }

  public void setContext(Context context) {
    this.context = context;
  }

  public String getAttributeAnnotation(String ns, String localName) {
    for (Iterator iter = attributeAnnotations.iterator(); iter.hasNext();) {
      AttributeAnnotation att = (AttributeAnnotation)iter.next();
      if (att.getNamespaceUri().equals(ns) && att.getLocalName().equals(localName))
        return att.getValue();
    }
    return null;
  }
}
