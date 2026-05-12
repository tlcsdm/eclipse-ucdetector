/**
 * Copyright (c) 2010 Joerg Spieler
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.tlcsdm.eclipse.ucdetector.action;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.tlcsdm.eclipse.ucdetector.Log;
import com.tlcsdm.eclipse.ucdetector.UCDetectorPlugin;
import com.tlcsdm.eclipse.ucdetector.iterator.AbstractUCDetectorIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.AdditionalIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.CheckNameConventionIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.CommentIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.DetectDoubleClassNameIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.DetectNoJavaFileIterator;
import com.tlcsdm.eclipse.ucdetector.iterator.MakeMethodsStaticIterator;

/**
 * Run Example Action
 */
public class ExampleAction extends AbstractUCDetectorAction {// NO_UCD
  private static final AdditionalIterator ITERATORS[] = { //
      /**/new MakeMethodsStaticIterator(), //
      new CheckNameConventionIterator(), //
      new CommentIterator(), //
      new DetectDoubleClassNameIterator(), //
      new DetectNoJavaFileIterator(), //
  };

  private AdditionalIterator iterator;

  @Override
  protected AbstractUCDetectorIterator createIterator() {
    String[] options = new String[ITERATORS.length];
    for (int i = 0; i < ITERATORS.length; i++) {
      String className = ITERATORS[i].getClass().getSimpleName();
      int index = className.indexOf("Iterator");
      options[i] = (index == -1) ? className : className.substring(0, index);
    }
    Image image = UCDetectorPlugin.getImage(UCDetectorPlugin.IMAGE_UCD);
    MessageDialog msg = new MessageDialog(UCDetectorPlugin.getShell(), "Select iterator", image,
        "Select an iterator to run", MessageDialog.QUESTION, options, 0);
    int open = msg.open();
    if (open == -1) {
      return null;
    }
    iterator = ITERATORS[open];
    try {
      iterator = iterator.getClass().getConstructor().newInstance();
    }
    catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
      Log.error("Can't instantiate iterator: " + iterator.getClass().getName(), e); //$NON-NLS-1$
    }
    Log.info("Selected iterator: " + iterator);
    return iterator;
  }

  private IStatus status = null;

  @Override
  protected IStatus postIteration() {
    final String message = iterator.getMessage();
    if (message != null) {
      // show message dialog
      Display.getDefault().asyncExec(new Runnable() {
        @Override
        public void run() {
          status = new Status(IStatus.INFO, UCDetectorPlugin.ID, IStatus.INFO, message, null);
          MessageDialog.openInformation(UCDetectorPlugin.getShell(), iterator.getJobName(), message);
        }
      });
    }
    return status;
  }
}
