def call(String repoURL = 'https://github.com/manpritsingh-s/ExcelReadWrite'){
  pipeline{
    agent any
    
     tools {
        maven 'maven3'
    }
    stages{
        stage('Clone Repo'){
            steps{
                git repoURL
            }
        }
        stage('Build Java'){
            steps{
                bat 'mvn clean install'
            }
        }
        stage('Log Build Success to Excel') {
            steps {
                bat 'mvn exec:java -Dexec.mainClass=com.example.ExcelLogger'
            }
        }
        stage('XLS Output'){
            steps {
                archiveArtifacts artifacts: 'test.xls'
            }
        }
    }
}
}
