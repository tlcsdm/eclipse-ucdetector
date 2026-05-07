/**
 * Copyright (c) 2010 Joerg Spieler
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.tlcsdm.eclipse.ucdetector.iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IMember;
import com.tlcsdm.eclipse.ucdetector.preferences.WarnLevel;
import com.tlcsdm.eclipse.ucdetector.report.ReportParam;
import com.tlcsdm.eclipse.ucdetector.search.LineManger;
import com.tlcsdm.eclipse.ucdetector.util.MarkerFactory;

/**
 *
 */
public abstract class AdditionalIterator extends AbstractUCDetectorIterator {
  static final String ADDITIONAL_MARKER_TYPE = MarkerFactory.UCD_MARKER_TYPE_PREFIX + "Example"; //$NON-NLS-1$
  private static final LineManger lineManger = new LineManger();

  void createMarker(IMember element, String message, String markerType) throws CoreException {
    int line = lineManger.getLine(element);
    ReportParam reportParam = new ReportParam(element, message, line, markerType, WarnLevel.WARNING);
    getMarkerFactory().reportMarker(reportParam);
  }

  public abstract String getMessage();
}
