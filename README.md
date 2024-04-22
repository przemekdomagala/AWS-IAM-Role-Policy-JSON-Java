# JSON verifier
### JSONVerifier is class with method verifying json data. It checks if input data is in correct format for AWS::IAM::Role Policy, and whether Resources property is different from '*'.

### If you want to launch program you have to type 'mvn clean compile assembly:single' in terminal while being in project directory. That will create jar file in target directory for you, so launch it with 'java -jar JSONVerifier-1.0.jar'.

#### Verifier is tested on multiple files (type 'mvn test') so tests cover most of the code.

###### Verified json file can be changed, you just have to drop file into src/min/resources and change name of file in Main Class (currently it's "data.json")