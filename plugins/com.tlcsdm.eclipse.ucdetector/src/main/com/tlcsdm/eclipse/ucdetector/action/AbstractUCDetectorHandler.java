/**
 * Copyright (c) 2010 Joerg Spieler
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.tlcsdm.eclipse.ucdetector.action;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Bridge handler that adapts an {@link AbstractUCDetectorAction} (an
 * {@code ActionDelegate} written against the deprecated
 * {@code org.eclipse.ui.popupMenus} extension point) to the modern
 * commands/handlers/menus extension points.
 *
 * <p>Concrete subclasses simply return a fresh instance of the
 * {@link AbstractUCDetectorAction} they want to invoke.</p>
 */
public abstract class AbstractUCDetectorHandler extends AbstractHandler { // NO_UCD

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    AbstractUCDetectorAction delegate = createActionDelegate();
    if (delegate == null) {
      return null;
    }
    ISelection selection = HandlerUtil.getCurrentSelection(event);
    IAction proxy = new Action() {
      // empty proxy used to satisfy the ActionDelegate API
    };
    delegate.selectionChanged(proxy, selection);
    delegate.runWithEvent(proxy, null);
    return null;
  }

  /**
   * @return a fresh {@link AbstractUCDetectorAction} instance that this
   *         handler should invoke
   */
  protected abstract AbstractUCDetectorAction createActionDelegate();
}
