rm -rf website.html || true
javac  transform.java
java  transform  websiteXml2Html.xsl  website.xml  website.html
