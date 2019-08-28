install:
	mvn install

run:
	mvn exec:java -Dexec.mainClass="com.cellranger.util.App"