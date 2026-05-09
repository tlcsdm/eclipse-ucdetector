/**
 * Copyright (c) 2010 Joerg Spieler
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.tlcsdm.eclipse.ucdetector.action;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.progress.IProgressConstants;
import com.tlcsdm.eclipse.ucdetector.Log;
import com.tlcsdm.eclipse.ucdetector.Messages;
import com.tlcsdm.eclipse.ucdetector.UCDetectorPlugin;
import com.tlcsdm.eclipse.ucdetector.iterator.AbstractUCDetectorIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.UCDetectorIterator;
import com.tlcsdm.eclipse.ucdetector.report.ReportNameManager;
import com.tlcsdm.eclipse.ucdetector.search.UCDProgressMonitor;
import com.tlcsdm.eclipse.ucdetector.util.JavaElementUtil;

/**
 * Run "detect"
 * <p>
 * @author Joerg Spieler
 * @since 2008-02-29
 */
public class UCDetectorAction extends AbstractUCDetectorAction {
  UCDetectorIterator iterator;

  @Override
  protected AbstractUCDetectorIterator createIterator() {
    iterator = new UCDetectorIterator();
    return iterator;
  }

  @Override
  protected void setJobProperty(Job job) {
    super.setJobProperty(job);
    IAction openEditor = new OpenInEditorAction();
    job.setProperty(IProgressConstants.ACTION_PROPERTY, openEditor);
  }

  /**
   * Open the element UCDetector detects in the java editor
   */
  private final class OpenInEditorAction extends Action {
    @Override
    public void run() {
      String objectToShow = null;
      try {
        UCDProgressMonitor monitor = iterator.getMonitor();
        if (monitor.isFinished()) {
          // See org.eclipse.ui.views.markers.MarkerViewUtil.getViewId()
          objectToShow = IPageLayout.ID_PROBLEM_VIEW;
          UCDetectorPlugin.getActivePage().showView(IPageLayout.ID_PROBLEM_VIEW);
          return;
        }
        IJavaElement element = monitor.getActiveSearchElement();
        if (element != null) {
          objectToShow = JavaElementUtil.getElementName(element);
          IEditorPart part = JavaUI.openInEditor(element, true, false);
          JavaUI.revealInEditor(part, element);
        }
      }
      catch (Exception ex) {
        Log.error("Can't open view for object: " + objectToShow, ex);//$NON-NLS-1$
      }
    }
  }

  @Override
  protected IStatus postIteration() {
    int created = iterator.getMarkerCreated();
    StringBuilder mes = new StringBuilder();
    mes.append(NLS.bind(Messages.UCDetectorAction_ResultMessage, String.valueOf(created)));
    //
    String reportFolder = ReportNameManager.getReportDir(false);
    if (reportFolder != null && created > 0) {
      mes.append(". "); //$NON-NLS-1$
      String s = NLS.bind(Messages.UCDetectorAction_ResultReport, reportFolder);
      mes.append(s);
    }
    return new Status(IStatus.INFO, UCDetectorPlugin.ID, mes.toString());
  }
}
