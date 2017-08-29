* # Manual run of the test task

If you just want to run tests you can clone them, and run them from IDE or open project directory in terminal and execute (you should have maven installed on your system):
```
mvn verify
```

Open ```[ProjectFolder]/target/serenity/index.html``` to view the test report.

* # Virtual machine and Jenkins.
  * Download a VM from [Google Drive](https://drive.google.com/open?id=0B9yDwiRQC2M5dTRCamE0Z0dvdE0)
  * Extract ubuntu.zip file.
  * Start the VM.
  * use password: ```qwerty``` to login to the OS.
  * Start jenkins in terminal by executing command: ```java -jar /home/me/Downloads/jenkins.war```
  * Open url: ```localhost:8080``` in Firefox. Use credentials: ```admin\qwerty```
  * Run tests by executing ```Keypr daily run``` job.
  * The test report will be in the folder written above.
