# UCDetector

UCDetector (Unnecessary Code Detector - pronounced "You See Detector") is an Eclipse plug-in tool to find unnecessary (dead) public Java code. For example public classes, methods or fields which have no references. UCDetector creates markers for the following problems, which appear in the Eclipse Problems view:

* Unnecessary (dead) code
* Code where the visibility could be changed to protected, default or private
* Methods or fields which can be final

Now supports Java 17 and Eclipse 2024-06 or later.

Go to the UCDetector web site for more screenshots and other information: http://www.ucdetector.org/index.html

## Use

1. Install UCDetector from the update site.
2. Right-click a Java project, package, type, or working set and choose **UCDetector**.
3. Run **Detect unnecessary code**, **Clean UCDetector markers**, or **Count references** from the context menu.
4. Review UCDetector markers in the Eclipse Problems view and apply the available quick fixes where appropriate.
5. Optional: configure detection modes and filters in **Window > Preferences > UCDetector**.

## Build

This project uses [Tycho](https://github.com/eclipse-tycho/tycho) with [Maven](https://maven.apache.org/) and the pomless layout used by the Eclipse plug-in projects under `plugins`, `features`, and `sites`. It requires Maven 3.9.0 or higher and JDK 17 or higher.

Dev build:

```bash
mvn clean verify
```

Release build:

```bash
mvn clean org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=2.1.0 verify
```

## Install

1. Add `https://raw.githubusercontent.com/tlcsdm/eclipse-ucdetector/update_site/` as the update site in Eclipse.
2. Download the generated update site archive from CI/release artifacts and install it as a local update site.

## History

UCDetector was originally created by Jörg Spieler and distributed from http://www.ucdetector.org/index.html. This fork keeps the original UCDetector project information and license attribution while updating the project structure and compatibility baseline.

* 2.1.0: refactored to the `com.tlcsdm.eclipse.ucdetector` namespace, moved to a pomless Tycho layout, and raised the baseline to Java 17 + Eclipse 2024-06.
* 2.0.x and earlier: see `plugins/com.tlcsdm.eclipse.ucdetector/doc/CHANGES.txt` for the original change history.

## License

UCDetector keeps the original author license information. See `LICENSE`, `features/com.tlcsdm.eclipse.ucdetector.feature/feature.properties`, and http://www.ucdetector.org/index.html for details.
