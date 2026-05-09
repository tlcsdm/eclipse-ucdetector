How to add a new custom detector

- Action
  - Add a new Action, e.g. CheckUcdMarkerAction
  - Add plugin.xml#org.eclipse.ui.popupMenus like CheckUcdMarkerAction

- Add a new Iterator e.g. CheckNameConventionIterator
  - Add constant like com.tlcsdm.eclipse.ucdetector.iterator.CheckUcdMarkerIterator.ANALYZE_MARKER_CHECK_UCD_MARKERS
  - Call AdditionalIterator.createMarker() 
  - Or create marker like: com.tlcsdm.eclipse.ucdetector.iterator.CheckUcdMarkerIterator.createMarker()

- Marker
  - Add plugin.xml # org.eclipse.core.resources.markers                   like com.tlcsdm.eclipse.ucdetector.analyzeMarkerCheckUcdMarkers
  - Add plugin.xml # org.eclipse.ui.editors.annotationTypes               like com.tlcsdm.eclipse.ucdetector.analyzeMarkerCheckUcdMarkers
  - Add plugin.xml # org.eclipse.ui.editors.markerAnnotationSpecification like com.tlcsdm.eclipse.ucdetector.analyzeMarkerCheckUcdMarkers
  
- L18N
  - Add plugin.properties # like check.ucd.marker.name
  - Add plugin.properties # like check.ucd.specification.label