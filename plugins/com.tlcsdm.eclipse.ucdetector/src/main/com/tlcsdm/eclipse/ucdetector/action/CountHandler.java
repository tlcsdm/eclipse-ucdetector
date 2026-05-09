/**
 * Copyright (c) 2010 Joerg Spieler
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.tlcsdm.eclipse.ucdetector.action;

/** Modern command handler for {@link CountAction}. */
public class CountHandler extends AbstractUCDetectorHandler { // NO_UCD
  @Override
  protected AbstractUCDetectorAction createActionDelegate() {
    return new CountAction();
  }
}
