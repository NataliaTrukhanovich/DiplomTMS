pipeline {
    agent any
    stages{
         stage('Build'){
            steps{
                powershell 'mvn clean install -DskipTests'
            }
        }
        stage('Run'){
            steps{
                powershell 'mvn clean test -Dconfig=\'%CONFIG%\' -DsuiteXml=\'%SUITE%\''
            }
        }
    }
    post {
        always{
            archiveArtifacts artifacts: 'target/logs/*', allowEmptyArchive: true
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}