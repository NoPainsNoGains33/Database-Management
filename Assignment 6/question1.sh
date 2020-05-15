rm -rf website.xml || true
javac  transform.java
java  transform  site2website.xsl  site.xml  website.xml
