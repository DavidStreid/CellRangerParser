install:
	mvn install

generate:
	mvn exec:java -Dexec.mainClass="com.cellranger.util.CodeGenerator"

run:
	mvn exec:java -Dexec.mainClass="com.cellranger.util.App"