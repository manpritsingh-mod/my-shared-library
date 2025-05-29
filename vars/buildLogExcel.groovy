@Library('my-shared-library')
def call(String repoURL = 'https://github.com/manpritsingh-s/ExcelReadWrite.git'){
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
                mvnBuildTest.Build()
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
