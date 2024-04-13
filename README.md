# oop-project

to compile the code, you shall use Maven as your build tool. If you are using any IDE this process will be automatic. Otherwise, simply run on your shell:
> mvn package

an then, execute the file with:
> java -cp target/app-1.0.jar com.techgear.App

to generate the javadoc, simply run:
> mvn javadoc:jar

then access `./apidocs/index.html` to read the documentation
