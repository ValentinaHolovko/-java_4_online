### About compilation ###

## Level 1 (without libs) ##

### go to /java/level_1/simple ###

javac Series.java
java Series

### go to /java/level_1/package ###

javac ua/com/alevel/Series.java
java ua.com.alevel.Series

### go to /java/level_1/separate_packages ###

javac ua/com/alevel/Series.java
java ua.com.alevel.Series

### go to /java/level_1/minimal_proj ###

javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Series.java
java -cp build/classes ua.com.alevel.Series

### go to /java/level_1/med_proj ###

javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Series.java
jar cvfm build/jar/series.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/series.jar

## Level 2 (with libs) ##

### Compilation contains external libraries ###

## go to /java/level_2/include_libs ##

javac -sourcepath ./src -d build/classes/ -cp ./lib/JColor-5.5.1.jar src/ua/com/alevel/util/Master.java src/ua/com/alevel/Series.java
java -cp build/classes/:./lib/JColor-5.5.1.jar ua.com.alevel.Series

## go to /java/level_2/jar ##
1 variant
## Run compile ##
$ javac -sourcepath ./src -d build/classes/ -cp ./lib/JColor-5.5.1.jar src/ua/com/alevel/util/Master.java src/ua/com/alevel/Series.java

## Unzip all jars ##
$ cd lib $ jar xf JColor-5.5.1.jar $ cp -rf com ../build/classes $ cd ..

## Create jar ##
$ jar cvfm build/jar/hello.jar resources/MANIFEST.MF -C build/classes .

## Show jar ##
$ jar tf build/jar/series.jar

## Run jar ##
$ java -jar build/jar/series.jar

2 variant
## Run compile ##
$ javac -sourcepath ./src -d build/classes/ -cp ./lib/JColor-5.5.1.jar src/ua/com/alevel/util/Message.java src/ua/com/alevel/Series.java

## copy lib jar ##
$ cp -r lib/*.jar build/jar

## Create jar ##
$ jar cvfm build/jar/hello.jar resources/MANIFEST.MF -C build/classes .

## Run jar ##
$ java -jar build/jar/series.jar