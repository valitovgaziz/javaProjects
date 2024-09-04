build:
	@javac -d bin src/Main.java

run: build
	@java -classpath ./bin src.Main

.DEFAULT_GOAL=run